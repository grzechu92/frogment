package ch.grze.frogment.frogment

import android.support.v4.app.Fragment
import ch.grze.frogment.core.navigation.NavigatorAware

abstract class AbstractFrogment private constructor(override val frogmentComponent: FrogmentComponent) :
        Fragment(),
        FrogmentInterface,
        FrogmentDataAware by frogmentComponent,
        FrogmentActivityAware by frogmentComponent,
        NavigatorAware by frogmentComponent
{
    constructor() : this(FrogmentComponent())

    init {
        frogmentComponent.frogment = this
    }
}
