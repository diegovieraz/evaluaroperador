package com.diegoviera.evaluaroperador.data.local.dao;

import static androidx.room.OnConflictStrategy.IGNORE;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.diegoviera.evaluaroperador.data.local.entity.EvaluadorEntity;

import java.util.List;

@Dao
public interface EvaluadorDAO {

    // CONSULTA
    @Query("SELECT * FROM EvaluadorEntity")
    List<EvaluadorEntity> getAll();

    @Query("SELECT * FROM EvaluadorEntity WHERE usuario = :usuario AND password = :password ")
    EvaluadorEntity getEvaluador(String usuario, String password);

    // INSERT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(EvaluadorEntity evaluadorEntity);

    @Insert(onConflict = IGNORE)
    long[] insertEvaluadores(List<EvaluadorEntity> evaluadorEntities);

}
