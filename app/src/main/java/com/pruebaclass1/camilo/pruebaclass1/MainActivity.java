package com.pruebaclass1.camilo.pruebaclass1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.pruebaclass1.camilo.pruebaclass1.modelo.Tema;



public class MainActivity extends Activity {

    //DataBaseManager manager;

    private DataBaseManager manager;
    private Cursor cursor;
    private ListView list;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*manager = new DataBaseManager(this);
        list = (ListView) findViewById(R.id.campoNombre); //aca mande cualquiera, hay que crear un listView y pasarle el id aca, no pudde crear xq no me anda la vista de diseño



        String[] from = new String[]{manager.CN_NOMBRE_PROPIETARIO_TEMAS, manager.CN_TEXTO_TEMAS};

        int[] to = new int[]{android.R.id.text1, android.R.id.text2}; //esos 2 text son los que trae el adapter por defecto

        cursor = manager.getTemas();

        adapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item, cursor,from, to, 0);
        list.setAdapter(adapter);*/

        Tema tema = new Tema();
        tema.setContext(this);
        ViewGroup cont = tema.renderizar();
        setContentView(cont);

    }



    public void irNuevo(View v)
    {
        Intent i = new Intent(MainActivity.this, NuevoActivity.class);
        startActivity(i);
    }

    public void irBuscar(View v)
    {
        Intent i = new Intent(MainActivity.this, BuscarActivity.class);
        startActivity(i);
    }

    public void irAyuda(View v)
    {
        Intent i = new Intent(MainActivity.this, AyudaActivity.class);
        //suponiendo que pasamos datos
        i.putExtra("nombre", "Camilo");
        i.putExtra("edad", 22);
        startActivity(i);
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
