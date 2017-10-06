package ch.grze.frogmentexample.sample.keepingfragmentstate;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.grze.frogment.activity.AbstractFrogmentActivity;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogmentexample.R;
import ch.grze.frogmentexample.sample.commons.FragmentSecond;

public class Activity extends AbstractFrogmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment_switching_from_activity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.first_fragment)
    public void onFragment1Click() {
        switchFrogment(FrogmentData.forClass(FragmentCounter.class));
    }

    @OnClick(R.id.second_fragment)
    public void onFragment2Click() {
        switchFrogment(FrogmentData.forClass(FragmentSecond.class));
    }

    @Override
    public int getFrogmentContainerId() {
        return R.id.fragment_container;
    }

    @Override
    public FrogmentData getDefaultFrogmentData() {
        return FrogmentData.forClass(FragmentCounter.class);
    }
}
