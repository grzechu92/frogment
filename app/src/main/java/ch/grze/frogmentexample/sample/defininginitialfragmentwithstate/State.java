package ch.grze.frogmentexample.sample.defininginitialfragmentwithstate;

import android.os.Parcel;

import ch.grze.frogment.frogment.FrogmentState;

public class State extends FrogmentState {
    private int value;

    public State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.value);
    }

    protected State(Parcel in) {
        this.value = in.readInt();
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
