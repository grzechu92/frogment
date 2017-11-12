package ch.grze.frogmentmvp.activity;

import ch.grze.frogment.activity.FrogmentActivityComponent;
import ch.grze.frogment.activity.FrogmentActivityInterface;
import ch.grze.frogmentmvp.presenter.MvpPresenter;

//still in Java due to lack of interop: https://youtrack.jetbrains.com/issue/KT-19415
public abstract class AbstractMvpFrogmentActivity<P extends MvpPresenter> extends AbstractMvpActivity<P> implements FrogmentActivityInterface {
    private FrogmentActivityComponent frogmentActivityComponent;

    @Override
    public FrogmentActivityComponent getFrogmentActivityComponent() {
        return frogmentActivityComponent;
    }
}
