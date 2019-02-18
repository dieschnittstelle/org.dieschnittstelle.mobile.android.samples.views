package org.dieschnittstelle.mobile.android.views.widgets;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import org.dieschnittstelle.mobile.android.views.R;

public class DatePickerActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker);
                
        // der DatePicker
        DatePicker picker = (DatePicker)findViewById(R.id.picker);
        
        // das Textfeld zur textuellen Darstellung des Datums
        final TextView dateAsText = (TextView)findViewById(R.id.dateAsText);
        dateAsText.setText(new Date().toString());
        
        picker.init(picker.getYear(),picker.getMonth(),picker.getDayOfMonth(), new DatePicker.OnDateChangedListener() {
			
			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				// initialisiere das Datum, beruecksichtige die Unterschiede bei den Konventionen fuer die Repraesentation von Jahr / Monat / Tag als Integer-Werte
				Date dt = new Date(year-1900,monthOfYear,dayOfMonth);
				// setze das Datum auf dem Textfeld
				dateAsText.setText(dt.toString());
				
				// ueberpruefe das Datum
				if (year < 2019) {
					startActivity(new Intent(DatePickerActivity.this,ListViewActivity.class));
				}
			}
		});
        
    }
}