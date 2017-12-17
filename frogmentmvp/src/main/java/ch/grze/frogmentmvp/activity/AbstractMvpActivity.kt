package ch.grze.frogmentmvp.activity

import android.support.v7.app.AppCompatActivity
import ch.grze.frogmentmvp.Mvp

abstract class AbstractMvpActivity<P : Mvp.Presenter<*>> : AppCompatActivity(), Mvp.View<P> {
    override var presenter: P? = null
}
