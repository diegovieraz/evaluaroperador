package com.diegoviera.evaluaroperador.data.repository;

import android.os.AsyncTask;

import com.diegoviera.evaluaroperador.data.local.dao.EvaluadoDAO;
import com.diegoviera.evaluaroperador.data.local.dao.EvaluadorDAO;
import com.diegoviera.evaluaroperador.data.local.entity.EvaluadoEntity;
import com.diegoviera.evaluaroperador.data.local.entity.EvaluadorEntity;
import com.diegoviera.evaluaroperador.domain.mapper.EvaluadoMapper;
import com.diegoviera.evaluaroperador.domain.mapper.EvaluadorMapper;
import com.diegoviera.evaluaroperador.domain.model.EvaluadoModel;
import com.diegoviera.evaluaroperador.domain.model.EvaluadorModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;
import javax.inject.Singleton;

public class EvaluadorRepository {

    private EvaluadorDAO evaluadorDAO;
    private EvaluadoDAO evaluadoDAO;

    @Inject
    public EvaluadorRepository(
            EvaluadorDAO evaluadorDAO,
            EvaluadoDAO evaluadoDAO
    ) {
        this.evaluadorDAO = evaluadorDAO;
        this.evaluadoDAO = evaluadoDAO;
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
            if (evaluadorEntity!=null){
                evaluadorModel = EvaluadorMapper.evaluadorEntityToModel(evaluadorEntity);
            }
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

    //REGISTRO EVALUADORES

    public void registraEvaluadores(List<EvaluadorModel> evaluadorModelList) {
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

    //---------------------EVALUADOS---------------------

    //CONSULTA TOTAL EVALUADOS

    public List<EvaluadoModel> getAllEvaluados() {
        List<EvaluadoModel> evaluadoModelList = new ArrayList<>();
        try {
            List<EvaluadoEntity> evaluadoEntities = new GetAllEvaluadoAsyncTask(evaluadoDAO).execute().get();
            evaluadoModelList = EvaluadoMapper.evaluadoEntityToModelsList(evaluadoEntities);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return evaluadoModelList;
    }

    private static class GetAllEvaluadoAsyncTask extends AsyncTask<Void, Void, List<EvaluadoEntity>> {
        private EvaluadoDAO evaluadoDAO;

        GetAllEvaluadoAsyncTask(EvaluadoDAO evaluadoDAO) {
            this.evaluadoDAO = evaluadoDAO;
        }

        @Override
        protected List<EvaluadoEntity> doInBackground(Void... params) {
            return evaluadoDAO.getAll();
        }
    }

    //CONSULTA INDIVIDUAL EVALUADO X ID

    public EvaluadoModel getEvaluadorXId(Integer id) {
        EvaluadoModel evaluadoModel = new EvaluadoModel();
        try {
            EvaluadoEntity evaluadoEntity = new GetEvaluadoXDniAsyncTask(evaluadoDAO).execute(id).get();
        }  catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return evaluadoModel;
    }

    private static class GetEvaluadoXDniAsyncTask extends AsyncTask<Integer, Void, EvaluadoEntity> {
        private EvaluadoDAO evaluadoDAO;

        GetEvaluadoXDniAsyncTask(EvaluadoDAO evaluadoDAO) {
            this.evaluadoDAO = evaluadoDAO;
        }


        @Override
        protected EvaluadoEntity doInBackground(final Integer... params) {
            return evaluadoDAO.getEvaluadoXId(params[0]);
        }
    }

    //CONSULTA INDIVIDUAL EVALUADO X NOMBRE

    public EvaluadoModel getEvaluadorXNombre(String nombre) {
        EvaluadoModel evaluadoModel = new EvaluadoModel();
        try {
            EvaluadoEntity evaluadoEntity = new GetEvaluadoXNombreAsyncTask(evaluadoDAO).execute(nombre).get();
        }  catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return evaluadoModel;
    }

    private static class GetEvaluadoXNombreAsyncTask extends AsyncTask<String, Void, EvaluadoEntity> {
        private EvaluadoDAO evaluadoDAO;

        GetEvaluadoXNombreAsyncTask(EvaluadoDAO evaluadoDAO) {
            this.evaluadoDAO = evaluadoDAO;
        }


        @Override
        protected EvaluadoEntity doInBackground(final String... params) {
            return evaluadoDAO.getEvaluadoXNombre(params[0]);
        }
    }

    //REGISTRO EVALUADOS

    public void registraEvaluados(List<EvaluadoModel> evaluadoModelList) {
        EvaluadoEntity evaluadoEntity;
        List<EvaluadoEntity> evaluadoEntities = new ArrayList<>();
        for (EvaluadoModel item : evaluadoModelList) {
            evaluadoEntity = EvaluadoMapper.evaluadoModelToEntity(item);
            evaluadoEntities.add(evaluadoEntity);
        }
        try {
            new InsertEvaluadoAsyncTask(evaluadoDAO).execute(evaluadoEntities).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class InsertEvaluadoAsyncTask extends AsyncTask<List<EvaluadoEntity>, Void, Void> {
        private EvaluadoDAO evaluadoDAO;

        InsertEvaluadoAsyncTask(EvaluadoDAO evaluadoDAO) {
            this.evaluadoDAO = evaluadoDAO;
        }


        @Override
        protected Void doInBackground(final List<EvaluadoEntity>... lists) {
            evaluadoDAO.insertEvaluados(lists[0]);
            return null;
        }
    }


}
