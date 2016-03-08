package org.dieschnittstelle.mobile.android.views.widgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import org.dieschnittstelle.mobile.android.views.R;

public class EditTextNumericActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittext_numeric);
                
        EditText editText = (EditText)findViewById(R.id.editText);
        
        editText.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView view, int arg1, KeyEvent arg2) {
				Log.d(EditTextNumericActivity.class.getName(), "got editor action " + arg1 + " on textview "
						+ view + ". KeyEvent is: " + arg2);
				if (arg1 == EditorInfo.IME_ACTION_DONE || arg2.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
					Log.i(EditTextNumericActivity.class.getName(), "done was pressed!");

					// Zugriff auf den eingegebenen Text
					String text= view.getText().toString();
					
					Log.i(EditTextNumericActivity.class.getName(), "text is: " + text);
					
					startActivity(new Intent(EditTextNumericActivity.this,EditTextAutocompleteActivity.class));

					return false;
				}
				return false;
			}

		});

    }
}