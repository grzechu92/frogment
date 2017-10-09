package ch.grze.frogmentexample.mvpsample.mvpactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.grze.frogmentexample.R;
import ch.grze.frogmentmvp.view.MvpPresenterComponent;
import ch.grze.frogmentmvp.view.PresenterAwareMvpView;

public class Activity extends AppCompatActivity implements PresenterAwareMvpView<PresenterInterface>, ViewInterface {
    private MvpPresenterComponent<PresenterInterface> mvpPresenterMvpPresenterComponent;
    private PresenterInterface presenter = new Presenter(); //inject Presenter instance using DI

    @BindView(R.id.status) protected TextView statusView;

    @Override
    public MvpPresenterComponent<PresenterInterface> getMvpPresenterComponent() {
        return mvpPresenterMvpPresenterComponent;
    }

    @Override
    public void setMvpPresenterComponent(MvpPresenterComponent<PresenterInterface> component) {
        mvpPresenterMvpPresenterComponent = component;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_with_status);

        ButterKnife.bind(this);

        attachPresenter(presenter);
    }

    @Override
    public void setStatus(String status) {
        statusView.setText(status);
    }

    @OnClick(R.id.button)
    protected void onButtonClicked() {
        getPresenter().onButtonClicked();
    }
}