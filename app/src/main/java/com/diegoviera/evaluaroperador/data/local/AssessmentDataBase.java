package com.diegoviera.evaluaroperador.data.local;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.diegoviera.evaluaroperador.data.local.dao.EvaluadoDAO;
import com.diegoviera.evaluaroperador.data.local.dao.EvaluadorDAO;
import com.diegoviera.evaluaroperador.data.local.entity.EvaluadoEntity;
import com.diegoviera.evaluaroperador.data.local.entity.EvaluadorEntity;
import com.diegoviera.evaluaroperador.ui.Utils.Constantes;

@Database(entities = {
        EvaluadorEntity.class,
        EvaluadoEntity.class
}, version = 1)
public abstract class AssessmentDataBase extends RoomDatabase {

    private static AssessmentDataBase instance;

    public static synchronized AssessmentDataBase getInstance(Context context) {
        if (instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AssessmentDataBase.class,
                    Constantes.DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract EvaluadorDAO getEvaluadorDAO();

    public abstract EvaluadoDAO getEvaluadoDAO();

    //---------------------------------GENERAL-------------------------------

}
