package com.javeriana.flyweight.implementation;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fabrizio Bolaño
 */

//  Aquí se debe modificar para agregar el artista
public class FabricaCanciones {
    
    public static boolean HabilitarFlyweight = true;
    private static final Map<String,Cancion> PLAY_CANCION = new HashMap<>();
    private static final Map<String,Artista> PLAY_ARTISTA = new HashMap<>();
    private static Long Secuencia = 0L;
    
    public static Cancion CrearItem(String NombreTema, String nombreArtista){

        Artista artista = null;

        if(HabilitarFlyweight && PLAY_ARTISTA.containsKey(nombreArtista)){
            artista = PLAY_ARTISTA.get(nombreArtista);
        }else{
            artista = new Artista(nombreArtista);
            PLAY_ARTISTA.put(nombreArtista ,artista);
        }

        if(HabilitarFlyweight && PLAY_CANCION.containsKey(NombreTema)){
            return PLAY_CANCION.get(NombreTema);
        }else{
            Cancion playItem = new Cancion(++Secuencia, NombreTema, artista);
            PLAY_CANCION.put(NombreTema, playItem);
            return playItem;
        }

        
    }
}
