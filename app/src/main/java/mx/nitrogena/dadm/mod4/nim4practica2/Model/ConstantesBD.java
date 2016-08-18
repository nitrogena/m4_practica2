package mx.nitrogena.dadm.mod4.nim4practica2.Model;

/**
 * Created by Nidia on 03/08/2016.
 */
public final class ConstantesBD{

    public static final String DATABASE_NAME = "aplicaciones";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_APPS = "aplicacion";
    public static final String TABLE_APPS_ID = "id";
    public static final String TABLE_APPS_NAME = "nombre";
    public static final String TABLE_APPS_DEVELOPER = "desarrollador";
    public static final String TABLE_APPS_DESCRPTION = "descripcion";
    public static final String TABLE_APPS_INSTALLED = "instalada";

    public static final String TABLE_LIKE = "like";
    public static final String TABLE_LIKE_ID = "id";
    public static final String TABLE_LIKE_CUENTA = "likes";
    public static final String TABLE_LIKE_APPS_ID = "aplicacion_id";

}
