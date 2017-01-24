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
@Table(name = "estadosantinarcoticos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadosantinarcoticos.findAll", query = "SELECT e FROM Estadosantinarcoticos e")
    , @NamedQuery(name = "Estadosantinarcoticos.findByIdEstadoAntinarcoticos", query = "SELECT e FROM Estadosantinarcoticos e WHERE e.idEstadoAntinarcoticos = :idEstadoAntinarcoticos")
    , @NamedQuery(name = "Estadosantinarcoticos.findByNombreEstadoAntinarcoticos", query = "SELECT e FROM Estadosantinarcoticos e WHERE e.nombreEstadoAntinarcoticos = :nombreEstadoAntinarcoticos")})
public class Estadosantinarcoticos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstadoAntinarcoticos")
    private Integer idEstadoAntinarcoticos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreEstadoAntinarcoticos")
    private String nombreEstadoAntinarcoticos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoAnti")
    private Collection<Antinarcoticos> antinarcoticosCollection;

    public Estadosantinarcoticos() {
    }

    public Estadosantinarcoticos(Integer idEstadoAntinarcoticos) {
        this.idEstadoAntinarcoticos = idEstadoAntinarcoticos;
    }

    public Estadosantinarcoticos(Integer idEstadoAntinarcoticos, String nombreEstadoAntinarcoticos) {
        this.idEstadoAntinarcoticos = idEstadoAntinarcoticos;
        this.nombreEstadoAntinarcoticos = nombreEstadoAntinarcoticos;
    }

    public Integer getIdEstadoAntinarcoticos() {
        return idEstadoAntinarcoticos;
    }

    public void setIdEstadoAntinarcoticos(Integer idEstadoAntinarcoticos) {
        this.idEstadoAntinarcoticos = idEstadoAntinarcoticos;
    }

    public String getNombreEstadoAntinarcoticos() {
        return nombreEstadoAntinarcoticos;
    }

    public void setNombreEstadoAntinarcoticos(String nombreEstadoAntinarcoticos) {
        this.nombreEstadoAntinarcoticos = nombreEstadoAntinarcoticos;
    }

    @XmlTransient
    public Collection<Antinarcoticos> getAntinarcoticosCollection() {
        return antinarcoticosCollection;
    }

    public void setAntinarcoticosCollection(Collection<Antinarcoticos> antinarcoticosCollection) {
        this.antinarcoticosCollection = antinarcoticosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoAntinarcoticos != null ? idEstadoAntinarcoticos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadosantinarcoticos)) {
            return false;
        }
        Estadosantinarcoticos other = (Estadosantinarcoticos) object;
        if ((this.idEstadoAntinarcoticos == null && other.idEstadoAntinarcoticos != null) || (this.idEstadoAntinarcoticos != null && !this.idEstadoAntinarcoticos.equals(other.idEstadoAntinarcoticos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Estadosantinarcoticos[ idEstadoAntinarcoticos=" + idEstadoAntinarcoticos + " ]";
    }
    
}
