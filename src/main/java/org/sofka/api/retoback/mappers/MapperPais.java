package org.sofka.api.retoback.mappers;

import com.mongodb.Function;
import org.sofka.api.retoback.collections.Pais;
import org.sofka.api.retoback.models.PaisDTO;
import org.springframework.stereotype.Component;

@Component
public class MapperPais {

    public Function<PaisDTO, Pais> paisDtoApais(Object o) {
        return mapperPais -> {
            var pais = new Pais();
            pais.setId(mapperPais.getId());
            pais.setNombre(mapperPais.getNombre());
            pais.setCodigo(mapperPais.getCodigo());
            return pais;
        };
    }

    public Function<Pais, PaisDTO> paisApaisDto() {
        return pais -> new PaisDTO(
                pais.getId(),
                pais.getNombre(),
                pais.getCodigo()
        );
    }
}
