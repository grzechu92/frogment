package ch.grze.frogment.core.module.provider;

public class UnableToCreateFrogmentInstanceException extends RuntimeException {
    public UnableToCreateFrogmentInstanceException(Class<?> clazz) {
        super(clazz.getCanonicalName());
    }
}
