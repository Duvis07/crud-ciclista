package org.sofka.api.retoback.mappers;

import org.sofka.api.retoback.collections.Ciclista;
import org.sofka.api.retoback.models.CiclistaDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperCiclista {
    public Function<CiclistaDTO, Ciclista> ciclistaDtoAciclista(Object o) {
        return ciclistaDTO -> {
            var ciclista = new Ciclista();
            ciclista.setId(ciclistaDTO.getId());
            ciclista.setNombre(ciclistaDTO.getNombre());
            ciclista.setEquipo(ciclistaDTO.getEquipo());
            ciclista.setPais_id(ciclistaDTO.getPais_id());
            return ciclista;
        };
    }

    public Function<Ciclista, CiclistaDTO> ciclistaAciclistaDto() {
        return ciclista -> new CiclistaDTO(
                ciclista.getId(),
                ciclista.getNombre(),
                ciclista.getEquipo(),
                ciclista.getPais_id()
        );
    }
}
