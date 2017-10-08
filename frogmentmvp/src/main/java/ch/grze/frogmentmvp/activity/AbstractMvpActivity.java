package ch.grze.frogmentmvp.activity;

import android.support.v7.app.AppCompatActivity;

import ch.grze.frogmentmvp.MvpPresenter;

public abstract class AbstractMvpActivity<P extends MvpPresenter> extends AppCompatActivity implements MvpActivityInterface<P>  {
    private MvpActivityComponent mvpActivityComponent;

    @Override
    public MvpActivityComponent getMvpActivityComponent() {
        return mvpActivityComponent;
    }

    @Override
    public void setMvpActivityComponent(MvpActivityComponent component) {
        mvpActivityComponent = component;
    }
}
