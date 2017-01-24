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
@Table(name = "tipostransportes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipostransportes.findAll", query = "SELECT t FROM Tipostransportes t")
    , @NamedQuery(name = "Tipostransportes.findByIdTipoTransporte", query = "SELECT t FROM Tipostransportes t WHERE t.idTipoTransporte = :idTipoTransporte")
    , @NamedQuery(name = "Tipostransportes.findByNombreTipoTransporte", query = "SELECT t FROM Tipostransportes t WHERE t.nombreTipoTransporte = :nombreTipoTransporte")})
public class Tipostransportes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTipoTransporte")
    private Integer idTipoTransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombreTipoTransporte")
    private String nombreTipoTransporte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoTransporte")
    private Collection<Empresastransportes> empresastransportesCollection;

    public Tipostransportes() {
    }

    public Tipostransportes(Integer idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public Tipostransportes(Integer idTipoTransporte, String nombreTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
        this.nombreTipoTransporte = nombreTipoTransporte;
    }

    public Integer getIdTipoTransporte() {
        return idTipoTransporte;
    }

    public void setIdTipoTransporte(Integer idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    public String getNombreTipoTransporte() {
        return nombreTipoTransporte;
    }

    public void setNombreTipoTransporte(String nombreTipoTransporte) {
        this.nombreTipoTransporte = nombreTipoTransporte;
    }

    @XmlTransient
    public Collection<Empresastransportes> getEmpresastransportesCollection() {
        return empresastransportesCollection;
    }

    public void setEmpresastransportesCollection(Collection<Empresastransportes> empresastransportesCollection) {
        this.empresastransportesCollection = empresastransportesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoTransporte != null ? idTipoTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipostransportes)) {
            return false;
        }
        Tipostransportes other = (Tipostransportes) object;
        if ((this.idTipoTransporte == null && other.idTipoTransporte != null) || (this.idTipoTransporte != null && !this.idTipoTransporte.equals(other.idTipoTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tipostransportes[ idTipoTransporte=" + idTipoTransporte + " ]";
    }
    
}
