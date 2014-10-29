package com.pruebaclass1.camilo.pruebaclass1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.pruebaclass1.camilo.pruebaclass1.modelo.Tema;


public class NuevoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);//Acá vamos a llamar al objeto, y el objeto va a traer el view de nuevo
    }

    public void irAyuda(View v)
    {
        Intent i = new Intent(NuevoActivity.this, AyudaActivity.class);
        startActivity(i);
    }

    public void irTemas(View v)
    {
        Intent i = new Intent(NuevoActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void crearTema(View v)
    {
        EditText etTitulo = (EditText)findViewById(R.id.campoTitulo);
        EditText etPregunta = (EditText)findViewById(R.id.campoPregunta);
        EditText etNombre = (EditText)findViewById(R.id.campoNombre);
        EditText etFecha = (EditText)findViewById(R.id.campoFecha);
        EditText etEmail = (EditText)findViewById(R.id.campoEmail);

        String stTitulo = etTitulo.getText().toString();
        String stPregunta = etPregunta.getText().toString();
        String stNombre = etNombre.getText().toString();
        String stFecha = etFecha.getText().toString();
        String stEmail = etEmail.getText().toString();


        if (stTitulo.length() == 0 || stPregunta.length() == 0 || stNombre.length() == 0 || stFecha.length() == 0 || stEmail.length() == 0)
        {
            if(stTitulo.length() == 0)
                etTitulo.setError("Debes ingresar un Titulo");

            if(stPregunta.length() == 0)
                etPregunta.setError("Debes ingresar una Pregunta");

            if(stNombre.length() == 0)
                etNombre.setError("Debes ingresar tu nombre");

            if(stFecha.length() == 0)
                etFecha.setError("Es obligatoria la fecha de hoy");

            if(stEmail.length() == 0)
                etEmail.setError("Debes ingresar tu E-mail");
        }

        else {

            DataBaseManager manager = new DataBaseManager(this.getApplicationContext());
            manager.insertar_tema(stTitulo, stNombre, stPregunta, stEmail, stFecha);

            irTemas(v);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nuevo, menu);
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
