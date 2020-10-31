package mx.edu.utng.appoptativa;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    Fragment f; //para manejo de los fragmentos a utilizar
    boolean modoJava = true; //bandera indicadora del modo java o kotlin


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //gestor de fragments, se define el fragmento por defecto
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedor, new JavaFragment())
                .commit();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg = "";

                if(modoJava){
                    f = new KotlinFragment();
                    msg = "KOTLIN";
                }else{
                    f = new JavaFragment();
                    msg = "JAVA";
                }
                modoJava = !modoJava;

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor, f)
                        .commit();

                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId(); //se obtiene el id de la opcion seleccionada
        String msg = "mensaje";
        switch (id){
            case R.id.action_saber:
                Intent intentSaber = new Intent(MainActivity.this, SaberMasActivity.class);
                startActivity(intentSaber);
                msg = "Saber más";
                break;

            case R.id.action_creditos:
                Intent intentCreditos = new Intent(MainActivity.this, CreditosActivity.class);
                startActivity(intentCreditos);
                msg = "Creditos";
                break;

            case R.id.action_salir:
                finish();
                break;
            default:
                super.onOptionsItemSelected(item);
        } //fin del swiitch

        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

    }
}