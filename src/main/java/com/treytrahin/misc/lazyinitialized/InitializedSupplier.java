package com.treytrahin.misc.lazyinitialized;

import java.util.function.Supplier;

public class InitializedSupplier<T> implements Supplier<T> {

    public Supplier<T> get;
    private T value;

    public InitializedSupplier(Supplier<T> initializeFunction) {
        get = () -> {
            synchronized (this) {
                if (value != null) {
                    return value;
                }
                value = initializeFunction.get();
                get = () -> value;
                return value;
            }
        };
    }

    @Override
    public T get() {
        return get.get();
    }
}
