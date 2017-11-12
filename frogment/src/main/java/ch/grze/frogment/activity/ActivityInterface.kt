package ch.grze.frogment.activity

import android.content.Intent
import android.support.v4.app.FragmentManager

interface ActivityInterface {
    fun getIntent(): Intent
    fun getSupportFragmentManager(): FragmentManager
    fun finish()
    fun startActivity(intent: Intent)
}
