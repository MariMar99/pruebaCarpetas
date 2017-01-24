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
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByIdProducto", query = "SELECT p FROM Productos p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Productos.findByNombreProducto", query = "SELECT p FROM Productos p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Productos.findByCategoria", query = "SELECT p FROM Productos p WHERE p.categoria = :categoria")
    , @NamedQuery(name = "Productos.findByCalibre", query = "SELECT p FROM Productos p WHERE p.calibre = :calibre")
    , @NamedQuery(name = "Productos.findByGradoMadurez", query = "SELECT p FROM Productos p WHERE p.gradoMadurez = :gradoMadurez")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProducto")
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombreProducto")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categoria")
    private int categoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calibre")
    private int calibre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gradoMadurez")
    private int gradoMadurez;
    @JoinColumn(name = "idEstadoProducto", referencedColumnName = "idEstadoProducto")
    @ManyToOne(optional = false)
    private Estadosproductos idEstadoProducto;
    @JoinColumn(name = "idPrecioCantidad", referencedColumnName = "idPrecioCantidad")
    @ManyToOne(optional = false)
    private Precioscantidades idPrecioCantidad;
    @JoinColumn(name = "idPresentacion", referencedColumnName = "idPresentacion")
    @ManyToOne(optional = false)
    private Presentaciones idPresentacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<Trazabilidades> trazabilidadesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private Collection<Detallespedidos> detallespedidosCollection;

    public Productos() {
    }

    public Productos(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Productos(Integer idProducto, String nombreProducto, String descripcion, int categoria, int calibre, int gradoMadurez) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.calibre = calibre;
        this.gradoMadurez = gradoMadurez;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getCalibre() {
        return calibre;
    }

    public void setCalibre(int calibre) {
        this.calibre = calibre;
    }

    public int getGradoMadurez() {
        return gradoMadurez;
    }

    public void setGradoMadurez(int gradoMadurez) {
        this.gradoMadurez = gradoMadurez;
    }

    public Estadosproductos getIdEstadoProducto() {
        return idEstadoProducto;
    }

    public void setIdEstadoProducto(Estadosproductos idEstadoProducto) {
        this.idEstadoProducto = idEstadoProducto;
    }

    public Precioscantidades getIdPrecioCantidad() {
        return idPrecioCantidad;
    }

    public void setIdPrecioCantidad(Precioscantidades idPrecioCantidad) {
        this.idPrecioCantidad = idPrecioCantidad;
    }

    public Presentaciones getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(Presentaciones idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    @XmlTransient
    public Collection<Trazabilidades> getTrazabilidadesCollection() {
        return trazabilidadesCollection;
    }

    public void setTrazabilidadesCollection(Collection<Trazabilidades> trazabilidadesCollection) {
        this.trazabilidadesCollection = trazabilidadesCollection;
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
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Productos[ idProducto=" + idProducto + " ]";
    }
    
}
