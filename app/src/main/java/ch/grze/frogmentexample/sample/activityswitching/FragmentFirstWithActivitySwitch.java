package ch.grze.frogmentexample.sample.activityswitching;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.grze.frogment.activity.FrogmentActivityData;
import ch.grze.frogment.frogment.Frogment;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogmentexample.R;

public class FragmentFirstWithActivitySwitch extends Frogment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first_with_button, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.button)
    public void onButtonClick() {
        final FrogmentActivityData data = new FrogmentActivityData.Builder(Activity2.class)
                .state(new State("State from first fragment"))
                .frogmentData(FrogmentData.forClass(FragmentSecondWithActivitySwitch.class))
                .build();

        getFrogmentActivity().switchActivity(data);
    }
}
