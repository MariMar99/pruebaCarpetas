/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mariana
 */
@Entity
@Table(name = "transportes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transportes.findAll", query = "SELECT t FROM Transportes t")
    , @NamedQuery(name = "Transportes.findByIdTransporte", query = "SELECT t FROM Transportes t WHERE t.idTransporte = :idTransporte")
    , @NamedQuery(name = "Transportes.findByFechaArribo", query = "SELECT t FROM Transportes t WHERE t.fechaArribo = :fechaArribo")})
public class Transportes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idTransporte")
    private Integer idTransporte;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaArribo")
    @Temporal(TemporalType.DATE)
    private Date fechaArribo;
    @JoinColumn(name = "idEmpresaTransporte", referencedColumnName = "idEmpresaTransporte")
    @ManyToOne(optional = false)
    private Empresastransportes idEmpresaTransporte;
    @JoinColumn(name = "idPedido", referencedColumnName = "idPedido")
    @ManyToOne(optional = false)
    private Pedidos idPedido;
    @JoinColumn(name = "idUsuarioTransportador", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuarios idUsuarioTransportador;

    public Transportes() {
    }

    public Transportes(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public Transportes(Integer idTransporte, Date fechaArribo) {
        this.idTransporte = idTransporte;
        this.fechaArribo = fechaArribo;
    }

    public Integer getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(Integer idTransporte) {
        this.idTransporte = idTransporte;
    }

    public Date getFechaArribo() {
        return fechaArribo;
    }

    public void setFechaArribo(Date fechaArribo) {
        this.fechaArribo = fechaArribo;
    }

    public Empresastransportes getIdEmpresaTransporte() {
        return idEmpresaTransporte;
    }

    public void setIdEmpresaTransporte(Empresastransportes idEmpresaTransporte) {
        this.idEmpresaTransporte = idEmpresaTransporte;
    }

    public Pedidos getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedidos idPedido) {
        this.idPedido = idPedido;
    }

    public Usuarios getIdUsuarioTransportador() {
        return idUsuarioTransportador;
    }

    public void setIdUsuarioTransportador(Usuarios idUsuarioTransportador) {
        this.idUsuarioTransportador = idUsuarioTransportador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTransporte != null ? idTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transportes)) {
            return false;
        }
        Transportes other = (Transportes) object;
        if ((this.idTransporte == null && other.idTransporte != null) || (this.idTransporte != null && !this.idTransporte.equals(other.idTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Transportes[ idTransporte=" + idTransporte + " ]";
    }
    
}
