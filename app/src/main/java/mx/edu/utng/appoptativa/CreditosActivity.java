package mx.edu.utng.appoptativa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class CreditosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        TextView texto = (TextView) findViewById(R.id.tvPaola);

        //animacion del texto
        Animation animacion = AnimationUtils.loadAnimation(this,R.anim.animacion);
        texto.startAnimation(animacion);
    }
}