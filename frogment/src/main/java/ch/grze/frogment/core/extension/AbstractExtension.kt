package ch.grze.frogment.core.extension

import android.app.Application
import android.support.annotation.CallSuper
import android.support.v4.app.FragmentManager
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.component.AbstractActivityComponentInjector
import ch.grze.frogment.core.component.AbstractFragmentComponentInjector
import java.util.*

abstract class AbstractExtension {
    private val activityLifecycleCallbacks = ArrayList<Application.ActivityLifecycleCallbacks>()
    private val fragmentLifecycleCallbacks = ArrayList<FragmentManager.FragmentLifecycleCallbacks>()
    private val activityComponentInjectors = ArrayList<AbstractActivityComponentInjector>()
    private val fragmentComponentInjectors = ArrayList<AbstractFragmentComponentInjector>()
    protected lateinit var core: Core

    @CallSuper
    open fun initialize(core: Core) {
        this.core = core
    }

    fun getActivityLifecycleCallbacks(): List<Application.ActivityLifecycleCallbacks> {
        return activityLifecycleCallbacks
    }

    fun getFragmentLifecycleCallbacks(): List<FragmentManager.FragmentLifecycleCallbacks> {
        return fragmentLifecycleCallbacks
    }

    fun getActivityComponentInjectors(): List<AbstractActivityComponentInjector> {
        return activityComponentInjectors
    }

    fun getFragmentComponentInjectors(): List<AbstractFragmentComponentInjector> {
        return fragmentComponentInjectors
    }

    protected fun addActivityLifecycleCallback(callback: Application.ActivityLifecycleCallbacks) {
        activityLifecycleCallbacks.add(callback)
    }

    protected fun addFragmentLifecycleCallback(callback: FragmentManager.FragmentLifecycleCallbacks) {
        fragmentLifecycleCallbacks.add(callback)
    }

    protected fun addActivityComponentInjector(injector: AbstractActivityComponentInjector) {
        activityComponentInjectors.add(injector)
    }

    protected fun addFragmentComponentInjector(injector: AbstractFragmentComponentInjector) {
        fragmentComponentInjectors.add(injector)
    }
}
