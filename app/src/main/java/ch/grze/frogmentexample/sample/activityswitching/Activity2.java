package ch.grze.frogmentexample.sample.activityswitching;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ch.grze.frogment.activity.StateAwareFrogmentActivity;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogmentexample.R;
import ch.grze.frogmentexample.sample.fragments.FragmentSecond;

public class Activity2 extends StateAwareFrogmentActivity<State> {
    @BindView(R.id.state) protected TextView stateView;

    public Activity2() {
        super(R.id.fragment_container);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_with_state);

        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
        updateView();
    }

    @Override
    public State getDefaultState() {
        return new State("Activity2 default state");
    }

    @Override
    protected FrogmentData getDefaultFrogmentData() {
        return FrogmentData.forClass(FragmentSecond.class);
    }

    @Override
    public void onStateChanged(State state) {
        super.onStateChanged(state);

        updateView();
    }

    private void updateView() {
        stateView.setText(state.getText());
    }
}
