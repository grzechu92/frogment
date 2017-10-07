package ch.grze.frogmentmvp.activity;

import ch.grze.frogment.core.Core;
import ch.grze.frogmentmvp.MvpPresenter;

public final class MvpActivityComponent<P extends MvpPresenter> {
    private final MvpActivityInterface<P> mvpActivityInterface;
    private final Core core;

    public MvpActivityComponent(Core core, MvpActivityInterface<P> mvpActivityInterface) {
        this.core = core;
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
