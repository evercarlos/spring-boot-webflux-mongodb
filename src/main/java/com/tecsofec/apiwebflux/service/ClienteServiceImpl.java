package com.tecsofec.apiwebflux.service;

import com.tecsofec.apiwebflux.document.Cliente;
import com.tecsofec.apiwebflux.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author EVER CARLOS ROJAS
 */
@Service
public class ClienteServiceImpl  implements  ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Flux<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Mono<Cliente> findById(String id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Mono<Cliente> save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Mono<Void> delete(Cliente cliente) {
        return clienteRepository.delete(cliente);
    }
}
