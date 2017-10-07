package ch.grze.frogment.core.parser;

import android.content.Intent;
import android.os.Bundle;

public class Parser {
    public <T> T getData(String key, T defaultData, Bundle primary, Intent secondary) {
        T data;

        final T primaryData = getDataFrom(key, primary);
        final T secondaryData = getDataFrom(key, secondary);

        data = (primaryData != null) ? primaryData : secondaryData;
        return (data == null) ? defaultData : data;
    }

    public <T> T getData(String key, T defaultData, Bundle primary, Bundle secondary) {
        T state;

        final T primaryData = getDataFrom(key, primary);
        final T secondaryData = getDataFrom(key, secondary);

        state = (primaryData != null) ? primaryData : secondaryData;
        return state == null ? defaultData : state;
    }

    private <T> T getDataFrom(String key, Bundle bundle) {
        if (bundle != null && bundle.getParcelable(key) != null) {
            return (T) bundle.getParcelable(key);
        }

        return null;
    }

    private <T> T getDataFrom(String key, Intent intent) {
        if (intent.getExtras() != null && intent.getExtras().getParcelable(key) != null) {
            return (T) intent.getExtras().getParcelable(key);
        }

        return null;
    }
}
