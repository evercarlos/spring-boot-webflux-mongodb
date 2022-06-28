package com.tecsofec.apiwebflux.controller;

import com.tecsofec.apiwebflux.document.Cliente;
import com.tecsofec.apiwebflux.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.File;
import java.net.URI;
import java.util.UUID;

/**
 * @author EVER CARLOS ROJAS
 */
@RestController
@RequestMapping(value = "/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Value("${config.uploads.path}")
    private String path;

    @PostMapping
    public Mono<ResponseEntity<Cliente>> create(Cliente cliente, FilePart file){
        cliente.setFoto(UUID.randomUUID().toString()+"-"+file.filename()
                .replace(" ", "")
                .replace(":","")
                .replace("//","")
        );
        return file.transferTo(new File(path+cliente.getFoto())).then(clienteService.save(cliente))
                .map(c->ResponseEntity.created(URI.create("/api/clientes".concat(c.getId())))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(c));
    }

}
