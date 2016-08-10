package org.firezenk.tabbles;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.HashMap;

import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Function;

/**
 * Created by Jorge Garrido Oval, aka firezenk on 08/08/16.
 * Project: Tabbels
 */
public class Tabbels {

    protected static Tabbels instance;
    protected static Lambda instance2;

    protected static final HashMap<Object, Function> table = new HashMap<>();

    private Tabbels() {}

    @SuppressWarnings("CloneDoesntCallSuperClone")
    @Override public Object clone() {
        return new Exception("Not allowed");
    }

    public static Lambda create() {
        if (instance == null) instance = new Tabbels();
        if (instance2 == null) instance2 = new Lambda();
        return instance2;
    }

    private boolean has(String methodName) {
        return Tabbels.table.containsKey(methodName);
    }

    /*
    LAMBDA EXECUTION
     */

    @SuppressWarnings("unchecked")
    public void λ(Object key) {
        ((Func1) Tabbels.table.get(key)).call(this);
    }

    @SuppressWarnings("unchecked")
    public Object λ(Object key, Object param) {
        return ((Func2) Tabbels.table.get(key)).call(this, param);
    }

    @SuppressWarnings("unchecked")
    public Object λ(Object key, Object param1, Object param2) {
        return ((Func3) Tabbels.table.get(key)).call(this, param1, param2);
    }

    @SuppressWarnings("unchecked")
    public Object λ(Object key, Object param1, Object param2, Object param3) {
        return ((Func4) Tabbels.table.get(key)).call(this, param1, param2, param3);
    }

    /*
    LIFECYCLE IMPL
     */

    public static void register(Application lifecycle) {
        create();
        lifecycle.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                if (instance.has("onCreate"))
                    instance.λ("onCreate", savedInstanceState);
            }

            @Override public void onActivityStarted(Activity activity) {
                if (instance.has("onStart"))
                    instance.λ("onStart");
            }

            @Override public void onActivityResumed(Activity activity) {
                if (instance.has("onResume"))
                    instance.λ("onResume");
            }

            @Override public void onActivityPaused(Activity activity) {
                if (instance.has("onPause"))
                    instance.λ("onPause");
            }

            @Override public void onActivityStopped(Activity activity) {
                if (instance.has("onStop"))
                    instance.λ("onStop");
            }

            @Override public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                if (instance.has("onSaveInstanceState"))
                    instance.λ("onSaveInstanceState", outState);
            }

            @Override public void onActivityDestroyed(Activity activity) {
                if (instance.has("onDestroy"))
                    instance.λ("onDestroy");
            }
        });
    }
}
