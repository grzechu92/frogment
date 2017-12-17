package ch.grze.frogmentexample.mvpsample.mvpfragment;

import ch.grze.frogmentmvp.Mvp;

public interface Contract {
    interface View extends Mvp.View<Presenter> {
        void setStatus(String status);
    }

    interface Presenter extends Mvp.Presenter<View> {
        void onButtonClicked();
    }
}
