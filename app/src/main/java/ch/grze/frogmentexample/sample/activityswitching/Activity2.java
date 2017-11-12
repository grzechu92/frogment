package ch.grze.frogmentexample.sample.activityswitching;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ch.grze.frogment.StateCallbacks;
import ch.grze.frogment.activity.AbstractStateAwareFrogmentActivity;
import ch.grze.frogment.core.navigation.FrogmentData;
import ch.grze.frogmentexample.R;
import ch.grze.frogmentexample.sample.commons.FragmentSecond;

public class Activity2 extends AbstractStateAwareFrogmentActivity<State> implements StateCallbacks.OnViewStateChange<State> {
    @BindView(R.id.state) protected TextView stateView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_with_state);
        ButterKnife.bind(this);
    }

    @Override
    public void onViewStateChange(State state) {
        stateView.setText(state.getText());
    }

    @Override
    public State getDefaultState() {
        return new State("Activity2 default state");
    }

    @Override
    public int getFrogmentContainerId() {
        return R.id.fragment_container;
    }

    @Override
    public FrogmentData getDefaultFrogmentData() {
        return FrogmentData.forClass(FragmentSecond.class);
    }
}
