package ch.grze.frogmentexample.sample.activitystateprovider;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ch.grze.frogment.activity.AbstractStateAwareFrogmentActivity;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogmentexample.R;

public class Activity extends AbstractStateAwareFrogmentActivity<State> {
    @BindView(R.id.state) protected TextView stateView;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_with_state);
        ButterKnife.bind(this);
    }

    @Override
    public State getDefaultState() {
        return new State("Default state");
    }

    @Override
    public void onViewStateChange(State state) {
        stateView.setText(state.getText());
    }

    @Override
    public int getFrogmentContainerId() {
        return R.id.fragment_container;
    }

    @Override
    public FrogmentData getDefaultFrogmentData() {
        return FrogmentData.forClass(FragmentStateProvider.class);
    }
}
