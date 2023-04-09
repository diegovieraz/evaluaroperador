package com.diegoviera.evaluaroperador.ui.Utils;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumberTextWatcher implements TextWatcher {

    private final DecimalFormat df;
    private final DecimalFormat dfnd;
    private final DecimalFormat dfDecimal;
    private final DecimalFormat dfndDecimal;
    private String symbolCurrency;
    private boolean hasFractionalPart;

    private final TextInputEditText et;
    private boolean isDecimal;

    public NumberTextWatcher(TextInputEditText et, boolean isDecimal) {

        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(new Locale("es", "PE"));
        df = new DecimalFormat("###########", otherSymbols);
        df.setDecimalSeparatorAlwaysShown(false);
        dfnd = new DecimalFormat("###########", otherSymbols);

        dfDecimal = new DecimalFormat("###########.##", otherSymbols);
        dfDecimal.setDecimalSeparatorAlwaysShown(true);
        dfndDecimal = new DecimalFormat("###########.##", otherSymbols);

        this.isDecimal = isDecimal;
        this.symbolCurrency = "S/ ";

        this.et = et;
        hasFractionalPart = true;
    }

    public NumberTextWatcher(TextInputEditText et, boolean isDecimal, boolean simbol) {

        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(new Locale("es", "PE"));
        df = new DecimalFormat("###########", otherSymbols);
        df.setDecimalSeparatorAlwaysShown(false);
        dfnd = new DecimalFormat("###########", otherSymbols);

        dfDecimal = new DecimalFormat("###########.##", otherSymbols);
        dfDecimal.setDecimalSeparatorAlwaysShown(true);
        dfndDecimal = new DecimalFormat("###########.##", otherSymbols);

        this.isDecimal = isDecimal;
        this.symbolCurrency = "";
        if (simbol) {
            this.symbolCurrency = "S/ ";
        }


        this.et = et;
        hasFractionalPart = true;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void afterTextChanged(Editable s) {
        et.removeTextChangedListener(this);

        try {

            int inilen, endlen;
            inilen = et.getText().length();

            String v = s.toString();
            v = v.replaceAll("[S/$,]", "");
            if (v != null && !v.isEmpty()) {

                Double n = Double.parseDouble(v);
                int cp = et.getSelectionStart();
                if (hasFractionalPart) {
                    et.setText(this.symbolCurrency + (this.isDecimal ? dfDecimal.format(n) : df.format(n)));
                } else {
                    et.setText(this.symbolCurrency + (this.isDecimal ? dfndDecimal.format(n) : dfnd.format(n)));
                }

                endlen = et.getText().length();
                int sel = (cp + (endlen - inilen));

                if (sel > 0 && sel <= et.getText().length()) {
                    et.setSelection(sel);
                } else {
                    et.setSelection(et.getText().length() - 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        et.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        hasFractionalPart = s.toString().contains(String.valueOf((this.isDecimal ? dfDecimal.getDecimalFormatSymbols().getDecimalSeparator() : df.getDecimalFormatSymbols().getDecimalSeparator())));
        if (start == 13 && !hasFractionalPart) {
            s = s + ".";
            hasFractionalPart = true;
        }
    }
}
