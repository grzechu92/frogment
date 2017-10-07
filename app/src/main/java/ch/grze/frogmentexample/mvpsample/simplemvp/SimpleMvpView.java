package ch.grze.frogmentexample.mvpsample.simplemvp;

import ch.grze.frogmentmvp.MvpView;

public interface SimpleMvpView extends MvpView<SimpleMvpPresenter> {
    void setStatus(String status);
}
