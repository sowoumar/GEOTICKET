package geoticket.com.geoticket;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.hp.mss.hpprint.model.PDFPrintItem;
import com.hp.mss.hpprint.model.PrintItem;
import com.hp.mss.hpprint.model.PrintJobData;
import com.hp.mss.hpprint.model.asset.PDFAsset;
import com.hp.mss.hpprint.util.PrintUtil;

import java.io.File;
import java.util.Date;
import java.util.List;

public class SelectionTarifActivity extends ListActivity {

    TicketsDataSourceDAO datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

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


    /**
     * permet l'edition de ticket de transport
     *
     * @param view le bouton cliqué
     */
    public void editTicket(View view) {

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
            imprimerTicket();
            Toast.makeText(this, "Tarif 1 imprimé !", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.tarif2) {
            ticket.setPrix(TARIF.TARIF2.getName());
            ticket.setTicket(TARIF.TARIF2.getPrice());
            ticket = datasource.createTicket(ticket);
            adapter.add(ticket);
            imprimerTicket();
            Toast.makeText(this, "Tarif 2 imprimé !", Toast.LENGTH_SHORT).show();

        } else if (i == R.id.tarif3) {
            ticket.setPrix(TARIF.TARIF3.getName());
            ticket.setTicket(TARIF.TARIF3.getPrice());
            ticket = datasource.createTicket(ticket);
            adapter.add(ticket);
            imprimerTicket();
            Toast.makeText(this, "Tarif 3 imprimé !", Toast.LENGTH_SHORT).show();

        } else if (i == R.id.tarif4) {
            ticket.setPrix(TARIF.TARIF4.getName());
            ticket.setTicket(TARIF.TARIF4.getPrice());
            ticket = datasource.createTicket(ticket);
            adapter.add(ticket);
            imprimerTicket();
            Toast.makeText(this, "Tarif 4 imprimé !", Toast.LENGTH_SHORT).show();

        } else if (i == R.id.tarif5) {
            ticket.setPrix(TARIF.TARIF5.getName());
            ticket.setTicket(TARIF.TARIF5.getPrice());
            ticket = datasource.createTicket(ticket);
            adapter.add(ticket);
            imprimerTicket();
            Toast.makeText(this, "Tarif 5 imprimé !", Toast.LENGTH_SHORT).show();

        } else if (i == R.id.tarif6) {
            ticket.setPrix(TARIF.TARIF6.getName());
            ticket.setTicket(TARIF.TARIF6.getPrice());
            ticket = datasource.createTicket(ticket);
            adapter.add(ticket);
            imprimerTicket();
            Toast.makeText(this, "Tarif 6 imprimé !", Toast.LENGTH_SHORT).show();

        } else if (i == R.id.tarif7) {
            ticket.setPrix(TARIF.TARIF7.getName());
            ticket.setTicket(TARIF.TARIF7.getPrice());
            ticket = datasource.createTicket(ticket);
            adapter.add(ticket);
            imprimerTicket();
            Toast.makeText(this, "Tarif 7 imprimé !", Toast.LENGTH_SHORT).show();

        } else if (i == R.id.tarif8) {
            ticket.setPrix(TARIF.TARIF8.getName());
            ticket.setTicket(TARIF.TARIF8.getPrice());
            ticket = datasource.createTicket(ticket);
            adapter.add(ticket);
            imprimerTicket();
            Toast.makeText(this, "Tarif 8 imprimé !", Toast.LENGTH_SHORT).show();

        } else if (i == R.id.tarif9) {
            ticket.setPrix(TARIF.TARIF9.getName());
            ticket.setTicket(TARIF.TARIF9.getPrice());
            ticket = datasource.createTicket(ticket);
            adapter.add(ticket);
            imprimerTicket();
            Toast.makeText(this, "Tarif 9 imprimé !", Toast.LENGTH_SHORT).show();

        } else if (i == R.id.tarif10) {
            ticket.setPrix(TARIF.TARIF10.getName());
            ticket.setTicket(TARIF.TARIF10.getPrice());
            ticket = datasource.createTicket(ticket);
            adapter.add(ticket);
            imprimerTicket();
            Toast.makeText(this, "Tarif 10 imprimé !", Toast.LENGTH_SHORT).show();

        }
        adapter.notifyDataSetChanged();
    }

    private void imprimerTicket() {

        /*LayoutInflater inflater = LayoutInflater.from(SelectionTarifActivity.this); // 1
        View theInflatedView = inflater.inflate(R.layout.ticket, null);
        EditText date = (EditText) findViewById(R.id.date);
        EditText tarif = (EditText) findViewById(R.id.tarif);*/


        PDFAsset pdfAsset4x6 = new PDFAsset("4x6.pdf", true);

        PrintItem printItemDefault = new PDFPrintItem(PrintItem.ScaleType.CENTER, pdfAsset4x6);

        PrintJobData printJobData = new PrintJobData(SelectionTarifActivity.this, printItemDefault);

        printJobData.setJobName("Example");

        PrintUtil.setPrintJobData(printJobData);

        PrintUtil.print(SelectionTarifActivity.this);
    }

    /**
     * permet de retourner à la page de menu et clore les ventes de la journée
     *
     * @param view le button
     */
    public void fermerVente(View view) {

        new AlertDialog.Builder(this)
                .setTitle(R.string.titre_modal_cloture_vente)
                .setMessage(R.string.message_cloture_ventes)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {

                        Intent intent = new Intent(SelectionTarifActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(android.R.string.no, null).show();

    }
}
