package ch.grze.frogment.core.module.provider;

import ch.grze.frogment.frogment.Frogment;

public interface FragmentInstanceProvider {
    Frogment getInstance(Class<? extends Frogment> frogmentClass);
}
