package ch.grze.frogmentexample.sample.simplemvp;

import ch.grze.frogmentmvp.MvpPresenter;

public interface SimpleMvpPresenter extends MvpPresenter<SimpleMvpView> {
    void onButtonClicked();
}
