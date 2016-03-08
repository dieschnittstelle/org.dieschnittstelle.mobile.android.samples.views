package org.dieschnittstelle.mobile.android.views.widgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import org.dieschnittstelle.mobile.android.views.R;

public class TextViewActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview);
                
        TextView textView = (TextView)findViewById(R.id.textView);
        
        textView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i(TextViewActivity.class.getName(),"onClick(): " + v);
				startActivity(new Intent(TextViewActivity.this,EditTextActivity.class));	
			}
		});

    }
}