package com.diegoviera.evaluaroperador.ui.Utils;

import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.EMPTY_STRING;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.diegoviera.evaluaroperador.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class CustomEditTextSpinner extends FrameLayout {

    private AutoCompleteTextView ed_spn;
    private TextInputLayout til_spn;
    private TextView textView;

    private String textviewText = EMPTY_STRING;
    private Boolean textViewVisible = false;
    private Boolean imageViewVisible = false;
    private Boolean editTextReadOnly = true;

    public CustomEditTextSpinner(@NonNull Context context) {
        super(context);
        init();
    }

    public CustomEditTextSpinner(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomEditTextSpinner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public CustomEditTextSpinner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.custom_edit_text_spinner, this);
        ed_spn = findViewById(R.id.ed_spn);
        til_spn = findViewById(R.id.til_spn);
        textView = findViewById(R.id.textView);

        ed_spn.setActivated(false);

        ed_spn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ed_spn.setCompoundDrawableTintList(getContext().getColorStateList(R.color.background_header));
                ed_spn.showDropDown();
            }
        });

    }

    public void setText(String text) {
        ed_spn.setText(text);
    }

    public String getText() {
        return ed_spn.getText().toString();
    }

    public String getSpinnerHint() {
        return ed_spn.getHint().toString();
    }

    public void setSpinnerhint(String hint) {
        til_spn.setHint(hint);
    }

    public void setSpinnerAdapter(String[] array) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, array);
        ed_spn.setAdapter(adapter);
    }

    public void setSpinnerAdapter(List<String> array) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, array);
        ed_spn.setAdapter(adapter);
    }

    public AutoCompleteTextView getAutoComplete() {
        return ed_spn;
    }

    public void setTextviewText(String textviewText) {
        this.textviewText = textviewText;
        this.textView.setText(textviewText == null ?  EMPTY_STRING : textviewText);
    }

    public void setTextViewVisible(Boolean textViewVisible) {
        this.textViewVisible = textViewVisible;
        if (textViewVisible) {
            this.textView.setVisibility(VISIBLE);
        } else {
            this.textView.setVisibility(GONE);
        }
    }

    public void setImageViewVisible(Boolean imageViewVisible) {
        this.imageViewVisible = imageViewVisible;
        if (imageViewVisible) {
            ed_spn.setCompoundDrawables(null, null, getContext().getDrawable(R.drawable.ic_warning_circle_red), null);
        } else {
            ed_spn.setCompoundDrawables(null, null, getContext().getDrawable(R.drawable.ic_menu_down_custom), null);
        }
    }

    public Boolean getEditTextReadOnly() {
        return editTextReadOnly;
    }

    public void setEditTextReadOnly(Boolean editTextReadOnly) {
        this.editTextReadOnly = editTextReadOnly;
        this.ed_spn.setEnabled(!editTextReadOnly);
        if(editTextReadOnly){
            ed_spn.setTextColor(Color.BLACK);
            ed_spn.setBackgroundResource(R.color.colorBgGray);
        }else{
            ed_spn.setBackgroundResource(R.color.colorWhite);
        }
        this.textView.setEnabled(!editTextReadOnly);
    }

    public void hideMessage() {
        setTextViewVisible(false);
        setImageViewVisible(false);
    }

    public void showMessage() {
        setTextviewText(getContext().getString(R.string.DATO_OBLIGATORIO));
        setTextViewVisible(true);
        setImageViewVisible(true);
    }

    public void showMessage(String message) {
        setTextviewText(message);
        setTextViewVisible(true);
        setImageViewVisible(true);
    }
}
