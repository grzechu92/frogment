package ch.grze.frogment.core.provider;

import ch.grze.frogment.frogment.FrogmentInterface;

public class ReflectionFragmentInstanceProvider implements FragmentInstanceProvider {
    @Override
    public FrogmentInterface getInstance(Class<? extends FrogmentInterface> frogmentClass) {
        try {
            return frogmentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new UnableToCreateFrogmentInstanceException(frogmentClass);
        }
    }
}
