package com.pruebaclass1.camilo.pruebaclass1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class ComentariosActivity extends Activity {

    public final static String ID_COMENTARIO_PASAR = "com.pruebaclass1.camilo.pruebaclass1._id";
    String valorRecibido;
    DataBaseComentariosManager manager;
    Cursor cursor;
    SimpleCursorAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);

        listView = (ListView) findViewById(R.id.listView);

        manager = new DataBaseComentariosManager(this);
        valorRecibido=getIntent().getStringExtra(MainActivity.ID_TEMA_PASAR);

        cursor = manager.traerRespuestas(valorRecibido);

        String[] from = new String[]{"texto"};
        int[] to = {R.id.textView_superior2};

        adapter = new SimpleCursorAdapter(this, R.layout.entrada2, cursor, from, to, 0);//contecto, layoutID, cursor, from, to
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                Intent i = new Intent(ComentariosActivity.this, UsuarioRespuestaActivity.class);
                i.putExtra(ID_COMENTARIO_PASAR, String.valueOf(id));
                startActivity(i);

                return true;
            }
        });

    }


    public void crearRespuesta(View v)
    {
        EditText etNombre = (EditText)findViewById(R.id.editText1);
        EditText etRespuesta = (EditText)findViewById(R.id.editText2);
        EditText etFecha = (EditText)findViewById(R.id.editText3);
        EditText etEmail = (EditText)findViewById(R.id.editText4);

        String stNombre = etNombre.getText().toString();
        String stRespuesta = etRespuesta.getText().toString();
        String stFecha = etFecha.getText().toString();
        String stEmail = etEmail.getText().toString();


        if (stNombre.length() == 0 || stRespuesta.length() == 0 || stFecha.length() == 0 || stEmail.length() == 0)
        {
            if(stNombre.length() == 0)
                etNombre.setError("Debes ingresar un Nombre");

            if(stRespuesta.length() == 0)
                etRespuesta.setError("Debes ingresar una Respuesta");

            if(stNombre.length() == 0)
                etNombre.setError("Debes ingresar tu nombre");

            if(stFecha.length() == 0)
                etFecha.setError("Es obligatoria la fecha de hoy");

            if(stEmail.length() == 0)
                etEmail.setError("Debes ingresar tu E-mail");
        }

        else {
            manager.insertar_comentario(stNombre, stRespuesta, stFecha, stEmail, valorRecibido);

            Intent i = new Intent(ComentariosActivity.this, MainActivity.class);
            startActivity(i);
        }

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
