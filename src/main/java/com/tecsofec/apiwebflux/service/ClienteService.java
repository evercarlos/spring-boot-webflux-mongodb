package com.tecsofec.apiwebflux.service;

import com.tecsofec.apiwebflux.document.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author EVER CARLOS ROJAS
 */
public interface ClienteService {

    public Flux<Cliente> findAll();

    public Mono<Cliente> findById(String id);

    public Mono<Cliente> save(Cliente cliente);

    public Mono<Void> delete(Cliente cliente);


}
