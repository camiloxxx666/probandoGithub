package com.pruebaclass1.camilo.pruebaclass1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Damian on 22/10/2014.
 */
public class DbHelper extends SQLiteOpenHelper
{
    //nombre del archivo de la base de datos
    private static final String DB_NAME = "mobile.sql";

    //version del schema de la base de datos
    //cuando se modifique la base (en el onUpgrade), esta variable va a cambiar
    private static final int DB_SCHEMA_VERSION = 1;

    public DbHelper(Context context)
    {
        super(context, DB_NAME, null, DB_SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DataBaseManager.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}
