package ch.grze.frogmentmvp.presenter;

import ch.grze.frogmentmvp.view.MvpView;

public interface MvpPresenter<V extends MvpView> {
    void onAttach(V view);
    V getView();
}
