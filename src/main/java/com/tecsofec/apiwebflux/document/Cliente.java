package com.tecsofec.apiwebflux.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author EVER CARLOS ROJAS
 */
@Document(collation = "clientes")
@Data
public class Cliente {

    @Id
    private String id;

    //@NotEmpty
    private String nombre;

    private String apellido;

    private Integer edad;

    private double sueldo;

    private String foto;

    public  Cliente() {

    }
}
