package com.github.dmacvicar.chinchilla;

import com.google.inject.Binder;
import com.google.inject.Module;

public class InjectorModule implements Module {

    private static final Session SHARED_SESSION = new Session();

    public void configure(Binder binder) {
        binder.bind(Session.class).toInstance(SHARED_SESSION);
    }

}