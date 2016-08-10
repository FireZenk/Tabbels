package org.firezenk.tabbels;

import android.app.Application;

import org.firezenk.tabbles.Tabbels;

/**
 * Created by Jorge Garrido Oval, aka firezenk on 08/08/16.
 * Project: Tabbels
 */
public class TabbelsApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();
        Tabbels.register(this);
    }
}
