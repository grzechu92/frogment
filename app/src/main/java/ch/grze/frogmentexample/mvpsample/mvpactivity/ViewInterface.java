package ch.grze.frogmentexample.mvpsample.mvpactivity;

import ch.grze.frogmentmvp.view.MvpView;

public interface ViewInterface extends MvpView<PresenterInterface> {
    void setStatus(String status);
}
