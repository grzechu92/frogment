package ch.grze.frogmentmvp.activity;

import ch.grze.frogment.activity.FrogmentActivityComponent;
import ch.grze.frogment.activity.FrogmentActivityInterface;
import ch.grze.frogmentmvp.presenter.MvpPresenter;

public abstract class AbstractMvpFrogmentActivity<P extends MvpPresenter> extends AbstractMvpActivity<P> implements FrogmentActivityInterface {
    private FrogmentActivityComponent frogmentActivityComponent;

    @Override
    public FrogmentActivityComponent getFrogmentActivityComponent() {
        return frogmentActivityComponent;
    }

    @Override
    public void setFrogmentActivityComponent(FrogmentActivityComponent component) {
        frogmentActivityComponent = component;
    }
}
