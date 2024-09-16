package com.example.Exercicio2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Exercicio2LeituraJson {
    String apiUrl = "http://localhost:3000/usuarios";

    public void app() {
        try {
            // Conecta-se à API
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");

            int ResponseCode = con.getResponseCode();
            if (ResponseCode == HttpURLConnection.HTTP_OK) { // Código 200 Ok 
                // Ler a resposta da API
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                // Lê a resposta da API linha por linha
                while ((inputLine = in.readLine()) != null){
                    content.append(inputLine); // Adiciona o conteúdo
                }
                in.close();

                
            }
        } catch (Exception e) {

        }
    }
}
