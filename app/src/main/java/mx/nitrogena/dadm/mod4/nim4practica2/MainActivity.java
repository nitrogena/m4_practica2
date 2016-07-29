package mx.nitrogena.dadm.mod4.nim4practica2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
/*import android.support.v4.widget.SwipeRefreshLayout;*/
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.nitrogena.dadm.mod4.nim4practica2.Adapter.AppAdapter;
import mx.nitrogena.dadm.mod4.nim4practica2.Adapter.ViewpageAdapter;
import mx.nitrogena.dadm.mod4.nim4practica2.Fragment.DetalleFragment;
import mx.nitrogena.dadm.mod4.nim4practica2.Fragment.RecyclerviewFragment;
import mx.nitrogena.dadm.mod4.nim4practica2.Model.AppModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*
    SwipeRefreshLayout srl;
    ListView lvApp;
    Adapter adaptador;*/

    ArrayList<AppModel> arrLstAppMdl;

    private RecyclerView rvListaApp;
    private TextView tvMensaje;

    //VIEWPAGER
    private Toolbar tbActionBar;
    private TabLayout tlTabLayout;
    private ViewPager vpViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //VIEW PAGER
        tbActionBar = (Toolbar) findViewById(R.id.actionBar);
        tlTabLayout = (TabLayout) findViewById(R.id.amain_tl_tablayout);
        vpViewPager = (ViewPager) findViewById(R.id.amain_vp_viewpager);

        if (tbActionBar != null){
            setSupportActionBar(tbActionBar);
        }


        tvMensaje = (TextView) findViewById(R.id.amain_tv_mensaje);

        Toast.makeText(this, getResources().getString(R.string.amain_mensaje_oncreate), Toast.LENGTH_SHORT).show();

        Log.i("onCreate:", "comenzando");

        //metodo que esta mas abajo para el VIEW PAGER
        setUpViewPager();

        /*SE VA AL FRAGMENT RECYCLER VIEW
        //ya es un objeto el rvListaApp
        rvListaApp = (RecyclerView) findViewById(R.id.amain_rv_recyclerV);
        //se le va a mostrar en lista
        LinearLayoutManager llmLayout = new LinearLayoutManager(this);
        llmLayout.setOrientation(LinearLayoutManager.VERTICAL);

        //QUE SE COMPORTE COMO EL OBJETO llmLayout
        rvListaApp.setLayoutManager(llmLayout);

        //Para mostrar en grid
        //GridLayoutManager glmLayout = new GridLayoutManager(this, 2);
        //rvListaApp.setLayoutManager(glmLayout);

        //SE OBTIENEN LOS DATOS PARA EL RECYCLER VIEW
        obtenerDatos();
        inicializarAdaptador();
        */


        /*
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
                final int intImgApp = blnBandera ? R.drawable.ba_1 : R.drawable.sh_sm_img;

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
        */



        /*SE PUEDE HACER UN ARREGLO DESDE ARCHIVO strings.xml
        //Arreglo que se obtiene del archivo strings.xml
        //Para rellenar la lista
        String[] arrApp = getResources().getStringArray(R.array.apps);
        //en el adaptador se coloca el contexto, un tipo de layout, los datos
        lvApp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrApp));

*/
        //Objeto ya referenciado, ya existe en la memoria, por lo que no se necesita instanciarlo
        /*
        srl = (SwipeRefreshLayout) findViewById(R.id.amain_srl);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
            refrescarContenido(arrLstNomApp);
        }
        });
        */

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

    //METODOS PARA EL RECYCLER VIEW FRAGMENT
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> arrLstFrag = new ArrayList<>();
        arrLstFrag.add(new RecyclerviewFragment());
        arrLstFrag.add(new DetalleFragment());
        return arrLstFrag;
    }
    private void setUpViewPager(){
        vpViewPager.setAdapter(new ViewpageAdapter(getSupportFragmentManager(), agregarFragments()));
        tlTabLayout.setupWithViewPager(vpViewPager);
        tlTabLayout.getTabAt(0).setIcon(R.drawable.ic_content_add_circle);
        tlTabLayout.getTabAt(1).setIcon(R.drawable.ic_content_add_circle);
    }

    //METODOS PARA EL MENU DE OPCIONES
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mopciones_registrar:
                Intent intent = new Intent(this, RegistroActivity.class);
                startActivity(intent);
                break;
            case R.id.mopciones_refresh:
                Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //MENU DE CONTEXTO
    /*
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto_amain, menu);

    }
    */


    /*
    public void refrescarContenido(ArrayList<String> arrLstNomApp){
        //se puede enviar otra lista, o datos de webservice
        //String[] arrApp = getResources().getStringArray(R.array.apps);
        //lvApp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrApp));

        lvApp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrLstNomApp));
        srl.setRefreshing(false);
    }
    */

    @Override
    public void onClick(View vwVista) {
        switch (vwVista.getId()) {
            case R.id.amain_btn_registrar:
                irRegistrarApp(vwVista);
                break;
        }
    }

    /*LO PUSE EN RECYCLER VIEW FRAGMENT
    public void inicializarAdaptador(){
        //instanciar el objeto de appAdaptador
        if (arrLstAppMdl.size() != 0) {
            //SE MANDAN LOS DATOS Y EL CONTEXTO
            AppAdapter adapter = new AppAdapter(arrLstAppMdl, this);
            rvListaApp.setAdapter(adapter); //el recycler view tiene el adaptador
            tvMensaje.setText("");
        }
        else{
            tvMensaje.setText(getResources().getString(R.string.amain_msj_sinApp));
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
    */

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
