package com.github.davidmoten.rx2;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.functions.Action;

public final class Actions {

    private Actions() {
        // prevent instantiation
    }

    public static Action setToTrue(final AtomicBoolean b) {
        return new Action() {

            @Override
            public void run() throws Exception {
                b.set(true);
            }

        };
    }

    public static Action throwing(final Exception e) {
        return new Action() {

            @Override
            public void run() throws Exception {
                throw e;
            }

        };
    }

    public static Action doNothing() {
        return DoNothingHolder.DO_NOTHING;
    }

    private static final class DoNothingHolder {
        static final Action DO_NOTHING = new Action() {
            @Override
            public void run() throws Exception {
                // do nothing!
            }
        };
    }

    public static Action increment(final AtomicInteger x) {
        //TODO make holder
        return new Action() {

            @Override
            public void run() throws Exception {
                x.incrementAndGet();
            }
        };
    }

}
