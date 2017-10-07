package ch.grze.frogmentexample.sample.simplemvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.grze.frogmentexample.R;
import ch.grze.frogmentmvp.activity.AbstractMvpActivity;

public class SimpleActivity extends AbstractMvpActivity<SimpleMvpPresenter> implements SimpleMvpView {
    @BindView(R.id.status) protected TextView statusView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_activity_button);

        ButterKnife.bind(this);

        attachPresenter(new SimplePresenter()); //inject Presenter instance via DI
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
