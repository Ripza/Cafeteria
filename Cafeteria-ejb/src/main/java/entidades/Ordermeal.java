/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
 * @author Lene
 */
@Entity
@Table(name = "ordermeal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordermeal.findAll", query = "SELECT o FROM Ordermeal o")
    , @NamedQuery(name = "Ordermeal.findByIdOrderMeal", query = "SELECT o FROM Ordermeal o WHERE o.idOrderMeal = :idOrderMeal")
    , @NamedQuery(name = "Ordermeal.findByMetodoPago", query = "SELECT o FROM Ordermeal o WHERE o.metodoPago = :metodoPago")
    , @NamedQuery(name = "Ordermeal.findByNombrePersona", query = "SELECT o FROM Ordermeal o WHERE o.nombrePersona = :nombrePersona")
    , @NamedQuery(name = "Ordermeal.findByCalle", query = "SELECT o FROM Ordermeal o WHERE o.calle = :calle")
    , @NamedQuery(name = "Ordermeal.findByNumCalle", query = "SELECT o FROM Ordermeal o WHERE o.numCalle = :numCalle")
    , @NamedQuery(name = "Ordermeal.findByDepto", query = "SELECT o FROM Ordermeal o WHERE o.depto = :depto")
    , @NamedQuery(name = "Ordermeal.findByCiudad", query = "SELECT o FROM Ordermeal o WHERE o.ciudad = :ciudad")
    , @NamedQuery(name = "Ordermeal.findByComuna", query = "SELECT o FROM Ordermeal o WHERE o.comuna = :comuna")
    , @NamedQuery(name = "Ordermeal.findByNroContacto", query = "SELECT o FROM Ordermeal o WHERE o.nroContacto = :nroContacto")
    , @NamedQuery(name = "Ordermeal.findByCorreo", query = "SELECT o FROM Ordermeal o WHERE o.correo = :correo")})
public class Ordermeal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idOrderMeal")
    private Integer idOrderMeal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "metodoPago")
    private String metodoPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombrePersona")
    private String nombrePersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "calle")
    private String calle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "num_calle")
    private String numCalle;
    @Size(max = 45)
    @Column(name = "depto")
    private String depto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comuna")
    private String comuna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nro_contacto")
    private String nroContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @ManyToMany(mappedBy = "ordermealList")
    private List<Comida> comidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderMealidOrderMeal")
    private List<Horarioocupado> horarioocupadoList;

    public Ordermeal() {
    }

    public Ordermeal(Integer idOrderMeal) {
        this.idOrderMeal = idOrderMeal;
    }

    public Ordermeal(Integer idOrderMeal, String metodoPago, String nombrePersona, String calle, String numCalle, String ciudad, String comuna, String nroContacto, String correo) {
        this.idOrderMeal = idOrderMeal;
        this.metodoPago = metodoPago;
        this.nombrePersona = nombrePersona;
        this.calle = calle;
        this.numCalle = numCalle;
        this.ciudad = ciudad;
        this.comuna = comuna;
        this.nroContacto = nroContacto;
        this.correo = correo;
    }

    public Integer getIdOrderMeal() {
        return idOrderMeal;
    }

    public void setIdOrderMeal(Integer idOrderMeal) {
        this.idOrderMeal = idOrderMeal;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumCalle() {
        return numCalle;
    }

    public void setNumCalle(String numCalle) {
        this.numCalle = numCalle;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getNroContacto() {
        return nroContacto;
    }

    public void setNroContacto(String nroContacto) {
        this.nroContacto = nroContacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public List<Comida> getComidaList() {
        return comidaList;
    }

    public void setComidaList(List<Comida> comidaList) {
        this.comidaList = comidaList;
    }

    @XmlTransient
    public List<Horarioocupado> getHorarioocupadoList() {
        return horarioocupadoList;
    }

    public void setHorarioocupadoList(List<Horarioocupado> horarioocupadoList) {
        this.horarioocupadoList = horarioocupadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrderMeal != null ? idOrderMeal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordermeal)) {
            return false;
        }
        Ordermeal other = (Ordermeal) object;
        if ((this.idOrderMeal == null && other.idOrderMeal != null) || (this.idOrderMeal != null && !this.idOrderMeal.equals(other.idOrderMeal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Ordermeal[ idOrderMeal=" + idOrderMeal + " ]";
    }
    
}
