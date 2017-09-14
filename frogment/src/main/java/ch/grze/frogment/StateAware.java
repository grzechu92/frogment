package ch.grze.frogment;

public interface StateAware<T extends State> {
    T getState();
    void setState(T state);
    T getDefaultState();
    default void onBeforeStateSave(T state) {}
    default void onBeforeStateChange(T state) {}
    default void onStateChange(T state) {}
}
