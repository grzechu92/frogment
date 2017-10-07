package ch.grze.frogment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import ch.grze.frogment.State;
import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.backstack.BackStackFrogmentManager;
import ch.grze.frogment.core.provider.FragmentInstanceProvider;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogment.frogment.FrogmentInterface;
import ch.grze.frogment.frogment.StateAwareFrogmentInterface;

final public class FrogmentActivityComponent {
    private final FrogmentActivityInterface frogmentActivity;
    private final Activity activity;
    private final Core core;

    private FrogmentData frogmentData;

    public FrogmentActivityComponent(Core core, FrogmentActivityInterface frogmentActivity) {
        this.core = core;
        this.frogmentActivity = frogmentActivity;

        activity = (Activity) frogmentActivity;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        final FragmentManager fragmentManager = frogmentActivity.getSupportFragmentManager();

        new BackStackFrogmentManager(fragmentManager, frogmentActivity);

        final FrogmentData defaultFrogmentData = frogmentActivity.getDefaultFrogmentData();
        final Intent intent = frogmentActivity.getIntent();

        final FrogmentData frogmentData = core.getParser().getData(FrogmentActivityInterface.FROGMENT_DATA, defaultFrogmentData, savedInstanceState, intent);
        frogmentActivity.switchFrogment(frogmentData);

        for (FragmentManager.FragmentLifecycleCallbacks callbacks : core.getFragmentLifecycleCallbacks()) {
            fragmentManager.registerFragmentLifecycleCallbacks(callbacks, true);
        }
    }

    public void onActivitySaveInstanceState(Bundle bundle) {
        bundle.putParcelable(FrogmentActivityInterface.FROGMENT_DATA, frogmentData);
    }

    public void onFrogmentConfigure(FrogmentInterface frogment) {
        final FrogmentData data = frogment.getData();
        frogmentData = data;

        if (frogment instanceof StateAwareFrogmentInterface) {
            final StateAwareFrogmentInterface stateAwareFrogment = (StateAwareFrogmentInterface) frogment;
            final State state;

            if (data.getState() == null || !(data.getState() instanceof State)) {
                state = stateAwareFrogment.getDefaultState();
            } else {
                state = data.getState();
            }

            final Bundle bundle = new Bundle();
            bundle.putParcelable(StateAwareFrogmentInterface.STATE, state);

            frogment.setArguments(bundle);
        }
    }

    public void onBackStackEmpty() {
        if (core.getConfig().isCallActivityFinishOnEmptyBackStack()) {
            frogmentActivity.finish();
        }
    }

    public void switchFrogment(FrogmentData data) {
        final FrogmentInterface frogment = getFrogmentFrom(data);
        frogment.setData(data);

        onFrogmentConfigure(frogment);

        frogmentActivity.getSupportFragmentManager().beginTransaction()
                .replace(frogmentActivity.getFrogmentContainerId(), (Fragment) frogment, data.getTag())
                .addToBackStack(data.getTag())
                .commit();
    }

    public void switchActivity(FrogmentActivityData data) {
        final Intent intent = new Intent(activity, data.getClazz());

        if (StateAwareFrogmentActivityInterface.class.isAssignableFrom(data.getClazz()) && data.getState() != null) {
            intent.putExtra(StateAwareFrogmentActivityInterface.STATE, data.getState());
        }

        if (FrogmentActivityInterface.class.isAssignableFrom(data.getClazz()) && data.getFrogmentData() != null) {
            intent.putExtra(FrogmentActivityInterface.FROGMENT_DATA, data.getFrogmentData());
        }

        frogmentActivity.startActivity(intent);
        frogmentActivity.finish();
    }

    private FrogmentInterface getFrogmentFrom(FrogmentData data) {
        final FrogmentInterface fragmentByTag = (FrogmentInterface) frogmentActivity.getSupportFragmentManager().findFragmentByTag(data.getTag());
        final FragmentInstanceProvider fragmentInstanceProvider = core.getConfig().getFragmentInstanceProvider();

        final FrogmentInterface frogment = fragmentByTag != null ? fragmentByTag : fragmentInstanceProvider.getInstance(data.getClazz());

        core.injectComponents((Fragment) frogment);

        return frogment;
    }
}
