package ch.grze.frogment.exception;

public class UnableToCreateFrogmentInstanceException extends RuntimeException {
    public UnableToCreateFrogmentInstanceException(Class<?> clazz) {
        super(clazz.getCanonicalName());
    }
}
