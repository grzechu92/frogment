package ch.grze.frogment.activity;

import android.support.v7.app.AppCompatActivity;

//still in Java due to lack of interop: https://youtrack.jetbrains.com/issue/KT-19415
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
