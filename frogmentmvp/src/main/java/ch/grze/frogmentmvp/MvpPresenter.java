package ch.grze.frogmentmvp;

public interface MvpPresenter<V extends MvpView> {
    void onAttach(V view);
    V getView();
}
