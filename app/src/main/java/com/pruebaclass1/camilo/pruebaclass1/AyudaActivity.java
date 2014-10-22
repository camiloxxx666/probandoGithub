package com.pruebaclass1.camilo.pruebaclass1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class AyudaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        /*String nombre = getIntent().getExtras().getString("nombre");
        int edad = getIntent().getExtras().getInt("edad");

        Toast.makeText(getApplicationContext(), "Nombre: " + nombre, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Edad: " + edad, Toast.LENGTH_SHORT).show();*/
    }

    public void irNuevo(View v)
    {
        Intent i = new Intent(AyudaActivity.this, NuevoActivity.class);
        startActivity(i);
    }

    public void irTemas(View v)
    {
        Intent i = new Intent(AyudaActivity.this, MainActivity.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ayuda, menu);
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
