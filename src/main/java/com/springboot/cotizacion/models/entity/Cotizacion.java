package com.springboot.cotizacion.models.entity;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Cotizacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;

    @OneToMany
    private List<LineaEquipos> listaEquipos;

    @OneToMany
    private List<LineaMateriales> listaMateriales;

    @OneToMany
    private List<LineaOtros> listaOtros;

    @OneToMany
    private List<LineaManoObra> listaManoObra;

    @Column(nullable = false)
    private Date fecha;

    private float subTotal;
    private float totalIgv;

    private float precioEquipos;
    private float precioMateriales;
    private float precioOtros;
    private float precioManoObra;
    private float utilidadEquipos;
    private float utilidadMateriales;

    public Cotizacion(Long id, Cliente cliente, Usuario usuario, List<LineaEquipos> listaEquipos, List<LineaMateriales> listaMateriales, List<LineaOtros> listaOtros, List<LineaManoObra> listaManoObra, Date fecha, float subTotal, float totalIgv, float precioEquipos, float precioMateriales, float precioOtros, float precioManoObra, float utilidadEquipos, float utilidadMateriales) {
        super();
        this.id = id;
        this.cliente = cliente;
        this.usuario = usuario;
        this.listaEquipos = listaEquipos;
        this.listaMateriales = listaMateriales;
        this.listaOtros = listaOtros;
        this.listaManoObra = listaManoObra;
        this.fecha = fecha;
        this.subTotal = subTotal;
        this.totalIgv = totalIgv;
        this.precioEquipos = precioEquipos;
        this.precioMateriales = precioMateriales;
        this.precioOtros = precioOtros;
        this.precioManoObra = precioManoObra;
        this.utilidadEquipos = utilidadEquipos;
        this.utilidadMateriales = utilidadMateriales;
    }

    public Cotizacion() {

    }


    //FUNCTIONS

    private float calcularTotalEquipos(){
        float precioTE=0;
        for (LineaEquipos lineaEquipos :listaEquipos) {
            precioTE+=lineaEquipos.getEquipo().getPrecioVenta();
        }
        return precioTE;
    }
    private float calcularTotalMateriales(){
        float precioTM=0;
        for (LineaMateriales lineaMateriales :listaMateriales) {
            precioTM+=lineaMateriales.getMaterial().getPrecioVenta();
        }
        return precioTM;
    }
    private float calcularTotalManoObra(){
        float precioMo=0;
        for (LineaManoObra lineaManoObra :listaManoObra) {
            precioMo+=lineaManoObra.getManoDeObra().getPrecioVenta();
        }
        return precioMo;
    }

    private float calcularTotalOtros(){
        float precioOt=0;
        for (LineaOtros lineaOtros :listaOtros) {
            precioOt+=lineaOtros.getOtro().getPrecioVenta();
        }
        return precioOt;
    }

    @PrePersist
    private void prePersist(){
        precioEquipos=calcularTotalEquipos();
        precioMateriales=calcularTotalMateriales();
        precioManoObra=calcularTotalManoObra();
        precioOtros=calcularTotalOtros();
        subTotal=precioEquipos+precioManoObra+precioMateriales+precioOtros;
        totalIgv= (float) (subTotal*1.18);
    }

    //GETTER AND SETTER
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getTotalIgv() {
        return totalIgv;
    }

    public void setTotalIgv(float totalIgv) {
        this.totalIgv = totalIgv;
    }

    public float getPrecioEquipos() {
        return precioEquipos;
    }

    public void setPrecioEquipos(float precioEquipos) {
        this.precioEquipos = precioEquipos;
    }

    public float getPrecioMateriales() {
        return precioMateriales;
    }

    public void setPrecioMateriales(float precioMateriales) {
        this.precioMateriales = precioMateriales;
    }

    public float getPrecioOtros() {
        return precioOtros;
    }

    public void setPrecioOtros(float precioOtros) {
        this.precioOtros = precioOtros;
    }

    public float getUtilidadEquipos() {
        return utilidadEquipos;
    }

    public void setUtilidadEquipos(float utilidadEquipos) {
        this.utilidadEquipos = utilidadEquipos;
    }

    public float getUtilidadMateriales() {
        return utilidadMateriales;
    }

    public void setUtilidadMateriales(float utilidadMateriales) {
        this.utilidadMateriales = utilidadMateriales;
    }

    public List<LineaEquipos> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<LineaEquipos> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public List<LineaMateriales> getListaMateriales() {
        return listaMateriales;
    }

    public void setListaMateriales(List<LineaMateriales> listaMateriales) {
        this.listaMateriales = listaMateriales;
    }

    public List<LineaManoObra> getListaManoObra() {
        return listaManoObra;
    }

    public void setListaManoObra(List<LineaManoObra> listaManoObra) {
        this.listaManoObra = listaManoObra;
    }

    public float getPrecioManoObra() {
        return precioManoObra;
    }

    public void setPrecioManoObra(float precioManoObra) {
        this.precioManoObra = precioManoObra;
    }
}
