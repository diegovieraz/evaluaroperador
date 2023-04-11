package com.diegoviera.evaluaroperador.data.repository;

import android.os.AsyncTask;

import com.diegoviera.evaluaroperador.data.local.dao.EvaluadorDAO;
import com.diegoviera.evaluaroperador.data.local.entity.EvaluadorEntity;
import com.diegoviera.evaluaroperador.domain.mapper.EvaluadorMapper;
import com.diegoviera.evaluaroperador.domain.model.EvaluadorModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.inject.Singleton;

public class EvaluadorRepository {

    private EvaluadorDAO evaluadorDAO;

    @Inject
    public EvaluadorRepository(EvaluadorDAO evaluadorDAO) {
        this.evaluadorDAO = evaluadorDAO;
    }

    //-------------------EVALUADORES-------------------

    //CONSULTA TOTAL EVALUADORES

    public List<EvaluadorModel> getAllEvaluadores() {
        List<EvaluadorModel> evaluadorModelList = new ArrayList<>();
        try {
            List<EvaluadorEntity> evaluadorEntities = new GetAllEvaluadorAsyncTask(evaluadorDAO).execute().get();
            evaluadorModelList = EvaluadorMapper.evaluadorEntityToModelsList(evaluadorEntities);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return evaluadorModelList;
    }

    private static class GetAllEvaluadorAsyncTask extends AsyncTask<Void, Void, List<EvaluadorEntity>> {
        private EvaluadorDAO evaluadorDAO;

        GetAllEvaluadorAsyncTask(EvaluadorDAO evaluadorDAO) {
            this.evaluadorDAO = evaluadorDAO;
        }

        @Override
        protected List<EvaluadorEntity> doInBackground(final Void... params) {
            return evaluadorDAO.getAll();
        }
    }

    //CONSULTA INDIVIDUAL EVALUADOR

    private static class LoginParams {
        String usuario;
        String password;

        public LoginParams(String usuario, String password) {
            this.usuario = usuario;
            this.password = password;
        }
    }

    public EvaluadorModel getEvaluador(String usuario, String password) {
        EvaluadorModel evaluadorModel = new EvaluadorModel();
        LoginParams loginParams = new LoginParams(usuario, password);
        try {
            EvaluadorEntity evaluadorEntity = new GetEvaluadorAsyncTask(evaluadorDAO).execute(loginParams).get();
            evaluadorModel = EvaluadorMapper.evaluadorEntityToModel(evaluadorEntity);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return evaluadorModel;
    }

    private static class GetEvaluadorAsyncTask extends AsyncTask<LoginParams, Void, EvaluadorEntity> {
        private EvaluadorDAO evaluadorDAO;

        GetEvaluadorAsyncTask(EvaluadorDAO evaluadorDAO) {
            this.evaluadorDAO = evaluadorDAO;
        }

        @Override
        protected EvaluadorEntity doInBackground(final LoginParams... params) {
            return evaluadorDAO.getEvaluador(params[0].usuario, params[0].password);
        }
    }

    //REGISTRO EVALUADOR

    public void registraEvaluador(List<EvaluadorModel> evaluadorModelList) {
        EvaluadorEntity evaluadorEntity;
        List<EvaluadorEntity> evaluadorEntities = new ArrayList<>();
        for (EvaluadorModel item : evaluadorModelList) {
            evaluadorEntity = EvaluadorMapper.evaluadorModelToEntity(item);
            evaluadorEntities.add(evaluadorEntity);
        }
        try {
            new InsertEvaluadorAsyncTask(evaluadorDAO).execute(evaluadorEntities).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class InsertEvaluadorAsyncTask extends AsyncTask<List<EvaluadorEntity>, Void, Void> {
        private EvaluadorDAO evaluadorDAO;

        InsertEvaluadorAsyncTask(EvaluadorDAO evaluadorDAO) {
            this.evaluadorDAO = evaluadorDAO;
        }


        @Override
        protected Void doInBackground(final List<EvaluadorEntity>... lists) {
            evaluadorDAO.insertEvaluadores(lists[0]);
            return null;
        }
    }

}
