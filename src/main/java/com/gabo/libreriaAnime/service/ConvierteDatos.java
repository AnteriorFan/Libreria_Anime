package com.gabo.libreriaAnime.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ConvierteDatos implements IConvirteDatos{

    private final ObjectMapper objectMapper;
    // Implementación Inyección de dependencias a través del constructor
    @Autowired
    public ConvierteDatos(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    // Implementación del método obtenerDatos definido en la interfaz IConvirteDatos
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase){
        System.out.println(objectMapper);
        try {
            // Intenta convertir el JSON en un objeto de la clase especificada
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e){
            // Si ocurre una excepción durante la conversión, lanza una RuntimeException
            throw new RuntimeException(e);
        }
    }
}
