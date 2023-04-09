package com.diegoviera.evaluaroperador.ui.Utils;

import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.EMPTY_STRING;

import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.diegoviera.evaluaroperador.R;

public class Utilitario {

    /*public static Dialog showDescargaDialog(Context context,
                                            String message) {

        Dialog customDialog = new Dialog(context, R.style.Theme_Dialog_Translucent);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setCancelable(false);
        customDialog.setContentView(R.layout.dialog_info_descarga_contenedores);

        Button btnAccept = customDialog.findViewById(R.id.btnAcceptDescarga);
        btnAccept.setText(context.getString(R.string.aceptar_es));

        TextView tvMessage = customDialog.findViewById(R.id.tvMessageDescarga);
        tvMessage.setText(message);

        customDialog.findViewById(R.id.btnAcceptDescarga).setOnClickListener(view -> customDialog.dismiss());

        customDialog.show();
        return customDialog;
    }*/

    public static void showInformationDialog(Context context, String title, String message) {
        showInformationDialog(context, title, message, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, false, false);
    }

    public static void showInformationDialog(Context context,
                                             String title,
                                             String message,
                                             String titleButtonPositive,
                                             String titleButtonNegative,
                                             String messageLarge,
                                             Boolean isVerMas) {
        showInformationDialog(context, title, message, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, false, false);
    }

    public static Dialog showInformationDialog(Context context,
                                               String title,
                                               String message,
                                               String titleButtonPositive,
                                               String titleButtonNegative,
                                               String messageLarge,
                                               Boolean isVerMas,
                                               boolean isHtml
    ) {

        Dialog customDialog = new Dialog(context, R.style.Theme_Dialog_Translucent);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setCancelable(false);
        customDialog.setContentView(R.layout.dialog_message_information);

        TextView tvTitle = customDialog.findViewById(R.id.tvTitle);
        tvTitle.setText(title);

        Button btnCancel = customDialog.findViewById(R.id.btnCancel);
        btnCancel.setText(titleButtonNegative);
        if (titleButtonNegative.isEmpty()) btnCancel.setVisibility(View.GONE);

        Button btnAccept = customDialog.findViewById(R.id.btnAccept);
        if (titleButtonPositive.isEmpty()) {
            btnAccept.setText(context.getString(R.string.aceptar_es));
        } else {
            btnAccept.setText(titleButtonPositive);
        }

        if (title.isEmpty()) tvTitle.setVisibility(View.GONE);

        TextView tvMessage = customDialog.findViewById(R.id.tvMessage);
        if (isHtml) {
            tvMessage.setText(Html.fromHtml(message));
        } else tvMessage.setText(message);

        customDialog.findViewById(R.id.btnCancel).setOnClickListener(view -> {
            if (isVerMas) {
                tvMessage.setText(messageLarge);
            } else {
                customDialog.dismiss();
            }
        });
        customDialog.findViewById(R.id.btnAccept).setOnClickListener(view -> customDialog.dismiss());

        customDialog.show();
        return customDialog;
    }

}
