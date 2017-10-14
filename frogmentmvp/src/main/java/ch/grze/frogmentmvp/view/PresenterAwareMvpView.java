package ch.grze.frogmentmvp.view;

import android.support.annotation.CallSuper;

import ch.grze.frogmentmvp.presenter.MvpPresenter;

//still in Java due to lack of interop: https://youtrack.jetbrains.com/issue/KT-19415
public interface PresenterAwareMvpView<P extends MvpPresenter> extends MvpView<P> {
    MvpPresenterComponent<P> getMvpPresenterComponent();
    void setMvpPresenterComponent(MvpPresenterComponent<P> component);

    @Override @CallSuper
    default P getPresenter() {
        return getMvpPresenterComponent().getPresenter();
    }

    @Override @CallSuper
    default void attachPresenter(P presenter) {
        getMvpPresenterComponent().setPresenter(presenter);

        presenter.onAttach(this);
    }
}
