package mx.nitrogena.dadm.mod4.nim4practica2.Model;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
                ConstantesBD.TABLE_APPS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_APPS_NAME + " TEXT, " +
                        ConstantesBD.TABLE_APPS_DEVELOPER + " TEXT, " +
                        ConstantesBD.TABLE_APPS_DESCRPTION + " TEXT, " +
                        ConstantesBD.TABLE_APPS_INSTALLED + "INTEGER" +

                ")";

        String queryCrearTablaLikes = "CREATE TABLE " + ConstantesBD.TABLE_LIKE + "(" +
                ConstantesBD.TABLE_LIKE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_LIKE_APPS_ID + " INTEGER, " +
                ConstantesBD.TABLE_LIKE_CUENTA + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBD.TABLE_LIKE_APPS_ID + ")" +
                "REFERENCES " + ConstantesBD.TABLE_APPS + "(" + ConstantesBD.TABLE_APPS_ID + ")" +
            ")";

        sqLiteDatabase.execSQL(queryCrearTablaApps);
        sqLiteDatabase.execSQL((queryCrearTablaLikes));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TABLE_APPS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TABLE_LIKE);
        onCreate(sqLiteDatabase);


    }

    public ArrayList<AppModel> obtenerTodasApp(){
        ArrayList<AppModel> arrLstApp = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_APPS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            AppModel appActual = new AppModel(registros.getString(1), registros.getString(2), 0,"1",
                    registros.getString(4), 1);


           // String strNombreApp, String strDesarrollador, int intImgApp, String strCalifica, String strInstalada, int intLike

            appActual.setIntId(registros.getInt(0));
            appActual.setStrNombreApp(registros.getString(1));
            appActual.setStrDesarrollador(registros.getString(2));
            appActual.setStrInstalada(registros.getString(4));

            arrLstApp.add(appActual);

        }
        db.close();
        return arrLstApp;
    }

    public void insertarApp(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_APPS, null, contentValues);
        db.close();
    }
}
