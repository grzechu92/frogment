package ch.grze.frogmentexample.mvpsample.mvpfragment;

import ch.grze.frogmentmvp.presenter.MvpPresenter;

public interface PresenterInterface extends MvpPresenter<ViewInterface> {
    void onButtonClicked();
}
