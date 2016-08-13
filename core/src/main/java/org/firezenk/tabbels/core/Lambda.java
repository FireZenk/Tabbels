package org.firezenk.tabbels.core;

import org.firezenk.tabbels.core.rx.functions.Action1;
import org.firezenk.tabbels.core.rx.functions.Action2;
import org.firezenk.tabbels.core.rx.functions.Action3;
import org.firezenk.tabbels.core.rx.functions.Action4;
import org.firezenk.tabbels.core.rx.functions.Func1;
import org.firezenk.tabbels.core.rx.functions.Func2;
import org.firezenk.tabbels.core.rx.functions.Func3;
import org.firezenk.tabbels.core.rx.functions.Func4;
import org.firezenk.tabbels.core.rx.functions.Function;

/**
 * Created by Jorge Garrido Oval, aka firezenk on 08/08/16.
 * Project: Tabbels
 */
public class Lambda implements Function {

    private Tabbels parent;

    public Lambda(Tabbels parent) {
        this.parent = parent;
    }

    public Lambda fλ(Object key, Func1<Tabbels, Object> pair) {
        Tabbels.table.put(key, pair);
        return this;
    }

    public Lambda fλ(Object key, Func2<Tabbels, Object, Object> pair) {
        Tabbels.table.put(key, pair);
        return this;
    }

    public Lambda fλ(Object key, Func3<Tabbels, Object, Object, Object> pair) {
        Tabbels.table.put(key, pair);
        return this;
    }

    public Lambda fλ(Object key, Func4<Tabbels, Object, Object, Object, Object> pair) {
        Tabbels.table.put(key, pair);
        return this;
    }

    public Lambda aλ(Object key, Action1<Tabbels> pair) {
        Tabbels.table.put(key, pair);
        return this;
    }

    public Lambda aλ(Object key, Action2<Tabbels, Object> pair) {
        Tabbels.table.put(key, pair);
        return this;
    }

    public Lambda aλ(Object key, Action3<Tabbels, Object, Object> pair) {
        Tabbels.table.put(key, pair);
        return this;
    }

    public Lambda aλ(Object key, Action4<Tabbels, Object, Object, Object> pair) {
        Tabbels.table.put(key, pair);
        return this;
    }

    public Tabbels build() {
        return parent;
    }
}
