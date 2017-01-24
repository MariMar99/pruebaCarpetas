/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mariana
 */
@Entity
@Table(name = "estadospedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadospedidos.findAll", query = "SELECT e FROM Estadospedidos e")
    , @NamedQuery(name = "Estadospedidos.findByIdEstadoPedido", query = "SELECT e FROM Estadospedidos e WHERE e.idEstadoPedido = :idEstadoPedido")
    , @NamedQuery(name = "Estadospedidos.findByNombreEstadoPedido", query = "SELECT e FROM Estadospedidos e WHERE e.nombreEstadoPedido = :nombreEstadoPedido")})
public class Estadospedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstadoPedido")
    private Integer idEstadoPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreEstadoPedido")
    private String nombreEstadoPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoPedido")
    private Collection<Pedidos> pedidosCollection;

    public Estadospedidos() {
    }

    public Estadospedidos(Integer idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public Estadospedidos(Integer idEstadoPedido, String nombreEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
        this.nombreEstadoPedido = nombreEstadoPedido;
    }

    public Integer getIdEstadoPedido() {
        return idEstadoPedido;
    }

    public void setIdEstadoPedido(Integer idEstadoPedido) {
        this.idEstadoPedido = idEstadoPedido;
    }

    public String getNombreEstadoPedido() {
        return nombreEstadoPedido;
    }

    public void setNombreEstadoPedido(String nombreEstadoPedido) {
        this.nombreEstadoPedido = nombreEstadoPedido;
    }

    @XmlTransient
    public Collection<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(Collection<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPedido != null ? idEstadoPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadospedidos)) {
            return false;
        }
        Estadospedidos other = (Estadospedidos) object;
        if ((this.idEstadoPedido == null && other.idEstadoPedido != null) || (this.idEstadoPedido != null && !this.idEstadoPedido.equals(other.idEstadoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Estadospedidos[ idEstadoPedido=" + idEstadoPedido + " ]";
    }
    
}
