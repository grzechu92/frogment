package ch.grze.frogment;

public interface StateAware<T extends State> {
    T getState();
    void setState(T state);
    default void onStateValidation(T state) {}
    default void onStateChanged(T state) {}
    T getDefaultState();
}
