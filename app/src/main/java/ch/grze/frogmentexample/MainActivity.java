package ch.grze.frogmentexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

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
}
