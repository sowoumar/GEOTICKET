package geoticket.com.geoticket;

/**
 * Created by oumar on 22/06/17.
 */


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseSQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_VENTES = "ventes";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TICKET = "ticket";

    private static final String DATABASE_NAME = "ventes.db";
    private static final int DATABASE_VERSION = 1;

    // Commande sql pour la création de la base de données
    private static final String DATABASE_CREATE = "create table "
            + TABLE_VENTES + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_TICKET
            + " text not null);";

    public DatabaseSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseSQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VENTES);
        onCreate(db);
    }
}