/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mariana
 */
@Entity
@Table(name = "detallespedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallespedidos.findAll", query = "SELECT d FROM Detallespedidos d")
    , @NamedQuery(name = "Detallespedidos.findByIdDetallePedido", query = "SELECT d FROM Detallespedidos d WHERE d.idDetallePedido = :idDetallePedido")
    , @NamedQuery(name = "Detallespedidos.findByCantidad", query = "SELECT d FROM Detallespedidos d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detallespedidos.findByMoneda", query = "SELECT d FROM Detallespedidos d WHERE d.moneda = :moneda")})
public class Detallespedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idDetallePedido")
    private Integer idDetallePedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "moneda")
    private String moneda;
    @JoinColumn(name = "idPallet", referencedColumnName = "idPallet")
    @ManyToOne(optional = false)
    private Pallets idPallet;
    @JoinColumn(name = "idPedido", referencedColumnName = "idPedido")
    @ManyToOne(optional = false)
    private Pedidos idPedido;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProducto")
    @ManyToOne(optional = false)
    private Productos idProducto;
    @JoinColumn(name = "idTipoEmpaque", referencedColumnName = "idTipoEmpaque")
    @ManyToOne(optional = false)
    private Tiposempaques idTipoEmpaque;

    public Detallespedidos() {
    }

    public Detallespedidos(Integer idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public Detallespedidos(Integer idDetallePedido, int cantidad, String moneda) {
        this.idDetallePedido = idDetallePedido;
        this.cantidad = cantidad;
        this.moneda = moneda;
    }

    public Integer getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(Integer idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Pallets getIdPallet() {
        return idPallet;
    }

    public void setIdPallet(Pallets idPallet) {
        this.idPallet = idPallet;
    }

    public Pedidos getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedidos idPedido) {
        this.idPedido = idPedido;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    public Tiposempaques getIdTipoEmpaque() {
        return idTipoEmpaque;
    }

    public void setIdTipoEmpaque(Tiposempaques idTipoEmpaque) {
        this.idTipoEmpaque = idTipoEmpaque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetallePedido != null ? idDetallePedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallespedidos)) {
            return false;
        }
        Detallespedidos other = (Detallespedidos) object;
        if ((this.idDetallePedido == null && other.idDetallePedido != null) || (this.idDetallePedido != null && !this.idDetallePedido.equals(other.idDetallePedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Detallespedidos[ idDetallePedido=" + idDetallePedido + " ]";
    }
    
}
