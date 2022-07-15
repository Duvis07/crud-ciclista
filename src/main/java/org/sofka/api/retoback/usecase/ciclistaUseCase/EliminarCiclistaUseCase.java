package org.sofka.api.retoback.usecase.ciclistaUseCase;

import org.sofka.api.retoback.mappers.MapperCiclista;
import org.sofka.api.retoback.repository.CiclistaRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.function.Function;

@Service
@Validated
public class EliminarCiclistaUseCase implements Function<String, Mono<Void>> {
    private final CiclistaRepository ciclistaRepository;
    private final MapperCiclista mapperCiclista;

    public EliminarCiclistaUseCase(CiclistaRepository ciclistaRepository, MapperCiclista mapperCiclista) {
        this.ciclistaRepository = ciclistaRepository;
        this.mapperCiclista = mapperCiclista;
    }


    @Override
    public Mono<Void> apply(String id) {
        Objects.requireNonNull(id, "Id is required");
        return ciclistaRepository.deleteById(id)
                .then();

    }
}