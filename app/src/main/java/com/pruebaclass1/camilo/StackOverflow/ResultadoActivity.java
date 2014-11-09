package com.pruebaclass1.camilo.StackOverflow;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.pruebaclass1.camilo.StackOverflow.R;

public class ResultadoActivity extends Activity {
    public final static String ID_TEMA_PASAR = "com.pruebaclass1.camilo.pruebaclass1._id";
    DataBaseTemasManager manager;
    Cursor cursor;
    SimpleCursorAdapter adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        String valorRecibido = getIntent().getStringExtra(BuscarActivity.aBuscar);
        listView = (ListView) findViewById(R.id.listView);

        manager = new DataBaseTemasManager(this);
        cursor = manager.buscarTemas(valorRecibido);

        if (cursor.moveToFirst() == false){
            TextView noHayRespuestas = (TextView) findViewById(R.id.textView1);
            noHayRespuestas.setText("No hay resultados para: "+valorRecibido);

        }
        else {
            String[] from = new String[]{"titulo", "texto"};
            int[] to = {R.id.textView_superior, R.id.textView_inferior};

            adapter = new SimpleCursorAdapter(this, R.layout.entrada, cursor, from, to, 0);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(onListClick);

            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                               int pos, long id) {
                    Intent i = new Intent(ResultadoActivity.this, UsuarioActivity.class);
                    i.putExtra(ID_TEMA_PASAR, String.valueOf(id));
                    startActivity(i);

                    return true;
                }
            });
        }
    }

    private AdapterView.OnItemClickListener onListClick = new AdapterView.OnItemClickListener()
    {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id )
        {
            Intent i = new Intent(ResultadoActivity.this, ComentariosActivity.class);
            i.putExtra(ID_TEMA_PASAR, String.valueOf(id));
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
        switch (item.getItemId()) {

            case R.id.action_nuevo:
                Intent i = new Intent(getApplicationContext(), NuevoActivity.class);
                startActivity(i);
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
