package org.sofka.api.retoback.repository;

import org.sofka.api.retoback.models.PaisDTO;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
@FunctionalInterface
public interface GuardarPais {
    Mono<PaisDTO>apply(@Valid PaisDTO paisDTO);
}
