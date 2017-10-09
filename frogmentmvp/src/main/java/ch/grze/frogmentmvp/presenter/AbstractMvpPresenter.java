package ch.grze.frogmentmvp.presenter;

import android.support.annotation.CallSuper;

import ch.grze.frogmentmvp.view.MvpView;

public abstract class AbstractMvpPresenter<V extends MvpView> implements MvpPresenter<V> {
    private V view;

    @Override @CallSuper
    public void onAttach(V view) {
        this.view = view;
    }

    @Override
    final public V getView() {
        return view;
    }
}
