package mx.nitrogena.dadm.mod4.nim4practica2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
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
        findViewById(R.id.aregistro_btn_mostrar).setOnClickListener(this);
    }


    public void onClick(View vwVista) {
        switch (vwVista.getId()) {
            case R.id.aregistro_btn_registrar:
                //generarArchivo(vwVista);
                guardarPreferencia(vwVista);
                break;
            case R.id.aregistro_btn_mostrar:
                mostrarPreferencias(vwVista);
                break;
        }
    }

    public void guardarPreferencia(View vwVista){
        //SE INICIALIZA, SE DA EL NOMBRE DEL ARCHIVO XML QUE TENDRA LAS PREFERENCIAS
        //PRIVADO: SOBREESCRIBE
        SharedPreferences spSharedP = getSharedPreferences("fxmlAplicaciones", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = spSharedP.edit();

        EditText etNombreApp = (EditText) findViewById(R.id.aregistro_et_aplicacion);
        strNombreApp = etNombreApp.getText().toString();

        EditText etAutor = (EditText) findViewById(R.id.aregistro_et_autor);
        strDesarrollador = etAutor.getText().toString();

        EditText etDetalle = (EditText) findViewById(R.id.aregistro_et_detalle);
        strDetalle = etDetalle.getText().toString();

        editor.putString("aplicacion", strNombreApp);
        editor.putString("desarrollador", strDesarrollador);
        editor.putString("detalle", strDetalle);
        editor.commit();

        Toast.makeText(this, "la preferencia se ha creado", Toast.LENGTH_SHORT).show();

        etNombreApp.setText("");
        etAutor.setText("");
        etDetalle.setText("");
    }

    public void mostrarPreferencias(View vwVista){
        SharedPreferences spSharedP =  getSharedPreferences("fxmlAplicaciones", Context.MODE_PRIVATE);
        //el 2do parametro es lo que se va a mostrar si no existe la clave "aplicacion"
        strNombreApp = spSharedP.getString("aplicacion", "no existe el nombre de la aplicacion");
        strDesarrollador = spSharedP.getString("desarrollador", "no existe desarrollador");
        strDetalle = spSharedP.getString("detalle", "no existe detalle");

        TextView tvDatos = (TextView) findViewById(R.id.aregistro_tv_datos);
        String resultado = "\nNombre App: " + strNombreApp + "\nDesarrollador: " + strDesarrollador;
        tvDatos.setText(resultado);


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
