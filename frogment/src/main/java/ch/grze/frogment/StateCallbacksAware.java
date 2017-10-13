package ch.grze.frogment;

//still in Java due to lack of interop: https://youtrack.jetbrains.com/issue/KT-19415
public interface StateCallbacksAware<S extends State> {
    default void onBeforeStateSave(S state) {}
    default void onBeforeStateChange(S state) {}
    default void onStateChange(S state) {}
    default void onViewStateChange(S state) {}
}
