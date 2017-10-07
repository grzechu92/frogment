package ch.grze.frogmentexample;

import android.app.Application;

import ch.grze.frogment.FrogmentFoundation;
import ch.grze.frogmentmvp.MvpExtension;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //new FrogmentFoundation(this); //default initializer

        new FrogmentFoundation.Builder(this)
                .extension(new MvpExtension()) //optional extension
                .build();
    }
}
