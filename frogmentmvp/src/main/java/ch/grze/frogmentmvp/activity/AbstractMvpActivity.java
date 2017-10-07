package ch.grze.frogmentmvp.activity;

import android.support.v7.app.AppCompatActivity;

import ch.grze.frogmentmvp.MvpPresenter;
import ch.grze.frogmentmvp.MvpView;

public abstract class AbstractMvpActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpView<P>  {
    private P presenter;

    @Override
    final public P getPresenter() {
        return presenter;
    }

    @Override
    final public void attachPresenter(P presenter) {
        this.presenter = presenter;

        presenter.onAttach(this);
    }
}
