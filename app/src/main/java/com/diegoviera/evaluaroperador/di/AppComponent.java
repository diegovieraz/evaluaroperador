package com.diegoviera.evaluaroperador.di;

import android.app.Application;

import com.diegoviera.evaluaroperador.di.module.ActivityModule;
import com.diegoviera.evaluaroperador.di.module.AppModule;
import com.diegoviera.evaluaroperador.di.module.DbModule;
import com.diegoviera.evaluaroperador.ui.viewmodel.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        DbModule.class,
        ActivityModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

    void inject(BaseApplication baseApplication);

}
