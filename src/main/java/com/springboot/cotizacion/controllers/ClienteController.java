package com.springboot.cotizacion.controllers;

import com.springboot.cotizacion.models.entity.Cliente;
import com.springboot.cotizacion.models.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping
    public List<Cliente> listar(){
        return iClienteService.findAll();
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id){
        return iClienteService.findById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente crear(@RequestBody Cliente cliente) {
        return iClienteService.save(cliente);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente editar(@RequestBody Cliente cliente, @PathVariable Long id) {
        Cliente clienteDb = iClienteService.findById(id);
        clienteDb.setRazonSocial(cliente.getRazonSocial());
        clienteDb.setRuc(cliente.getRuc());
        clienteDb.setNumero(cliente.getNumero());
        clienteDb.setDireccion(cliente.getDireccion());
        clienteDb.setRubro(cliente.getRubro());

        return iClienteService.save(clienteDb);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iClienteService.deleteById(id);
    }

    private boolean hasRole(String role) {

        SecurityContext context = SecurityContextHolder.getContext();

        if(context == null) {
            return false;
        }

        Authentication auth = context.getAuthentication();

        if(auth == null) {
            return false;
        }

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

        return authorities.contains(new SimpleGrantedAuthority(role));

    }
}
