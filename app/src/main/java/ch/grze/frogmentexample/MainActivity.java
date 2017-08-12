package ch.grze.frogmentexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ch.grze.frogment.activity.FrogmentActivity;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogmentexample.sample.defininginitialfragment.Fragment2;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        intent.putExtra(FrogmentActivity.FROGMENT_DATA, FrogmentData.forClass(Fragment2.class));
        startActivity(intent);
    }

    @OnClick(R.id.keeping_fragment_state)
    public void onKeepingFragmentStateClick() {
        final Intent intent = new Intent(this, ch.grze.frogmentexample.sample.keepingfragmentstate.Activity.class);
        startActivity(intent);
    }
}
