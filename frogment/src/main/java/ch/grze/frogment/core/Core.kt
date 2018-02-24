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

class Core(application: Application,
           val config: Config,
           extensions: List<AbstractExtension>) {

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

        activityLifecycleCallbacks.forEach {
            application.registerActivityLifecycleCallbacks(it)
        }
    }

    fun injectComponents(activity: Activity) {
        activityComponentInjectors.forEach {
            it.inject(this, activity)
        }
    }

    fun injectComponents(fragment: Fragment) {
        fragmentComponentInjectors.forEach {
            it.inject(this, fragment)
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
        extensions.forEach {
            this.extensions[it.id] = it
        }

        extensions.forEach {
            it.initialize(this)

            activityLifecycleCallbacks.addAll(it.activityLifecycleCallbacks)
            fragmentLifecycleCallbacks.addAll(it.fragmentLifecycleCallbacks)
            activityComponentInjectors.addAll(it.activityComponentInjectors)
            fragmentComponentInjectors.addAll(it.fragmentComponentInjectors)
        }
    }
}
