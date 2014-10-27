package com.pruebaclass1.camilo.pruebaclass1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import com.pruebaclass1.camilo.pruebaclass1.modelo.Tema;


public class MainActivity extends Activity {

    DbHelper dbHelper;
    private ListView listTemas;
    SimpleCursorAdapter adapter;
    Cursor cursor;
    DataBaseManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new DbHelper(this);
        //SQLiteDatabase db = dbHelper.getWritableDatabase();
        //manager = new DataBaseManager(this);//esto me pertenece



        Tema tema = new Tema();
        tema.setTitulo("Probaandoo");
        tema.setContext(this); //aca le pasamos this porque el contexto es el activity!!
        ViewGroup cont = tema.renderizar();
        setContentView(cont);

        /*listTemas = (ListView) findViewById(R.id.lvTemas);
        String[] from = new String[]{manager.CN_TITULO, manager.CN_TEXTO};
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};//Son los id de los layouts en este caso el por defecto tho_line_list
        cursor=manager.cargarCursorTemas();
        adapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item, cursor, from, to, 0);
        listTemas.setAdapter(adapter);*/

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
