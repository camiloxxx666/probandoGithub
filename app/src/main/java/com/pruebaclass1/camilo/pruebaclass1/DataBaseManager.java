package com.pruebaclass1.camilo.pruebaclass1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Damian on 22/10/2014.
 */
public class DataBaseManager
{
    public static final String TABLE_NAME = "temas";

    public static final String CN_ID = "id";

    public static final String CN_TITULO = "titulo";

    public static final String CN_TEXTO = "texto";

    public static final String CN_NOMBRE_PROPIETARIO = "nombre_propietario";

    public static final String CREATE_TABLE = " create table " + TABLE_NAME + " ( "
                                                     + CN_ID + " integer primary key autoincrement, "
                                                     + CN_TITULO + " text NOT NULL, "
                                                     + CN_NOMBRE_PROPIETARIO + " text NOT NULL, "
                                                     + CN_TEXTO + " text NOT NULL);";

    private DbHelper helper;

    private SQLiteDatabase db;


    public DataBaseManager(Context context)
    {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    public void insert(String titulo, String texto, String nombre)
    {
        ContentValues valores = new ContentValues();

        valores.put(CN_TITULO, titulo);
        valores.put(CN_TEXTO, texto);
        valores.put(CN_NOMBRE_PROPIETARIO, nombre);

        db.insert(TABLE_NAME, null, valores);
    }
}
