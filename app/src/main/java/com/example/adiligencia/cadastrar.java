package com.example.adiligencia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastrar extends AppCompatActivity {
    Button botao;
    EditText nome;
    EditText email;
    EditText senha;
    EditText senhaConfere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        Button botao = (Button) findViewById(R.id.botaocad);

        botao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                BancoController crud = new BancoController(getBaseContext());

                EditText nome = (EditText)findViewById(R.id.nome);
                EditText email = (EditText)findViewById(R.id.email);
                EditText senha = (EditText)findViewById(R.id.senha);
                EditText senhaConfere = (EditText)findViewById(R.id.senhaconfere);

                String nomeString = nome.getText().toString();
                String emailString = email.getText().toString();
                String senhaString = senha.getText().toString();
                String senhaConfereString = senhaConfere.getText().toString();


                if(nomeString.isEmpty() || emailString.isEmpty() || senhaString.isEmpty() || senhaConfereString.isEmpty()) {

                    String resultado = "Preencha todos os campos";
                        Toast toast = Toast.makeText(getApplicationContext(),
                                resultado, Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();

                }else{
                    if(senhaString.equals(senhaConfereString)){

                      /*String resultado = "cadastrou";
                       Toast toast = Toast.makeText(getApplicationContext(),
                             resultado, Toast.LENGTH_SHORT);
                       toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                       toast.show();*/
                        String resultado  = crud
                                 .insereDado(nomeString,emailString,senhaString);

                       Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                    }else{

                    String resultado = "A senha não confere";
                        Toast toast = Toast.makeText(getApplicationContext(),
                                resultado, Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                        toast.show();


                    }
                }
            }
        });
    }
}

