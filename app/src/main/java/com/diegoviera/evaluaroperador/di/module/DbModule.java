package com.diegoviera.evaluaroperador.di.module;

import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.DATABASE_NAME;

import android.app.Application;

import androidx.room.Room;

import com.diegoviera.evaluaroperador.data.local.AssessmentDataBase;
import com.diegoviera.evaluaroperador.data.local.dao.EvaluadorDAO;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {

    @Singleton
    @Provides
    static AssessmentDataBase provideDataBase(Application application) {
        return Room.databaseBuilder(
                application,
                AssessmentDataBase.class,
                DATABASE_NAME
        ).build();
    }

    @Singleton
    @Provides
    static EvaluadorDAO provideEvaluadorDAO(AssessmentDataBase dataBase) {
        return dataBase.getEvaluadorDAO();
    }

}
