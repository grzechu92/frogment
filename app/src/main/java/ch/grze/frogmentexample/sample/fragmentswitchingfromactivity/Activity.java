package ch.grze.frogmentexample.sample.fragmentswitchingfromactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.grze.frogment.activity.FrogmentActivity;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogmentexample.R;

public class Activity extends FrogmentActivity {
    public Activity() {
        super(R.id.fragment_container);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_fragment_switching_from_activity);

        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
    }

    @Override
    protected FrogmentData getDefaultFrogmentData() {
        return FrogmentData.forClass(Fragment1.class);
    }

    @OnClick(R.id.first_fragment)
    public void onFragment1Click() {
        switchFrogment(FrogmentData.forClass(Fragment1.class));
    }

    @OnClick(R.id.second_fragment)
    public void onFragment2Click() {
        switchFrogment(FrogmentData.forClass(Fragment2.class));
    }
}
