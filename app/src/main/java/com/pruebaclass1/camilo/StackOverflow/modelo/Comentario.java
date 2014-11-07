package com.pruebaclass1.camilo.StackOverflow.modelo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.pruebaclass1.camilo.StackOverflow.DataBaseComentariosManager;
import com.pruebaclass1.camilo.StackOverflow.R;

/**
 * Created by Camilo on 23/10/2014.
 */
public class Comentario {

    private SimpleCursorAdapter adapter;
    private Cursor cursorTemas;
    private ListView listView;
    private DataBaseComentariosManager manager;
    private String idTema;
    private Cursor cursor;

    private Integer id;

    private String texto;

    private Context ctx;

    private String nombre_propietario;

    private String fechaCreado;

    private String email;

    public Comentario(){}

    public Comentario(String text, String nom, String fecha, String mail)
    {
        texto = text;
        nombre_propietario = nom;
        fechaCreado = fecha;
        email = mail;
    }

    public void setContext(Context context)
    {
        ctx=context;
    }

    public void setIdTema(String idT)
    {
        idTema = idT;
    }

    public ViewGroup renderizar()
    {
        ViewGroup vg = null;

        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        vg = (ViewGroup) inflater.inflate(R.layout.activity_comentarios, null, true);

        listView = (ListView) vg.findViewById(R.id.listView);

        manager = new DataBaseComentariosManager(ctx);
        //valorRecibido=getIntent().getStringExtra(MainActivity.ID_TEMA_PASAR);

        cursor = manager.traerRespuestas(idTema);

        String[] from = new String[]{"texto"};
        int[] to = {R.id.textView_superior2};

        adapter = new SimpleCursorAdapter(ctx, R.layout.entrada2, cursor, from, to, 0);//contecto, layoutID, cursor, from, to
        listView.setAdapter(adapter);

        return vg;

    }
    
}
