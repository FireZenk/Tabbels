package org.firezenk.tabbels.core;

import org.firezenk.tabbels.core.rx.functions.Action;
import org.firezenk.tabbels.core.rx.functions.Action1;
import org.firezenk.tabbels.core.rx.functions.Action2;
import org.firezenk.tabbels.core.rx.functions.Action3;
import org.firezenk.tabbels.core.rx.functions.Action4;
import org.firezenk.tabbels.core.rx.functions.Func1;
import org.firezenk.tabbels.core.rx.functions.Func2;
import org.firezenk.tabbels.core.rx.functions.Func3;
import org.firezenk.tabbels.core.rx.functions.Func4;
import org.firezenk.tabbels.core.rx.functions.Function;

import java.util.HashMap;

/**
 * Created by Jorge Garrido Oval, aka firezenk on 10/08/16.
 * Project: Tabbels
 */
public class Tabbels {

    protected static Tabbels instance;
    protected static Lambda instance2;

    protected static final HashMap<Object, Function> table = new HashMap<>();

    private Tabbels() {}

    private Tabbels(Tabbels seed) {
        table.putAll(seed.table);
    }

    @SuppressWarnings("CloneDoesntCallSuperClone")
    @Override public Object clone() {
        return new Exception("Not allowed");
    }

    public static Lambda create() {
        if (instance == null) instance = new Tabbels();
        if (instance2 == null) instance2 = new Lambda(instance);
        return instance2;
    }

    public static Lambda create(Tabbels seed) {
        if (instance == null) instance = new Tabbels(seed);
        if (instance2 == null) instance2 = new Lambda(instance);
        return instance2;
    }

    public boolean has(String methodName) {
        return Tabbels.table.containsKey(methodName);
    }

    public boolean isAction(String methodName) {
        return Tabbels.table.get(methodName) instanceof Action;
    }

    public boolean isFunction(String methodName) {
        return !this.isAction(methodName);
    }

    @SuppressWarnings("unchecked")
    public Object fλ(Object key) {
        return ((Func1) Tabbels.table.get(key)).call(this);
    }

    @SuppressWarnings("unchecked")
    public Object fλ(Object key, Object param) {
        return ((Func2) Tabbels.table.get(key)).call(this, param);
    }

    @SuppressWarnings("unchecked")
    public Object fλ(Object key, Object param1, Object param2) {
        return ((Func3) Tabbels.table.get(key)).call(this, param1, param2);
    }

    @SuppressWarnings("unchecked")
    public Object fλ(Object key, Object param1, Object param2, Object param3) {
        return ((Func4) Tabbels.table.get(key)).call(this, param1, param2, param3);
    }

    @SuppressWarnings("unchecked")
    public void aλ(Object key) {
        ((Action1) Tabbels.table.get(key)).call(this);
    }

    @SuppressWarnings("unchecked")
    public void aλ(Object key, Object param) {
        ((Action2) Tabbels.table.get(key)).call(this, param);
    }

    @SuppressWarnings("unchecked")
    public void aλ(Object key, Object param1, Object param2) {
        ((Action3) Tabbels.table.get(key)).call(this, param1, param2);
    }

    @SuppressWarnings("unchecked")
    public void aλ(Object key, Object param1, Object param2, Object param3) {
         ((Action4) Tabbels.table.get(key)).call(this, param1, param2, param3);
    }
}
