package ch.grze.frogment.activity

import android.os.Bundle
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.backstack.BackStackChangeListener
import ch.grze.frogment.core.backstack.BackStackFrogmentManager
import ch.grze.frogment.core.navigation.FrogmentData
import ch.grze.frogment.core.navigation.Navigator
import ch.grze.frogment.core.navigation.NavigatorAware
import ch.grze.frogment.frogment.FrogmentInterface
import ch.grze.frogment.frogment.StateAwareFrogmentInterface

class FrogmentActivityComponent : NavigatorAware, BackStackChangeListener {
    private var frogmentData: FrogmentData? = null
    lateinit var core: Core
    lateinit var frogmentActivity: FrogmentActivityInterface

    override val navigator: Navigator by lazy {
        Navigator(frogmentActivity, core)
    }

    override fun onBackStackEmpty() {
        if (core.config.isCallActivityFinishOnEmptyBackStack) {
            frogmentActivity.finish()
        }
    }

    override fun onFrogmentPushed(frogment: FrogmentInterface) {
        onFrogmentConfigure(frogment)
    }

    override fun onFrogmentPopped(frogment: FrogmentInterface) {
        onFrogmentConfigure(frogment)
    }

    fun onActivityCreated(savedInstanceState: Bundle?) {
        val fragmentManager = frogmentActivity.getSupportFragmentManager()

        BackStackFrogmentManager(fragmentManager, frogmentActivity)

        val defaultFrogmentData = frogmentActivity.defaultFrogmentData
        val intent = frogmentActivity.getIntent()

        val frogmentData = core.parser.getData(FrogmentActivityInterface.FROGMENT_DATA, defaultFrogmentData, savedInstanceState, intent)
        navigator.to(frogmentData)

        for (callback in core.fragmentLifecycleCallbacks) {
            fragmentManager.registerFragmentLifecycleCallbacks(callback, true)
        }
    }

    fun onActivitySaveInstanceState(bundle: Bundle) {
        bundle.putParcelable(FrogmentActivityInterface.FROGMENT_DATA, frogmentData)
    }

    fun onFrogmentConfigure(frogment: FrogmentInterface) {
        if (frogment is StateAwareFrogmentInterface<*>) {
            val bundle = Bundle()
            bundle.putParcelable(StateAwareFrogmentInterface.STATE, frogmentData?.state ?: frogment.data.state ?: frogment.defaultState)

            frogment.setArguments(bundle)
        }
    }
}