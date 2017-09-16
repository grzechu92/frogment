package ch.grze.frogmentexample.sample.keepingfragmentstate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.grze.frogment.frogment.StateAwareFrogment;
import ch.grze.frogmentexample.R;
import ch.grze.frogmentexample.sample.commons.FragmentCounterState;

public class FragmentCounter extends StateAwareFrogment<FragmentCounterState> {
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
    public void onViewStateChange(FragmentCounterState state) {
        value.setText(String.valueOf(state.getValue()));
    }

    @Override
    public FragmentCounterState getDefaultState() {
        return new FragmentCounterState(0);
    }

    @OnClick(R.id.increment)
    public void onIncrementClick() {
        int value = state.getValue();
        state.setValue(++value);

        onViewStateChange(state);
    }

    @OnClick(R.id.decrement)
    public void onDecrementClick() {
        int value = state.getValue();
        state.setValue(--value);

        onViewStateChange(state);
    }
}
