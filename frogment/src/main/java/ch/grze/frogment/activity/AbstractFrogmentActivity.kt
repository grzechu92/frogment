package ch.grze.frogment.activity

import android.support.v7.app.AppCompatActivity
import ch.grze.frogment.SwitchAware
import ch.grze.frogment.core.backstack.BackStackChangeListener

abstract class AbstractFrogmentActivity private constructor(override var frogmentActivityComponent: FrogmentActivityComponent) :
        AppCompatActivity(),
        FrogmentActivityInterface,
        SwitchAware by frogmentActivityComponent,
        BackStackChangeListener by frogmentActivityComponent
{
    constructor() : this(FrogmentActivityComponent())

    init {
        frogmentActivityComponent.frogmentActivity = this
    }
}
