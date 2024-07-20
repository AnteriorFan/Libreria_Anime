package com.gabo.libreriaAnime.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gabo.libreriaAnime.service.ConsumoAPI;
import com.gabo.libreriaAnime.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {
    private final Scanner teclado;
    private  final ConvierteDatos convierteDatos;
    private final ConsumoAPI consumoApi = new ConsumoAPI();
    private final  String URL_BASE =  "https://api.jikan.moe/v4/anime?q=";

    public Principal(Scanner teclado, ObjectMapper objectMapper) {
        this.teclado = new Scanner(System.in);
        this.convierteDatos = new ConvierteDatos(objectMapper);
    }


    public  void main(){
        System.out.println("Que serie buscar");
        var opc = -1;

        while (opc != 0){
            var menu = """
                    \n
                    1 ->> Buscar Anime
                    \n
                    """;

            System.out.println(menu);
            opc = teclado.nextInt();
            teclado.nextLine();

            switch (opc){
                case 1:


                    break;
                case 0:
                    System.out.println("Cerrando aplicación ...");
                    break;
                default:
                    System.out.println("No existe");
                    break;
            }


        }
    }
}
