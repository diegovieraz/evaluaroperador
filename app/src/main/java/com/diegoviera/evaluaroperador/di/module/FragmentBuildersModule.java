package com.diegoviera.evaluaroperador.di.module;

import com.diegoviera.evaluaroperador.ui.view.fragments.HomeFragment;
import com.diegoviera.evaluaroperador.ui.view.fragments.LoginFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract LoginFragment loginFragment();

    @ContributesAndroidInjector
    abstract HomeFragment homeFragment();

}
