package com.diegoviera.evaluaroperador.domain.mapper;

import com.diegoviera.evaluaroperador.data.local.entity.EvaluadorEntity;
import com.diegoviera.evaluaroperador.domain.model.EvaluadorModel;

import java.util.ArrayList;
import java.util.List;

public class EvaluadorMapper {

    public static EvaluadorEntity evaluadorModelToEntity(EvaluadorModel evaluadorModel){
        return new EvaluadorEntity(evaluadorModel.getId() == 0 ? 0 : evaluadorModel.getId(),
                evaluadorModel.getUsuario() == null ? "" : evaluadorModel.getUsuario(),
                evaluadorModel.getPassword() == null ? "" : evaluadorModel.getPassword(),
                evaluadorModel.getNombre() == null ? "" : evaluadorModel.getNombre(),
                evaluadorModel.getApellido() == null ? "" : evaluadorModel.getApellido(),
                evaluadorModel.getCargo() == null ? "" : evaluadorModel.getCargo(),
                evaluadorModel.getNegocio() == null ? "" : evaluadorModel.getNegocio());
    }

    public static EvaluadorModel evaluadorEntityToModel(EvaluadorEntity evaluadorEntity){
        return new EvaluadorModel(evaluadorEntity.getId() == 0 ? 0 : evaluadorEntity.getId(),
                evaluadorEntity.getUsuario() == null ? "" : evaluadorEntity.getUsuario(),
                evaluadorEntity.getPassword() == null ? "" : evaluadorEntity.getPassword(),
                evaluadorEntity.getNombre() == null ? "" : evaluadorEntity.getNombre(),
                evaluadorEntity.getApellido() == null ? "" : evaluadorEntity.getApellido(),
                evaluadorEntity.getCargo() == null ? "" : evaluadorEntity.getCargo(),
                evaluadorEntity.getNegocio() == null ? "" : evaluadorEntity.getNegocio());
    }

    public static List<EvaluadorModel> evaluadorEntityToModelsList(List<EvaluadorEntity> evaluadorEntities) {
        List<EvaluadorModel> evaluadorModelList = new ArrayList<>();
        for (EvaluadorEntity e : evaluadorEntities){
            evaluadorModelList.add(evaluadorEntityToModel(e));
        }
        return evaluadorModelList;
    }

}
