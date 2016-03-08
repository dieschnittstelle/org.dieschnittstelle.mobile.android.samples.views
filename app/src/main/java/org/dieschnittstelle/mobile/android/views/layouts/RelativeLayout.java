package org.dieschnittstelle.mobile.android.views.layouts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import org.dieschnittstelle.mobile.android.views.R;

public class RelativeLayout extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.relative);

		Button okButton = (Button) findViewById(R.id.ok);

		okButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Log.i(RelativeLayout.class.getName(), "onClick(): " + v);
				startActivity(new Intent(RelativeLayout.this, FrameLayout.class));
			}
		});

	}
}