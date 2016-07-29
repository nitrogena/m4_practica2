package mx.nitrogena.dadm.mod4.nim4practica2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private String strNombreApp;
    private String strDesarrollador;
    private int intImgApp;
    private String strCalifica;
    private String strInstalada;

    private String strDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Toolbar tbActionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(tbActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.aregistro_btn_registrar).setOnClickListener(this);
    }


    public void onClick(View vwVista) {
        switch (vwVista.getId()) {
            case R.id.aregistro_btn_registrar:
                generarArchivo(vwVista);
                break;
        }
    }

    public void generarArchivo(View vwVista){
        try{
            EditText etNombreApp = (EditText) findViewById(R.id.aregistro_et_aplicacion);
            strNombreApp = etNombreApp.getText().toString();

            EditText etAutor = (EditText) findViewById(R.id.aregistro_et_autor);
            strDesarrollador = etAutor.getText().toString();

            EditText etDetalle = (EditText) findViewById(R.id.aregistro_et_detalle);
            strDetalle = etDetalle.getText().toString();

            final CheckBox checkBox = (CheckBox) findViewById(R.id.aregistro_cb_actualizada);
            if (checkBox.isChecked()) {
                checkBox.setChecked(false);
            }


            FileOutputStream fosFileOs = null;
            //CON PRIVATE SOLO SE CREA Y SUSTITUYE, NO AÑADE NADA, PERO CON APPEND SI
            fosFileOs = openFileOutput("fosFile.txt", Context.MODE_APPEND);
            //lo escribe de forma más rápida
            fosFileOs.write(strNombreApp.getBytes());
            fosFileOs.close();
            Toast.makeText(this, "el archivo se ha creado", Toast.LENGTH_SHORT).show();

            etNombreApp.setText("");
            etAutor.setText("");
            etDetalle.setText("");

        }catch (Exception exception){
            //NOS INDICA QUE PASO
            exception.printStackTrace();
            //Damos mensaje a los usuarios
            Toast.makeText(this, "No se creo el archivo", Toast.LENGTH_SHORT).show();

        }


    }


}
