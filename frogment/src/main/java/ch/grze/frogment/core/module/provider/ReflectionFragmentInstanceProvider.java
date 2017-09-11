package ch.grze.frogment.core.module.provider;

import ch.grze.frogment.frogment.Frogment;

public class ReflectionFragmentInstanceProvider implements FragmentInstanceProvider {
    @Override
    public Frogment getInstance(Class<? extends Frogment> frogmentClass) {
        try {
            return frogmentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new UnableToCreateFrogmentInstanceException(frogmentClass);
        }
    }
}
