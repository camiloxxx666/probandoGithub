package com.pruebaclass1.camilo.pruebaclass1;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class UsuarioActivity extends Activity {

    String valorRecibido;
    private TextView nombre;
    private TextView email;
    private TextView fecha;
    DataBaseTemasManager manager;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        manager = new DataBaseTemasManager(this);
        valorRecibido=getIntent().getStringExtra(MainActivity.ID_PASAR);

        //Toast.makeText(getApplicationContext(), "Has seleccionado: "+ valorRecibido, Toast.LENGTH_LONG).show();

        cursor = manager.traerUsuarioTema(valorRecibido);

        cursor.moveToPosition(0);//Linea vital
        String name = cursor.getString(cursor.getColumnIndex("nombreCreador"));
        String fe = cursor.getString(cursor.getColumnIndex("fechaCreado"));

        nombre = (TextView) findViewById(R.id.textView);
        nombre.setText("Nombre del usuario: "+name);

        fecha = (TextView) findViewById(R.id.textView2);
        fecha.setText("Fecha en que se creó el tema: "+fe);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
