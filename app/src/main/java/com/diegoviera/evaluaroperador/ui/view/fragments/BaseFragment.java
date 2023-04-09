package com.diegoviera.evaluaroperador.ui.view.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.diegoviera.evaluaroperador.R;
import com.diegoviera.evaluaroperador.ui.Utils.Utilitario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class BaseFragment extends Fragment implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    protected ProgressDialog mProgressDialog;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    public void showDialogProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
        String msj = "Por favor, espere.";
        mProgressDialog = ProgressDialog.show(getContext(), "", msj, true);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setCanceledOnTouchOutside(false);
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {

            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    //ocultar teclado virtual
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /*public void notificacionDescargaExcel(String fileName) {
        String mensaje = fileName;
        Dialog dialog = Utilitario.showDescargaDialog(getContext(), mensaje);
        dialog.findViewById(R.id.btnAcceptDescarga).setOnClickListener(positiveView -> {
            dialog.dismiss();
        });
    }*/

    public boolean saveBase64StringToExcel(String base64Str,
                                           String filePath, String fileName) throws FileNotFoundException, IOException {
        boolean success=false;
        byte[] decoder = Base64.getDecoder().decode(base64Str);
        String extension = ".xls";
        File doc = new File(filePath);

        if (doc.exists()){
            int version = 1;
            String nuevoNombreArchivo;
            File nuevoArchivo;
            do {
                nuevoNombreArchivo = filePath.replace(".xls"," ("+version+")"+".xls");
                nuevoArchivo = new File(nuevoNombreArchivo);
                version++;
            } while (nuevoArchivo.exists());

            try {
                FileOutputStream fos = new FileOutputStream(nuevoArchivo);
                fos.write(decoder);
                fos.flush();
                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());
                Intent excelIntent = new Intent(Intent.ACTION_VIEW);
                excelIntent.setDataAndType(Uri.parse("file://" + doc.getAbsolutePath()), extension);
                excelIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                excelIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                try {
                    success=true;
                    //startActivity(new Intent(DownloadManager.ACTION_NOTIFICATION_CLICKED));
                    startActivity(new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS));
                } catch (ActivityNotFoundException e) {
                    success=false;
                    //Toast.makeText(getContext(), "No Application available", Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                FileOutputStream fos = new FileOutputStream(doc);
                fos.write(decoder);
                fos.flush();
                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());
                Intent excelIntent = new Intent(Intent.ACTION_VIEW);
                excelIntent.setDataAndType(Uri.parse("file://" + doc.getAbsolutePath()), extension);
                excelIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                excelIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                try {
                    success=true;
                    //startActivity(new Intent(DownloadManager.ACTION_NOTIFICATION_CLICKED));
                    startActivity(new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS));
                } catch (ActivityNotFoundException e) {
                    success=false;
                    //Toast.makeText(getContext(), "No Application available", Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    //----------------------------FLUJO NAVEGACION PANTALLAS-----------------------------------------

    public void goToFragment(Fragment newInstance) {
        FragmentTransaction trans = getFragmentManager().beginTransaction();
        trans.replace(R.id.main_fragment_placeholder, newInstance);
        trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        trans.addToBackStack(null);
        trans.commit();
    }


}
