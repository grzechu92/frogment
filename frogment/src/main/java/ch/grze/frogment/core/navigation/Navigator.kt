package ch.grze.frogment.core.navigation

import android.app.Activity
import android.content.Intent
import android.support.v4.app.Fragment
import android.text.TextUtils.replace
import ch.grze.frogment.activity.FrogmentActivityInterface
import ch.grze.frogment.activity.StateAwareFrogmentActivityInterface
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.provider.FragmentInstanceProvider
import ch.grze.frogment.frogment.FrogmentInterface

class Navigator constructor(private val activity: FrogmentActivityInterface,
                            private val core: Core) {

    fun to(data: FrogmentData) {
        val frogment = getFrogmentFrom(data)
        frogment.data = data

        activity.frogmentActivityComponent.onFrogmentConfigure(frogment)

        activity.getSupportFragmentManager().beginTransaction().apply {
            replace(activity.frogmentContainerId, frogment as Fragment, data.tag)
            addToBackStack(data.tag)
            commit()
        }
    }

    fun to(data: FrogmentActivityData) {
        val clazz = data.clazz
        val intent = Intent(activity as Activity, clazz)

        if (StateAwareFrogmentActivityInterface::class.java.isAssignableFrom(clazz) && data.state != null) {
            intent.putExtra(StateAwareFrogmentActivityInterface.STATE, data.state)
        }

        if (FrogmentActivityInterface::class.java.isAssignableFrom(clazz) && data.frogmentData != null) {
            intent.putExtra(FrogmentActivityInterface.FROGMENT_DATA, data.frogmentData)
        }

        (activity as FrogmentActivityInterface).apply {
            startActivity(intent)
            finish()
        }
    }

    private fun getFrogmentFrom(data: FrogmentData): FrogmentInterface {
        val fragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(data.tag)
        val provider: FragmentInstanceProvider = core.config.fragmentInstanceProvider

        val frogment: FrogmentInterface = (fragmentByTag ?: provider.getInstance(data.clazz)) as FrogmentInterface

        core.injectComponents(frogment as Fragment)

        return frogment
    }
}