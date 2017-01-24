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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permisos.findAll", query = "SELECT p FROM Permisos p")
    , @NamedQuery(name = "Permisos.findByIdPermiso", query = "SELECT p FROM Permisos p WHERE p.idPermiso = :idPermiso")
    , @NamedQuery(name = "Permisos.findByNombrePermiso", query = "SELECT p FROM Permisos p WHERE p.nombrePermiso = :nombrePermiso")
    , @NamedQuery(name = "Permisos.findByDescripcionPermiso", query = "SELECT p FROM Permisos p WHERE p.descripcionPermiso = :descripcionPermiso")
    , @NamedQuery(name = "Permisos.findByEstado", query = "SELECT p FROM Permisos p WHERE p.estado = :estado")
    , @NamedQuery(name = "Permisos.findByUrl", query = "SELECT p FROM Permisos p WHERE p.url = :url")
    , @NamedQuery(name = "Permisos.findByTipoMenu", query = "SELECT p FROM Permisos p WHERE p.tipoMenu = :tipoMenu")})
public class Permisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPermiso")
    private Integer idPermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombrePermiso")
    private String nombrePermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcionPermiso")
    private String descripcionPermiso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tipoMenu")
    private String tipoMenu;
    @JoinTable(name = "permisosroles", joinColumns = {
        @JoinColumn(name = "idPermiso", referencedColumnName = "idPermiso")}, inverseJoinColumns = {
        @JoinColumn(name = "idRol", referencedColumnName = "idRol")})
    @ManyToMany
    private Collection<Roles> rolesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "permisoPadre")
    private Collection<Permisos> permisosCollection;
    @JoinColumn(name = "permisoPadre", referencedColumnName = "idPermiso")
    @ManyToOne(optional = false)
    private Permisos permisoPadre;

    public Permisos() {
    }

    public Permisos(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Permisos(Integer idPermiso, String nombrePermiso, String descripcionPermiso, boolean estado, String url, String tipoMenu) {
        this.idPermiso = idPermiso;
        this.nombrePermiso = nombrePermiso;
        this.descripcionPermiso = descripcionPermiso;
        this.estado = estado;
        this.url = url;
        this.tipoMenu = tipoMenu;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getDescripcionPermiso() {
        return descripcionPermiso;
    }

    public void setDescripcionPermiso(String descripcionPermiso) {
        this.descripcionPermiso = descripcionPermiso;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    @XmlTransient
    public Collection<Roles> getRolesCollection() {
        return rolesCollection;
    }

    public void setRolesCollection(Collection<Roles> rolesCollection) {
        this.rolesCollection = rolesCollection;
    }

    @XmlTransient
    public Collection<Permisos> getPermisosCollection() {
        return permisosCollection;
    }

    public void setPermisosCollection(Collection<Permisos> permisosCollection) {
        this.permisosCollection = permisosCollection;
    }

    public Permisos getPermisoPadre() {
        return permisoPadre;
    }

    public void setPermisoPadre(Permisos permisoPadre) {
        this.permisoPadre = permisoPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermiso != null ? idPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Permisos[ idPermiso=" + idPermiso + " ]";
    }
    
}
