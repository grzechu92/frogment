package ch.grze.frogment.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import ch.grze.frogment.SwitchAware
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.backstack.BackStackChangeListener
import ch.grze.frogment.core.backstack.BackStackFrogmentManager
import ch.grze.frogment.core.provider.FragmentInstanceProvider
import ch.grze.frogment.frogment.FrogmentData
import ch.grze.frogment.frogment.FrogmentInterface
import ch.grze.frogment.frogment.StateAwareFrogmentInterface

class FrogmentActivityComponent : SwitchAware, BackStackChangeListener {
    private var frogmentData: FrogmentData? = null
    lateinit var core: Core
    lateinit var frogmentActivity: FrogmentActivityInterface

    override fun switchFrogment(data: FrogmentData) {
        val frogment = getFrogmentFrom(data)
        frogment.data = data

        onFrogmentConfigure(frogment)

        frogmentActivity
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(frogmentActivity.frogmentContainerId, frogment as Fragment, data.tag)
                .addToBackStack(data.tag)
                .commit()
    }

    override fun switchActivity(data: FrogmentActivityData) {
        val clazz = data.clazz
        val intent = Intent(frogmentActivity as Activity, clazz)

        if (StateAwareFrogmentActivityInterface::class.java.isAssignableFrom(clazz) && data.state != null) {
            intent.putExtra(StateAwareFrogmentActivityInterface.STATE, data.state)
        }

        if (FrogmentActivityInterface::class.java.isAssignableFrom(clazz) && data.frogmentData != null) {
            intent.putExtra(FrogmentActivityInterface.FROGMENT_DATA, data.frogmentData)
        }

        frogmentActivity.startActivity(intent)
        frogmentActivity.finish()
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
        switchFrogment(frogmentData)

        for (callback in core.fragmentLifecycleCallbacks) {
            fragmentManager.registerFragmentLifecycleCallbacks(callback, true)
        }
    }

    fun onActivitySaveInstanceState(bundle: Bundle) {
        bundle.putParcelable(FrogmentActivityInterface.FROGMENT_DATA, frogmentData)
    }

    private fun onFrogmentConfigure(frogment: FrogmentInterface) {
        if (frogment is StateAwareFrogmentInterface<*>) {
            val bundle = Bundle()
            bundle.putParcelable(StateAwareFrogmentInterface.STATE, frogmentData?.state ?: frogment.data?.state ?: frogment.defaultState)

            frogment.arguments = bundle
        }
    }

    private fun getFrogmentFrom(data: FrogmentData): FrogmentInterface {
        val fragmentByTag = frogmentActivity.getSupportFragmentManager().findFragmentByTag(data.tag)
        val fragmentInstanceProvider: FragmentInstanceProvider = core.config.fragmentInstanceProvider

        val frogment: FrogmentInterface = (fragmentByTag ?: fragmentInstanceProvider.getInstance(data.clazz)) as FrogmentInterface

        core.injectComponents(frogment as Fragment)

        return frogment
    }
}