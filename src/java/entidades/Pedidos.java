/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mariana
 */
@Entity
@Table(name = "pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")
    , @NamedQuery(name = "Pedidos.findByIdPedido", query = "SELECT p FROM Pedidos p WHERE p.idPedido = :idPedido")
    , @NamedQuery(name = "Pedidos.findByFechaPedido", query = "SELECT p FROM Pedidos p WHERE p.fechaPedido = :fechaPedido")
    , @NamedQuery(name = "Pedidos.findByFechaEntrega", query = "SELECT p FROM Pedidos p WHERE p.fechaEntrega = :fechaEntrega")})
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPedido")
    private Integer idPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaPedido")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaEntrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "idAntinarcoticos", referencedColumnName = "idAntinarcoticos")
    @ManyToOne(optional = false)
    private Antinarcoticos idAntinarcoticos;
    @JoinColumn(name = "idCliente", referencedColumnName = "idClienteUsuario")
    @ManyToOne(optional = false)
    private Clientes idCliente;
    @JoinColumn(name = "idEstadoPedido", referencedColumnName = "idEstadoPedido")
    @ManyToOne(optional = false)
    private Estadospedidos idEstadoPedido;
    @JoinColumn(name = "idInconterm", referencedColumnName = "idInconterm")
    @ManyToOne(optional = false)
    private Inconterms idInconterm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido")
    private Collection<Transportes> transportesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido")
    private Collection<Detallespedidos> detallespedidosCollection;

    public Pedidos() {
    }

    public Pedidos(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedidos(Integer idPedido, Date fechaPedido, Date fechaEntrega) {
        this.idPedido = idPedido;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Antinarcoticos getIdAntinarcoticos() {
        return idAntinarcoticos;
    }

    public void setIdAntinarcoticos(Antinarcoticos idAntinarcoticos) {
        this.idAntinarcoticos = idAntinarcoticos;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    public Estadospedidos getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(Estadospedidos idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public Inconterms getIdInconterm() {
        return idInconterm;
    }

    public void setIdInconterm(Inconterms idInconterm) {
        this.idInconterm = idInconterm;
    }

    @XmlTransient
    public Collection<Transportes> getTransportesCollection() {
        return transportesCollection;
    }

    public void setTransportesCollection(Collection<Transportes> transportesCollection) {
        this.transportesCollection = transportesCollection;
    }

    @XmlTransient
    public Collection<Detallespedidos> getDetallespedidosCollection() {
        return detallespedidosCollection;
    }

    public void setDetallespedidosCollection(Collection<Detallespedidos> detallespedidosCollection) {
        this.detallespedidosCollection = detallespedidosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Pedidos[ idPedido=" + idPedido + " ]";
    }
    
}
