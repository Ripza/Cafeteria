/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "menus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menus.findAll", query = "SELECT m FROM Menus m")
    , @NamedQuery(name = "Menus.findByIdMenus", query = "SELECT m FROM Menus m WHERE m.idMenus = :idMenus")
    , @NamedQuery(name = "Menus.findByEspecialDelDia", query = "SELECT m FROM Menus m WHERE m.especialDelDia = :especialDelDia")})
public class Menus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idMenus")
    private Integer idMenus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "especialDelDia")
    private String especialDelDia;
    @ManyToMany(mappedBy = "menusList")
    private List<Comida> comidaList;

    public Menus() {
    }

    public Menus(Integer idMenus) {
        this.idMenus = idMenus;
    }

    public Menus(Integer idMenus, String especialDelDia) {
        this.idMenus = idMenus;
        this.especialDelDia = especialDelDia;
    }

    public Integer getIdMenus() {
        return idMenus;
    }

    public void setIdMenus(Integer idMenus) {
        this.idMenus = idMenus;
    }

    public String getEspecialDelDia() {
        return especialDelDia;
    }

    public void setEspecialDelDia(String especialDelDia) {
        this.especialDelDia = especialDelDia;
    }

    @XmlTransient
    public List<Comida> getComidaList() {
        return comidaList;
    }

    public void setComidaList(List<Comida> comidaList) {
        this.comidaList = comidaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenus != null ? idMenus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menus)) {
            return false;
        }
        Menus other = (Menus) object;
        if ((this.idMenus == null && other.idMenus != null) || (this.idMenus != null && !this.idMenus.equals(other.idMenus))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Menus[ idMenus=" + idMenus + " ]";
    }
    
}
