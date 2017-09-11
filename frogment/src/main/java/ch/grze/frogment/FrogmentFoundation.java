package ch.grze.frogment;

import android.app.Application;

import ch.grze.frogment.core.Core;

public final class FrogmentFoundation {
    private Core core;

    public FrogmentFoundation(Application application) {
        core = new Core(application);
    }

    public Core getCore() {
        return core;
    }

    protected FrogmentFoundation(Builder builder) {
        this(builder.application);
    }

    public static class Builder {
        private final Application application;

        public Builder(Application application) {
            this.application = application;
        }

        public FrogmentFoundation build() {
            return new FrogmentFoundation(this);
        }
    }
}
