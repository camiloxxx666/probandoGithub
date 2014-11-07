package com.pruebaclass1.camilo.StackOverflow;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Damian on 22/10/2014.
 */
public class DbHelper extends SQLiteOpenHelper
{

    //Nombre de la base
    private static final String DATABASE_NAME = "mobile.sqlite";

    //Version de la base
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DataBaseTemasManager.CREATE_TABLE_TEMAS);
        db.execSQL(DataBaseComentariosManager.CREATE_TABLE_COMENTARIO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
