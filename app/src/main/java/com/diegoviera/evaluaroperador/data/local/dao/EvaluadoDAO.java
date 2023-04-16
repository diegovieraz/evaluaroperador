package com.diegoviera.evaluaroperador.data.local.dao;

import static androidx.room.OnConflictStrategy.IGNORE;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.diegoviera.evaluaroperador.data.local.entity.EvaluadoEntity;

import java.util.List;

public interface EvaluadoDAO {

    // CONSULTA
    @Query("SELECT * FROM EvaluadoEntity")
    List<EvaluadoEntity> getAll();

    @Query("SELECT * FROM EvaluadoEntity WHERE id = :id ")
    EvaluadoEntity getEvaluadoXId(int id);

    @Query("SELECT * FROM EvaluadoEntity WHERE nombre = :nombre ")
    EvaluadoEntity getEvaluadoXNombre(String nombre);

    // INSERT
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(EvaluadoEntity evaluadoEntity);

    @Insert(onConflict = IGNORE)
    long[] insertEvaluados(List<EvaluadoEntity> evaluadoEntities);

}
