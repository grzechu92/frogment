package ch.grze.frogment.exception;

public class FrogmentNotFoundException extends RuntimeException {
    public FrogmentNotFoundException(String canonicalName) {
        super(canonicalName);
    }
}
