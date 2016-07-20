package mx.nitrogena.dadm.mod4.nim4practica2.Model;

/**
 * Created by Nidia on 19/07/2016.
 */
public class AppModel {
    public String strNombreApp;
    public String strDesarrollador;

    public AppModel(String strNombreApp, String strDesarrollador) {
        this.strNombreApp = strNombreApp;
        this.strDesarrollador = strDesarrollador;
    }

    public String getStrNombreApp() {
        return strNombreApp;
    }

    public void setStrNombreApp(String strNombreApp) {
        this.strNombreApp = strNombreApp;
    }

    public String getStrDesarrollador() {
        return strDesarrollador;
    }

    public void setStrDesarrollador(String strDesarrollador) {
        this.strDesarrollador = strDesarrollador;
    }
}
