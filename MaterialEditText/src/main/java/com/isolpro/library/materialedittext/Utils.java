package com.isolpro.library.materialedittext;

import android.os.Handler;

final class Utils {

  public static void setTimeout(final OnValidationErrorCallback callback, int delay) {
    new Handler().postDelayed(() -> callback.exec(null), delay);
  }
}
