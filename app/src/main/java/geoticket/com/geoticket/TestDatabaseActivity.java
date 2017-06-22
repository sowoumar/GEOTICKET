package geoticket.com.geoticket;

/**
 * Created by oumar on 22/06/17.
 */

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.Random;

public class TestDatabaseActivity extends ListActivity {
    private TicketsDataSourceDAO datasource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        datasource = new TicketsDataSourceDAO(this);
        datasource.open();

        List<Ticket> values = datasource.getAllComments();

        // utilisez SimpleCursorAdapter pour afficher les
        // éléments dans une ListView
        ArrayAdapter<Ticket> adapter = new ArrayAdapter<Ticket>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    // Sera appelée par l'attribut onClick
    // des boutons déclarés dans main.xml
    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Ticket> adapter = (ArrayAdapter<Ticket>) getListAdapter();
        Ticket ticket = null;
        switch (view.getId()) {
            case R.id.add:
                String[] comments = new String[]{"Cool", "Very nice", "Hate it"};
                int nextInt = new Random().nextInt(3);
                // enregistrer le nouveau commentaire dans la base de données
                ticket = datasource.createComment(comments[nextInt]);
                adapter.add(ticket);
                break;
            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    ticket = (Ticket) getListAdapter().getItem(0);
                    datasource.deleteComment(ticket);
                    adapter.remove(ticket);
                }
                break;
        }
        adapter.notifyDataSetChanged();
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