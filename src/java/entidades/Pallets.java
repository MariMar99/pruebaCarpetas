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
@Table(name = "pallets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pallets.findAll", query = "SELECT p FROM Pallets p")
    , @NamedQuery(name = "Pallets.findByIdPallet", query = "SELECT p FROM Pallets p WHERE p.idPallet = :idPallet")
    , @NamedQuery(name = "Pallets.findByPalletStandar", query = "SELECT p FROM Pallets p WHERE p.palletStandar = :palletStandar")})
public class Pallets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPallet")
    private Integer idPallet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "palletStandar")
    private String palletStandar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPallet")
    private Collection<Detallespedidos> detallespedidosCollection;

    public Pallets() {
    }

    public Pallets(Integer idPallet) {
        this.idPallet = idPallet;
    }

    public Pallets(Integer idPallet, String palletStandar) {
        this.idPallet = idPallet;
        this.palletStandar = palletStandar;
    }

    public Integer getIdPallet() {
        return idPallet;
    }

    public void setIdPallet(Integer idPallet) {
        this.idPallet = idPallet;
    }

    public String getPalletStandar() {
        return palletStandar;
    }

    public void setPalletStandar(String palletStandar) {
        this.palletStandar = palletStandar;
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
        hash += (idPallet != null ? idPallet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pallets)) {
            return false;
        }
        Pallets other = (Pallets) object;
        if ((this.idPallet == null && other.idPallet != null) || (this.idPallet != null && !this.idPallet.equals(other.idPallet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Pallets[ idPallet=" + idPallet + " ]";
    }
    
}
