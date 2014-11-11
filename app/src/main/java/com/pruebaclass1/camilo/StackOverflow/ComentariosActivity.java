package com.pruebaclass1.camilo.StackOverflow;

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
import android.widget.Toast;


public class ComentariosActivity extends Activity {

    public final static String ID_COMENTARIO_PASAR = "com.pruebaclass1.camilo.pruebaclass1._id";
    //String valorRecibido;
    DataBaseComentariosManager manager;
    DataBaseTemasManager manager2;
    Cursor cursor;
    SimpleCursorAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentarios);
        String valorRecibido=getIntent().getStringExtra(MainActivity.ID_TEMA_PASAR);

        //Seteando la pregunta:

        manager2 = new DataBaseTemasManager(this);
        String preg = manager2.getTexto(valorRecibido);
        TextView tvPregunta = (TextView) findViewById(R.id.preguntaTextView);
        tvPregunta.setText(preg);

        //Armando la lista:
        listView = (ListView) findViewById(R.id.listView);

        manager = new DataBaseComentariosManager(this);
        cursor = manager.traerRespuestas(valorRecibido);

        if (cursor.moveToFirst() == false){
            TextView noHayRespuestas = (TextView) findViewById(R.id.textView1);
            noHayRespuestas.setText("Este tema aún no tiene respuestas, sé el primero en responder: ");

        }
        else {
            //cursor = manager.traerRespuestas(valorRecibido);
            String[] from = new String[]{"texto"};
            int[] to = {R.id.textView_superior2};

            adapter = new SimpleCursorAdapter(this, R.layout.entrada2, cursor, from, to, 0);
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

    }


    public void crearRespuesta(View v)
    {
        String valorRecibido=getIntent().getStringExtra(MainActivity.ID_TEMA_PASAR);

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
        switch (item.getItemId()) {

            case R.id.action_nuevo:
                Intent i = new Intent(getApplicationContext(), NuevoActivity.class);
                startActivity(i);
                return true;

            case R.id.action_buscar:
                Intent i4 = new Intent(getApplicationContext(), BuscarActivity.class);
                startActivity(i4);
                return true;

            case R.id.action_tutorial:
                Intent i2 = new Intent(getApplicationContext(), TutorialActivity.class);
                startActivity(i2);
                return true;

            case R.id.action_ayuda:
                Intent i3 = new Intent(getApplicationContext(), AyudaActivity.class);
                startActivity(i3);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}