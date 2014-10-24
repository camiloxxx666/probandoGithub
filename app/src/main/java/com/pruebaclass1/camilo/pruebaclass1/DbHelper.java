package com.pruebaclass1.camilo.pruebaclass1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by Damian on 22/10/2014.
 */
public class DbHelper extends SQLiteOpenHelper
{
   private static final String DATABASE_NAME = "mobile.db";

    private static final String TABLE_NAME = "tema";

    private static final String TABLE_ID = "_id";

    private static final String TITULO = "titulo";

    private static final String PREGUNTA = "pregunta";

    private static final String NOMBRE_CREADOR = "nombre_creador";

    private static final String FECHA_CREACION = "fecha";

    private static final String EMAIL = "email";

    private static final int DATABASE_VERSION = 1;

    private Context context;

    public DbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    /*
        método que se llama cuando se crea la base de datos todo lo que se creacion de tablas
        e informacion inicial en ellas debe ir en este método
     */
    @Override
    public void onCreate(SQLiteDatabase db)
    {

            db.execSQL("CREATE TABLE temas ("+ TABLE_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                            TITULO + " VARCHAR(255), " +
                                            PREGUNTA +" VARCHAR(255), " +
                                            NOMBRE_CREADOR +" VARCHAR(255), " +
                                            FECHA_CREACION +" date, " +
                                            EMAIL +" VARCHAR(255));");

    }


    /*
        método que se utiliza para todo lo que se modificación de la base de datos,
        todos los drop y para agregar columnas a la base deben ir en este método
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE " + TABLE_NAME + " IF EXISTS");
        onCreate(db);
    }
}
