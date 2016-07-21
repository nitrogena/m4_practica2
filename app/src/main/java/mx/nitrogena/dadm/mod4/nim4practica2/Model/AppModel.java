package mx.nitrogena.dadm.mod4.nim4practica2.Model;

/**
 * Created by Nidia on 19/07/2016.
 */
public class AppModel {
    private String strNombreApp;
    private String strDesarrollador;
    private int intImgApp;
    private double dblCalifica;


    public AppModel(String strNombreApp, String strDesarrollador, int intImgApp, double dblCalifica) {
        this.strNombreApp = strNombreApp;
        this.strDesarrollador = strDesarrollador;
        this.intImgApp = intImgApp;
        this.dblCalifica = dblCalifica;
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

    public double getDblCalifica() {
        return dblCalifica;
    }

    public void setDblCalifica(double dblCalifica) {
        this.dblCalifica = dblCalifica;
    }
}
