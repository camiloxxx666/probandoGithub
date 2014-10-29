package com.pruebaclass1.camilo.pruebaclass1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Damian on 22/10/2014.
 */
public class DataBaseManager
{
    public static final String TABLE_NAME_TEMAS = "temas";

    public static final String CN_ID_TEMAS = "id";

    public static final String CN_TITULO_TEMAS = "titulo";

    public static final String CN_TEXTO_TEMAS = "texto";

    public static final String CN_NOMBRE_PROPIETARIO_TEMAS = "nombreCreador";

    public static final String CN_EMAIL_TEMAS = "email";

    public static final String CN_FECHA_TEMAS = "fechaCreado";

    public static final String CREATE_TABLE_TEMAS = " create table " + TABLE_NAME_TEMAS + " ( "
                                                     + CN_ID_TEMAS + " integer primary key autoincrement, "
                                                     + CN_TITULO_TEMAS + " text NOT NULL, "
                                                     + CN_NOMBRE_PROPIETARIO_TEMAS + " text NOT NULL, "
                                                     + CN_TEXTO_TEMAS + " text NOT NULL, "
                                                     + CN_EMAIL_TEMAS +  " text NOT NULL, "
                                                     + CN_FECHA_TEMAS + " text NOT NULL); ";


    public static final String TABLE_NAME_COMENTARIO = "comentario";

    public static final String CN_ID_COMENTARIO = "id";

    public static final String CN_PROPIETARIO_COMENTARIO = "nombrePropietario";

    public static final String CN_EMAIL_COMENTARIO = "email";

    public static final String CN_FECHA_COMENTARIO = "fechaCreado";

    public static final String CN_TEXTO_COMENTARIO = "texto";

    public static final String CN_TEMA_FK_COMENTARIO = "tema_fk";

    public static final String CREATE_TABLE_COMENTARIO = " create table " + TABLE_NAME_COMENTARIO + " ( "
                                                         + CN_TEMA_FK_COMENTARIO + " integer NOT NULL, "
                                                         + CN_ID_COMENTARIO + " integer primary key autoincrement, "
                                                         + CN_PROPIETARIO_COMENTARIO + " text NOT NULL, "
                                                         + CN_TEXTO_COMENTARIO + " text NOT NULL, "
                                                         + CN_EMAIL_COMENTARIO + " text NOT NULL, "
                                                         + CN_FECHA_COMENTARIO + " text NOT NULL, "
                                                         + "FOREIGN KEY (" + CN_TEMA_FK_COMENTARIO +") REFERENCES " + TABLE_NAME_TEMAS +" (" + CN_ID_TEMAS + ") );";
    private DbHelper helper;

    private SQLiteDatabase db;

    public DataBaseManager(Context context)
    {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    public void insertar_tema(String titulo, String nombrePropietario, String texto, String email, String fecha )
    {
        ContentValues valores = new ContentValues();
        valores.put(CN_TITULO_TEMAS, titulo);
        valores.put(CN_NOMBRE_PROPIETARIO_TEMAS, nombrePropietario);
        valores.put(CN_TEXTO_TEMAS, texto);
        valores.put(CN_EMAIL_TEMAS, email);
        valores.put(CN_FECHA_TEMAS, fecha);


        db.insert(TABLE_NAME_TEMAS, null, valores);
    }

    public Cursor traer_temas()
    {
        String[] temas = new String[]{CN_ID_TEMAS, CN_TITULO_TEMAS, CN_TEXTO_TEMAS};
        return db.query(TABLE_NAME_TEMAS, temas, null, null, null, null, null);
    }
}
