package ch.grze.frogment

import android.content.Intent
import android.support.v4.app.FragmentManager

interface ActivityInterface {
    val intent: Intent
    val supportFragmentManager: FragmentManager
    fun finish()
    fun startActivity(intent: Intent)
}
