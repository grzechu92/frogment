package ch.grze.frogmentexample.sample.keepingfragmentstate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.grze.frogment.frogment.StateAwareFrogment;
import ch.grze.frogmentexample.R;

public class FragmentCounter extends StateAwareFrogment<State> {
    @BindView(R.id.value) protected TextView value;
    
    public FragmentCounter() {
        super(R.layout.fragment_counter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        updateView();
    }

    @Override
    public State getDefaultState() {
        return new State(0);
    }

    @OnClick(R.id.increment)
    public void onIncrementClick() {
        int value = state.getValue();
        state.setValue(++value);

        updateView();
    }

    @OnClick(R.id.decrement)
    public void onDecrementClick() {
        int value = state.getValue();
        state.setValue(--value);

        updateView();
    }

    private void updateView() {
        value.setText(String.valueOf(state.getValue()));
    }
}
