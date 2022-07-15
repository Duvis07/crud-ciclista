package org.sofka.api.retoback.collections;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ciclista")
public class Ciclista {

    @Id
    private String id;
    private String nombre;
    private String equipo;
    private String pais_id;

}
