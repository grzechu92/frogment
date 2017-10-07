package ch.grze.frogmentexample.mvpsample.simplemvp;

import ch.grze.frogmentmvp.MvpPresenter;

public interface SimpleMvpPresenter extends MvpPresenter<SimpleMvpView> {
    void onButtonClicked();
}
