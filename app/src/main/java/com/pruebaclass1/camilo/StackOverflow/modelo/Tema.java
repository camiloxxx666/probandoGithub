package com.pruebaclass1.camilo.StackOverflow.modelo;


import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;

import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.pruebaclass1.camilo.StackOverflow.DataBaseTemasManager;
import com.pruebaclass1.camilo.StackOverflow.R;


/**
 * Created by Camilo on 23/10/2014.
 */
public class Tema {


    private SimpleCursorAdapter adapter;
    private Cursor cursorTemas;
    private ListView listView;
    private DataBaseTemasManager manager;

    private Integer ID;

    private Context ctx;

    private String titulo;

    private String pregunta;

    private String nombreCreador;

    private String fechaCreado;

    private String email;

    //Metodos
    public Tema(){}

    public Tema(String tit, String preg, String nom, String fecha, String email)
    {
        titulo = tit;
        pregunta = preg;
        nombreCreador = nom;
        fechaCreado = fecha;
        this.email = email;
    }

    public void setTitulo(String tit)
    {
        titulo = tit;
    }

    public void setContext(Context context)
    {
        ctx=context;
    }


    public ViewGroup renderizar()
    {
        ViewGroup vg = null;

        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        vg = (ViewGroup) inflater.inflate(R.layout.activity_principal, null, true);

        listView = (ListView) vg.findViewById(R.id.listView);

        manager = new DataBaseTemasManager(ctx);
        cursorTemas = manager.getTemas();

        String[] from = new String[]{"titulo", "texto"};
        int[] to = {R.id.textView_superior, R.id.textView_inferior};

        adapter = new SimpleCursorAdapter(ctx, R.layout.entrada, cursorTemas, from, to, 0);//contecto, layoutID, cursor, from, to
        listView.setAdapter(adapter);

        return vg;

    }



}
