package ch.grze.frogment;

import android.app.Application;

import ch.grze.frogment.core.Core;

public class Frogment {
    private Core core;

    public Frogment(Application application) {
        core = new Core(application);
    }

    public Core getCore() {
        return core;
    }

    protected Frogment(Builder builder) {
        this(builder.application);
    }

    public static class Builder {
        private final Application application;

        public Builder(Application application) {
            this.application = application;
        }

        public Frogment build() {
            return new Frogment(this);
        }
    }
}
