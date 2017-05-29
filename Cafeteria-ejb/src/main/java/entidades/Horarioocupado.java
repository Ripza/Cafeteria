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
 * @author Lene
 */
@Entity
@Table(name = "horarioocupado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horarioocupado.findAll", query = "SELECT h FROM Horarioocupado h")
    , @NamedQuery(name = "Horarioocupado.findByIdHorarioOcupado", query = "SELECT h FROM Horarioocupado h WHERE h.idHorarioOcupado = :idHorarioOcupado")
    , @NamedQuery(name = "Horarioocupado.findByFecha", query = "SELECT h FROM Horarioocupado h WHERE h.fecha = :fecha")})
public class Horarioocupado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idHorarioOcupado")
    private Integer idHorarioOcupado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "OrderMeal_idOrderMeal", referencedColumnName = "idOrderMeal")
    @ManyToOne(optional = false)
    private Ordermeal orderMealidOrderMeal;

    public Horarioocupado() {
    }

    public Horarioocupado(Integer idHorarioOcupado) {
        this.idHorarioOcupado = idHorarioOcupado;
    }

    public Horarioocupado(Integer idHorarioOcupado, Date fecha) {
        this.idHorarioOcupado = idHorarioOcupado;
        this.fecha = fecha;
    }

    public Integer getIdHorarioOcupado() {
        return idHorarioOcupado;
    }

    public void setIdHorarioOcupado(Integer idHorarioOcupado) {
        this.idHorarioOcupado = idHorarioOcupado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Ordermeal getOrderMealidOrderMeal() {
        return orderMealidOrderMeal;
    }

    public void setOrderMealidOrderMeal(Ordermeal orderMealidOrderMeal) {
        this.orderMealidOrderMeal = orderMealidOrderMeal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorarioOcupado != null ? idHorarioOcupado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horarioocupado)) {
            return false;
        }
        Horarioocupado other = (Horarioocupado) object;
        if ((this.idHorarioOcupado == null && other.idHorarioOcupado != null) || (this.idHorarioOcupado != null && !this.idHorarioOcupado.equals(other.idHorarioOcupado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Horarioocupado[ idHorarioOcupado=" + idHorarioOcupado + " ]";
    }
    
}
