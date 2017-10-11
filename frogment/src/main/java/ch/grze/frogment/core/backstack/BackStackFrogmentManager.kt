package ch.grze.frogment.core.backstack

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import ch.grze.frogment.frogment.FrogmentInterface


class BackStackFrogmentManager(
        private val fragmentManager: FragmentManager,
        private val listener: BackStackChangeListener
) : FragmentManager.OnBackStackChangedListener {
    private var lastBackStackEntryCount: Int = 0

    init {
        lastBackStackEntryCount = fragmentManager.backStackEntryCount

        fragmentManager.addOnBackStackChangedListener(this)
    }

    override fun onBackStackChanged() {
        val backStackEntryCount: Int = fragmentManager.backStackEntryCount
        val fragments: MutableList<Fragment> = fragmentManager.fragments

        if (hasFragments(fragments)) {
            val frogment: FrogmentInterface? = getParentFrogment(fragments)

            if (frogment != null) {
                if (wasPushed(backStackEntryCount)) {
                    listener.onFrogmentPushed(frogment)
                }

                if (wasPopped(backStackEntryCount)) {
                    listener.onFrogmentPopped(frogment)
                }
            }

        } else {
            listener.onBackStackEmpty()
        }

        lastBackStackEntryCount = backStackEntryCount
    }

    private fun wasPushed(backStackEntryCount: Int): Boolean {
        return lastBackStackEntryCount < backStackEntryCount
    }

    private fun wasPopped(backStackEntryCount: Int): Boolean {
        return lastBackStackEntryCount > backStackEntryCount
    }

    private fun hasFragments(fragments: List<Fragment>?): Boolean {
        return !(fragments?.isEmpty() ?: true)
    }

    private fun getParentFrogment(fragments: List<Fragment>): FrogmentInterface? {
        return fragments[Math.max(0, fragments.size - 2)] as FrogmentInterface
    }
}