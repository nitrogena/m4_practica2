package mx.nitrogena.dadm.mod4.nim4practica2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Bundle bdlExtras = getIntent().getExtras();
        String strNombreApp = bdlExtras.getString("NombreApp");
        String strDesarrollador = bdlExtras.getString("Desarrollador");


    }
}