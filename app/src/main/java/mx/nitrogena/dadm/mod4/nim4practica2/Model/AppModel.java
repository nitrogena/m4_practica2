package mx.nitrogena.dadm.mod4.nim4practica2.Model;

/**
 * Created by Nidia on 19/07/2016.
 */
public class AppModel {
    private String strNombreApp;
    private String strDesarrollador;
    private int intImgApp;
    private String strCalifica;
    private String strInstalada;


    public AppModel(String strNombreApp, String strDesarrollador, int intImgApp, String strCalifica, String strInstalada) {
        this.strNombreApp = strNombreApp;
        this.strDesarrollador = strDesarrollador;
        this.intImgApp = intImgApp;
        this.strCalifica = strCalifica;
        this.strInstalada = strInstalada;
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



    public int getIntImgApp() {
        return intImgApp;
    }

    public void setIntImgApp(int intImgApp) {
        this.intImgApp = intImgApp;
    }


    public String getStrInstalada() {
        return strInstalada;
    }

    public void setStrInstalada(String strInstalada) {
        this.strInstalada = strInstalada;
    }

    public String getStrCalifica() {
        return strCalifica;
    }

    public void setStrCalifica(String strCalifica) {
        this.strCalifica = strCalifica;
    }
}
