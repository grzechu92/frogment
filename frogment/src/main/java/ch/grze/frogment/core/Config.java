package ch.grze.frogment.core;

import ch.grze.frogment.core.module.provider.FragmentInstanceProvider;
import ch.grze.frogment.core.module.provider.ReflectionFragmentInstanceProvider;

public class Config {
    private final FragmentInstanceProvider fragmentInstanceProvider;
    private final boolean isCallActivityFinishOnEmptyBackStack;
    private final boolean isWaitForViewReadyWithStateChange;

    private Config(Builder builder) {
        isCallActivityFinishOnEmptyBackStack = builder.isCallActivityFinishOnEmptyBackStack;
        fragmentInstanceProvider = builder.fragmentInstanceProvider;
        isWaitForViewReadyWithStateChange = builder.isWaitForViewReadyWithStateChange;
    }

    public static Config getDefault() {
        return new Config.Builder().build();
    }

    public boolean isCallActivityFinishOnEmptyBackStack() {
        return isCallActivityFinishOnEmptyBackStack;
    }

    public boolean isWaitForViewReadyWithStateChange() {
        return isWaitForViewReadyWithStateChange;
    }

    public FragmentInstanceProvider getFragmentInstanceProvider() {
        return fragmentInstanceProvider;
    }

    public static class Builder {
        private FragmentInstanceProvider fragmentInstanceProvider = new ReflectionFragmentInstanceProvider();
        private boolean isCallActivityFinishOnEmptyBackStack = true;
        private boolean isWaitForViewReadyWithStateChange = true;

        public Builder WaitForViewReadyWithStateChange(boolean isWaitForViewReadyWithStateChange) {
            this.isWaitForViewReadyWithStateChange = isWaitForViewReadyWithStateChange;
            return this;
        }

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
