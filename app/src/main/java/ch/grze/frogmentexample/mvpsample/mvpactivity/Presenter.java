package ch.grze.frogmentexample.mvpsample.mvpactivity;

import ch.grze.frogmentmvp.presenter.AbstractMvpPresenter;

public class Presenter extends AbstractMvpPresenter<Contract.View> implements Contract.Presenter {
    @Override
    public void onAttach(Contract.View view) {
        view.setStatus("Not clicked!");
    }

    @Override
    public void onDetach() {}

    @Override
    public void onButtonClicked() {
        getView().setStatus("Clicked!");
    }
}
