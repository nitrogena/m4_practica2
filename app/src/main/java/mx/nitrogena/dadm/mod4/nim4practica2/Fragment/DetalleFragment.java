package mx.nitrogena.dadm.mod4.nim4practica2.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.nitrogena.dadm.mod4.nim4practica2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment {


    public DetalleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }

}
