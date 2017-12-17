package ch.grze.frogmentexample.mvpsample.mvpactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.grze.frogmentexample.R;
import ch.grze.frogmentmvp.activity.AbstractMvpActivity;

public class Activity extends AbstractMvpActivity<Contract.Presenter> implements Contract.View {
    @BindView(R.id.status) protected TextView statusView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_with_status);

        ButterKnife.bind(this);

        setPresenter(new Presenter());
        getPresenter().onAttach(this);
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
