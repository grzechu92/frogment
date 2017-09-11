package ch.grze.frogment;

import android.app.Application;

import ch.grze.frogment.core.Config;
import ch.grze.frogment.core.Core;

public final class FrogmentFoundation {
    private final Core core;

    public FrogmentFoundation(Application application) {
        core = new Core(application, Config.getDefault());
    }

    private FrogmentFoundation(Builder builder) {
        core = new Core(builder.application, builder.config);
    }

    public static class Builder {
        private final Application application;
        private Config config = Config.getDefault();

        public Builder(Application application) {
            this.application = application;
        }

        public Builder config(Config config) {
            this.config = config;
            return this;
        }

        public FrogmentFoundation build() {
            return new FrogmentFoundation(this);
        }
    }
}
