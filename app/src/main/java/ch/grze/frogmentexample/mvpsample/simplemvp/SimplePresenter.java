package ch.grze.frogmentexample.mvpsample.simplemvp;

import ch.grze.frogmentmvp.presenter.AbstractMvpPresenter;

public class SimplePresenter extends AbstractMvpPresenter<SimpleMvpView> implements SimpleMvpPresenter {
    @Override
    public void onAttach(SimpleMvpView view) {
        super.onAttach(view);

        getView().setStatus("Not clicked!");
    }

    @Override
    public void onButtonClicked() {
        getView().setStatus("Clicked!");
    }
}
