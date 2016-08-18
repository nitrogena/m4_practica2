package mx.nitrogena.dadm.mod4.nim4practica2.Model;

import android.content.Context;

import java.util.ArrayList;

import mx.nitrogena.dadm.mod4.nim4practica2.R;

/**
 * Created by Nidia on 03/08/2016.
 */
public class ConstructorApp {

    private Context contexto;

    public ConstructorApp(Context contexto){
        this.contexto = contexto;

        //SIEMPRE LOS DATOS DEBEN DE VENIR EN UN ARRAYLIST

    }

    public ArrayList<AppModel>  obtenerDatosBD(){

        ArrayList<AppModel> arrLstAppMdl = new ArrayList<>();

        arrLstAppMdl.add(new AppModel("App abc def", "Nidia Orduña", R.drawable.ba_1, "4.6", "si", 5));
        arrLstAppMdl.add(new AppModel("App ghi jkl", "Angelina Ochoa", R.drawable.sh_sm_img, "5.6", "si", 3));
        arrLstAppMdl.add(new AppModel("App mnñ opq", "Irma Ocaña", R.drawable.ba_1, "8.6", "no", 2));
        arrLstAppMdl.add(new AppModel("App rst uvw", "Doris Olvera", R.drawable.sh_sm_img, "2.6", "no", 3));
        arrLstAppMdl.add(new AppModel("App nueva uno", "Bertha Ozuna", R.drawable.ba_1, "9.6", "si", 6));
        arrLstAppMdl.add(new AppModel("App nueva dos", "Cecilia Ortega", R.drawable.sh_sm_img, "6.6", "si", 5));

        return arrLstAppMdl;

    }
}
