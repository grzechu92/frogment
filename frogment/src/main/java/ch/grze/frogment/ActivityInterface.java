package ch.grze.frogment;

import android.content.Intent;
import android.support.v4.app.FragmentManager;

public interface ActivityInterface {
    Intent getIntent();
    void finish();
    void startActivity(Intent intent);
    FragmentManager getSupportFragmentManager();
}
