package com.pruebaclass1.camilo.pruebaclass1;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.pruebaclass1.camilo.pruebaclass1.modelo.Tema;
import com.pruebaclass1.camilo.pruebaclass1.utilidades.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    //private ListView listTemas;
    //SimpleCursorAdapter adapter;
    //Cursor cursor;
    //DataBaseManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //SQLiteDatabase db = dbHelper.getWritableDatabase();
        //manager = new DataBaseManager(this);//esto me pertenece

        DbHelper helper = new DbHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        Tema tema = new Tema();
        tema.setTitulo("Probaandoo");
        tema.setContext(this); //aca le pasamos this porque el contexto es el activity!!
        ViewGroup cont = tema.renderizar();
        setContentView(cont);

        // agarro la listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        expListView.setAdapter(listAdapter);

        /*listTemas = (ListView) findViewById(R.id.lvTemas);
        String[] from = new String[]{manager.CN_TITULO, manager.CN_TEXTO};
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};//Son los id de los layouts en este caso el por defecto tho_line_list
        cursor=manager.cargarCursorTemas();
        adapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item, cursor, from, to, 0);
        listTemas.setAdapter(adapter);*/

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Top 250");
        listDataHeader.add("Now Showing");
        listDataHeader.add("Coming Soon..");
        listDataHeader.add("blabla");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        List<String> blabla = new ArrayList<String>();
        blabla.add("2 Guns");
        blabla.add("The Smurfs 2");
        blabla.add("The Spectacular Now");
        blabla.add("The Canyons");
        blabla.add("Europa Report");
        blabla.add("2 Guns");
        blabla.add("The Smurfs 2");
        blabla.add("The Spectacular Now");
        blabla.add("The Canyons");
        blabla.add("Europa Report");
        blabla.add("2 Guns");
        blabla.add("The Smurfs 2");
        blabla.add("The Spectacular Now");
        blabla.add("The Canyons");
        blabla.add("Europa Report");
        blabla.add("2 Guns");
        blabla.add("The Smurfs 2");
        blabla.add("The Spectacular Now");
        blabla.add("The Canyons");
        blabla.add("Europa Report");

        listDataChild.put(listDataHeader.get(0), top250);
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
        listDataChild.put(listDataHeader.get(3), blabla);
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
