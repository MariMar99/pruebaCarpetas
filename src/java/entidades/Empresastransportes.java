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
@Table(name = "empresastransportes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresastransportes.findAll", query = "SELECT e FROM Empresastransportes e")
    , @NamedQuery(name = "Empresastransportes.findByIdEmpresaTransporte", query = "SELECT e FROM Empresastransportes e WHERE e.idEmpresaTransporte = :idEmpresaTransporte")
    , @NamedQuery(name = "Empresastransportes.findByNombreEmpresa", query = "SELECT e FROM Empresastransportes e WHERE e.nombreEmpresa = :nombreEmpresa")
    , @NamedQuery(name = "Empresastransportes.findByTelefono", query = "SELECT e FROM Empresastransportes e WHERE e.telefono = :telefono")})
public class Empresastransportes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEmpresaTransporte")
    private Integer idEmpresaTransporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @JoinColumn(name = "idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false)
    private Ciudad idCiudad;
    @JoinColumn(name = "idTipoTransporte", referencedColumnName = "idTipoTransporte")
    @ManyToOne(optional = false)
    private Tipostransportes idTipoTransporte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEmpresaTransporte")
    private Collection<Transportes> transportesCollection;

    public Empresastransportes() {
    }

    public Empresastransportes(Integer idEmpresaTransporte) {
        this.idEmpresaTransporte = idEmpresaTransporte;
    }

    public Empresastransportes(Integer idEmpresaTransporte, String nombreEmpresa, int telefono) {
        this.idEmpresaTransporte = idEmpresaTransporte;
        this.nombreEmpresa = nombreEmpresa;
        this.telefono = telefono;
    }

    public Integer getIdEmpresaTransporte() {
        return idEmpresaTransporte;
    }

    public void setIdEmpresaTransporte(Integer idEmpresaTransporte) {
        this.idEmpresaTransporte = idEmpresaTransporte;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Tipostransportes getIdTipoTransporte() {
        return idTipoTransporte;
    }

    public void setIdTipoTransporte(Tipostransportes idTipoTransporte) {
        this.idTipoTransporte = idTipoTransporte;
    }

    @XmlTransient
    public Collection<Transportes> getTransportesCollection() {
        return transportesCollection;
    }

    public void setTransportesCollection(Collection<Transportes> transportesCollection) {
        this.transportesCollection = transportesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpresaTransporte != null ? idEmpresaTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresastransportes)) {
            return false;
        }
        Empresastransportes other = (Empresastransportes) object;
        if ((this.idEmpresaTransporte == null && other.idEmpresaTransporte != null) || (this.idEmpresaTransporte != null && !this.idEmpresaTransporte.equals(other.idEmpresaTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Empresastransportes[ idEmpresaTransporte=" + idEmpresaTransporte + " ]";
    }
    
}
