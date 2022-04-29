package com.springboot.cotizacion.controllers;

import com.springboot.cotizacion.models.entity.Cotizacion;
import com.springboot.cotizacion.models.service.ICotizacionService;
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
@RequestMapping("/api/cotizaciones")
public class CotizacionController {
    @Autowired
    private ICotizacionService iCotizacionService;

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping
    public List<Cotizacion> listar(){
        return iCotizacionService.findAll();
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/{id}")
    public Cotizacion buscar(@PathVariable Long id){
        return iCotizacionService.findById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Cotizacion crear(@RequestBody Cotizacion cotizacion) {

        return iCotizacionService.save(cotizacion);
    }

    @Secured({"ROLE_ADMIN"})
    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cotizacion editar(@RequestBody Cotizacion cotizacion, @PathVariable Long id) {
        Cotizacion cotizacionDB = iCotizacionService.findById(id);
        cotizacionDB.setCliente(cotizacion.getCliente());
        cotizacionDB.setFecha(cotizacion.getFecha());
        cotizacionDB.setListaEquipos(cotizacion.getListaEquipos());
        cotizacionDB.setListaMateriales(cotizacion.getListaMateriales());
        cotizacionDB.setListaManoObra(cotizacion.getListaManoObra());
        cotizacionDB.setPrecioEquipos(cotizacion.getPrecioEquipos());
        cotizacionDB.setPrecioManoObra(cotizacion.getPrecioManoObra());
        cotizacionDB.setPrecioMateriales(cotizacion.getPrecioMateriales());
        cotizacionDB.setPrecioOtros(cotizacion.getPrecioOtros());
        cotizacionDB.setSubTotal(cotizacion.getSubTotal());
        cotizacionDB.setTotalIgv(cotizacion.getTotalIgv());
        cotizacionDB.setUtilidadEquipos(cotizacion.getUtilidadEquipos());
        cotizacionDB.setUtilidadMateriales(cotizacion.getUtilidadMateriales());
        return iCotizacionService.save(cotizacionDB);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        iCotizacionService.deleteById(id);
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
