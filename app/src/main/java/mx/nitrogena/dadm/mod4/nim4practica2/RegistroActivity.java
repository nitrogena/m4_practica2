package mx.nitrogena.dadm.mod4.nim4practica2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Toolbar tbActionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(tbActionBar);
    }
}
