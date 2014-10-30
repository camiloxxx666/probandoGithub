package com.pruebaclass1.camilo.pruebaclass1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class AyudaActivity extends Activity {

    private WebView webViewAyuda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        webViewAyuda = (WebView) findViewById(R.id.wvAyuda);

        //Activar javascript
        WebSettings webSettings = webViewAyuda.getSettings();
        webSettings.setJavaScriptEnabled(true);

        String pagina = "<html>" +
                "<head>" +
                "<title>bla</title>" +
                "</head>" +
                "<body>" +
                "<p1>Integrantes:</p1><br/></br>" +
                "<p2>Camilo Orquera</p2><br/><p2>Damián Salaverry</p2><br/><p2>Lautaro Acosta</p2>" +
                "</body>" +
                "</html>";

        webViewAyuda.loadData(pagina, "text/html; charset=UTF-8", null);

        /*String nombre = getIntent().getExtras().getString("nombre");
        int edad = getIntent().getExtras().getInt("edad");*/

    }

    public void irNuevo(View v)
    {
        Intent i = new Intent(AyudaActivity.this, NuevoActivity.class);
        startActivity(i);
    }

    public void irTemas(View v)
    {
        Intent i = new Intent(AyudaActivity.this, MainActivity.class);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ayuda, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
