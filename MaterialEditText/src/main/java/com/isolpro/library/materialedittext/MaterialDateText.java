package com.isolpro.library.materialedittext;

import android.app.DatePickerDialog;
import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MaterialDateText extends MaterialEditText {

  private DatePickerDialog datePickerDialog;
  private Date selectedDate;
  private OnDatePickedCallback onDatePickedCallback = null;

  public MaterialDateText(Context context) {
    super(context);
  }

  public MaterialDateText(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public MaterialDateText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }
    @Override
  protected void instantiate() {
    super.instantiate();

    Calendar calendar = Calendar.getInstance();

    datePickerDialog = new DatePickerDialog(getContext(),
      (view, year, month, day) -> setSelectedDate(year, month, day),
      calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

    datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
  }

  @Override
  protected void initialize() {
    super.initialize();
    setInputType(InputType.TYPE_NULL);
  }

  @Override
  protected void listen() {
    super.listen();

    textInputEditText.setOnClickListener(v -> datePickerDialog.show());
  }

  private void setSelectedDate(int year, int month, int day) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(year, month, day, 0, 0, 0);

    setDate(calendar.getTime());
  }

  public Date getSelectedDate() {
    return selectedDate;
  }

  public boolean isDateSelected() {
    return selectedDate != null;
  }

  public void selectToday() {
    setDate(new Date());
  }

  public void setDate(Date date) {
    if (date != null) {
      selectedDate = date;

      SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd", Locale.US);
      setText(dateFormat.format(date));

      if (onDatePickedCallback != null) onDatePickedCallback.exec(selectedDate);
    }
  }

  public void setOnDatePickedCallback(OnDatePickedCallback onDatePickedCallback) {
    this.onDatePickedCallback = onDatePickedCallback;
  }
}
