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
    
    public Activity() {
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
        return new State(0, false);
    }

    @Override
    protected FrogmentData getDefaultFrogmentData() {
        return FrogmentData.forClass(FragmentCounterWithActivityState.class);
    }

    @Override
    public void onStateChanged(State state) {
        super.onStateChanged(state);

        updateView();
    }

    private void updateView() {
        if (!state.isChanged()) {
            stateView.setText("State not changed");
        } else {
            stateView.setText("Counter value: " + state.getCounter());
        }
    }
}
