package ch.grze.frogment;

import android.app.Activity;
import android.os.Bundle;

public interface FragmentInterface {
    Activity getActivity();
    void setArguments(Bundle arguments);
    Bundle getArguments();
}
