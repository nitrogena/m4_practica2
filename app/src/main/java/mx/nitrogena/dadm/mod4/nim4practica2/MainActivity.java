package mx.nitrogena.dadm.mod4.nim4practica2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.nitrogena.dadm.mod4.nim4practica2.Model.AppModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SwipeRefreshLayout srl;
    ListView lvApp;
    Adapter adaptador;

    ArrayList<AppModel> arrLstAppMdl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, getResources().getString(R.string.amain_mensaje_oncreate), Toast.LENGTH_SHORT).show();

        Log.i("hola", "clic en algun lugar");


        arrLstAppMdl = new ArrayList<AppModel>();
        arrLstAppMdl.add(new AppModel("App abc def", "Nidia Orduña", intImgApp, dblCalifica));
        arrLstAppMdl.add(new AppModel("App ghi jkl", "Angelina Ochoa", intImgApp, dblCalifica));
        arrLstAppMdl.add(new AppModel("App mnñ opq", "Irma Ocaña", intImgApp, dblCalifica));
        arrLstAppMdl.add(new AppModel("App rst uvw", "Doris Olvera", intImgApp, dblCalifica));


        //boolean blnBandera = !(arrLstAppMdl.size()%2 == 0);
        //final String strImgApp = blnBandera ? R.drawable.ic_action_extension : R.drawable.ic_notification_adb;

        final ArrayList<String> arrLstNomApp = new ArrayList<>();
        for (AppModel regApp : arrLstAppMdl){
            arrLstNomApp.add(regApp.getStrNombreApp());
        }




        //Nos devuelve un VIEW, y debemos hacer el cast
        lvApp = (ListView) findViewById(R.id.amain_lv_app);

        lvApp.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrLstNomApp));
        lvApp.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                boolean blnBandera = !(i%2 == 0);
                final int intImgApp = blnBandera ? R.drawable.ic_content_add : R.drawable.ic_content_add_circle;

                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("NombreApp", arrLstAppMdl.get(i).getStrNombreApp());
                intent.putExtra("Desarrollador", arrLstAppMdl.get(i).getStrDesarrollador());
                intent.putExtra("ImgApp", intImgApp);
                //se pueden enviar arreglos de strings
                startActivity(intent);
                //PARA TENER SOLO UNA ACTIVIDAD EN EL STACK
                finish();
            }
        });




        /*SE PUEDE HACER UN ARREGLO DESDE ARCHIVO strings.xml
        //Arreglo que se obtiene del archivo strings.xml
        //Para rellenar la lista
        String[] arrApp = getResources().getStringArray(R.array.apps);
        //en el adaptador se coloca el contexto, un tipo de layout, los datos
        lvApp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrApp));

*/
        //Objeto ya referenciado, ya existe en la memoria, por lo que no se necesita instanciarlo
        srl = (SwipeRefreshLayout) findViewById(R.id.amain_srl);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
            refrescarContenido(arrLstNomApp);
        }
        });

        /*
        FloatingActionButton fabRegistrar = (FloatingActionButton) findViewById(R.id.amain_btn_registrar);
        fabRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        */
        findViewById(R.id.amain_btn_registrar).setOnClickListener(this);

    }

    public void refrescarContenido(ArrayList<String> arrLstNomApp){
        //se puede enviar otra lista, o datos de webservice
        //String[] arrApp = getResources().getStringArray(R.array.apps);
        //lvApp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrApp));

        lvApp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrLstNomApp));
        srl.setRefreshing(false);
    }

    @Override
    public void onClick(View vwVista) {
        switch (vwVista.getId()) {
            case R.id.amain_btn_registrar:
                irRegistrarApp(vwVista);
                break;
        }
    }

    public void irRegistrarApp(View vwVista){
        //Toast.makeText(this, "Registrando", Toast.LENGTH_SHORT).show();
        Snackbar.make(vwVista, getResources().getString(R.string.amain_mensajeSnack), Snackbar.LENGTH_SHORT)
                .setAction(getResources().getString(R.string.amain_mensajeAccionSnack), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i("SNACKBAR", "Click en snackbar");
                    }
                })
                .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                .show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, getResources().getString(R.string.amain_mensaje_onstart), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, getResources().getString(R.string.amain_mensaje_onresume), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,getResources().getString(R.string.amain_mensaje_onpause), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, getResources().getString(R.string.amain_mensaje_onrestart), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, getResources().getString(R.string.amain_mensaje_onstop), Toast.LENGTH_SHORT).show();

        //Cuando se aprieta el boton de home, la actividad pasa a onPause y onStop, no es destruida,
        //y si se regresa  a ella entonces comienza con el onRestart, onStart, onResume, ya no se crea

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,getResources().getString(R.string.amain_mensaje_ondestroy), Toast.LENGTH_SHORT).show();

        //Cuando le damos back la aplicacion se va onPause, onStop y es destruida
        //lo mismo pasa cuando se cambia la orientacion del telefono
        //esto es importante para los formularios,porque se borrara la informacion

    }


}
