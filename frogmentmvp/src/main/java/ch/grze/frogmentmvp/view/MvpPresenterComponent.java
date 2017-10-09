package ch.grze.frogmentmvp.view;

import ch.grze.frogmentmvp.presenter.MvpPresenter;

public final class MvpPresenterComponent<P extends MvpPresenter> {
    private final PresenterAwareMvpView<P> mvpActivityInterface;

    public MvpPresenterComponent(PresenterAwareMvpView<P> mvpActivityInterface) {
        this.mvpActivityInterface = mvpActivityInterface;
    }

    private P presenter;

    public P getPresenter() {
        return presenter;
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }
}
