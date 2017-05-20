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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lecho
 */
@Entity
@Table(name = "comida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comida.findAll", query = "SELECT c FROM Comida c")
    , @NamedQuery(name = "Comida.findByIdComida", query = "SELECT c FROM Comida c WHERE c.idComida = :idComida")
    , @NamedQuery(name = "Comida.findByNombre", query = "SELECT c FROM Comida c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Comida.findByDescripcion", query = "SELECT c FROM Comida c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Comida.findByPrecio", query = "SELECT c FROM Comida c WHERE c.precio = :precio")})
public class Comida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComida")
    private Integer idComida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;

    public Comida() {
    }

    public Comida(Integer idComida) {
        this.idComida = idComida;
    }

    public Comida(Integer idComida, String nombre, int precio) {
        this.idComida = idComida;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getIdComida() {
        return idComida;
    }

    public void setIdComida(Integer idComida) {
        this.idComida = idComida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComida != null ? idComida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comida)) {
            return false;
        }
        Comida other = (Comida) object;
        if ((this.idComida == null && other.idComida != null) || (this.idComida != null && !this.idComida.equals(other.idComida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Comida[ idComida=" + idComida + " ]";
    }
    
}
