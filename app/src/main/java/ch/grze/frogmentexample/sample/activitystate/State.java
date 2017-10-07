package ch.grze.frogmentexample.sample.activitystate;

import android.os.Parcel;

public class State implements ch.grze.frogment.State {
    private int counter;
    private boolean changed;

    public State(int counter, boolean changed) {
        this.counter = counter;
        this.changed = changed;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.counter);
        dest.writeByte(this.changed ? (byte) 1 : (byte) 0);
    }

    protected State(Parcel in) {
        this.counter = in.readInt();
        this.changed = in.readByte() != 0;
    }

    public static final Creator<State> CREATOR = new Creator<State>() {
        @Override
        public State createFromParcel(Parcel source) {
            return new State(source);
        }

        @Override
        public State[] newArray(int size) {
            return new State[size];
        }
    };
}
