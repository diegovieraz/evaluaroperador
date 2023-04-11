package com.diegoviera.evaluaroperador.di.module;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.ViewModelProvider;

import com.diegoviera.evaluaroperador.ui.viewmodel.ProjectViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = ViewModelSubComponent.class)
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Singleton
    @Provides
    ViewModelProvider.Factory provideViewModelFactory(
            ViewModelSubComponent.Builder viewModelSubComponent) {
        return new ProjectViewModelFactory(viewModelSubComponent.build());
    }

}
