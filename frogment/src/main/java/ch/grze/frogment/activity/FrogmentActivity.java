package ch.grze.frogment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.CoreAware;
import ch.grze.frogment.core.module.backstack.BackStackChangeListener;
import ch.grze.frogment.core.module.provider.FragmentInstanceProvider;
import ch.grze.frogment.frogment.Frogment;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogment.frogment.FrogmentState;
import ch.grze.frogment.frogment.StateAwareFrogment;

public abstract class FrogmentActivity extends AppCompatActivity implements BackStackChangeListener, CoreAware {
    public static final String FROGMENT_DATA = "frogment_data";

    private final int frogmentContainerId;

    private FrogmentData frogmentData;
    private Core core;

    public FrogmentActivity(@IdRes int frogmentContainerId) {
        this.frogmentContainerId = frogmentContainerId;
    }

    @Override
    final public void setCore(Core core) {
        this.core = core;
    }

    @Override
    final public Core getCore() {
        return core;
    }

    @Override @CallSuper
    public void onFrogmentPushed(Frogment frogment) {
        onFrogmentConfigure(frogment);
    }

    @Override @CallSuper
    public void onFrogmentPopped(Frogment frogment) {
        onFrogmentConfigure(frogment);
    }

    @Override @CallSuper
    public void onBackStackEmpty() {
        if (core.getConfig().isCallActivityFinishOnEmptyBackStack()) {
            finish();
        }
    }

    final public FrogmentData getFrogmentData() {
        return frogmentData;
    }

    public void switchFrogment(FrogmentData data) {
        final Frogment frogment = getFrogmentFrom(data);
        frogment.setData(data);

        onFrogmentConfigure(frogment);

        getSupportFragmentManager().beginTransaction()
                .replace(frogmentContainerId, frogment, data.getTag())
                .addToBackStack(data.getTag())
                .commit();
    }

    public void switchActivity(FrogmentActivityData data) {
        final Intent intent = new Intent(this, data.getClazz());

        if (StateAwareFrogmentActivity.class.isAssignableFrom(data.getClazz()) && data.getState() != null) {
            intent.putExtra(StateAwareFrogmentActivity.STATE, data.getState());
        }

        if (FrogmentActivity.class.isAssignableFrom(data.getClazz()) && data.getFrogmentData() != null) {
            intent.putExtra(FrogmentActivity.FROGMENT_DATA, data.getFrogmentData());
        }

        startActivity(intent);
        finish();
    }

    protected abstract FrogmentData getDefaultFrogmentData();

    @CallSuper
    protected void onFrogmentConfigure(Frogment frogment) {
        final FrogmentData data = frogment.getData();
        frogmentData = data;

        if (frogment instanceof StateAwareFrogment) {
            final StateAwareFrogment stateAwareFrogment = (StateAwareFrogment) frogment;
            final FrogmentState state;

            if (data.getState() == null || !(data.getState() instanceof FrogmentState)) {
                state = (FrogmentState) stateAwareFrogment.getDefaultState();
            } else {
                state = data.getState();
            }

            final Bundle bundle = new Bundle();
            bundle.putParcelable(StateAwareFrogment.STATE, state);

            frogment.setArguments(bundle);
        }
    }

    private Frogment getFrogmentFrom(FrogmentData data) {
        final Frogment fragmentByTag = (Frogment) getSupportFragmentManager().findFragmentByTag(data.getTag());
        final FragmentInstanceProvider fragmentInstanceProvider = core.getConfig().getFragmentInstanceProvider();

        return fragmentByTag != null ? fragmentByTag : fragmentInstanceProvider.getInstance(data.getClazz());
    }
}
