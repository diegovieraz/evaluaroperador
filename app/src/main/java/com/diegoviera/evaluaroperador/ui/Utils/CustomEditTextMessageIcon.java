package com.diegoviera.evaluaroperador.ui.Utils;

import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.EMPTY_INTEGER;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.EMPTY_STRING;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.MORE_SPACING;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.SIMBOL_USD;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.SPACING;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.SYMBOL_COMMA;
import static com.diegoviera.evaluaroperador.ui.Utils.Constantes.SYMBOL_HYPHEN;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.diegoviera.evaluaroperador.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CustomEditTextMessageIcon extends ConstraintLayout {

    private Context context;

    private String editTextHint;
    private ColorStateList editTextColor;
    private float editTextSize = getResources().getDimension(R.dimen.textSize_16);
    private float editTextPaddingStart = 0;
    private float editTextPaddingEnd = 0;
    private float editTextPaddingTop = 0;
    private float editTextPaddingBottom = 0;
    private Integer editTextMaxLength;
    private Boolean editTextCurrency = false;
    private Integer editTextInputType;
    private Integer editTextImeOptions;
    private Integer editTextAlign;
    private Integer editTextYearMax;
    private Integer editTextYearMin;
    private Integer editTextFormatDate;
    private Boolean editTextFocusable = true;
    private Boolean editTextReadOnly = true;
    private Boolean editTextReadOnlyWithLine= true;
    private Boolean hintDate = false;

    private ColorStateList textViewColor;
    private float textViewSize = getResources().getDimension(R.dimen.textSize_14);
    private Boolean textViewMultiline = false;
    private Boolean textViewVisible = false;
    private String textviewText = EMPTY_STRING;

    private int imageViewScr = R.drawable.ic_warning_circle_red;
    private ColorStateList imageViewColor;
    private float imageViewSize = getResources().getDimension(R.dimen.content_inset_40);
    private Boolean imageViewVisible = false;

    private TextInputLayout textInputLayout;
    private TextInputEditText textInputEditText;
    private ImageView imageView;
    private TextView textView;

    private Drawable textInputDrawable;
    private Drawable defaultDrawable;

    private boolean isDecimal = false;
    private boolean isDate = false;
    private boolean isDiaMesAnio = false;

    private static final int DEFAULT_VALUE = -1;

    private static final int TEXT_SINGLE = 1;
    private static final int TEXT_MULTILINE = 2;
    private static final int TEXT_NUMBER = 3;
    private static final int TEXT_NUMBER_DECIMAL = 4;
    private static final int TEXT_DATE = 5;
    private static final int TEXT_PHONE = 6;
    private static final int TEXT_NONE = 7;
    private static final int TEXT_CAPS= 8;
    private static final int TEXT_NUMBER_SINGLE = 9;

    private static final int ACTION_DONE = 1;
    private static final int ACTION_SEND = 2;
    private static final int ACTION_NEXT = 3;
    private static final int ACTION_NONE = 4;
    private static final int ACTION_SEARCH = 5;

    private static final int TEXT_ALIGNMENT_START = 1;
    private static final int TEXT_ALIGNMENT_END = 2;
    private static final int TEXT_ALIGNMENT_CENTER = 3;

    private static final int TEXT_DATE_FORMAT_DDMMYYYY = 1;
    private static final int TEXT_DATE_FORMAT_MMYYYY = 2;

    public CustomEditTextMessageIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        loadAttributes(attrs);
        loadViews();
    }

    private void loadViews() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.custom_edittext_icon_message, this, true);

        textInputLayout = findViewById(R.id.textInputLayout);
        textInputEditText = findViewById(R.id.textInputEditText);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        textInputDrawable = textInputEditText.getBackground();

        setEditTextHint(editTextHint);
        setEditTextSize(editTextSize);
        setEditTextPaddingStart(editTextPaddingStart);
        setEditTextPaddingEnd(editTextPaddingEnd);
        setEditTextMaxLength(editTextMaxLength);
        setEditTextInputType(editTextInputType);
        setEditTextImeOptions(editTextImeOptions);
        setEditTextAlign(editTextAlign);
        setEditTextFormatDate(editTextFormatDate);
        setEditTextCurrency(editTextCurrency);
        setFocusable(editTextFocusable);
        setEditTextReadOnly(editTextReadOnly);
        setEditTextReadOnlyWithLine( editTextReadOnlyWithLine);


        setTextViewColor(textViewColor);
        setTextViewSize(textViewSize);
        setTextViewMultiline(textViewMultiline);
        setTextViewVisible(textViewVisible);
        setTextviewText(textviewText);

        setImageViewScr(imageViewScr);
        setImageViewColor(imageViewColor);
        setImageViewSize(imageViewSize);
        setImageViewVisible(imageViewVisible);

    }

    private void loadAttributes(final AttributeSet _attributeSet) {
        TypedArray attributeSet = context.obtainStyledAttributes(_attributeSet, R.styleable.CustomEditTextMessageIcon);

        editTextHint = attributeSet.getString(R.styleable.CustomEditTextMessageIcon_editTextHint) == null ? EMPTY_STRING : attributeSet.getString(R.styleable.CustomEditTextMessageIcon_editTextHint);
        editTextColor = attributeSet.getColorStateList(R.styleable.CustomEditTextMessageIcon_editTextColor);
        editTextSize = attributeSet.getDimension(R.styleable.CustomEditTextMessageIcon_editTextSize, editTextSize);
        editTextPaddingStart = attributeSet.getDimension(R.styleable.CustomEditTextMessageIcon_editTextPaddingStart, editTextPaddingStart);
        editTextPaddingEnd = attributeSet.getDimension(R.styleable.CustomEditTextMessageIcon_editTextPaddingEnd, editTextPaddingEnd);
        editTextPaddingTop = attributeSet.getDimension(R.styleable.CustomEditTextMessageIcon_editTextPaddingTop, editTextPaddingTop);
        editTextPaddingBottom = attributeSet.getDimension(R.styleable.CustomEditTextMessageIcon_editTextPaddingBottom, editTextPaddingBottom);
        editTextCurrency = attributeSet.getBoolean(R.styleable.CustomEditTextMessageIcon_editTextCurrency, false);
        editTextFocusable = attributeSet.getBoolean(R.styleable.CustomEditTextMessageIcon_editTextFocusable, true);
        editTextMaxLength = attributeSet.getInteger(R.styleable.CustomEditTextMessageIcon_editTextMaxLength, 100);
        editTextInputType = attributeSet.getInt(R.styleable.CustomEditTextMessageIcon_editTextInputType, DEFAULT_VALUE);
        editTextImeOptions = attributeSet.getInt(R.styleable.CustomEditTextMessageIcon_editTextImeOptions, DEFAULT_VALUE);
        editTextAlign = attributeSet.getInt(R.styleable.CustomEditTextMessageIcon_editTextAlign, DEFAULT_VALUE);
        editTextYearMax = attributeSet.getInteger(R.styleable.CustomEditTextMessageIcon_editTextYearMax, 0);
        editTextYearMin = attributeSet.getInteger(R.styleable.CustomEditTextMessageIcon_editTextYearMin, 0);
        editTextFormatDate = attributeSet.getInt(R.styleable.CustomEditTextMessageIcon_editTextFormatDate, DEFAULT_VALUE);
        editTextReadOnly = attributeSet.getBoolean(R.styleable.CustomEditTextMessageIcon_editTextReadOnly, false);
        editTextReadOnlyWithLine = attributeSet.getBoolean(R.styleable.CustomEditTextMessageIcon_editTextReadOnly, false);


        textViewColor = attributeSet.getColorStateList(R.styleable.CustomEditTextMessageIcon_textViewColor);
        textViewSize = attributeSet.getDimension(R.styleable.CustomEditTextMessageIcon_textViewSize, textViewSize);
        textViewMultiline = attributeSet.getBoolean(R.styleable.CustomEditTextMessageIcon_textViewMultiline, false);
        textViewVisible = attributeSet.getBoolean(R.styleable.CustomEditTextMessageIcon_textViewVisible, false);
        textviewText = attributeSet.getString(R.styleable.CustomEditTextMessageIcon_textViewText) == null ? EMPTY_STRING : attributeSet.getString(R.styleable.CustomEditTextMessageIcon_textViewText);

        imageViewScr = attributeSet.getResourceId(R.styleable.CustomEditTextMessageIcon_imageViewScr, imageViewScr);
        imageViewColor = attributeSet.getColorStateList(R.styleable.CustomEditTextMessageIcon_imageViewColor);
        imageViewSize = attributeSet.getDimension(R.styleable.CustomEditTextMessageIcon_imageViewSize, imageViewSize);
        imageViewVisible = attributeSet.getBoolean(R.styleable.CustomEditTextMessageIcon_imageViewVisible, false);
    }

    public void hideMessage() {
        setTextViewVisible(false);
        setImageViewVisible(false);
    }

    public void showMessage() {
        setTextviewText(context.getString(R.string.DATO_OBLIGATORIO));
        setTextViewVisible(true);
        setImageViewVisible(true);
        this.editTextPaddingEnd = this.imageViewSize + 8;
        setTextInputEditTextPadding();
    }

    public void showMessage(String message) {
        setTextviewText(message);
        setTextViewVisible(true);
        setImageViewVisible(true);
        this.editTextPaddingEnd = this.imageViewSize + 8;
        setTextInputEditTextPadding();
    }

    public void showMessageWithoutIcon(String message) {
        setTextviewText(message);
        setTextViewVisible(true);
        setImageViewVisible(false);
        setTextInputEditTextPadding();
    }

    public void showIconWithoutMessage() {
        setTextViewVisible(false);
        setImageViewVisible(true);
        this.editTextPaddingEnd = this.imageViewSize + 8;
        setTextInputEditTextPadding();
    }

    public String getEditTextHint() {
        return editTextHint;
    }

    public void setEditTextHint(String editTextHint) {
        this.editTextHint = editTextHint;
        this.textInputLayout.setHint(editTextHint == null ?  EMPTY_STRING : editTextHint);
    }

    public ColorStateList getEditTextColor() {
        return editTextColor;
    }

    public void setEditTextColor(ColorStateList editTextColor) {
        this.editTextColor = editTextColor;
        this.textInputEditText.setTextColor(editTextColor);
    }

    public float getEditTextSize() {
        return editTextSize;
    }

    public void setEditTextSize(float editTextSize) {
        this.editTextSize = editTextSize;
        this.textInputEditText.setTextSize(TypedValue.COMPLEX_UNIT_PX, editTextSize);
    }

    public Integer getEditTextMaxLength() {
        return editTextMaxLength;
    }

    public void setEditTextMaxLength(Integer editTextMaxLength) {
        this.editTextMaxLength = (this.editTextCurrency ? editTextMaxLength + 3 : editTextMaxLength);
        this.editTextMaxLength = (this.isDecimal ? this.editTextMaxLength + 1 : this.editTextMaxLength);
        this.textInputEditText.setFilters(new InputFilter[]{
                new InputFilter.LengthFilter(editTextMaxLength)
        });
    }

    public Boolean getEditTextCurrency() {
        return editTextCurrency;
    }

    public void setEditTextCurrency(Boolean editTextCurrency) {
        this.editTextCurrency = editTextCurrency;
        if (editTextCurrency) {
            this.textInputEditText.addTextChangedListener(new NumberTextWatcher(this.textInputEditText,
                    this.isDecimal));
        }
    }

    public void setEditTextCurrencySimbol(Boolean editTextCurrency, Boolean simbol) {
        this.editTextCurrency = editTextCurrency;
        if (editTextCurrency) {
            this.textInputEditText.addTextChangedListener(new NumberTextWatcher(this.textInputEditText,
                    this.isDecimal, simbol));
        }
    }

    public Integer getEditTextInputType() {
        return editTextInputType;
    }

    public void setEditTextInputType(Integer editTextInputType) {
        this.editTextInputType = editTextInputType;
        this.isDecimal = false;
        this.isDate = false;
        this.textInputEditText.setTypeface(Typeface.DEFAULT);
        switch (editTextInputType) {
            case TEXT_SINGLE:
                this.textInputEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
            case TEXT_MULTILINE:
                this.textInputEditText.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
                break;
            case TEXT_NUMBER_SINGLE:
                this.textInputEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            case TEXT_NUMBER:
                this.textInputEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED );
                break;
            case TEXT_NUMBER_DECIMAL:
                this.textInputEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                this.isDecimal = true;
                break;
            case TEXT_DATE:
                this.textInputEditText.setInputType(InputType.TYPE_CLASS_DATETIME);
                this.isDate = true;
                break;
            case TEXT_PHONE:
                this.textInputEditText.setInputType(InputType.TYPE_CLASS_PHONE);
                break;
            case TEXT_NONE:
                this.textInputEditText.setInputType(InputType.TYPE_NULL);
                break;
            case TEXT_CAPS:
                this.textInputEditText.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
                break;
        }
    }

    public Integer getEditTextImeOptions() {
        return editTextImeOptions;
    }

    public void setEditTextImeOptions(Integer editTextImeOptions) {
        this.editTextImeOptions = editTextImeOptions;
        switch (editTextImeOptions) {
            case ACTION_DONE:
                this.textInputEditText.setImeOptions(EditorInfo.IME_ACTION_DONE);
                break;
            case ACTION_SEND:
                this.textInputEditText.setImeOptions(EditorInfo.IME_ACTION_SEND);
                break;
            case ACTION_NEXT:
                this.textInputEditText.setImeOptions(EditorInfo.IME_ACTION_NEXT);
                break;
            case ACTION_NONE:
                this.textInputEditText.setImeOptions(EditorInfo.IME_ACTION_NONE);
                break;
            case ACTION_SEARCH:
                this.textInputEditText.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
                break;
        }
    }

    public ColorStateList getTextViewColor() {
        return textViewColor;
    }

    @SuppressLint("UseCompatLoadingForColorStateLists")
    public void setTextViewColor(ColorStateList textViewColor) {
        this.textViewColor = textViewColor;
        this.textView.setTextColor(textViewColor == null ? getResources().getColorStateList(R.color.red_A000) : textViewColor);
    }

    public float getTextViewSize() {
        return textViewSize;
    }

    public void setTextViewSize(float textViewSize) {
        this.textViewSize = textViewSize;
        this.textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textViewSize);
    }

    public Boolean getTextViewMultiline() {
        return textViewMultiline;
    }

    public void setTextViewMultiline(Boolean textViewMultiline) {
        this.textViewMultiline = textViewMultiline;
        this.textView.setSingleLine(!textViewMultiline);
    }

    public Boolean getTextViewVisible() {
        return textViewVisible;
    }

    public void setTextViewVisible(Boolean textViewVisible) {
        this.textViewVisible = textViewVisible;
        if (textViewVisible) {
            this.textView.setVisibility(VISIBLE);
        } else {
            this.textView.setVisibility(GONE);
        }
    }

    public int getImageViewScr() {
        return imageViewScr;
    }

    public void setImageViewScr(int imageViewScr) {
        this.imageViewScr = imageViewScr;
        this.imageView.setImageResource(imageViewScr);

    }

    public ColorStateList getImageViewColor() {
        return imageViewColor;
    }

    public void setImageViewColor(ColorStateList imageViewColor) {
        this.imageViewColor = imageViewColor;
        this.imageView.setImageTintList(imageViewColor);
    }

    public float getImageViewSize() {
        return imageViewSize;
    }

    public void setImageViewSize(float imageViewSize) {
        this.imageViewSize = imageViewSize;
        ViewGroup.LayoutParams layoutParams = this.imageView.getLayoutParams();
        layoutParams.width = (int) imageViewSize;
        layoutParams.height = (int) imageViewSize;
        this.imageView.setLayoutParams(layoutParams);
    }

    public Boolean getImageViewVisible() {
        return imageViewVisible;
    }

    public void setImageViewVisible(Boolean imageViewVisible) {
        this.imageViewVisible = imageViewVisible;
        if (imageViewVisible) {
            this.imageView.setVisibility(VISIBLE);
            this.imageView.setOnClickListener(view -> {
                Utilitario.showInformationDialog(context, EMPTY_STRING, this.textviewText);
            });
            this.editTextPaddingEnd = this.imageViewSize + 8;
            setTextInputEditTextPadding();
        } else {
            this.imageView.setVisibility(GONE);
            this.editTextPaddingEnd = 16;
            setTextInputEditTextPadding();
        }
    }

    public void setImageEmptyViewVisible(Boolean imageViewVisible) {
        this.imageViewVisible = imageViewVisible;
        if (imageViewVisible) {
            this.imageView.setVisibility(VISIBLE);
            this.editTextPaddingEnd = this.imageViewSize + 8;
            setTextInputEditTextPadding();
        }
    }

    public String getTextviewText() {
        return textviewText;
    }

    public void setTextviewText(String textviewText) {
        this.textviewText = textviewText;
        this.textView.setText(textviewText == null ?  EMPTY_STRING : textviewText);
    }

    public float getEditTextPaddingStart() {
        return editTextPaddingStart;
    }

    public void setEditTextPaddingStart(float editTextPaddingStart) {
        this.editTextPaddingStart = editTextPaddingStart;
    }

    public float getEditTextPaddingEnd() {
        return editTextPaddingEnd;
    }

    public void setEditTextPaddingEnd(float editTextPaddingEnd) {
        this.editTextPaddingEnd = editTextPaddingEnd;
    }

    public void setTextInputEditTextPadding() {
        editTextPaddingTop = editTextPaddingTop == 0 ? this.textInputEditText.getPaddingTop() : editTextPaddingTop;
        editTextPaddingBottom = editTextPaddingBottom == 0 ? this.textInputEditText.getPaddingBottom() : editTextPaddingBottom;
        editTextPaddingStart = editTextPaddingStart == 0 ? this.textInputEditText.getPaddingStart() : editTextPaddingStart;
        editTextPaddingEnd = editTextPaddingEnd == 0 ? this.textInputEditText.getPaddingEnd() : editTextPaddingEnd;
        this.textInputEditText.setPadding((int) editTextPaddingStart, (int) editTextPaddingTop, (int) editTextPaddingEnd, (int) editTextPaddingBottom);
    }

    public Integer getEditTextAlign() {
        return editTextAlign;
    }

    public void setEditTextAlign(Integer editTextAlign) {
        this.editTextAlign = editTextAlign;
        switch (editTextAlign) {
            case TEXT_ALIGNMENT_START:
                this.textInputEditText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                break;
            case TEXT_ALIGNMENT_END:
                this.textInputEditText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                break;
            case TEXT_ALIGNMENT_CENTER:
                this.textInputEditText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                break;
        }
    }

    public void setBorder(boolean border) {
        if (border) textInputEditText.setBackgroundResource(R.drawable.border_declaracion);
    }

    public Integer getEditTextFormatDate() {
        return editTextFormatDate;
    }

    public void setEditTextFormatDate(Integer editTextFormatDate) {
        this.editTextFormatDate = editTextFormatDate;
        switch (editTextFormatDate) {
            case TEXT_DATE_FORMAT_DDMMYYYY:
                this.isDiaMesAnio = true;
                break;
            case TEXT_DATE_FORMAT_MMYYYY:
                this.isDiaMesAnio = false;
                break;
        }
    }

    public String getText() {
        if(editTextInputType == TEXT_SINGLE  || editTextInputType == TEXT_MULTILINE ||  editTextInputType == DEFAULT_VALUE){
            return textInputEditText.getText().toString().trim();

        }else {
            return textInputEditText.getText().toString()
                    .replaceAll(MORE_SPACING, EMPTY_STRING)
                    .replaceAll(SIMBOL_USD, EMPTY_STRING)
                    .replaceAll(SYMBOL_HYPHEN, EMPTY_STRING)
                    .replaceAll(SPACING, EMPTY_STRING)
                    .replaceAll(SYMBOL_COMMA, EMPTY_STRING).trim();
        }
    }

    public String getTextValue() {
        return textInputEditText.getText().toString().replace(SIMBOL_USD, EMPTY_STRING).trim().equals(EMPTY_STRING) ? String.valueOf(EMPTY_INTEGER) : textInputEditText.getText().toString().replace(SIMBOL_USD, EMPTY_STRING).trim();
    }

    public TextInputEditText getTextInputEditText() {
        return textInputEditText;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setText(String text) {
        this.textInputEditText.setText(text);
    }

    public void setEnabled(boolean isEnabled) {
        if (isEnabled) {
            enableInputText();
        } else {
            disabledInputText();
        }
    }

    private void disabledInputText() {
        this.textInputEditText.setBackground(null);
        this.textInputEditText.setEnabled(false);
        //setEditTextColor(this.editTextColor);
    }

    private void enableInputText() {
        this.textInputEditText.setBackground(this.textInputDrawable);
        this.textInputEditText.setEnabled(true);
        setTextInputEditTextPadding();
    }

    public void setEditTextFocusable(boolean isFocusable) {
        this.editTextFocusable = isFocusable;
        this.textInputEditText.setFocusable(isFocusable);
    }

    public Boolean getEditTextReadOnly() {
        return editTextReadOnly;
    }

    public void setEditTextReadOnly(Boolean editTextReadOnly) {
        this.editTextReadOnly = editTextReadOnly;
        this.textInputEditText.setEnabled(!editTextReadOnly);
        this.textInputEditText.setBackground(this.textInputDrawable);
        if(editTextReadOnly){
            this.textInputEditText.setBackgroundResource(R.color.colorBgGray);
        }else {
            this.textInputEditText.setBackgroundResource(R.color.colorWhite);
        }
        setTextInputEditTextPadding();
    }

    public Boolean getEditTextReadOnlyWithLine() {
        return editTextReadOnlyWithLine;
    }

    //no usar
    public void setEditTextReadOnlyWithLine(Boolean editTextReadOnlyWithLine) {
        this.editTextReadOnlyWithLine = editTextReadOnlyWithLine;
        this.setEnabled(!editTextReadOnlyWithLine);
        //this.setEnabled(!editTextReadOnlyWithLine);
        this.textInputEditText.setBackground(this.textInputDrawable);
        // this.setEditTextColor(ColorStateList.valueOf(Color.parseColor("#A3A3A3")));

        //this.textInputEditText.setBackground(context.getDrawable(R.color.black));
        setTextInputEditTextPadding();
    }


    public void showMessageText(String message) {
        setTextviewText(message);
        setTextViewVisible(true);
        setImageViewVisible(false);
        this.editTextPaddingEnd = this.imageViewSize + 8;
        setTextInputEditTextPadding();
    }
}
