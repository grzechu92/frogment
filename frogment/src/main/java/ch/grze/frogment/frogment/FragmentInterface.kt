package ch.grze.frogment.frogment

import android.app.Activity
import android.os.Bundle

interface FragmentInterface {
    val activity: Activity

    fun getArguments(): Bundle?
    fun setArguments(arguments: Bundle?)
}
