package ch.grze.frogmentmvp.fragment;

import android.support.v4.app.Fragment;

import ch.grze.frogment.frogment.FrogmentComponent;
import ch.grze.frogment.frogment.FrogmentInterface;
import ch.grze.frogmentmvp.presenter.MvpPresenter;
import ch.grze.frogmentmvp.view.MvpPresenterComponent;
import ch.grze.frogmentmvp.view.PresenterAwareMvpView;

//still in Java due to lack of interop: https://youtrack.jetbrains.com/issue/KT-19415
public abstract class AbstractMvpFrogment<P extends MvpPresenter> extends Fragment implements PresenterAwareMvpView<P>, FrogmentInterface {
    private MvpPresenterComponent<P> mvpPresenterComponent;
    private FrogmentComponent frogmentComponent;

    @Override
    public MvpPresenterComponent<P> getMvpPresenterComponent() {
        return mvpPresenterComponent;
    }

    @Override
    public void setMvpPresenterComponent(MvpPresenterComponent<P> component) {
        mvpPresenterComponent = component;
    }

    @Override
    public FrogmentComponent getFrogmentComponent() {
        return frogmentComponent;
    }

    @Override
    public void setFrogmentComponent(FrogmentComponent component) {
        frogmentComponent = component;
    }
}
