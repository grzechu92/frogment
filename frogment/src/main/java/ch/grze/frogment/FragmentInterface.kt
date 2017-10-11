package ch.grze.frogment

import android.app.Activity
import android.os.Bundle

interface FragmentInterface {
    val activity: Activity
    var arguments: Bundle
}
