package mx.nitrogena.dadm.mod4.nim4practica2.presenter;

import android.content.Context;

import java.util.ArrayList;

import mx.nitrogena.dadm.mod4.nim4practica2.Fragment.InterfaceRecyclerVFragmentV;
import mx.nitrogena.dadm.mod4.nim4practica2.Model.AppModel;
import mx.nitrogena.dadm.mod4.nim4practica2.Model.ConstructorApp;

/**
 * Created by Nidia on 03/08/2016.
 */
public class RecyclerVFragmentPresenter implements InterfaceRecyclerVFragmentPresenter{

    //PRESENTADOR FUNGE COMO INTERMEDIARO ENTRE TODAS LAS ACCIONES DE LA VISTA Y
    // DE TODAS LAS ACCONES DE BD, MANTIENE CAPA DE DATOS AISLADA DE LA VISTA, COMO NOTIFICADOR


    //private InterfaceRecyclerVFragmentPresenter interfRecycVFragPresenter;
    private InterfaceRecyclerVFragmentV interfaceRecyclerVFragmentV;
    private Context contexto;
    private ConstructorApp constructorApp;
    private ArrayList<AppModel> arrLstAppMdl;

    //constructor
    public RecyclerVFragmentPresenter(InterfaceRecyclerVFragmentV interfaceRecyclerVFragmentV, Context contexto){
        this.interfaceRecyclerVFragmentV = interfaceRecyclerVFragmentV;
        this.contexto = contexto;
        obtenerAppBD();
    }


    @Override
    public void obtenerAppBD() {
        //NECESITO ANTES EL MDDELO DE BD

        //SEPARAMOS LA FUENTE DE DATOS CON LA PRESENTACION DE DATOS
        constructorApp = new ConstructorApp(contexto);
        arrLstAppMdl = constructorApp.obtenerDatosBD();
        mostrarAppRV();


    }

    @Override
    public void mostrarAppRV() {
        interfaceRecyclerVFragmentV.inicializarAdaptadorRV(interfaceRecyclerVFragmentV.crearAdaptador(arrLstAppMdl));
        interfaceRecyclerVFragmentV.generarLayoutLV();

    }
}
