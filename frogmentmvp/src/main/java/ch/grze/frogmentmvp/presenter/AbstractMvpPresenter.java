package ch.grze.frogmentmvp.presenter;

import android.support.annotation.CallSuper;

import ch.grze.frogmentmvp.view.MvpView;

//still in Java due to lack of interop: https://youtrack.jetbrains.com/issue/KT-19415
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
