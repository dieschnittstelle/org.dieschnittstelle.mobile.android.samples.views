package org.dieschnittstelle.mobile.android.views.layouts;

import android.app.Activity;
import android.os.Bundle;
import org.dieschnittstelle.mobile.android.views.R;

public class ViewsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative);
    }
}