package com.pruebaclass1.camilo.pruebaclass1;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class UsuarioRespuestaActivity extends Activity {

    String valorRecibido;
    private TextView nombre;
    private TextView fecha;
    DataBaseComentariosManager manager;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuariorespuesta);

        manager = new DataBaseComentariosManager(this);
        valorRecibido=getIntent().getStringExtra(ComentariosActivity.ID_COMENTARIO_PASAR);

        //Toast.makeText(getApplicationContext(), "Has seleccionado: "+ valorRecibido, Toast.LENGTH_LONG).show();

        cursor = manager.traerUsuarioRespuesta(valorRecibido);

        cursor.moveToPosition(0);//Linea vital
        String name = cursor.getString(cursor.getColumnIndex("nombrePropietario"));
        String fe = cursor.getString(cursor.getColumnIndex("fechaCreado"));

        nombre = (TextView) findViewById(R.id.textView);
        nombre.setText("Nombre del usuario: "+name);

        fecha = (TextView) findViewById(R.id.textView2);
        fecha.setText("Fecha en que se creó el tema: "+fe);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.usuario_respuesta, menu);
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
