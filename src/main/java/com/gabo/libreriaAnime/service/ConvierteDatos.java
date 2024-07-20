package com.gabo.libreriaAnime.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvirteDatos{

    private final ObjectMapper objectMapper;
    // Implementación Inyección de dependencias a través del constructor
    public ConvierteDatos(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    // Implementación del método obtenerDatos definido en la interfaz IConvirteDatos
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase){
        try {
            // Intenta convertir el JSON en un objeto de la clase especificada
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e){
            // Si ocurre una excepción durante la conversión, lanza una RuntimeException
            throw new RuntimeException(e);
        }
    }
}
