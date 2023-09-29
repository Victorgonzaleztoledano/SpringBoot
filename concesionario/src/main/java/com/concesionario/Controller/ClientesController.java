package com.concesionario.Controller;

import com.concesionario.Domain.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController

public class ClientesController {
    private List<Cliente> clientes = new ArrayList<>();

    @GetMapping("/clientes")
    public List<Cliente> listarClientes(){ return clientes; }

    @PostMapping("/clientes")
    public void agregarCliente(@RequestBody Cliente cliente){ clientes.add(cliente); }
}
