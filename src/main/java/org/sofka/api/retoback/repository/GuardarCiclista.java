package org.sofka.api.retoback.repository;

import org.sofka.api.retoback.models.CiclistaDTO;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
@FunctionalInterface

public interface GuardarCiclista {
    Mono<CiclistaDTO>apply(@Valid CiclistaDTO ciclistaDTO);


}
