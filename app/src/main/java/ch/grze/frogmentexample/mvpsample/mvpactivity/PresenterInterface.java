package ch.grze.frogmentexample.mvpsample.mvpactivity;

import ch.grze.frogmentmvp.presenter.MvpPresenter;

public interface PresenterInterface extends MvpPresenter<ViewInterface> {
    void onButtonClicked();
}
