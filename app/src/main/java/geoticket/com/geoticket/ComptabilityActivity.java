package geoticket.com.geoticket;

/*
 * Created by oumar on 22/06/17.
 */


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.Date;
import java.util.List;

public class ComptabilityActivity extends ListActivity {
    private TicketsDataSourceDAO datasource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comptability_activity);
        datasource = new TicketsDataSourceDAO(getApplicationContext());
        datasource.open();
	    String today = Utils.formatDate(new Date());
        List<Ticket> values = datasource.getAllTickets(today);
	    
        ArrayAdapter<Ticket> adapter = new ArrayAdapter<Ticket>(this,
                android.R.layout.simple_list_item_checked, values);
        setListAdapter(adapter);
    }
    
    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }
}
