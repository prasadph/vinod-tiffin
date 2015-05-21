package shubham.tfin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shubham on 21/5/15.
 */
public class myDBHelper extends SQLiteOpenHelper{
    private static final String DB_NAME = "fooddb.sqlite";
    private static final String DB_TABLE = "downloaded";
    private static final int DB_VERSION = 1;
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String PRICE = "price";
    private static final String IMG_SRC = "img";

    //SQL stmts
    private static final String CREATE_TABLE = "create table " + DB_TABLE +
            "(" + ID  ;

    public myDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        onCreate(sqLiteDatabase);
    }
}
