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
@Table(name = "estadosclientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadosclientes.findAll", query = "SELECT e FROM Estadosclientes e")
    , @NamedQuery(name = "Estadosclientes.findByIdEstadoCliente", query = "SELECT e FROM Estadosclientes e WHERE e.idEstadoCliente = :idEstadoCliente")
    , @NamedQuery(name = "Estadosclientes.findByNombreEstadoCliente", query = "SELECT e FROM Estadosclientes e WHERE e.nombreEstadoCliente = :nombreEstadoCliente")})
public class Estadosclientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstadoCliente")
    private Integer idEstadoCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreEstadoCliente")
    private String nombreEstadoCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoCliente")
    private Collection<Clientes> clientesCollection;

    public Estadosclientes() {
    }

    public Estadosclientes(Integer idEstadoCliente) {
        this.idEstadoCliente = idEstadoCliente;
    }

    public Estadosclientes(Integer idEstadoCliente, String nombreEstadoCliente) {
        this.idEstadoCliente = idEstadoCliente;
        this.nombreEstadoCliente = nombreEstadoCliente;
    }

    public Integer getIdEstadoCliente() {
        return idEstadoCliente;
    }

    public void setIdEstadoCliente(Integer idEstadoCliente) {
        this.idEstadoCliente = idEstadoCliente;
    }

    public String getNombreEstadoCliente() {
        return nombreEstadoCliente;
    }

    public void setNombreEstadoCliente(String nombreEstadoCliente) {
        this.nombreEstadoCliente = nombreEstadoCliente;
    }

    @XmlTransient
    public Collection<Clientes> getClientesCollection() {
        return clientesCollection;
    }

    public void setClientesCollection(Collection<Clientes> clientesCollection) {
        this.clientesCollection = clientesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoCliente != null ? idEstadoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadosclientes)) {
            return false;
        }
        Estadosclientes other = (Estadosclientes) object;
        if ((this.idEstadoCliente == null && other.idEstadoCliente != null) || (this.idEstadoCliente != null && !this.idEstadoCliente.equals(other.idEstadoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Estadosclientes[ idEstadoCliente=" + idEstadoCliente + " ]";
    }
    
}
