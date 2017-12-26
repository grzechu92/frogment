package ch.grze.frogmentmvp.view

import android.support.v7.app.AppCompatActivity
import ch.grze.frogmentmvp.Mvp

abstract class AbstractMvpActivity<P : Mvp.Presenter<*>> : AppCompatActivity(), Mvp.View<P> {
    override var presenter: P? = null
}
