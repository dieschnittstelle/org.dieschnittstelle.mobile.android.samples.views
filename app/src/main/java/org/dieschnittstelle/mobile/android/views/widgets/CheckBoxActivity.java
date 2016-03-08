package org.dieschnittstelle.mobile.android.views.widgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import org.dieschnittstelle.mobile.android.views.R;

public class CheckBoxActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // setze das Layout als Ansicht der Activity.
        setContentView(R.layout.checkbox);
                
        // lies das CheckBox Objekt mittels seiner id aus dem Layout aus.
        CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);
        
        // setze den Listener auf dem CheckBox Objekt.
        checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton checkbox,
					boolean checked) {
				Log.i(CheckBoxActivity.class.getName(),"onCheckedChange(): checked is: " + checked);
				
				startActivity(new Intent(CheckBoxActivity.this,ToggleButtonActivity.class));
			}
        });

    }
}



