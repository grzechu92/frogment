package ch.grze.frogment.activity;

import android.support.v7.app.AppCompatActivity;

public abstract class AbstractFrogmentActivity extends AppCompatActivity implements FrogmentActivityInterface {
    private FrogmentActivityComponent frogmentActivityComponent;

    @Override
    public FrogmentActivityComponent getFrogmentActivityComponent() {
        return frogmentActivityComponent;
    }

    @Override
    public void setFrogmentActivityComponent(FrogmentActivityComponent component) {
        frogmentActivityComponent = component;
    }
}
