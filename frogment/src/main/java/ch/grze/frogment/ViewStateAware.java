package ch.grze.frogment;

public interface ViewStateAware {
    boolean isViewReady();
    void onViewReady();
}
