package ch.grze.frogment.core

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import ch.grze.frogment.activity.ActivityCallbacks
import ch.grze.frogment.activity.ActivityComponentInjector
import ch.grze.frogment.core.callbacks.ActivityComponentInjectorCallbacks
import ch.grze.frogment.core.component.ComponentInjector
import ch.grze.frogment.core.extension.AbstractExtension
import ch.grze.frogment.core.parser.Parser
import ch.grze.frogment.frogment.FragmentCallbacks
import ch.grze.frogment.frogment.FrogmentComponentInjector
import java.util.*
import kotlin.collections.HashMap

class Core(
        application: Application,
        val config: Config,
        extensions: List<AbstractExtension>
) {
    private val activityComponentInjectors = ArrayList<ComponentInjector<Activity>>()
    private val fragmentComponentInjectors = ArrayList<ComponentInjector<Fragment>>()
    private val extensions = HashMap<String, AbstractExtension>()

    val fragmentLifecycleCallbacks = ArrayList<FragmentManager.FragmentLifecycleCallbacks>()
    val activityLifecycleCallbacks = ArrayList<Application.ActivityLifecycleCallbacks>()
    val parser = Parser()

    init {
        initializeCallbacks()
        initializeInjectors()
        initializeExtensions(extensions)

        for (callback in activityLifecycleCallbacks) {
            application.registerActivityLifecycleCallbacks(callback)
        }
    }

    fun injectComponents(activity: Activity) {
        for (injector in activityComponentInjectors) {
            injector.inject(this, activity)
        }
    }

    fun injectComponents(fragment: Fragment) {
        for (injector in fragmentComponentInjectors) {
            injector.inject(this, fragment)
        }
    }

    fun <T : AbstractExtension> getExtension(id: String): T? = extensions[id] as? T

    private fun initializeInjectors() {
        activityComponentInjectors.add(ActivityComponentInjector())
        fragmentComponentInjectors.add(FrogmentComponentInjector())
    }

    private fun initializeCallbacks() {
        activityLifecycleCallbacks.add(ActivityComponentInjectorCallbacks(this))

        activityLifecycleCallbacks.add(ActivityCallbacks(this))
        fragmentLifecycleCallbacks.add(FragmentCallbacks(this))
    }

    private fun initializeExtensions(extensions: List<AbstractExtension>) {
        for (extension in extensions) {
            this.extensions[extension.ID] = extension
        }

        for (extension in extensions) {
            extension.initialize(this)

            activityLifecycleCallbacks.addAll(extension.activityLifecycleCallbacks)
            fragmentLifecycleCallbacks.addAll(extension.fragmentLifecycleCallbacks)
            activityComponentInjectors.addAll(extension.activityComponentInjectors)
            fragmentComponentInjectors.addAll(extension.fragmentComponentInjectors)
        }
    }
}
