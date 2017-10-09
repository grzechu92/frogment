package ch.grze.frogmentexample.mvpsample.mvpfragment;

import ch.grze.frogmentmvp.presenter.AbstractMvpPresenter;

public class Presenter extends AbstractMvpPresenter<ViewInterface> implements PresenterInterface {
    @Override
    public void onAttach(ViewInterface view) {
        super.onAttach(view);

        getView().setStatus("Not clicked!");
    }

    @Override
    public void onButtonClicked() {
        getView().setStatus("Clicked!");
    }
}
