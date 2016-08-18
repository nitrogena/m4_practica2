package mx.nitrogena.dadm.mod4.nim4practica2.Fragment;

import java.util.ArrayList;

import mx.nitrogena.dadm.mod4.nim4practica2.Adapter.AppAdapter;
import mx.nitrogena.dadm.mod4.nim4practica2.Model.AppModel;

/**
 * Created by Nidia on 01/08/2016.
 */
public interface InterfaceRecyclerVFragmentV {

    //INTERACCIONES DIRECTAS CON LA INTERFAZ DE USUARIO

    //Generar liinear layout vertical
    public void generarLayoutLV ();

    public AppAdapter  crearAdaptador(ArrayList<AppModel> arrLstAppMdl);

    public void inicializarAdaptadorRV(AppAdapter adaptador);


}
