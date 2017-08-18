package ch.grze.frogmentexample.sample.activitystateprovider;

import android.os.Parcel;

import ch.grze.frogment.activity.FrogmentActivityState;

public class State extends FrogmentActivityState {
    private String text;

    public State(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.text);
    }

    protected State(Parcel in) {
        this.text = in.readString();
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
