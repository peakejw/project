package e.wyattpeake.synonym;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wyattpeake on 4/2/18.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "synonym.db";
    private static final String TABLE_SYNONYM = "synonym";
    private static final String COLUMN_ID = "id";
    private static final String COLLUMN_WORD1 = "word1";
    private static final String COLLUMN_WORD2 = "word2";
    SQLiteDatabase db;

    public static final String Table_Create = "create table "+ TABLE_SYNONYM + " (id integer primary key autoincrement, " +
            "word1 text not null, word2 text not null)";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Table_Create);
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "drop table if EXISTS " + TABLE_SYNONYM;
        db.execSQL(query);
        this.onCreate(db);


    }

    public void insertContact(Words c) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(COLLUMN_WORD1, c.getWord1());
        values.put(COLLUMN_WORD2, c.getWord2());

        db.insert(TABLE_SYNONYM, null, values);
        db.close();


    }

    public String search(String word) {
        db = this.getReadableDatabase();
        //String query = "select word1 from" + TABLE_SYNONYM;
        Cursor cursor = db.rawQuery("select * from "+ TABLE_SYNONYM, null);
        String a;
        String b = "not found";

        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(1);
                if (a.equals(word)) {
                    b = cursor.getString(2);
                    break;
                }

            } while (cursor.moveToNext());
        }
        return b;


    }

}
