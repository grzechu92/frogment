package ch.grze.frogment;

public interface ActivityStateProvider<T extends State> {
    T getFrogmentActivityState();
}
