package org.dieschnittstelle.mobile.android.views.widgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import org.dieschnittstelle.mobile.android.views.R;

public class OptionsMenuActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contextmenu);
		
		// die mainview im layout wird fuer das Kontextmenue registriert, d.h. ein langer Klick bringt das Kontextmenue zur Darstellung
		registerForContextMenu(findViewById(R.id.mainview));
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		Log.i(OptionsMenuActivity.class.getName(), "options menu is being created...");
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.layout.contextmenu_menu, menu);
	}
	
	public boolean onContextItemSelected(MenuItem item) {
		super.onContextItemSelected(item);
		
		Log.i(OptionsMenuActivity.class.getName(), "got selection on context item: " + item);
		
		// we will now return to the initial activity
		startActivity(new Intent(OptionsMenuActivity.this,org.dieschnittstelle.mobile.android.views.layouts.LinearLayoutHorizontal.class));
		
		return true;
	}
}