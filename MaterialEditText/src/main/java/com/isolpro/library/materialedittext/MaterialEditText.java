package com.isolpro.library.materialedittext;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MaterialEditText extends TextInputLayout {

  private final Context context;
  private TextInputEditText textInputEditText;

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
  }

  private void instantiate() {
    textInputEditText = new TextInputEditText(context);
  }

  private void initialize() {
    addView(textInputEditText);

//    setBoxBackgroundMode(BOX_BACKGROUND_OUTLINE);
  }
}
