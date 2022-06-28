package com.tecsofec.apiwebflux.repository;

import com.tecsofec.apiwebflux.document.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author EVER CARLOS ROJAS
 */
// tambien llamados DAOS antiguamente (ClienteDao)
public interface ClienteRepository  extends ReactiveMongoRepository<Cliente, String> {

}
