package ch.grze.frogment.core.backstack

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import ch.grze.frogment.frogment.FrogmentInterface


class BackStackFrogmentManager(private val fragmentManager: FragmentManager,
                               private val listener: BackStackChangeListener) : FragmentManager.OnBackStackChangedListener {

    private var lastBackStackEntryCount: Int = 0

    init {
        lastBackStackEntryCount = fragmentManager.backStackEntryCount

        fragmentManager.addOnBackStackChangedListener(this)
    }

    override fun onBackStackChanged() {
        val backStackEntryCount = fragmentManager.backStackEntryCount
        val fragments = fragmentManager.fragments

        if (hasFragments(fragments)) {
            getParentFrogment(fragments)?.let {
                if (wasPushed(backStackEntryCount)) {
                    listener.onFrogmentPushed(it)
                }

                if (wasPopped(backStackEntryCount)) {
                    listener.onFrogmentPopped(it)
                }
            }
        } else {
            listener.onBackStackEmpty()
        }

        lastBackStackEntryCount = backStackEntryCount
    }

    private fun wasPushed(backStackEntryCount: Int) = lastBackStackEntryCount < backStackEntryCount

    private fun wasPopped(backStackEntryCount: Int) = lastBackStackEntryCount > backStackEntryCount

    private fun hasFragments(fragments: List<Fragment>?) = fragments?.isEmpty()?.not() ?: false

    private fun getParentFrogment(fragments: List<Fragment>) =
        fragments[Math.max(0, fragments.size - 2)] as? FrogmentInterface
}