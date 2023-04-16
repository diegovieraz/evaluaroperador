package com.diegoviera.evaluaroperador.domain.mapper;

import com.diegoviera.evaluaroperador.data.local.entity.EvaluadoEntity;
import com.diegoviera.evaluaroperador.domain.model.EvaluadoModel;

import java.util.ArrayList;
import java.util.List;

public class EvaluadoMapper {

    public static EvaluadoEntity evaluadoModelToEntity(EvaluadoModel evaluadoModel) {
        return new EvaluadoEntity(evaluadoModel.getId() == 0 ? 0 : evaluadoModel.getId(),
                evaluadoModel.getNombre() == null ? "" : evaluadoModel.getNombre(),
                evaluadoModel.getApellido() == null ? "" : evaluadoModel.getApellido(),
                evaluadoModel.getAnexo() == null ? "" : evaluadoModel.getAnexo(),
                evaluadoModel.getDni() == 0 ? 0 : evaluadoModel.getDni(),
                evaluadoModel.getNegocio() == null ? "" : evaluadoModel.getNegocio(),
                evaluadoModel.getCartera() == null ? "" : evaluadoModel.getCartera(),
                evaluadoModel.getFecIngreso() == null ? "" : evaluadoModel.getFecIngreso(),
                evaluadoModel.getZonal() == null ? "" : evaluadoModel.getZonal());
    }

    public static EvaluadoModel evaluadoEntityToModel(EvaluadoEntity evaluadoEntity) {
        return new EvaluadoModel(evaluadoEntity.getId() == 0 ? 0 : evaluadoEntity.getId(),
                evaluadoEntity.getNombre() == null ? "" : evaluadoEntity.getNombre(),
                evaluadoEntity.getApellido() == null ? "" : evaluadoEntity.getApellido(),
                evaluadoEntity.getAnexo() == null ? "" : evaluadoEntity.getAnexo(),
                evaluadoEntity.getDni() == 0 ? 0 : evaluadoEntity.getDni(),
                evaluadoEntity.getNegocio() == null ? "" : evaluadoEntity.getNegocio(),
                evaluadoEntity.getCartera() == null ? "" : evaluadoEntity.getCartera(),
                evaluadoEntity.getFecIngreso() == null ? "" : evaluadoEntity.getFecIngreso(),
                evaluadoEntity.getZonal() == null ? "" : evaluadoEntity.getZonal());
    }

    public static List<EvaluadoModel> evaluadoEntityToModelsList(List<EvaluadoEntity> evaluadoEntities) {
        List<EvaluadoModel> evaluadoModelList = new ArrayList<>();
        for (EvaluadoEntity e : evaluadoEntities) {
            evaluadoModelList.add(evaluadoEntityToModel(e));
        }
        return evaluadoModelList;
    }


}
