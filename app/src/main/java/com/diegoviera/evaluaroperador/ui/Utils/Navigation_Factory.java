package com.diegoviera.evaluaroperador.ui.Utils;

import com.diegoviera.evaluaroperador.ui.view.MainActivity;

import javax.inject.Provider;

import dagger.internal.Factory;

public final class Navigation_Factory implements Factory<Navigation> {
    private final Provider<MainActivity> mainActivityProvider;

    public Navigation_Factory(Provider<MainActivity> mainActivityProvider) {
        this.mainActivityProvider = mainActivityProvider;
    }

    @Override
    public Navigation get() {
        return new Navigation(mainActivityProvider.get());
    }

    public static Navigation_Factory create(Provider<MainActivity> mainActivityProvider) {
        return new Navigation_Factory(mainActivityProvider);
    }

    public static Navigation newNavigation(MainActivity mainActivity) {
        return new Navigation(mainActivity);
    }
}