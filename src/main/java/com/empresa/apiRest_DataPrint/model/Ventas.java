package com.empresa.apiRest_DataPrint.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@Entity
@Table(name = "ventas")
public class Ventas implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idventas")
    private Long idventas;

    @Column(name = "precioTotal")
    private double precioTotal;

    @Column(name = "fecvent")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecvent;
    
    @ManyToOne
    @JoinColumn(name="pago_id")
    private Pagos pago;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuarios usuarios;

    @OneToMany(mappedBy = "venta",cascade=CascadeType.ALL)
    @JsonIgnoreProperties("venta")
    private List<DetalleVenta> detalleVentas = new ArrayList<>();

    public void agregarDetalleVenta(DetalleVenta detalleVenta){
        detalleVentas.add(detalleVenta);
    }
}
