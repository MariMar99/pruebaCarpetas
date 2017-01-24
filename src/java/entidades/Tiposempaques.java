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
@Table(name = "tiposempaques")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposempaques.findAll", query = "SELECT t FROM Tiposempaques t")
    , @NamedQuery(name = "Tiposempaques.findByIdTipoEmpaque", query = "SELECT t FROM Tiposempaques t WHERE t.idTipoEmpaque = :idTipoEmpaque")
    , @NamedQuery(name = "Tiposempaques.findByMarcaCaja", query = "SELECT t FROM Tiposempaques t WHERE t.marcaCaja = :marcaCaja")})
public class Tiposempaques implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTipoEmpaque")
    private Integer idTipoEmpaque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "marcaCaja")
    private String marcaCaja;
    @JoinColumn(name = "idMedidaCaja", referencedColumnName = "idMedidaCaja")
    @ManyToOne(optional = false)
    private Medidascajas idMedidaCaja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEmpaque")
    private Collection<Detallespedidos> detallespedidosCollection;

    public Tiposempaques() {
    }

    public Tiposempaques(Integer idTipoEmpaque) {
        this.idTipoEmpaque = idTipoEmpaque;
    }

    public Tiposempaques(Integer idTipoEmpaque, String marcaCaja) {
        this.idTipoEmpaque = idTipoEmpaque;
        this.marcaCaja = marcaCaja;
    }

    public Integer getIdTipoEmpaque() {
        return idTipoEmpaque;
    }

    public void setIdTipoEmpaque(Integer idTipoEmpaque) {
        this.idTipoEmpaque = idTipoEmpaque;
    }

    public String getMarcaCaja() {
        return marcaCaja;
    }

    public void setMarcaCaja(String marcaCaja) {
        this.marcaCaja = marcaCaja;
    }

    public Medidascajas getIdMedidaCaja() {
        return idMedidaCaja;
    }

    public void setIdMedidaCaja(Medidascajas idMedidaCaja) {
        this.idMedidaCaja = idMedidaCaja;
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
        hash += (idTipoEmpaque != null ? idTipoEmpaque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposempaques)) {
            return false;
        }
        Tiposempaques other = (Tiposempaques) object;
        if ((this.idTipoEmpaque == null && other.idTipoEmpaque != null) || (this.idTipoEmpaque != null && !this.idTipoEmpaque.equals(other.idTipoEmpaque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tiposempaques[ idTipoEmpaque=" + idTipoEmpaque + " ]";
    }
    
}
