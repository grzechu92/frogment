package ch.grze.frogment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import ch.grze.frogment.exception.UnableToCreateFrogmentInstanceException;
import ch.grze.frogment.frogment.Frogment;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogment.frogment.FrogmentState;
import ch.grze.frogment.frogment.StateAwareFrogment;

public abstract class FrogmentActivity extends AppCompatActivity {
    public static final String FROGMENT_DATA = "frogment_data";

    private final FragmentManager supportFragmentManager;
    private final int frogmentContainerId;

    private FrogmentData frogmentData;

    public FrogmentActivity(@IdRes int frogmentContainerId) {
        this.frogmentContainerId = frogmentContainerId;

        supportFragmentManager = getSupportFragmentManager();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final FrogmentData frogmentData = getData(FROGMENT_DATA, getDefaultFrogmentData(), getIntent(), savedInstanceState);
        switchFrogment(frogmentData);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(FROGMENT_DATA, frogmentData);
    }

    public void switchFrogment(FrogmentData data) {
        final Fragment fragment = getFragmentFrom(data);

        if (fragment instanceof StateAwareFrogment) {
            final StateAwareFrogment stateAwareFrogment = (StateAwareFrogment) fragment;
            final FrogmentState state;

            if (data.getState() == null || !(data.getState() instanceof FrogmentState)) {
                state = (FrogmentState) stateAwareFrogment.getDefaultState();
            } else {
                state = data.getState();
            }

            final Bundle bundle = new Bundle();
            bundle.putParcelable(StateAwareFrogment.STATE, state);

            fragment.setArguments(bundle);
        }

        frogmentData = data;

        supportFragmentManager.beginTransaction()
                .replace(frogmentContainerId, fragment, data.getTag())
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

    protected Fragment getFragmentFrom(FrogmentData data) {
        final Fragment fragmentByTag = supportFragmentManager.findFragmentByTag(data.getTag());

        return fragmentByTag != null ? fragmentByTag : getFrogmentInstance(data.getClazz());
    }

    protected Frogment getFrogmentInstance(Class<? extends Frogment> frogmentClass) {
        try {
            return frogmentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new UnableToCreateFrogmentInstanceException(frogmentClass);
        }
    }

    protected <T> T getDataFromBundle(String key, Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.getParcelable(key) != null) {
            return (T) savedInstanceState.getParcelable(key);
        }

        return null;
    }

    protected <T> T getDataFromIntent(String key, Intent intent) {
        if (intent.getExtras() != null && intent.getExtras().getParcelable(key) != null) {
            return (T) intent.getExtras().getParcelable(key);
        }

        return null;
    }

    protected <T> T getData(String key, T defaultData, Intent intent, Bundle bundle) {
        T data;

        final T dataFromIntent = getDataFromIntent(key, intent);
        final T dataFromSavedInstance = getDataFromBundle(key, bundle);

        data = (dataFromSavedInstance != null) ? dataFromSavedInstance : dataFromIntent;
        return (data == null) ? defaultData : data;
    }
}
