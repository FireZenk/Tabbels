package org.firezenk.tabbels.core;

import java.util.HashMap;

import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Function;

/**
 * Created by Jorge Garrido Oval, aka firezenk on 10/08/16.
 * Project: Tabbels
 */
public class Tabbels {

    protected static Tabbels instance;
    protected static Lambda instance2;

    protected static final HashMap<Object, Function> table = new HashMap<>();

    protected Tabbels() {}

    @SuppressWarnings("CloneDoesntCallSuperClone")
    @Override public Object clone() {
        return new Exception("Not allowed");
    }

    public static Lambda create() {
        if (instance == null) instance = new Tabbels();
        if (instance2 == null) instance2 = new Lambda(instance);
        return instance2;
    }

    public boolean has(String methodName) {
        return Tabbels.table.containsKey(methodName);
    }

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
}
