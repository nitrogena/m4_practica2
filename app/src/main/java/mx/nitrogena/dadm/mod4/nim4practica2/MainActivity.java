package mx.nitrogena.dadm.mod4.nim4practica2;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SwipeRefreshLayout srl;
    ListView lvApp;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, getResources().getString(R.string.amain_mensaje_oncreate), Toast.LENGTH_SHORT).show();

        Log.i("hola", "clic en algun lugar");



        lvApp = (ListView) findViewById(R.id.amain_lv_app);
        String[] arrApp = getResources().getStringArray(R.array.apps);
        lvApp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrApp));

        srl = (SwipeRefreshLayout) findViewById(R.id.amain_srl);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescarContenido();
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

    public void refrescarContenido(){
        String[] arrApp = getResources().getStringArray(R.array.apps);
        lvApp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrApp));
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,getResources().getString(R.string.amain_mensaje_ondestroy), Toast.LENGTH_SHORT).show();
    }


}
