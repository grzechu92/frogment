package ch.grze.frogment.core;

import ch.grze.frogment.core.provider.FragmentInstanceProvider;
import ch.grze.frogment.core.provider.ReflectionFragmentInstanceProvider;

public class Config {
    private final FragmentInstanceProvider fragmentInstanceProvider;
    private final boolean isCallActivityFinishOnEmptyBackStack;

    private Config(Builder builder) {
        isCallActivityFinishOnEmptyBackStack = builder.isCallActivityFinishOnEmptyBackStack;
        fragmentInstanceProvider = builder.fragmentInstanceProvider;
    }

    public static Config getDefault() {
        return new Config.Builder().build();
    }

    public boolean isCallActivityFinishOnEmptyBackStack() {
        return isCallActivityFinishOnEmptyBackStack;
    }

    public FragmentInstanceProvider getFragmentInstanceProvider() {
        return fragmentInstanceProvider;
    }

    public static class Builder {
        private FragmentInstanceProvider fragmentInstanceProvider = new ReflectionFragmentInstanceProvider();
        private boolean isCallActivityFinishOnEmptyBackStack = true;

        public Builder callActivityFinishOnEmptyBackStack(boolean isCallActivityFinishOnEmptyBackStack) {
            this.isCallActivityFinishOnEmptyBackStack = isCallActivityFinishOnEmptyBackStack;
            return this;
        }

        public Builder fragmentInstanceProvider(FragmentInstanceProvider fragmentInstanceProvider) {
            this.fragmentInstanceProvider = fragmentInstanceProvider;
            return this;
        }

        public Config build() {
            return new Config(this);
        }
    }
}
