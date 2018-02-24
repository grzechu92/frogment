package ch.grze.frogment.core.extension

import android.app.Activity
import android.app.Application
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.component.ComponentInjector
import java.util.*

abstract class AbstractExtension {
    protected lateinit var core: Core

    val activityLifecycleCallbacks = ArrayList<Application.ActivityLifecycleCallbacks>()
    val fragmentLifecycleCallbacks = ArrayList<FragmentManager.FragmentLifecycleCallbacks>()
    val activityComponentInjectors = ArrayList<ComponentInjector<Activity>>()
    val fragmentComponentInjectors = ArrayList<ComponentInjector<Fragment>>()

    abstract val id: String

    @CallSuper
    open fun initialize(core: Core) {
        this.core = core
    }
}
