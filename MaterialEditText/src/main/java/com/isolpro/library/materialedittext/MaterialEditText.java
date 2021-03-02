package com.isolpro.library.materialedittext;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MaterialEditText extends RelativeLayout {

  private final Context context;

  private View mv;
  private TextInputLayout textInputLayout;
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
    mv = LayoutInflater.from(context).inflate(R.layout.material_edit_text, null);

    textInputLayout = mv.findViewById(R.id.til);
    textInputEditText = mv.findViewById(R.id.tiet);
  }

  private void initialize() {
    addView(mv);
  }

}
