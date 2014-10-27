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
        String etTitulo = (String)((EditText)findViewById(R.id.campoTitulo)).getText().toString();
        String etPregunta = (String)((EditText)findViewById(R.id.campoPregunta)).getText().toString();
        String etNombre = (String)((EditText)findViewById(R.id.campoNombre)).getText().toString();
        String etFecha = (String)((EditText)findViewById(R.id.campoFecha)).getText().toString();
        String etEmail = (String)((EditText)findViewById(R.id.campoEmail)).getText().toString();

        //Tema tema = new Tema(etTitulo, etPregunta, etNombre, etFecha, etEmail);

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
