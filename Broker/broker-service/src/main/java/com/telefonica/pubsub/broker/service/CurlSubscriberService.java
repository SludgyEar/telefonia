package com.telefonica.pubsub.broker.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CurlSubscriberService {

    private final IpService ipService = new IpService();

    // Guarda la respuesta completa del servidor
    private String responseBody;
    public String getResponseBody() { return responseBody; }

    public void enviarCurl(String idCliente, String json) {
        try {
            //Obtener la IP local
            String ipPc = ipService.ipPC();

            //Construir la URL destino
            String urlString = "http://" + ipPc + ":8081/consultas-pendientes/response";
            URI uri = URI.create(urlString);
            URL url = uri.toURL();

            //Construir el cuerpo del mensaje
            String body = String.format(
                "{\"json\": \"%s\", \"idpeticion\": \"%s\", \"ipBroker\": \"%s\"}",
                json, idCliente, ipPc
            );

            //Configurar la conexión HTTP
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setDoOutput(true);

            // Enviar el body
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = body.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Leer la respuesta del servidor
            int statusCode = con.getResponseCode();
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                        statusCode >= 200 && statusCode < 400
                            ? con.getInputStream()
                            : con.getErrorStream(),
                        StandardCharsets.UTF_8))) {

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    response.append(line);
                }

                responseBody = response.toString();
            }
            System.out.println("Petición enviada a: " + urlString);
            System.out.println("Body enviado: " + body);
            System.out.println("Código HTTP: " + statusCode);
            System.out.println("Respuesta: " + responseBody);

        } catch (Exception e) {
            e.printStackTrace();
            responseBody = "Error: " + e.getMessage();
        }
    }
}
