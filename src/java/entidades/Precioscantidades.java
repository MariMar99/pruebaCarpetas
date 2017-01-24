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
@Table(name = "precioscantidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Precioscantidades.findAll", query = "SELECT p FROM Precioscantidades p")
    , @NamedQuery(name = "Precioscantidades.findByIdPrecioCantidad", query = "SELECT p FROM Precioscantidades p WHERE p.idPrecioCantidad = :idPrecioCantidad")
    , @NamedQuery(name = "Precioscantidades.findByPeso", query = "SELECT p FROM Precioscantidades p WHERE p.peso = :peso")
    , @NamedQuery(name = "Precioscantidades.findByCosto", query = "SELECT p FROM Precioscantidades p WHERE p.costo = :costo")})
public class Precioscantidades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPrecioCantidad")
    private Integer idPrecioCantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "peso")
    private String peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private int costo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPrecioCantidad")
    private Collection<Productos> productosCollection;

    public Precioscantidades() {
    }

    public Precioscantidades(Integer idPrecioCantidad) {
        this.idPrecioCantidad = idPrecioCantidad;
    }

    public Precioscantidades(Integer idPrecioCantidad, String peso, int costo) {
        this.idPrecioCantidad = idPrecioCantidad;
        this.peso = peso;
        this.costo = costo;
    }

    public Integer getIdPrecioCantidad() {
        return idPrecioCantidad;
    }

    public void setIdPrecioCantidad(Integer idPrecioCantidad) {
        this.idPrecioCantidad = idPrecioCantidad;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
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
        hash += (idPrecioCantidad != null ? idPrecioCantidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Precioscantidades)) {
            return false;
        }
        Precioscantidades other = (Precioscantidades) object;
        if ((this.idPrecioCantidad == null && other.idPrecioCantidad != null) || (this.idPrecioCantidad != null && !this.idPrecioCantidad.equals(other.idPrecioCantidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Precioscantidades[ idPrecioCantidad=" + idPrecioCantidad + " ]";
    }
    
}
