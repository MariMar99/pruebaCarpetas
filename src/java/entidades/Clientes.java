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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByIdClienteUsuario", query = "SELECT c FROM Clientes c WHERE c.idClienteUsuario = :idClienteUsuario")
    , @NamedQuery(name = "Clientes.findByNombreEmpresa", query = "SELECT c FROM Clientes c WHERE c.nombreEmpresa = :nombreEmpresa")
    , @NamedQuery(name = "Clientes.findBySigla", query = "SELECT c FROM Clientes c WHERE c.sigla = :sigla")
    , @NamedQuery(name = "Clientes.findByNumeroLegal", query = "SELECT c FROM Clientes c WHERE c.numeroLegal = :numeroLegal")
    , @NamedQuery(name = "Clientes.findByCodPostal", query = "SELECT c FROM Clientes c WHERE c.codPostal = :codPostal")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idClienteUsuario")
    private Integer idClienteUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sigla")
    private String sigla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroLegal")
    private long numeroLegal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codPostal")
    private String codPostal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<Pedidos> pedidosCollection;
    @JoinColumn(name = "idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false)
    private Ciudad idCiudad;
    @JoinColumn(name = "idEstadoCliente", referencedColumnName = "idEstadoCliente")
    @ManyToOne(optional = false)
    private Estadosclientes idEstadoCliente;
    @JoinColumn(name = "idClienteUsuario", referencedColumnName = "idUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuarios usuarios;

    public Clientes() {
    }

    public Clientes(Integer idClienteUsuario) {
        this.idClienteUsuario = idClienteUsuario;
    }

    public Clientes(Integer idClienteUsuario, String nombreEmpresa, String sigla, long numeroLegal, String codPostal) {
        this.idClienteUsuario = idClienteUsuario;
        this.nombreEmpresa = nombreEmpresa;
        this.sigla = sigla;
        this.numeroLegal = numeroLegal;
        this.codPostal = codPostal;
    }

    public Integer getIdClienteUsuario() {
        return idClienteUsuario;
    }

    public void setIdClienteUsuario(Integer idClienteUsuario) {
        this.idClienteUsuario = idClienteUsuario;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public long getNumeroLegal() {
        return numeroLegal;
    }

    public void setNumeroLegal(long numeroLegal) {
        this.numeroLegal = numeroLegal;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    @XmlTransient
    public Collection<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(Collection<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Estadosclientes getIdEstadoCliente() {
        return idEstadoCliente;
    }

    public void setIdEstadoCliente(Estadosclientes idEstadoCliente) {
        this.idEstadoCliente = idEstadoCliente;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteUsuario != null ? idClienteUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idClienteUsuario == null && other.idClienteUsuario != null) || (this.idClienteUsuario != null && !this.idClienteUsuario.equals(other.idClienteUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Clientes[ idClienteUsuario=" + idClienteUsuario + " ]";
    }
    
}
