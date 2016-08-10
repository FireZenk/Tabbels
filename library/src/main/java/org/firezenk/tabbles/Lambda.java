package org.firezenk.tabbles;

import rx.functions.Func1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Function;

/**
 * Created by Jorge Garrido Oval, aka firezenk on 08/08/16.
 * Project: Tabbels
 */
public class Lambda implements Function {

    public Lambda λ(Object key, Func1<Tabbels, Object> pair) {
        Tabbels.table.put(key, pair);
        return this;
    }

    public Lambda λ(Object key, Func2<Tabbels, Object, Object> pair) {
        Tabbels.table.put(key, pair);
        return this;
    }

    public Lambda λ(Object key, Func3<Tabbels, Object, Object, Object> pair) {
        Tabbels.table.put(key, pair);
        return this;
    }

    public Lambda λ(Object key, Func4<Tabbels, Object, Object, Object, Object> pair) {
        Tabbels.table.put(key, pair);
        return this;
    }

    public Tabbels build() {
        return Tabbels.instance;
    }
}
