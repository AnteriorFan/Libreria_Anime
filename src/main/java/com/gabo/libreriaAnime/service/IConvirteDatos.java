package com.gabo.libreriaAnime.service;

public interface IConvirteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
