package ch.grze.frogment.frogment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import ch.grze.frogment.core.Core
import ch.grze.frogment.core.callbacks.AbstractFragmentLifecycleCallbacks

class FragmentCallbacks(core: Core) : AbstractFragmentLifecycleCallbacks(core) {
    override fun onFragmentPreCreated(fm: FragmentManager?, f: Fragment?, savedInstanceState: Bundle?) {
        super.onFragmentPreCreated(fm, f, savedInstanceState)

        (f as? StateAwareFrogmentInterface<*>)
            ?.stateAwareFrogmentComponent
            ?.onFragmentPreCreated(savedInstanceState)
    }

    override fun onFragmentActivityCreated(fm: FragmentManager?, f: Fragment?, savedInstanceState: Bundle?) {
        super.onFragmentActivityCreated(fm, f, savedInstanceState)

        (f as? StateAwareFrogmentInterface<*>)
            ?.stateAwareFrogmentComponent
            ?.onFragmentActivityCreated(savedInstanceState)
    }

    override fun onFragmentSaveInstanceState(fm: FragmentManager?, f: Fragment?, outState: Bundle) {
        super.onFragmentSaveInstanceState(fm, f, outState)

        (f as? StateAwareFrogmentInterface<*>)
            ?.stateAwareFrogmentComponent
            ?.onFragmentSaveInstanceState(outState)
    }
}