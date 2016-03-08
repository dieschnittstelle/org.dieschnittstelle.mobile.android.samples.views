package org.dieschnittstelle.mobile.android.views.widgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.dieschnittstelle.mobile.android.views.R;

public class ListViewActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
               
        // Zugriff auf die Listenansicht
        ListView listview = (ListView)findViewById(R.id.list);
        
        // lies die Optionen aus
        final String[] options = getResources().getStringArray(R.array.options);
        
        /**
         * erzeuge einen Adapter, der dem listview Zugriff auf die Inhalte ermoeglicht
         * Diesem wird ausserdem die Ansicht uebermittelt, die fuer ein einzelnes Listenelement verwendet werden soll
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options);
        
        // setze den Adapter auf die Listenansicht
        listview.setAdapter(adapter);
        
        // setze einen Listener, der auf die Auswahl eines Elements reagiert
        listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Log.i(ListViewActivity.class.getName(), "item at position " + arg2 + " has been selected: " + options[arg2]);
				
				// rufe die initiale Activity wieder auf...
				startActivity(new Intent(ListViewActivity.this,OptionsMenuActivity.class));
			}
			
		});
    
        
    }
}