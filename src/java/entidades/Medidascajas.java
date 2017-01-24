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
@Table(name = "medidascajas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medidascajas.findAll", query = "SELECT m FROM Medidascajas m")
    , @NamedQuery(name = "Medidascajas.findByIdMedidaCaja", query = "SELECT m FROM Medidascajas m WHERE m.idMedidaCaja = :idMedidaCaja")
    , @NamedQuery(name = "Medidascajas.findByMedidaCaja", query = "SELECT m FROM Medidascajas m WHERE m.medidaCaja = :medidaCaja")})
public class Medidascajas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMedidaCaja")
    private Integer idMedidaCaja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "medidaCaja")
    private String medidaCaja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedidaCaja")
    private Collection<Tiposempaques> tiposempaquesCollection;

    public Medidascajas() {
    }

    public Medidascajas(Integer idMedidaCaja) {
        this.idMedidaCaja = idMedidaCaja;
    }

    public Medidascajas(Integer idMedidaCaja, String medidaCaja) {
        this.idMedidaCaja = idMedidaCaja;
        this.medidaCaja = medidaCaja;
    }

    public Integer getIdMedidaCaja() {
        return idMedidaCaja;
    }

    public void setIdMedidaCaja(Integer idMedidaCaja) {
        this.idMedidaCaja = idMedidaCaja;
    }

    public String getMedidaCaja() {
        return medidaCaja;
    }

    public void setMedidaCaja(String medidaCaja) {
        this.medidaCaja = medidaCaja;
    }

    @XmlTransient
    public Collection<Tiposempaques> getTiposempaquesCollection() {
        return tiposempaquesCollection;
    }

    public void setTiposempaquesCollection(Collection<Tiposempaques> tiposempaquesCollection) {
        this.tiposempaquesCollection = tiposempaquesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedidaCaja != null ? idMedidaCaja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medidascajas)) {
            return false;
        }
        Medidascajas other = (Medidascajas) object;
        if ((this.idMedidaCaja == null && other.idMedidaCaja != null) || (this.idMedidaCaja != null && !this.idMedidaCaja.equals(other.idMedidaCaja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Medidascajas[ idMedidaCaja=" + idMedidaCaja + " ]";
    }
    
}
