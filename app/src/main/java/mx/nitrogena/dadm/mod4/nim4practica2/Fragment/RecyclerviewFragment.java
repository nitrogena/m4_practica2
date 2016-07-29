package mx.nitrogena.dadm.mod4.nim4practica2.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.nitrogena.dadm.mod4.nim4practica2.Adapter.AppAdapter;
import mx.nitrogena.dadm.mod4.nim4practica2.Model.AppModel;
import mx.nitrogena.dadm.mod4.nim4practica2.R;

/**
 * Created by Nidia on 23/07/2016.
 */
public class RecyclerviewFragment extends Fragment {

    ArrayList<AppModel> arrLstAppMdl;

    private RecyclerView rvListaApp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        //equivale al setcontent view
        // el layout esta en el objeto vwVista
        View vwVista = inflater.inflate(R.layout.fragment_recyclerview, container, false);



        //ya es un objeto el rvListaApp
        rvListaApp = (RecyclerView) vwVista.findViewById(R.id.amain_rv_recyclerV);
        //se le va a mostrar en lista
        LinearLayoutManager llmLayout = new LinearLayoutManager(getActivity());
        llmLayout.setOrientation(LinearLayoutManager.VERTICAL);

        //QUE SE COMPORTE COMO EL OBJETO llmLayout
        rvListaApp.setLayoutManager(llmLayout);

        //Para mostrar en grid
        //GridLayoutManager glmLayout = new GridLayoutManager(this, 2);
        //rvListaApp.setLayoutManager(glmLayout);

        //SE OBTIENEN LOS DATOS PARA EL RECYCLER VIEW
        obtenerDatos();
        inicializarAdaptador();


        return vwVista;

    }

    public void inicializarAdaptador(){
        //instanciar el objeto de appAdaptador
        if (arrLstAppMdl.size() != 0) {
            //SE MANDAN LOS DATOS Y EL CONTEXTO
            AppAdapter adapter = new AppAdapter(arrLstAppMdl, getActivity());
            rvListaApp.setAdapter(adapter); //el recycler view tiene el adaptador
            //tvMensaje.setText("");
        }
        else{
            //tvMensaje.setText(getResources().getString(R.string.amain_msj_sinApp));
        }
    }

    public void obtenerDatos(){

        arrLstAppMdl = new ArrayList<AppModel>();

        arrLstAppMdl.add(new AppModel("App abc def", "Nidia Orduña", R.drawable.ba_1, "4.6", "si"));
        arrLstAppMdl.add(new AppModel("App ghi jkl", "Angelina Ochoa", R.drawable.sh_sm_img, "5.6", "si"));
        arrLstAppMdl.add(new AppModel("App mnñ opq", "Irma Ocaña", R.drawable.ba_1, "8.6", "no"));
        arrLstAppMdl.add(new AppModel("App rst uvw", "Doris Olvera", R.drawable.sh_sm_img, "2.6", "no"));
        arrLstAppMdl.add(new AppModel("App nueva uno", "Bertha Ozuna", R.drawable.ba_1, "9.6", "si"));
        arrLstAppMdl.add(new AppModel("App nueva dos", "Cecilia Ortega", R.drawable.sh_sm_img, "6.6", "si"));

    }
}
