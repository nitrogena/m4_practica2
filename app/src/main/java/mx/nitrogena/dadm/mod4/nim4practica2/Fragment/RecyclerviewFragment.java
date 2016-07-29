package mx.nitrogena.dadm.mod4.nim4practica2.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.nitrogena.dadm.mod4.nim4practica2.R;

/**
 * Created by Nidia on 23/07/2016.
 */
public class RecyclerviewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        //equivale al setcontent view
        // el layout esta en el objeto vwVista
        View vwVista = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        return vwVista;

    }
}
