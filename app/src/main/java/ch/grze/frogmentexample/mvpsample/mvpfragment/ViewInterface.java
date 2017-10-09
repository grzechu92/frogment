package ch.grze.frogmentexample.mvpsample.mvpfragment;

import ch.grze.frogmentmvp.view.PresenterAwareMvpView;

public interface ViewInterface extends PresenterAwareMvpView<PresenterInterface> {
    void setStatus(String status);
}
