package org.sofka.api.retoback.repository;

import org.sofka.api.retoback.collections.Pais;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends ReactiveCrudRepository<Pais, String> {

}

