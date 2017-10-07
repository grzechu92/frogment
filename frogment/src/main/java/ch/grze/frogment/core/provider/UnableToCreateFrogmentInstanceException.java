package ch.grze.frogment.core.provider;

public class UnableToCreateFrogmentInstanceException extends RuntimeException {
    public UnableToCreateFrogmentInstanceException(Class<?> clazz) {
        super(clazz.getCanonicalName());
    }
}
