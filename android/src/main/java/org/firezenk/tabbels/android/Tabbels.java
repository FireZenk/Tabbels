package org.firezenk.tabbels.android;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import org.firezenk.tabbels.core.Lambda;

/**
 * Created by Jorge Garrido Oval, aka firezenk on 08/08/16.
 * Project: Tabbels
 */
public class Tabbels extends org.firezenk.tabbels.core.Tabbels {

    private Tabbels() {}

    public static Lambda create() {
        if (instance == null) instance = new Tabbels();
        if (instance2 == null) instance2 = new Lambda(instance);
        return instance2;
    }

    public static void register(Application lifecycle) {
        create();
        lifecycle.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                if (instance.has("onCreate") && instance.isAction("onCreate"))
                    instance.aλ("onCreate", savedInstanceState);
            }

            @Override public void onActivityStarted(Activity activity) {
                if (instance.has("onStart") && instance.isAction("onStart"))
                    instance.aλ("onStart");
            }

            @Override public void onActivityResumed(Activity activity) {
                if (instance.has("onResume") && instance.isAction("onResume"))
                    instance.aλ("onResume");
            }

            @Override public void onActivityPaused(Activity activity) {
                if (instance.has("onPause") && instance.isAction("onPause"))
                    instance.aλ("onPause");
            }

            @Override public void onActivityStopped(Activity activity) {
                if (instance.has("onStop") && instance.isAction("onStop"))
                    instance.aλ("onStop");
            }

            @Override public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                if (instance.has("onSaveInstanceState") && instance.isAction("onSaveInstanceState"))
                    instance.aλ("onSaveInstanceState", outState);
            }

            @Override public void onActivityDestroyed(Activity activity) {
                if (instance.has("onDestroy") && instance.isAction("onDestroy"))
                    instance.aλ("onDestroy");
            }
        });
    }
}
