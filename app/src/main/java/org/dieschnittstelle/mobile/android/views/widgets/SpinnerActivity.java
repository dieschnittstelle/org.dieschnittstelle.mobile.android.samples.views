package org.dieschnittstelle.mobile.android.views.widgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;

import org.dieschnittstelle.mobile.android.views.R;

public class SpinnerActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.spinner);

		Spinner spinner = (Spinner) findViewById(R.id.spinner);

		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parentView,
					View selectedItemView, int position, long id) {
				if (position == 0) {
					Log.i(SpinnerActivity.class.getName(),
							"got selection on 1st element, which may be the preselection. Ignore.");
				} else {
					String selectedItem = ((TextView) selectedItemView)
							.getText().toString();
					Log.i(SpinnerActivity.class.getName(),
							"got selected item on spinner: " + selectedItem);
					startActivity(new Intent(SpinnerActivity.this,
							CheckBoxActivity.class));
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parentView) {
				// your code here
			}

		});

	}
}