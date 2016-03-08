package org.dieschnittstelle.mobile.android.views.widgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import org.dieschnittstelle.mobile.android.views.R;

public class ToggleButtonActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.togglebutton);
                
        ToggleButton button = (ToggleButton)findViewById(R.id.toggleButton);
        
        button.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton checkbox,
					boolean checked) {
				Log.i(ToggleButtonActivity.class.getName(),"onCheckedChange(): checked is: " + checked);
				
				startActivity(new Intent(ToggleButtonActivity.this,RadioButtonActivity.class));
			}
        });

    }
}