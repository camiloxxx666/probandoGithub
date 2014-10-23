package com.pruebaclass1.camilo.pruebaclass1.modelo;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.pruebaclass1.camilo.pruebaclass1.R;

import java.util.Date;

/**
 * Created by Camilo on 23/10/2014.
 */
public class Tema {

    private Integer ID;

    private Context ctx;

    private String titulo;

    private String pregunta;

    private String nombreCreador;

    private Date fechaCreado;

    private String email;

    //Metodos

    public void setTitulo(String tit)
    {
        titulo = tit;
    }

    public void setContext(Context context)
    {
        ctx=context;
    }

    //probando
    public ViewGroup renderizar()
    {
        ViewGroup vg = null;
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
        vg = (ViewGroup) inflater.inflate(R.layout.activity_principal, null, true);

        //la siguiente linea es para especificar un elemento de la vista
        TextView texto = (TextView) vg.findViewById(R.id.textView2);//ListView listado = (ListView) vg.findViewById(R.id.idDeLaListView);//
        texto.setText(titulo);
        return vg;
    }

}
