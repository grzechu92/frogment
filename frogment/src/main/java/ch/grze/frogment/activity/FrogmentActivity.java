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

        final FrogmentData frogmentData = getInitialFrogment(getIntent(), savedInstanceState);
        switchFrogment(frogmentData);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(FROGMENT_DATA, frogmentData);
    }

    public void switchFrogment(FrogmentData data) {
        final Fragment frogmentByTag = supportFragmentManager.findFragmentByTag(data.getTag());
        final Fragment frogment = frogmentByTag != null ? frogmentByTag : getFrogmentInstance(data.getClazz());

        if (frogment instanceof StateAwareFrogment) {
            final StateAwareFrogment stateAwareFrogment = (StateAwareFrogment) frogment;
            final FrogmentState state;

            if (data.getState() == null || !(data.getState() instanceof FrogmentState)) {
                state = stateAwareFrogment.getDefaultState();
            } else {
                state = data.getState();
            }

            final Bundle bundle = new Bundle();
            bundle.putParcelable(StateAwareFrogment.STATE, state);

            frogment.setArguments(bundle);
        }

        frogmentData = data;

        supportFragmentManager.beginTransaction()
                .replace(frogmentContainerId, frogment, data.getTag())
                .commit();
    }

    protected abstract FrogmentData getDefaultFrogmentData();

    protected Frogment getFrogmentInstance(Class<? extends Frogment> frogmentClass) {
        try {
            return frogmentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new UnableToCreateFrogmentInstanceException(frogmentClass);
        }
    }

    protected  FrogmentData getFrogmentDataFromSavedInstance(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.getParcelable(FROGMENT_DATA) != null) {
            return savedInstanceState.getParcelable(FROGMENT_DATA);
        }

        return null;
    }

    protected FrogmentData getFrogmentDataFromIntentExtras(Intent intent) {
        if (intent.getExtras() != null && intent.getExtras().getParcelable(FROGMENT_DATA) != null) {
            return intent.getExtras().getParcelable(FROGMENT_DATA);
        }

        return null;
    }

    protected FrogmentData getInitialFrogment(Intent intent, Bundle savedInstanceState) {
        FrogmentData frogmentData = null;

        final FrogmentData frogmentDataFromIntentExtras = getFrogmentDataFromIntentExtras(intent);
        final FrogmentData frogmentDataFromSavedInstance = getFrogmentDataFromSavedInstance(savedInstanceState);

        if (frogmentDataFromSavedInstance != null) {
            frogmentData = frogmentDataFromSavedInstance;
        } else {
            if (frogmentDataFromIntentExtras != null) {
                frogmentData = frogmentDataFromIntentExtras;
            }
        }

        return frogmentData == null ? getDefaultFrogmentData() : frogmentData;
    }
}
