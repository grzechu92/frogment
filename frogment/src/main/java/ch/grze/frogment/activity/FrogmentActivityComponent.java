package ch.grze.frogment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.module.backstack.BackStackFrogmentManager;
import ch.grze.frogment.core.module.provider.FragmentInstanceProvider;
import ch.grze.frogment.frogment.Frogment;
import ch.grze.frogment.frogment.FrogmentData;
import ch.grze.frogment.frogment.FrogmentState;
import ch.grze.frogment.frogment.StateAwareFrogment;

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

    public void onFrogmentConfigure(Frogment frogment) {
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

    public void onBackStackEmpty() {
        if (core.getConfig().isCallActivityFinishOnEmptyBackStack()) {
            frogmentActivity.finish();
        }
    }

    public void switchFrogment(FrogmentData data) {
        final Frogment frogment = getFrogmentFrom(data);
        frogment.setData(data);

        onFrogmentConfigure(frogment);

        frogmentActivity.getSupportFragmentManager().beginTransaction()
                .replace(frogmentActivity.getFrogmentContainerId(), frogment, data.getTag())
                .addToBackStack(data.getTag())
                .commit();
    }

    public void switchActivity(FrogmentActivityData data) {
        final Intent intent = new Intent(activity, data.getClazz());

        if (AbstractStateAwareFrogmentActivity.class.isAssignableFrom(data.getClazz()) && data.getState() != null) {
            intent.putExtra(AbstractStateAwareFrogmentActivity.STATE, data.getState());
        }

        if (AbstractFrogmentActivity.class.isAssignableFrom(data.getClazz()) && data.getFrogmentData() != null) {
            intent.putExtra(AbstractFrogmentActivity.FROGMENT_DATA, data.getFrogmentData());
        }

        frogmentActivity.startActivity(intent);
        frogmentActivity.finish();
    }

    private Frogment getFrogmentFrom(FrogmentData data) {
        final Frogment fragmentByTag = (Frogment) frogmentActivity.getSupportFragmentManager().findFragmentByTag(data.getTag());
        final FragmentInstanceProvider fragmentInstanceProvider = core.getConfig().getFragmentInstanceProvider();

        return fragmentByTag != null ? fragmentByTag : fragmentInstanceProvider.getInstance(data.getClazz());
    }
}
