package org.sofka.api.retoback.repository;

import org.sofka.api.retoback.collections.Ciclista;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiclistaRepository extends ReactiveCrudRepository<Ciclista, String> {

}

