package ch.grze.frogment.frogment;

import android.os.Parcelable;

public abstract class FrogmentState implements Parcelable {
    public <T extends FrogmentState> T as(Class<T> clazz) {
        return (T) this;
    }
}
