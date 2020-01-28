package com.example.adiligencia;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HTTPServise extends AsyncTask <Void, Void, ACEP> {

    private final String cep;
    private static final String BLANK_SPACE=" ";

    public HTTPServise(String cep) {
        this.cep = cep;
    }

    @Override
    protected ACEP doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();


        if (this.cep != null && this.cep.length() == 8) {
            try {
                URL url = new URL("http://ws.matheuscastiglioni.com.br/ws/cep/find/" + this.cep + "/json/");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json");
                connection.setRequestProperty("Accpet", "aplication/json");
                connection.setDoOutput(true);
                connection.setConnectTimeout(5000);
                connection.connect();

                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    resposta.append(scanner.next());
                    resposta.append(BLANK_SPACE);
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return new Gson().fromJson(resposta.toString(), ACEP.class);
    }

}

