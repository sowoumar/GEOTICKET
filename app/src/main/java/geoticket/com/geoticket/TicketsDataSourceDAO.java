package geoticket.com.geoticket;

/**
 * Created by oumar on 22/06/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TicketsDataSourceDAO {

    // Champs de la base de données
    private SQLiteDatabase database;
    private DatabaseSQLiteHelper dbHelper;
    private String[] allColumns = {DatabaseSQLiteHelper.COLUMN_ID,
            DatabaseSQLiteHelper.COLUMN_TICKET,DatabaseSQLiteHelper.COLUMN_PRIX};

    public TicketsDataSourceDAO(Context context) {
        dbHelper = new DatabaseSQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Ticket createTicket(String ticket) {
        ContentValues values = new ContentValues();
        values.put(DatabaseSQLiteHelper.COLUMN_TICKET, ticket);
        values.put(DatabaseSQLiteHelper.COLUMN_PRIX, "TARIF 1");
        long insertId = database.insert(DatabaseSQLiteHelper.TABLE_VENTES, null,
                values);
        Cursor cursor = database.query(DatabaseSQLiteHelper.TABLE_VENTES,
                allColumns, DatabaseSQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        Ticket newTicket = cursorToTicket(cursor);
        cursor.close();
        return newTicket;
    }

    public void deleteTicket(Ticket ticket) {
        long id = ticket.getId();
        System.out.println("Ticket deleted with id: " + id);
        database.delete(DatabaseSQLiteHelper.TABLE_VENTES, DatabaseSQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Ticket> getAllTickets() {
        List<Ticket> tickets = new ArrayList<Ticket>();

        Cursor cursor = database.query(DatabaseSQLiteHelper.TABLE_VENTES,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Ticket ticket = cursorToTicket(cursor);
            tickets.add(ticket);
            cursor.moveToNext();
        }
        // assurez-vous de la fermeture du curseur
        cursor.close();
        return tickets;
    }

    private Ticket cursorToTicket(Cursor cursor) {
        Ticket ticket = new Ticket();
        ticket.setId(cursor.getLong(0));
        ticket.setTicket(cursor.getString(1));
        ticket.setPrix(cursor.getString(2));
        return ticket;
    }
}