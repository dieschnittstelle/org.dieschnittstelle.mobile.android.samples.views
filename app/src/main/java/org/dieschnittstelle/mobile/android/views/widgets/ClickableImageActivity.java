package org.dieschnittstelle.mobile.android.views.widgets;

import org.dieschnittstelle.mobile.android.views.layouts.ComposedLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import org.dieschnittstelle.mobile.android.views.R;

public class ClickableImageActivity extends Activity {

	// a counter to control number of clicks before calling the next activity
	private int counter = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clickableimage);

		final ImageView image = (ImageView) findViewById(R.id.image);

		image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i(ComposedLayout.class.getName(), "onClick(): " + v);
				counter++;

				if (counter > 3) {
					startActivity(new Intent(ClickableImageActivity.this,
							DatePickerActivity.class));
				}
				// setze das Bild in Abhaengigkeit vom Stand des Counters
				else {
					image.setImageResource(counter % 2 == 0 ? R.drawable.star_grey
							: R.drawable.star_yellow);
				}
				
			}

		});
	}
}