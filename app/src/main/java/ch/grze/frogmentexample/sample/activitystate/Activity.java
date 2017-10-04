package ch.grze.frogmentexample.sample.activitystate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ch.grze.frogment.activity.StateAwareFrogmentActivity;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogmentexample.R;

public class Activity extends StateAwareFrogmentActivity<State> {
    @BindView(R.id.state) protected TextView stateView;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_with_state);
        ButterKnife.bind(this);
    }

    @Override
    public State getDefaultState() {
        return new State(0, false);
    }

    @Override
    public void onViewStateChange(State state) {
        if (!state.isChanged()) {
            stateView.setText("State not changed");
        } else {
            stateView.setText("Counter value: " + state.getCounter());
        }
    }

    @Override
    protected FrogmentData getDefaultFrogmentData() {
        return FrogmentData.forClass(FragmentCounterWithActivityState.class);
    }

    @Override
    protected int getFrogmentContainerId() {
        return R.id.fragment_container;
    }
}
