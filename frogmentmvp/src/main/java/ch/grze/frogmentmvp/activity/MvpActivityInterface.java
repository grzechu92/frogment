package ch.grze.frogmentmvp.activity;

import android.support.annotation.CallSuper;

import ch.grze.frogmentmvp.MvpPresenter;
import ch.grze.frogmentmvp.MvpView;

public interface MvpActivityInterface<P extends MvpPresenter> extends MvpView<P> {
    MvpActivityComponent<P> getMvpActivityComponent();
    void setMvpActivityComponent(MvpActivityComponent<P> component);

    @Override @CallSuper
    default P getPresenter() {
        return getMvpActivityComponent().getPresenter();
    }

    @Override @CallSuper
    default void attachPresenter(P presenter) {
        getMvpActivityComponent().setPresenter(presenter);

        presenter.onAttach(this);
    }
}
