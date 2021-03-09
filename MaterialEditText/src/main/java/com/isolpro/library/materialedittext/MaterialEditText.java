package com.isolpro.library.materialedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MaterialEditText extends RelativeLayout {

  private final Context context;

  private View mv;
  private TextInputLayout textInputLayout;
  private TextInputEditText textInputEditText;

  // - Props
  private String errorMessage = "";
  private boolean required;

  public MaterialEditText(@NonNull Context context) {
    this(context, null);
  }

  public MaterialEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public MaterialEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    this.context = context;

    instantiate();
    initialize();
    listen();
    defaults(
      context.getTheme().obtainStyledAttributes(attrs, R.styleable.MaterialEditText, 0, 0)
    );
  }

  public static boolean validateEditTexts(OnValidationErrorCallback onValidationErrorCallback, MaterialEditText... materialEditTexts) {
    for (MaterialEditText met : materialEditTexts) {
      if (met.isRequired() && met.getText().toString().isEmpty()) {
        if (!met.getErrorMessage().isEmpty())
          met.showError(3000);

        if (onValidationErrorCallback != null) onValidationErrorCallback.exec(met);

        return false;
      }
    }

    return true;
  }

  public static boolean validateEditTexts(MaterialEditText... materialEditTexts) {
    return validateEditTexts(null, materialEditTexts);
  }

  private void instantiate() {
    mv = LayoutInflater.from(context).inflate(R.layout.material_edit_text, null);

    textInputLayout = mv.findViewById(R.id.til);
    textInputEditText = mv.findViewById(R.id.tiet);
  }

  private void initialize() {
    addView(mv);
  }

  private void listen() {
  }

  private void defaults(TypedArray ta) {
    setErrorMessage(ta.getString(R.styleable.MaterialEditText_met_errorMessage));
    setBoxBackgroundColor(ta.getInteger(R.styleable.MaterialEditText_met_boxBackgroundColor, Color.WHITE));
    setBoxBackgroundMode(ta.getInteger(R.styleable.MaterialEditText_met_boxBackgroundMode, 2));
    setEnabled(ta.getBoolean(R.styleable.MaterialEditText_met_enabled, true));
    setRequired(ta.getBoolean(R.styleable.MaterialEditText_met_required, false));
    setHint(ta.getString(R.styleable.MaterialEditText_met_hint));

    setText(ta.getString(R.styleable.MaterialEditText_met_text));
    setInputType(ta.getInteger(R.styleable.MaterialEditText_met_inputType, 1));
    setLines(ta.getInteger(R.styleable.MaterialEditText_met_lines, 1));
  }

  private void setError(CharSequence errorMessage) {
    textInputLayout.setError(errorMessage);
  }

  private void setErrorVisible(boolean isErrorVisible) {
    setErrorEnabled(isErrorVisible);
    setError(isErrorVisible ? getErrorMessage() : "");
  }

  private void setErrorEnabled(boolean errorEnabled) {
    textInputLayout.setErrorEnabled(errorEnabled);
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage != null ? errorMessage : "";
  }

  public void showError(int autoHideDuration) {
    setErrorVisible(true);

    if (autoHideDuration >= 0)
      Utils.setTimeout(o -> hideError(), autoHideDuration);
  }

  public void showError() {
    showError(-1);
  }

  public void hideError() {
    setErrorVisible(false);
  }

  public Integer getBoxBackgroundColor() {
    return textInputLayout.getBoxBackgroundColor();
  }

  public void setBoxBackgroundColor(@ColorInt int boxBackgroundColor) {
    textInputLayout.setBoxBackgroundColor(boxBackgroundColor);
  }

  public Integer getBoxBackgroundMode() {
    return textInputLayout.getBoxBackgroundMode();
  }

  public void setBoxBackgroundMode(int boxBackgroundMode) {
    textInputLayout.setBoxBackgroundMode(boxBackgroundMode);
  }

  public boolean isEnabled() {
    return textInputLayout.isEnabled();
  }

  public void setEnabled(boolean enabled) {
    textInputLayout.setEnabled(enabled);
  }

  public boolean isRequired() {
    return required;
  }

  public void setRequired(boolean required) {
    this.required = required;
  }

  public CharSequence getHint() {
    return textInputLayout.getHint();
  }

  public void setHint(String hint) {
    textInputLayout.setHint(hint);
  }

  public CharSequence getText() {
    return textInputEditText.getText();
  }

  public void setText(String text) {
    textInputEditText.setText(text);
  }

  public int getInputType() {
    return textInputEditText.getInputType();
  }

  public void setInputType(int inputType) {
    textInputEditText.setInputType(inputType);
  }

  public void setLines(int lines) {
    textInputEditText.setLines(lines);
  }

  public String getString() {
    return getText().toString();
  }

  public int getInteger(int defaultValue) {
    try {
      return Integer.parseInt(getString());
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public float getFloat(float defaultValue) {
    try {
      return Float.parseFloat(getString());
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public boolean getBoolean(boolean defaultValue) {
    try {
      return Boolean.parseBoolean(getString());
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

}
