package ch.grze.frogment.activity;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;

import ch.grze.frogment.State;
import ch.grze.frogment.frogment.FrogmentData;

public class FrogmentActivityData implements Parcelable {
    private final Class<? extends AppCompatActivity> clazz;
    private final State state;
    private final FrogmentData frogmentData;

    public FrogmentActivityData(Class<? extends AppCompatActivity> clazz, State state, FrogmentData frogmentData) {
        this.clazz = clazz;
        this.state = state;
        this.frogmentData = frogmentData;
    }

    public static FrogmentActivityData forClass(Class<? extends AppCompatActivity> clazz) {
        return new Builder(clazz).build();
    }

    public Class<? extends AppCompatActivity> getClazz() {
        return clazz;
    }

    public State getState() {
        return state;
    }

    public FrogmentData getFrogmentData() {
        return frogmentData;
    }

    public static class Builder {
        private final Class<? extends AppCompatActivity> clazz;
        private State state;
        private FrogmentData frogmentData;

        public Builder(Class<? extends AppCompatActivity> clazz) {
            this.clazz = clazz;
        }

        public Builder state(State state) {
            this.state = state;
            return this;
        }

        public Builder frogmentData(FrogmentData frogmentData) {
            this.frogmentData = frogmentData;
            return this;
        }

        public FrogmentActivityData build() {
            return new FrogmentActivityData(clazz, state, frogmentData);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.clazz);
        dest.writeParcelable(this.state, flags);
        dest.writeParcelable(this.frogmentData, flags);
    }

    protected FrogmentActivityData(Parcel in) {
        this.clazz = (Class<? extends AppCompatActivity>) in.readSerializable();
        this.state = in.readParcelable(State.class.getClassLoader());
        this.frogmentData = in.readParcelable(FrogmentData.class.getClassLoader());
    }

    public static final Creator<FrogmentActivityData> CREATOR = new Creator<FrogmentActivityData>() {
        @Override
        public FrogmentActivityData createFromParcel(Parcel source) {
            return new FrogmentActivityData(source);
        }

        @Override
        public FrogmentActivityData[] newArray(int size) {
            return new FrogmentActivityData[size];
        }
    };
}
