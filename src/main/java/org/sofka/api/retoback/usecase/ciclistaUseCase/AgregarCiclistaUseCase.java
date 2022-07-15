package org.sofka.api.retoback.usecase.ciclistaUseCase;

import org.sofka.api.retoback.mappers.MapperCiclista;
import org.sofka.api.retoback.models.CiclistaDTO;
import org.sofka.api.retoback.repository.CiclistaRepository;
import org.sofka.api.retoback.repository.GuardarCiclista;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class AgregarCiclistaUseCase implements GuardarCiclista {

    private final CiclistaRepository ciclistaRepository;

    private  final MapperCiclista mapperCiclista;

    public AgregarCiclistaUseCase(CiclistaRepository ciclistaRepository, MapperCiclista mapperCiclista) {
        this.ciclistaRepository = ciclistaRepository;
        this.mapperCiclista = mapperCiclista;
    }
    @Override
    public Mono<CiclistaDTO> apply(CiclistaDTO ciclistaDTO) {
        return ciclistaRepository.save(mapperCiclista.ciclistaDtoAciclista(null).apply(ciclistaDTO))
                .map(ciclista->mapperCiclista.ciclistaAciclistaDto().apply(ciclista));
    }
}
