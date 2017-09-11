package ch.grze.frogmentexample;

import android.app.Application;

import ch.grze.frogment.FrogmentFoundation;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        new FrogmentFoundation(this);
    }
}
