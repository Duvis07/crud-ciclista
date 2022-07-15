package org.sofka.api.retoback.routers;

import org.sofka.api.retoback.models.CiclistaDTO;
import org.sofka.api.retoback.usecase.ciclistaUseCase.AgregarCiclistaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class CiclistaRouter {
    @Bean
    public RouterFunction<ServerResponse> crearCiclista(AgregarCiclistaUseCase useCase) {
        Function<CiclistaDTO, Mono<ServerResponse>> executor = ciclistaDTO -> useCase.apply(ciclistaDTO)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result));

        return route(
                POST("/crear").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CiclistaDTO.class).flatMap(executor)
        );
    }

}
