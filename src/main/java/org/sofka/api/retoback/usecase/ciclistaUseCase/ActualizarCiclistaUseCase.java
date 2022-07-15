package org.sofka.api.retoback.usecase.ciclistaUseCase;

import org.sofka.api.retoback.mappers.MapperCiclista;
import org.sofka.api.retoback.models.CiclistaDTO;
import org.sofka.api.retoback.repository.CiclistaRepository;
import org.sofka.api.retoback.repository.GuardarCiclista;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class ActualizarCiclistaUseCase implements GuardarCiclista {

    private final CiclistaRepository ciclistaRepository;
    private final MapperCiclista mapperCiclista;

    public ActualizarCiclistaUseCase(CiclistaRepository ciclistaRepository, MapperCiclista mapperCiclista) {
        this.ciclistaRepository = ciclistaRepository;
        this.mapperCiclista = mapperCiclista;
    }


    @Override
    public Mono<CiclistaDTO> apply(CiclistaDTO ciclistaDTO) {
        Objects.requireNonNull(ciclistaDTO.getId(), "El id del ciclista es requerido");
        return ciclistaRepository
                .save(mapperCiclista.ciclistaDtoAciclista(ciclistaDTO.getId())
                        .apply(ciclistaDTO))
                .thenReturn(ciclistaDTO);
    }

}