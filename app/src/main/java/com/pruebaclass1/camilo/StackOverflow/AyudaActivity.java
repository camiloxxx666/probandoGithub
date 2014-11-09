package com.pruebaclass1.camilo.StackOverflow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;


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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            case R.id.action_nuevo:
                Intent i = new Intent(getApplicationContext(), NuevoActivity.class);
                startActivity(i);
                return true;

            case R.id.action_buscar:
                Intent i4 = new Intent(getApplicationContext(), BuscarActivity.class);
                startActivity(i4);
                return true;

            case R.id.action_tutorial:
                Intent i2 = new Intent(getApplicationContext(), TutorialActivity.class);
                startActivity(i2);
                return true;

            case R.id.action_ayuda:
                Intent i3 = new Intent(getApplicationContext(), AyudaActivity.class);
                startActivity(i3);
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
