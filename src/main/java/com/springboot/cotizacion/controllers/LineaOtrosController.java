package com.springboot.cotizacion.controllers;

import com.springboot.cotizacion.models.entity.LineaOtros;
import com.springboot.cotizacion.models.service.ILineaOtrosService;
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
@RequestMapping("/api/lineaOtros")
public class LineaOtrosController {

    @Autowired
    private ILineaOtrosService iLineaOtrosService;

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping
    public List<LineaOtros> listar(){
        return iLineaOtrosService.findAll();
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/{id}")
    public LineaOtros buscar(@PathVariable Long id){
        return iLineaOtrosService.findById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public LineaOtros crear(@RequestBody LineaOtros lineaOtros) {
        return iLineaOtrosService.save(lineaOtros);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public LineaOtros editar(@RequestBody LineaOtros lineaOtros, @PathVariable Long id) {
        LineaOtros lineaOtrosDb = iLineaOtrosService.findById(id);
        lineaOtrosDb.setOtro(lineaOtros.getOtro());
        lineaOtrosDb.setCantidad(lineaOtros.getCantidad());
        lineaOtrosDb.setUtilidad(lineaOtros.getUtilidad());
        lineaOtrosDb.setMargenUtilidad(lineaOtros.getMargenUtilidad());
        return iLineaOtrosService.save(lineaOtrosDb);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iLineaOtrosService.deleteById(id);
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
