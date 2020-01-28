package com.example.adiligencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class cep extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cep);

        final EditText etCep = findViewById(R.id.etMain_cep);
        final TextView tvResposta = findViewById(R.id.etMain_resposta);


        Button btBuscarCep = findViewById(R.id.btnMain_buscarCep);

        btBuscarCep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //buscar cep
                if(etCep.getText().toString().length() > 0 && !etCep.getText().toString().equals("") && etCep.length()== 8){
                    Log.i("teste", "CEP válido");
                      HTTPServise servise =  new HTTPServise(etCep.getText().toString());
                        try {
                            ACEP retorno = servise.execute().get();
                            tvResposta.setText(retorno.toString());
                        }catch(InterruptedException e) {
                            e.printStackTrace();
                        }catch(ExecutionException e){

                        }
                }

            }
        });
    }
}

