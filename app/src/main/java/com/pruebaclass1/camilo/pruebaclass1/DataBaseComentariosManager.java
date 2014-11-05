package com.pruebaclass1.camilo.pruebaclass1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Damian on 02/11/2014.
 */
public class DataBaseComentariosManager
{
    public static final String TABLE_NAME_COMENTARIO = "comentario";

    public static final String ID_COMENTARIO = "_id";

    public static final String CN_PROPIETARIO_COMENTARIO = "nombrePropietario";

    public static final String CN_EMAIL_COMENTARIO = "email";

    public static final String CN_FECHA_COMENTARIO = "fechaCreado";

    public static final String CN_TEXTO_COMENTARIO = "texto";

    public static final String CN_TEMA_FK_COMENTARIO = "tema_fk";

    // nombre y identificador de la tabla temas
    public static final String TABLE_NAME_TEMAS = "temas";

    public static final String CN_ID_TEMAS = "id";

    public static final String CREATE_TABLE_COMENTARIO = " create table " + TABLE_NAME_COMENTARIO + " ( "
                                                        + CN_TEMA_FK_COMENTARIO + " integer NOT NULL, "
                                                        + ID_COMENTARIO + " integer primary key autoincrement, "
                                                        + CN_PROPIETARIO_COMENTARIO + " text NOT NULL, "
                                                        + CN_TEXTO_COMENTARIO + " text NOT NULL, "
                                                        + CN_EMAIL_COMENTARIO + " text NOT NULL, "
                                                        + CN_FECHA_COMENTARIO + " text NOT NULL, "
                                                        + "FOREIGN KEY (" + CN_TEMA_FK_COMENTARIO +") REFERENCES " + TABLE_NAME_TEMAS +" (" + CN_ID_TEMAS + ") );";


    private DbHelper helper;

    private SQLiteDatabase db;

    public DataBaseComentariosManager(Context context) {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }
}
