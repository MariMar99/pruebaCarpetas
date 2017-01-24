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
@Table(name = "inconterms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inconterms.findAll", query = "SELECT i FROM Inconterms i")
    , @NamedQuery(name = "Inconterms.findByIdInconterm", query = "SELECT i FROM Inconterms i WHERE i.idInconterm = :idInconterm")
    , @NamedQuery(name = "Inconterms.findByInconterm", query = "SELECT i FROM Inconterms i WHERE i.inconterm = :inconterm")
    , @NamedQuery(name = "Inconterms.findByDescripcion", query = "SELECT i FROM Inconterms i WHERE i.descripcion = :descripcion")})
public class Inconterms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInconterm")
    private Integer idInconterm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "INCONTERM")
    private String inconterm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInconterm")
    private Collection<Pedidos> pedidosCollection;

    public Inconterms() {
    }

    public Inconterms(Integer idInconterm) {
        this.idInconterm = idInconterm;
    }

    public Inconterms(Integer idInconterm, String inconterm, String descripcion) {
        this.idInconterm = idInconterm;
        this.inconterm = inconterm;
        this.descripcion = descripcion;
    }

    public Integer getIdInconterm() {
        return idInconterm;
    }

    public void setIdInconterm(Integer idInconterm) {
        this.idInconterm = idInconterm;
    }

    public String getInconterm() {
        return inconterm;
    }

    public void setInconterm(String inconterm) {
        this.inconterm = inconterm;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idInconterm != null ? idInconterm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inconterms)) {
            return false;
        }
        Inconterms other = (Inconterms) object;
        if ((this.idInconterm == null && other.idInconterm != null) || (this.idInconterm != null && !this.idInconterm.equals(other.idInconterm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Inconterms[ idInconterm=" + idInconterm + " ]";
    }
    
}
