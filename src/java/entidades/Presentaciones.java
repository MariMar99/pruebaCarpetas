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
@Table(name = "presentaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presentaciones.findAll", query = "SELECT p FROM Presentaciones p")
    , @NamedQuery(name = "Presentaciones.findByIdPresentacion", query = "SELECT p FROM Presentaciones p WHERE p.idPresentacion = :idPresentacion")
    , @NamedQuery(name = "Presentaciones.findByPresentacion", query = "SELECT p FROM Presentaciones p WHERE p.presentacion = :presentacion")})
public class Presentaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPresentacion")
    private Integer idPresentacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "presentacion")
    private String presentacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPresentacion")
    private Collection<Productos> productosCollection;

    public Presentaciones() {
    }

    public Presentaciones(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public Presentaciones(Integer idPresentacion, String presentacion) {
        this.idPresentacion = idPresentacion;
        this.presentacion = presentacion;
    }

    public Integer getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    @XmlTransient
    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresentacion != null ? idPresentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presentaciones)) {
            return false;
        }
        Presentaciones other = (Presentaciones) object;
        if ((this.idPresentacion == null && other.idPresentacion != null) || (this.idPresentacion != null && !this.idPresentacion.equals(other.idPresentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Presentaciones[ idPresentacion=" + idPresentacion + " ]";
    }
    
}
