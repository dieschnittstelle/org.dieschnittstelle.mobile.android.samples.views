package org.dieschnittstelle.mobile.android.views.layouts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import org.dieschnittstelle.mobile.android.views.R;
import org.dieschnittstelle.mobile.android.views.widgets.TextViewActivity;

public class ComposedLayout extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.composition);

		Button okButton = (Button) findViewById(R.id.ok);

		okButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i(ComposedLayout.class.getName(), "onClick(): " + v);
				startActivity(new Intent(ComposedLayout.this, TextViewActivity.class));
			}
		});

	}
}