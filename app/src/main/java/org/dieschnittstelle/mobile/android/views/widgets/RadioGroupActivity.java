package org.dieschnittstelle.mobile.android.views.widgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import org.dieschnittstelle.mobile.android.views.R;

public class RadioGroupActivity extends Activity {
	
	private static final int NOSELECTION = 999;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiogroup);
                
        RadioGroup group = (RadioGroup)findViewById(R.id.radioGroup);
        
        // wir lesen wiederum die Optionsliste aus und erzeugen fuer jedes Element der Liste einen RadioButton
        String[] options = getResources().getStringArray(R.array.options);
        Log.i(RadioGroupActivity.class.getName(),"setting " + options.length + " options");
        
        for (int i=0;i<options.length;i++) {
        	RadioButton button = new RadioButton(this);
        	group.addView(button);
        	button.setText(options[i]);
        	button.setId(i);
        }
        
        // setze einen Wert, dessen Auswahl einen uebergang in die naechste Ansicht bewirkt
		RadioButton button = new RadioButton(this);
    	group.addView(button);
    	button.setText("Keine Auswahl");
    	button.setId(NOSELECTION);
        
    	// setze einen Listener, der bei aenderung der Auswahl aufgerufen wird
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				Log.i(RadioGroupActivity.class.getName(),"onCheckedChange(): checkedId is: " + checkedId);

				// lies den ausgewaehlten Wert aus
				if (checkedId != -1) {
					RadioButton but = (RadioButton)findViewById(checkedId);
					
					Log.i(RadioGroupActivity.class.getName(),"text value of checked item is: " + but.getText());
					if (checkedId == NOSELECTION) {
						startActivity(new Intent(RadioGroupActivity.this,ClickableImageActivity.class));						
					}
				}				
			}
        });

    }
}