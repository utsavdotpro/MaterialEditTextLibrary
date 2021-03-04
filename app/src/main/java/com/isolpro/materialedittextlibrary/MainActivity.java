package com.isolpro.materialedittextlibrary;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.isolpro.library.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {

  private MaterialButton btnValidate;
  private MaterialEditText metEmail, metPassword;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    metEmail = findViewById(R.id.metEmail);
    metPassword = findViewById(R.id.metPassword);
    btnValidate = findViewById(R.id.btnValidate);

    btnValidate.setOnClickListener(v -> {
      MaterialEditText.validateEditTexts(met -> {
        Toast.makeText(this, "Some required fields are empty", Toast.LENGTH_LONG).show();
      }, metEmail, metPassword);
    });
  }
}