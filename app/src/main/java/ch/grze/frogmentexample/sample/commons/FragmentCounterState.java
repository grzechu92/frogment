package ch.grze.frogmentexample.sample.commons;

import android.os.Parcel;

import ch.grze.frogment.frogment.FrogmentState;

public class FragmentCounterState extends FrogmentState {
    private int value;

    public FragmentCounterState(int value) {
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

    protected FragmentCounterState(Parcel in) {
        this.value = in.readInt();
    }

    public static final Creator<FragmentCounterState> CREATOR = new Creator<FragmentCounterState>() {
        @Override
        public FragmentCounterState createFromParcel(Parcel source) {
            return new FragmentCounterState(source);
        }

        @Override
        public FragmentCounterState[] newArray(int size) {
            return new FragmentCounterState[size];
        }
    };
}
