package ch.grze.frogmentexample.mvpsample.mvpfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.grze.frogment.frogment.AbstractFrogment;
import ch.grze.frogmentexample.R;
import ch.grze.frogmentmvp.view.MvpPresenterComponent;

public class Fragment extends AbstractFrogment implements ViewInterface {
    private MvpPresenterComponent<PresenterInterface> mvpPresenterComponent;
    private PresenterInterface presenter = new Presenter();

    @BindView(R.id.status) protected TextView statusView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.button_with_status, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
        attachPresenter(presenter);
    }

    @Override
    public MvpPresenterComponent<PresenterInterface> getMvpPresenterComponent() {
        return mvpPresenterComponent;
    }

    @Override
    public void setMvpPresenterComponent(MvpPresenterComponent<PresenterInterface> component) {
        mvpPresenterComponent = component;
    }

    @Override
    public void setStatus(String status) {
        statusView.setText(status);
    }
    
    @OnClick(R.id.button)
    protected void onButtonClicked() {
        presenter.onButtonClicked();
    }
}
