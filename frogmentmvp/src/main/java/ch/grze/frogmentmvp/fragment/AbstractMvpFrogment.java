package ch.grze.frogmentmvp.fragment;

import ch.grze.frogment.frogment.AbstractFrogment;
import ch.grze.frogment.frogment.FrogmentInterface;
import ch.grze.frogmentmvp.presenter.MvpPresenter;
import ch.grze.frogmentmvp.view.MvpPresenterComponent;
import ch.grze.frogmentmvp.view.PresenterAwareMvpView;

//still in Java due to lack of interop: https://youtrack.jetbrains.com/issue/KT-19415
abstract public class AbstractMvpFrogment<P extends MvpPresenter> extends AbstractFrogment implements PresenterAwareMvpView<P>, FrogmentInterface {
    private MvpPresenterComponent<P> mvpPresenterComponent;

    @Override
    public MvpPresenterComponent<P> getMvpPresenterComponent() {
        return mvpPresenterComponent;
    }

    @Override
    public void setMvpPresenterComponent(MvpPresenterComponent<P> component) {
        mvpPresenterComponent = component;
    }
}
