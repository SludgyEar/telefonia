package com.telefonica.pubsub.broker.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class CurlPublisherService {

    private final IpService ipService = new IpService();

    // Guardar la respuesta completa del servidor
    private String responseBody;
    public String getResponseBody() { return responseBody; }

    public void enviarCurl(String idPeticion, String json) {
        try {
            // Obtener IP local
            String ipPc = ipService.ipPC();

            // URL de destino (mismo host, puerto 8083)
            String urlString = "http://" + ipPc + ":8083/api/cobertura/consultar";
            URI uri = URI.create(urlString);
            URL url = uri.toURL();

            // Crear cuerpo JSON
            String body = String.format(
                "{\"json\": \"%s\", \"idpeticion\": \"%s\", \"ipBroker\": \"%s\"}",
                json, idPeticion, ipPc
            );

            // Configurar conexión
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setDoOutput(true);

            // Enviar el body
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = body.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Leer la respuesta completa del servidor
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

            // Mostrar datos en consola
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
