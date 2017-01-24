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
@Table(name = "continentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Continentes.findAll", query = "SELECT c FROM Continentes c")
    , @NamedQuery(name = "Continentes.findByIdContinente", query = "SELECT c FROM Continentes c WHERE c.idContinente = :idContinente")
    , @NamedQuery(name = "Continentes.findByNombreContinente", query = "SELECT c FROM Continentes c WHERE c.nombreContinente = :nombreContinente")})
public class Continentes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idContinente")
    private Integer idContinente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombreContinente")
    private String nombreContinente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContinente")
    private Collection<Paises> paisesCollection;

    public Continentes() {
    }

    public Continentes(Integer idContinente) {
        this.idContinente = idContinente;
    }

    public Continentes(Integer idContinente, String nombreContinente) {
        this.idContinente = idContinente;
        this.nombreContinente = nombreContinente;
    }

    public Integer getIdContinente() {
        return idContinente;
    }

    public void setIdContinente(Integer idContinente) {
        this.idContinente = idContinente;
    }

    public String getNombreContinente() {
        return nombreContinente;
    }

    public void setNombreContinente(String nombreContinente) {
        this.nombreContinente = nombreContinente;
    }

    @XmlTransient
    public Collection<Paises> getPaisesCollection() {
        return paisesCollection;
    }

    public void setPaisesCollection(Collection<Paises> paisesCollection) {
        this.paisesCollection = paisesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContinente != null ? idContinente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Continentes)) {
            return false;
        }
        Continentes other = (Continentes) object;
        if ((this.idContinente == null && other.idContinente != null) || (this.idContinente != null && !this.idContinente.equals(other.idContinente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Continentes[ idContinente=" + idContinente + " ]";
    }
    
}
