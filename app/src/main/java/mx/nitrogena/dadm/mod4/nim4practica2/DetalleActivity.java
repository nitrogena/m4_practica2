package mx.nitrogena.dadm.mod4.nim4practica2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class DetalleActivity extends AppCompatActivity {

    private ImageView ivImgApp;
    private TextView tvNombreApp;
    private TextView tvAutorApp;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        ivImgApp = (ImageView) findViewById(R.id.adetalle_iv_imgApp);
        tvNombreApp = (TextView) findViewById(R.id.adetalle_tv_nombreApp);
        tvAutorApp = (TextView) findViewById(R.id.adetalle_tv_autorApp);

        //Obteniendo datos de la MainActivity
        Bundle bdlExtras = getIntent().getExtras();
        String strNombreApp = bdlExtras.getString("NombreApp");
        String strDesarrollador = bdlExtras.getString("Desarrollador");
        int intImgApp = bdlExtras.getInt("ImgApp");

        tvNombreApp.setText(strNombreApp);
        tvAutorApp.setText(strDesarrollador);
        ivImgApp.setImageResource(intImgApp);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intentKC = new Intent(DetalleActivity.this, MainActivity.class);
            //AL HACER CLIC EN BOTON REGRESAR SE VUELVA A CREAR MAINACTIVITY, LA CUAL YA TIENE UN FINISH
            //Y EVITAR QUE SE HAGA LENTO EL DISPOSITIVO
            startActivity(intentKC);

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Detalle Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://mx.nitrogena.dadm.mod4.nim4practica2/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Detalle Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://mx.nitrogena.dadm.mod4.nim4practica2/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
