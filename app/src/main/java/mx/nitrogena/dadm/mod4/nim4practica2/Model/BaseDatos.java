package mx.nitrogena.dadm.mod4.nim4practica2.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nidia on 03/08/2016.
 */
public class BaseDatos extends SQLiteOpenHelper{
    private Context contexto;
    // String name, SQLiteDatabase.CursorFactory factory, int version
    public BaseDatos(Context contexto) {
        //SE CREA O ABRE LA BASE DE DATOS
        super(contexto, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.contexto = contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCrearTablaApps = "CREATE TABLE " + ConstantesBD.TABLE_APPS + "(" +
                ConstantesBD.TABLE_APPS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT " +
                ConstantesBD.TABLE_APPS_NAME + " TEXT, " +
                        ConstantesBD.TABLE_APPS_DEVELOPER + " TEXT, " +
                        ConstantesBD.TABLE_APPS_DESCRPTION + " TEXT " +
                        ConstantesBD.TABLE_APPS_INSTALLED + "INTEGER" +

                ")";

        String queryCrearTablaLikes = "CREATE TABLE " + ConstantesBD.TABLE_LIKE + "(" +
                ConstantesBD.TABLE_LIKE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT" +
                ConstantesBD.TABLE_LIKE_APPS_ID + " INTEGER " +
                ConstantesBD.TABLE_LIKE_CUENTA + " INTEGER " +
                "FOREIGN KEY (" + ConstantesBD.TABLE_LIKE_APPS_ID + ")" +
                "REFERENCES " + ConstantesBD.TABLE_APPS + "(" + ConstantesBD.TABLE_APPS_ID + ")" +
            ")";

        sqLiteDatabase.execSQL(queryCrearTablaApps);
        sqLiteDatabase.execSQL((queryCrearTablaLikes));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
