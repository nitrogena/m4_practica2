package mx.nitrogena.dadm.mod4.nim4practica2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleActivity extends AppCompatActivity {

    private ImageView ivImgApp;
    private TextView tvNombreApp;
    private TextView tvAutorApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        ivImgApp = (ImageView) findViewById(R.id.adetalle_iv_imgApp);
        tvNombreApp = (TextView) findViewById(R.id.adetalle_tv_nombreApp);
        tvAutorApp = (TextView) findViewById(R.id.adetalle_tv_autorApp);

        //Obteniendo datos de la MainActivity O ADAPTADOR
        Bundle bdlExtras = getIntent().getExtras();
        String strNombreApp = bdlExtras.getString("NombreApp");
        String strDesarrollador = bdlExtras.getString("Desarrollador");
        int intImgApp = bdlExtras.getInt("ImgApp");
        String strCalifica = bdlExtras.getString("Calificacion");
        String strInstalada = bdlExtras.getString("Instalada");

        tvNombreApp.setText(strNombreApp);
        tvAutorApp.setText(strDesarrollador);
        ivImgApp.setImageResource(intImgApp);



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


}
