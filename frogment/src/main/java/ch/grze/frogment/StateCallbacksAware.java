package ch.grze.frogment;

public interface StateCallbacksAware<S extends State> {
    default void onBeforeStateSave(S state) {}
    default void onBeforeStateChange(S state) {}
    default void onStateChange(S state) {}
    default void onViewStateChange(S state) {}
}
