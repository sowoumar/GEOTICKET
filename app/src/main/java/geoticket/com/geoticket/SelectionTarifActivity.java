package geoticket.com.geoticket;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.Date;
import java.util.List;

public class SelectionTarifActivity extends ListActivity {
	
	TicketsDataSourceDAO datasource;
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selection_tarif);
		datasource = new TicketsDataSourceDAO(getApplicationContext());
		datasource.open();
		List<Ticket> values = datasource.getAllTickets(Utils.formatDate(new Date()));
		// utilisez SimpleCursorAdapter pour afficher les
		// éléments dans une ListView
		ArrayAdapter<Ticket> adapter = new ArrayAdapter<Ticket>(this, android.R.layout.simple_list_item_1, values);
		setListAdapter(adapter);
	}
	
	
	
	public void editTicket (View view) {
		
		@SuppressWarnings("unchecked")
		ArrayAdapter<Ticket> adapter = (ArrayAdapter<Ticket>) getListAdapter();
		Ticket ticket = new Ticket();
		ticket.setDateVente(Utils.formatDate(new Date()));
		int i = view.getId();
		if (i == R.id.tarif1) {
			ticket.setPrix(TARIF.TARIF1.getName());
			ticket.setTicket(TARIF.TARIF1.getPrice());
			ticket = datasource.createTicket(ticket);
			adapter.add(ticket);
			
		} else if (i == R.id.tarif2) {
			ticket.setPrix(TARIF.TARIF2.getName());
			ticket.setTicket(TARIF.TARIF2.getPrice());
			ticket = datasource.createTicket(ticket);
			adapter.add(ticket);
			
		} else if (i == R.id.tarif3) {
			ticket.setPrix(TARIF.TARIF3.getName());
			ticket.setTicket(TARIF.TARIF3.getPrice());
			ticket = datasource.createTicket(ticket);
			adapter.add(ticket);
			
		} else if (i == R.id.tarif4) {
			ticket.setPrix(TARIF.TARIF4.getName());
			ticket.setTicket(TARIF.TARIF4.getPrice());
			ticket = datasource.createTicket(ticket);
			adapter.add(ticket);
			
		} else if (i == R.id.tarif5) {
			ticket.setPrix(TARIF.TARIF5.getName());
			ticket.setTicket(TARIF.TARIF5.getPrice());
			ticket = datasource.createTicket(ticket);
			adapter.add(ticket);
			
		} else if (i == R.id.tarif6) {
			ticket.setPrix(TARIF.TARIF6.getName());
			ticket.setTicket(TARIF.TARIF6.getPrice());
			ticket = datasource.createTicket(ticket);
			adapter.add(ticket);
			
		} else if (i == R.id.tarif7) {
			ticket.setPrix(TARIF.TARIF7.getName());
			ticket.setTicket(TARIF.TARIF7.getPrice());
			ticket = datasource.createTicket(ticket);
			adapter.add(ticket);
			
		} else if (i == R.id.tarif8) {
			ticket.setPrix(TARIF.TARIF8.getName());
			ticket.setTicket(TARIF.TARIF8.getPrice());
			ticket = datasource.createTicket(ticket);
			adapter.add(ticket);
			
		} else if (i == R.id.tarif9) {
			ticket.setPrix(TARIF.TARIF9.getName());
			ticket.setTicket(TARIF.TARIF9.getPrice());
			ticket = datasource.createTicket(ticket);
			adapter.add(ticket);
			
		} else if (i == R.id.tarif10) {
			ticket.setPrix(TARIF.TARIF10.getName());
			ticket.setTicket(TARIF.TARIF10.getPrice());
			ticket = datasource.createTicket(ticket);
			adapter.add(ticket);
			
		}
		adapter.notifyDataSetChanged();
	}
}
