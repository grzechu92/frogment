package ch.grze.frogment;

public interface StateAware<S extends State> {
    S getState();
    void setState(S state);
    S getDefaultState();
}
