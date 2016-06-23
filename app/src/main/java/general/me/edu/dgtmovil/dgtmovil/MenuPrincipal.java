package general.me.edu.dgtmovil.dgtmovil;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import general.me.edu.dgtmovil.R;


public class MenuPrincipal extends Activity {


    ImageButton imagenNuevo;
    ImageButton imagenGlecturas;
    ImageButton imagenConfiguracion;
    ImageButton imagenSalir;

    String idUsuario;
    String idPerfil;
    String idEntidad = "";
    String nombre = "";
    TextView nombreEntidad;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu_principal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Bundle bundle = this.getIntent().getExtras();
        //Construimos el mensaje a mostrar
        idUsuario = bundle.getString("idUsuario");
        idPerfil = bundle.getString("perfil");
        idEntidad = bundle.getString("idEntidad");
        nombre = bundle.getString("nombre");

        this.setTitle("" + bundle.getString("nombre"));

        imagenNuevo = (ImageButton) this.findViewById(R.id.imageView1);
        imagenGlecturas = (ImageButton) this.findViewById(R.id.imageView2);
        imagenConfiguracion = (ImageButton) this.findViewById(R.id.imageView4);
        imagenSalir = (ImageButton) this.findViewById(R.id.imageView5);
        nombreEntidad = (TextView) findViewById(R.id.txt_territorio);

        Toast.makeText(getApplicationContext(),"Entidad: "+idEntidad, Toast.LENGTH_SHORT).show();
        nombreEntidad.setText(""+idUsuario);

        if (idPerfil.equals("3")) {
            imagenGlecturas.setEnabled(false);
        }

        imagenNuevo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = null;
                //if (idEntidad.equals("1")) {
                      intent = new Intent(MenuPrincipal.this, FormulariosActivity.class);
                //}

                // Creamos la informaciï¿½n a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("idUsuario", idUsuario);
                b.putString("idEntidad", idEntidad);
                b.putString("nombre", nombre);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        imagenGlecturas.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipal.this, Sincronizar.class);

                // Creamos la informaciï¿½n a pasar entre actividades
                Bundle b = new Bundle();
                //	b.putInt("idAgente", idAgente);
                b.putString("idUsuario", idUsuario);
                b.putString("idEntidad", idEntidad);
                intent.putExtras(b);
                startActivity(intent);
            }
        });


        imagenSalir.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipal.this, MainActivity.class);

                // Creamos la informaciï¿½n a pasar entre actividades
                Bundle b = new Bundle();
                //	b.putInt("idAgente", idAgente);

                intent.putExtras(b);
                startActivity(intent);
            }


        });


        imagenConfiguracion.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuPrincipal.this, Reprocesar.class);
                startActivity(intent);

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //	getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("MenuPrincipal Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}