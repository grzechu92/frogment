package ch.grze.frogmentmvp;

public interface MvpView<P extends MvpPresenter> {
    P getPresenter();
    void attachPresenter(P presenter);
}
