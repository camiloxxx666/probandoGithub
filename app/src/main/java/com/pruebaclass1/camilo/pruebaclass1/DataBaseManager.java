package com.pruebaclass1.camilo.pruebaclass1;

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


}
