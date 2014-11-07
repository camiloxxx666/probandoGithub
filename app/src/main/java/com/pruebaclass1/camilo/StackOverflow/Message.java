package com.pruebaclass1.camilo.StackOverflow;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Damian on 23/10/2014.
 */
public class Message
{
    public static void message(Context context, String message)
    {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
