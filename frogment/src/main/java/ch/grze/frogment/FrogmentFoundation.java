package ch.grze.frogment;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import ch.grze.frogment.core.Config;
import ch.grze.frogment.core.Core;
import ch.grze.frogment.core.extension.AbstractExtension;

public final class FrogmentFoundation {
    private final Core core;

    public FrogmentFoundation(Application application) {
        this(new Builder(application));
    }

    private FrogmentFoundation(Builder builder) {
        core = new Core(builder.application, builder.config, builder.extensions);
    }

    public static class Builder {
        private final List<AbstractExtension> extensions = new ArrayList<>();
        private final Application application;
        private Config config = Config.getDefault();

        public Builder(Application application) {
            this.application = application;
        }

        public Builder config(Config config) {
            this.config = config;
            return this;
        }

        public Builder extension(AbstractExtension extension) {
            extensions.add(extension);
            return this;
        }

        public FrogmentFoundation build() {
            return new FrogmentFoundation(this);
        }
    }
}
