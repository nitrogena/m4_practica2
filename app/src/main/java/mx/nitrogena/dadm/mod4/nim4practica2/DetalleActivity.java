package mx.nitrogena.dadm.mod4.nim4practica2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivImgApp;
    private TextView tvNombreApp;
    private TextView tvAutorApp;

    private ImageButton btnLike;
    private String strCalifica;

    private TextView tvIntLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Toolbar tbActionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(tbActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ivImgApp = (ImageView) findViewById(R.id.adetalle_iv_imgApp);
        tvNombreApp = (TextView) findViewById(R.id.adetalle_tv_nombreApp);
        tvAutorApp = (TextView) findViewById(R.id.adetalle_tv_autorApp);

        btnLike = (ImageButton) findViewById(R.id.adetalle_btn_like);

        //PARA LA VISTA PRESENTADO Y EL SQLITE
        tvIntLike = (TextView) findViewById(R.id.adetalle_tv_numLike);


        //Obteniendo datos de la MainActivity O ADAPTADOR
        Bundle bdlExtras = getIntent().getExtras();
        String strNombreApp = bdlExtras.getString("NombreApp");
        String strDesarrollador = bdlExtras.getString("Desarrollador");
        int intImgApp = bdlExtras.getInt("ImgApp");
        strCalifica = bdlExtras.getString("Calificacion");
        String strInstalada = bdlExtras.getString("Instalada");

        int intLike = bdlExtras.getInt("Like");

        tvNombreApp.setText(strNombreApp);
        tvAutorApp.setText(strDesarrollador);
        ivImgApp.setImageResource(intImgApp);

        tvIntLike.setText(String.valueOf(intLike) + " likes");

        btnLike.setOnClickListener(this);

        //LA IMAGEN TENDRA EL MENU DE CONTEXTO
        registerForContextMenu(ivImgApp);

    }

    public void telefonear(View view) {
        String strTel = "55555555";
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //SE DEBE COLOCAR EL PERMISO EN EL MANIFEST.XML
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + strTel)));
    }

    public void enviarCorreo(View view) {
        String correoE = "alguien@gmail.com";
        Log.i("email", correoE);
        Intent intentCorreo = new Intent(Intent.ACTION_SEND);
        intentCorreo.setData(Uri.parse("mailto:"));
        //SE PUEDE USAR EL EXTRA_TEXT, EXTRA_CC Y OTRAS
        intentCorreo.putExtra(Intent.EXTRA_EMAIL, correoE);
        //que el choser sean todas las aplicaciones del email disponibles
        intentCorreo.setType("message/rfc822");
        startActivity(Intent.createChooser(intentCorreo, "Correo electrónico"));

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //SE USA PORQUE PUSIMOS UN FINISH, EN EL ADAPTADOR O ACTIVIDAD
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intentKC = new Intent(DetalleActivity.this, MainActivity.class);
            //AL HACER CLIC EN BOTON REGRESAR SE VUELVA A CREAR MAINACTIVITY, LA CUAL YA TIENE UN FINISH
            //Y EVITAR QUE SE HAGA LENTO EL DISPOSITIVO
            startActivity(intentKC);
        }
        return super.onKeyDown(keyCode, event);
    }

    //BOTON LIKE
    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Tiene calificacion de: "+strCalifica, Toast.LENGTH_SHORT).show();
    }

    //METODOS PARA EL MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opc_detalle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mopciones_editar:
                Intent intent = new Intent(this, RegistroActivity.class);
                startActivity(intent);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    //MENU CONTEXTO
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_contexto_amain, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mcontexto_detalle_editar:
                Toast.makeText(this, R.string.mopcion_adetalle_editar, Toast.LENGTH_SHORT).show();
                break;
            case R.id.mcontexto_detalle_eliminar:
                Toast.makeText(this, R.string.mcontexto_adetalle_eliminar, Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }
}
