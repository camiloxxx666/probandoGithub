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


}