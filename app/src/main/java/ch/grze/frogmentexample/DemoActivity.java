package ch.grze.frogmentexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.grze.frogment.activity.FrogmentActivityInterface;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogmentexample.sample.commons.FragmentCounterState;
import ch.grze.frogmentexample.sample.commons.FragmentSecond;
import ch.grze.frogmentexample.sample.keepingfragmentstate.FragmentCounter;

public class DemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.simple_implementation)
    public void onSimpleImplementationClick() {
        final Intent intent = new Intent(this, ch.grze.frogmentexample.sample.simpleimplementation.Activity.class);
        startActivity(intent);
    }

    @OnClick(R.id.fragment_switching_from_activity)
    public void onFragmentSwitchingFromActivityClick() {
        final Intent intent = new Intent(this, ch.grze.frogmentexample.sample.fragmentswitchingfromactivity.Activity.class);
        startActivity(intent);
    }

    @OnClick(R.id.fragment_switching_from_fragment)
    public void onFragmentSwitchingFromFragmentClick() {
        final Intent intent = new Intent(this, ch.grze.frogmentexample.sample.fragmentswitchingfromfragment.Activity.class);
        startActivity(intent);
    }

    @OnClick(R.id.defining_initial_fragment)
    public void onDefiningInitialFragmentClick() {
        final Intent intent = new Intent(this, ch.grze.frogmentexample.sample.defininginitialfragment.Activity.class);
        intent.putExtra(FrogmentActivityInterface.FROGMENT_DATA, FrogmentData.forClass(FragmentSecond.class));
        startActivity(intent);
    }

    @OnClick(R.id.defining_initial_fragment_with_state)
    public void onDefiningInitialFragmentWithStateClick() {
        final FrogmentData frogmentData = new FrogmentData.Builder(FragmentCounter.class)
                .state(new FragmentCounterState(100))
                .build();

        final Intent intent = new Intent(this, ch.grze.frogmentexample.sample.defininginitialfragment.Activity.class);
        intent.putExtra(FrogmentActivityInterface.FROGMENT_DATA, frogmentData);
        startActivity(intent);
    }

    @OnClick(R.id.keeping_fragment_state)
    public void onKeepingFragmentStateClick() {
        final Intent intent = new Intent(this, ch.grze.frogmentexample.sample.keepingfragmentstate.Activity.class);
        startActivity(intent);
    }

    @OnClick(R.id.activity_state)
    public void onActivityStateClick() {
        final Intent intent = new Intent(this, ch.grze.frogmentexample.sample.activitystate.Activity.class);
        startActivity(intent);
    }

    @OnClick(R.id.activity_state_provider)
    public void onActivityStateProviderClick() {
        final Intent intent = new Intent(this, ch.grze.frogmentexample.sample.activitystateprovider.Activity.class);
        startActivity(intent);
    }

    @OnClick(R.id.activity_switching)
    public void onActivitySwitchingClick() {
        final Intent intent = new Intent(this, ch.grze.frogmentexample.sample.activityswitching.Activity1.class);
        startActivity(intent);
    }

    @OnClick(R.id.mvp_simple)
    public void onMvpSimpleClick() {
        final Intent intent = new Intent(this, ch.grze.frogmentexample.sample.simplemvp.SimpleActivity.class);
        startActivity(intent);
    }
}
