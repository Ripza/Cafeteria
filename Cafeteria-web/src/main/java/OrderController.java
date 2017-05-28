/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
 
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import entidades.Comida;

/**
 *
 * @author Lene
 */
@ManagedBean(name = "orderctrl", eager = true)
@RequestScoped
public class OrderController implements Serializable {
        
    @ManagedProperty(value="#{calctrl}")
    private CalendarioController calendarioController;

    public CalendarioController getCalendarioController() {
        return calendarioController;
    }

    public void setCalendarioController(CalendarioController calendarioController) {
        this.calendarioController = calendarioController;
    }
    private String otroPene;

    public String getOtroPene() {
        System.out.println("NOSE");
        if(calendarioController != null) {
            System.out.println("NOSEEE");
         otroPene = calendarioController.getMiPene();
      }       
      return otroPene;
    }

    public void setOtroPene(String otroPene) {
        this.otroPene = otroPene;
    }

    public void mostrarValorPene()
    {
        System.out.println("Nohay");
        System.out.println(calendarioController.getMiPene());
    }
    /**
     * Creates a new instance of OrderController
     */
    public OrderController() {

      System.out.println("OrderController started!");   
    }
    
    private List<Comida> comidas;
    private Comida selectedComida;
    private List<Comida> selectedComidas;
    
     
    @PostConstruct
    public void init() {
    }
 
    public List<Comida> getComidas1() {
        return comidas;
    }
     
 
    public Comida getSelectedComida() {
        return selectedComida;
    }
 
    public void setSelectedComida(Comida selectedComida) {
        this.selectedComida = selectedComida;
    }
 
    public List<Comida> getSelectedComidas() {
        return selectedComidas;
    }
 
    public void setSelectedComidas(List<Comida> selectedComidas) {
        this.selectedComidas = selectedComidas;
    }
     
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Comida Selected", ((Comida) event.getObject()).getIdComida()+"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Comida Unselected", ((Comida) event.getObject()).getIdComida()+"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
