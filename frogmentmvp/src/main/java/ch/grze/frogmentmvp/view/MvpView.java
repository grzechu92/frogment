package ch.grze.frogmentmvp.view;

import ch.grze.frogmentmvp.presenter.MvpPresenter;

public interface MvpView<P extends MvpPresenter> {
    P getPresenter();
    void attachPresenter(P presenter);
}
