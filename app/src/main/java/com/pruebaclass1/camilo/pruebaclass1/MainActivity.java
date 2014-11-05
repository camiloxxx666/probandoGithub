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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.pruebaclass1.camilo.pruebaclass1.modelo.Tema;



public class MainActivity extends Activity
{
    public final static String ID_PASAR = "com.pruebaclass1.camilo.pruebaclass1._id";
    DataBaseTemasManager manager;
    ListView listview;
    Cursor cursorTemas;
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Tema tema = new Tema();
        tema.setContext(this);
        ViewGroup cont = tema.renderizar();
        setContentView(cont);

        listview = (ListView)findViewById(R.id.listView);
        listview.setOnItemClickListener(onListClick);
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                Intent i = new Intent(MainActivity.this, UsuarioActivity.class);
                i.putExtra(ID_PASAR, String.valueOf(id));
                startActivity(i);

                return true;
            }
        });

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
        startActivity(i);
    }


    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener()
    {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id )
        {
            Intent i = new Intent(MainActivity.this, ComentariosActivity.class);
            i.putExtra(ID_PASAR, String.valueOf(id));
            startActivity(i);

        }

    };


















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
