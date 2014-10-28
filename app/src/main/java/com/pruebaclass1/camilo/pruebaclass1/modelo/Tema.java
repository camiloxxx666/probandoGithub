package com.pruebaclass1.camilo.pruebaclass1.modelo;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.pruebaclass1.camilo.pruebaclass1.R;
import com.pruebaclass1.camilo.pruebaclass1.modelo.Tema;
import com.pruebaclass1.camilo.pruebaclass1.utilidades.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Camilo on 23/10/2014.
 */
public class Tema {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

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

    //probando
    public ViewGroup renderizar()
    {
        ViewGroup vg = null;
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);

        vg = (ViewGroup) inflater.inflate(R.layout.activity_principal, null, true);
        expListView = (ExpandableListView) vg.findViewById(R.id.lvExp);

        prepareListData();

        listAdapter = new ExpandableListAdapter(ctx, listDataHeader, listDataChild);

        expListView.setAdapter(listAdapter);

        return vg;
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

}
