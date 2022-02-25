package org.dieschnittstelle.mobile.android.views.widgets;

import org.dieschnittstelle.mobile.android.views.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SeekBarActivity extends Activity {
	
	/**
	 * lokale Variable fuer den SeekBar
	 */
	SeekBar bar; 
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar);
                
        bar = (SeekBar)findViewById(R.id.seekbar);
        
        // Textansicht zur Darstellung des eingestellten Werts
        final TextView txt = (TextView)findViewById(R.id.seekbar_value);
        
        bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				Log.i(SeekBarActivity.class.getName(),"stop tracking touch...");
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				Log.i(SeekBarActivity.class.getName(),"start tracking touch...");
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				Log.i(SeekBarActivity.class.getName(),"progress changed: " + progress);
				
				txt.setText(String.valueOf(progress));
								
				// setze einen zweiten Verlaufswert (hier willkuerlich)
				seekBar.setSecondaryProgress(progress + seekBar.getMax() / 2);
				
				// ueberpruefe ob der Wert den Schwellenwert fuer den Aufruf der naechsten Activity erreicht hat
				if (progress > 350) {
					startActivity(new Intent(SeekBarActivity.this,SpinnerActivity.class));
				}
			}
		});

    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	Log.i(SeekBarActivity.class.getName(),"onResume(): setze seekBar zurueck");
    	bar.setProgress(0);
    }
}