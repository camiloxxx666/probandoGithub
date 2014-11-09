package com.pruebaclass1.camilo.StackOverflow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class NuevoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);//Acá vamos a llamar al objeto, y el objeto va a traer el view de nuevo
    }


    public void irTemas(View v)
    {
        Intent i = new Intent(NuevoActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void crearTema(View v)
    {
        EditText etTitulo = (EditText)findViewById(R.id.editText);
        EditText etPregunta = (EditText)findViewById(R.id.editText2);
        EditText etNombre = (EditText)findViewById(R.id.editText3);
        EditText etFecha = (EditText)findViewById(R.id.editText4);
        EditText etEmail = (EditText)findViewById(R.id.editText5);

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

            DataBaseTemasManager manager = new DataBaseTemasManager(this.getApplicationContext());
            manager.insertar_tema(stTitulo, stNombre, stPregunta, stEmail, stFecha);

            irTemas(v);
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
