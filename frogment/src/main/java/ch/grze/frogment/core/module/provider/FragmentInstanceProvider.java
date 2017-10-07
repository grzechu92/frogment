package ch.grze.frogment.core.module.provider;

import ch.grze.frogment.frogment.FrogmentInterface;

public interface FragmentInstanceProvider {
    FrogmentInterface getInstance(Class<? extends FrogmentInterface> frogmentClass);
}
