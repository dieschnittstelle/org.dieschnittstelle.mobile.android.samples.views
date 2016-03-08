package org.dieschnittstelle.mobile.android.views.widgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import org.dieschnittstelle.mobile.android.views.R;

public class EditTextAutocompleteActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittext_autocomplete);
                
        AutoCompleteTextView editText = (AutoCompleteTextView)findViewById(R.id.editText);
        
        /*
         *  Adapter zur uebermittlung der Optionen, die zur Vervollstaendigung angeboten werden. Die Optionen werden durch die Ressource "options" in strings.xml bereitgestellt.
         */        
        String[] options = getResources().getStringArray(R.array.options);
        Log.i(EditTextAutocompleteActivity.class.getName(),"setting " + options.length + " options");
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,options);
        editText.setAdapter(adapter);
        
        editText.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView view, int arg1, KeyEvent arg2) {
				Log.d(EditTextAutocompleteActivity.class.getName(), "got editor action " + arg1 + " on textview "
						+ view + ". KeyEvent is: " + arg2);
				if (arg1 == EditorInfo.IME_ACTION_DONE || arg2.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
					Log.i(EditTextAutocompleteActivity.class.getName(), "done was pressed!");

					// Zugriff auf den eingegebenen Text
					String text= view.getText().toString();
					
					Log.i(EditTextAutocompleteActivity.class.getName(), "text is: " + text);
					
					startActivity(new Intent(EditTextAutocompleteActivity.this,SeekBarActivity.class));

					return false;
				}
				return false;
			}

		});

    }
}