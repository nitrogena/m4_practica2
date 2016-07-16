package mx.nitrogena.dadm.mod4.nim4practica2;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout srl;
    ListView lvApp;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("hola", "clic en algun lugar");

        srl = (SwipeRefreshLayout) findViewById(R.id.amain_srl);

        lvApp = (ListView) findViewById(R.id.amain_lv_app);
        String[] arrApp = getResources().getStringArray(R.array.apps);
        lvApp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrApp));

        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrescarContenido();
            }
        });

    }

    public void refrescarContenido(){
        String[] arrApp = getResources().getStringArray(R.array.apps);
        lvApp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrApp));
        srl.setRefreshing(false);
    }
}
