package ch.grze.frogmentexample;

import android.app.Application;

import ch.grze.frogment.Frogment;
import ch.grze.frogmentmvp.MvpExtension;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //new FrogmentFoundation(this); //default initializer

        new Frogment.Builder(this)
                .extension(new MvpExtension()) //optional extension
                .build();
    }
}
