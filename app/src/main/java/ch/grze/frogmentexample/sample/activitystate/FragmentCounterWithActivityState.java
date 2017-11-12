package ch.grze.frogmentexample.sample.activitystate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.grze.frogment.StateCallbacks;
import ch.grze.frogment.frogment.AbstractStateAwareFrogment;
import ch.grze.frogmentexample.R;
import ch.grze.frogmentexample.sample.commons.FragmentCounterState;

public class FragmentCounterWithActivityState extends AbstractStateAwareFrogment<FragmentCounterState> implements StateCallbacks.OnViewStateChange<FragmentCounterState> {
    @BindView(R.id.value) protected TextView value;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_counter, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
    }

    @Override
    public FragmentCounterState getDefaultState() {
        return new FragmentCounterState(0);
    }

    @Override
    public void onViewStateChange(FragmentCounterState state) {
        value.setText(String.valueOf(state.getValue()));
    }

    @OnClick(R.id.increment)
    public void onIncrementClick() {
        final FragmentCounterState state = getState();

        int value = state.getValue();
        state.setValue(++value);

        onViewStateChange(state);
        updateActivity();
    }

    @OnClick(R.id.decrement)
    public void onDecrementClick() {
        final FragmentCounterState state = getState();

        int value = state.getValue();
        state.setValue(--value);

        onViewStateChange(state);
        updateActivity();
    }

    private void updateActivity() {
        final Activity activity = getTypedActivity();
        final State state = activity.getState();

        state.setChanged(true);
        state.setCounter(getState().getValue());

        activity.setState(state);
    }
}
