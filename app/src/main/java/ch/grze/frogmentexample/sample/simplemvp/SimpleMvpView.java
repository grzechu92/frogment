package ch.grze.frogmentexample.sample.simplemvp;

import ch.grze.frogmentmvp.MvpView;

public interface SimpleMvpView extends MvpView<SimpleMvpPresenter> {
    void setStatus(String status);
}
