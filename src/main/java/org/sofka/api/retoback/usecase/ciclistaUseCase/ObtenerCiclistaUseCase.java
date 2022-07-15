package org.sofka.api.retoback.usecase.ciclistaUseCase;

import org.sofka.api.retoback.mappers.MapperCiclista;
import org.sofka.api.retoback.models.CiclistaDTO;
import org.sofka.api.retoback.repository.CiclistaRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@Validated
public class ObtenerCiclistaUseCase implements Supplier<Flux<CiclistaDTO>> {


    private final CiclistaRepository ciclistaRepository;
    private final MapperCiclista mapperCiclista;

    public ObtenerCiclistaUseCase(CiclistaRepository ciclistaRepository, MapperCiclista mapperCiclista) {
        this.ciclistaRepository = ciclistaRepository;
        this.mapperCiclista = mapperCiclista;
    }


    @Override
    public Flux<CiclistaDTO> get() {
        return ciclistaRepository.findAll()
                .map(mapperCiclista.ciclistaAciclistaDto());


    }
}
