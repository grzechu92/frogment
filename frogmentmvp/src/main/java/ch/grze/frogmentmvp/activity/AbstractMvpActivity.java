package ch.grze.frogmentmvp.activity;

import android.support.v7.app.AppCompatActivity;

import ch.grze.frogmentmvp.presenter.MvpPresenter;
import ch.grze.frogmentmvp.view.MvpPresenterComponent;
import ch.grze.frogmentmvp.view.PresenterAwareMvpView;

//still in Java due to lack of interop: https://youtrack.jetbrains.com/issue/KT-19415
public abstract class AbstractMvpActivity<P extends MvpPresenter> extends AppCompatActivity implements PresenterAwareMvpView<P> {
    private MvpPresenterComponent mvpPresenterComponent;

    @Override
    public MvpPresenterComponent getMvpPresenterComponent() {
        return mvpPresenterComponent;
    }

    @Override
    public void setMvpPresenterComponent(MvpPresenterComponent component) {
        mvpPresenterComponent = component;
    }
}
