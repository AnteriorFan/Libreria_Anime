package com.gabo.libreriaAnime.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsumoAPI {
    //Se utiliza la clase Logger de Java para registrar mensajes de información, advertencia y error.
    //          Esto es útil para el seguimiento y diagnóstico de problemas.

    private static final Logger logger = Logger.getLogger(ConsumoAPI.class.getName());
    // Uso de HttpClient como atributo de clase: Para evitar crear una nueva instancia de HttpClient en cada solicitud,
        // se puede inicializar una sola vez como atributo de la clase
    private final HttpClient client; //Al crear el HttpClient una sola vez en el constructor, se evita la sobrecarga de crear nuevas instancias repetidamente.

    public ConsumoAPI() {
        this.client = HttpClient.newHttpClient();

    }

    //Uso de Optional: Para manejar el caso donde la respuesta sea null de una manera más segura.
    public String obtenerDatos(String url) {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        System.out.println(request);
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            // Se verifica si la respuesta HTTP tiene un código de estado 200 (OK) antes de devolver el cuerpo de la respuesta.
            // Si no es así, se registra una advertencia y se devuelve un Optional.empty().
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                logger.log(Level.WARNING, "Solicitud fallida. Código de estado: " + response.statusCode());
                return null;
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error de IO al enviar la solicitud", e);
            throw new RuntimeException("Error de IO al enviar la solicitud", e);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Solicitud interrumpida", e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Solicitud interrumpida", e);
        }
    }

}
