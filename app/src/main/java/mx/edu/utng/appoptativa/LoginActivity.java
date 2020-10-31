package mx.edu.utng.appoptativa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements OnClickListener {
    private EditText etUser, etPass;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = (EditText) findViewById(R.id.etUser);
        etPass = (EditText) findViewById(R.id.etPass);

        btnLogin = (Button) findViewById(R.id.btnIngresar);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String user = etUser.getText().toString();
        String pass = etPass.getText().toString();

        if(!user.isEmpty() && !pass.isEmpty()){
            //utilizar la clase Intent
            Intent intentLogin = new Intent(LoginActivity.this, MainActivity.class);
            //agregar parametros a datos extra
            intentLogin.putExtra("usuario", user);
            startActivity(intentLogin);
        }else{
            Toast.makeText(LoginActivity.this,"Error en los datos", Toast.LENGTH_LONG).show();

        }

    }
}