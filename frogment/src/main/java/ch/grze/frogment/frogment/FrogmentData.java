package ch.grze.frogment.frogment;

import android.os.Parcel;
import android.os.Parcelable;

import ch.grze.frogment.State;

public class FrogmentData implements Parcelable {
    private final Class<? extends FrogmentInterface> clazz;
    private final State state;
    private final String tag;

    private FrogmentData(Class<? extends FrogmentInterface> clazz, State state, String tag) {
        this.clazz = clazz;
        this.state = state;
        this.tag = tag == null ? clazz.getCanonicalName() : tag;
    }

    public static FrogmentData forClass(Class<? extends FrogmentInterface> clazz) {
        return new Builder(clazz).build();
    }

    public Class<? extends FrogmentInterface> getClazz() {
        return clazz;
    }

    public State getState() {
        return state;
    }

    public String getTag() {
        return tag;
    }

    public static class Builder {
        private final Class<? extends FrogmentInterface> clazz;
        private State state = null;
        private String tag = null;

        public Builder(Class<? extends FrogmentInterface> clazz) {
            this.clazz = clazz;
        }

        public Builder state(State state) {
            this.state = state;
            return this;
        }

        public Builder tag(String tag) {
            this.tag = tag;
            return this;
        }

        public FrogmentData build() {
            return new FrogmentData(clazz, state, tag);
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
        dest.writeString(this.tag);
    }

    protected FrogmentData(Parcel in) {
        this.clazz = (Class<? extends FrogmentInterface>) in.readSerializable();
        this.state = in.readParcelable(State.class.getClassLoader());
        this.tag = in.readString();
    }

    public static final Creator<FrogmentData> CREATOR = new Creator<FrogmentData>() {
        @Override
        public FrogmentData createFromParcel(Parcel source) {
            return new FrogmentData(source);
        }

        @Override
        public FrogmentData[] newArray(int size) {
            return new FrogmentData[size];
        }
    };
}
