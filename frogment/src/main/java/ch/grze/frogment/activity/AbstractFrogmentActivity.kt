package ch.grze.frogment.activity

import android.support.v7.app.AppCompatActivity
import ch.grze.frogment.core.backstack.BackStackChangeListener
import ch.grze.frogment.core.navigation.NavigatorAware

abstract class AbstractFrogmentActivity private constructor(override val frogmentActivityComponent: FrogmentActivityComponent) :
        AppCompatActivity(),
        FrogmentActivityInterface,
        NavigatorAware by frogmentActivityComponent,
        BackStackChangeListener by frogmentActivityComponent {

    constructor() : this(FrogmentActivityComponent())

    init {
        frogmentActivityComponent.frogmentActivity = this
    }
}
