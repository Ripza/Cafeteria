/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
import controladores.ComidaController;
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
import java.util.ArrayList;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Lene
 */
@ManagedBean(name = "orderctrl", eager = true)
@RequestScoped
public class OrderController implements Serializable {
        
    @ManagedProperty(value="#{calctrl}")
    private CalendarioController calendarioController;

    
    @ManagedProperty(value="#{comidaController}")
    private ComidaController comidaController ;

    public ComidaController getComidaController() {
        return comidaController;
    }

    public void setComidaController(ComidaController comidaController) {
        this.comidaController = comidaController;
    }
    
    
    private List<Comida> comidas;
    private Comida asd;
    
    private Comida comidaseleccionada;
    private List<Comida> comidaSeleccionadas;
    private List<Comida> comidaSeleccionadaOrden;

    public List<Comida> getComidaSeleccionadaOrden() {
        return comidaSeleccionadaOrden;
    }

    public void setComidaSeleccionadaOrden(List<Comida> comidaSeleccionadaOrden) {
        this.comidaSeleccionadaOrden = comidaSeleccionadaOrden;
    }
    static private List<Comida> comidasEnOrden;

    public List<Comida> getComidasEnOrden() {
        return comidasEnOrden;
    }

    public void setComidasEnOrden(List<Comida> comidasEnOrden) {
        this.comidasEnOrden = comidasEnOrden;
    }

    public Comida getComidaseleccionada() {
        return comidaseleccionada;
    }

    public void setComidaseleccionada(Comida comidaseleccionada) {
        this.comidaseleccionada = comidaseleccionada;
    }

    public List<Comida> getComidaSeleccionadas() {
        return comidaSeleccionadas;
    }

    public void setComidaSeleccionadas(List<Comida> comidaSeleccionadas) {
        System.out.println("Seleccione comidas");
        System.out.println(comidaSeleccionadas);
        this.comidaSeleccionadas = comidaSeleccionadas;
    }

    public Comida getAsd() {
        return asd;
    }

    public void setAsd(Comida asd) {
        this.asd = asd;
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }

    public CalendarioController getCalendarioController() {
        return calendarioController;
    }

    public void setCalendarioController(CalendarioController calendarioController) {
        this.calendarioController = calendarioController;
    }
    public void cargarSeleccion()
    {
        System.out.println("Comidas cargadas");
        if(comidaSeleccionadas != null)
            comidasEnOrden.addAll(comidaSeleccionadas);
        System.out.println(comidasEnOrden);
    }
    
    public void testButtonActionListener(ActionEvent event) {
        System.out.println("testButtonActionListener invoked");
    }

    public String ir_confirmacion()
    {
        System.out.println("Confirmando orden");
        return "ordenConfirmada";
    }
    
    public void eliminarComida()
    {
        
        System.out.println("Comidas eliminadas");
        if(comidasEnOrden != null)
            comidasEnOrden.removeAll(comidaSeleccionadaOrden);
        System.out.println(comidaSeleccionadaOrden);
    }

    private String otroPene;

    public String getOtroPene() {
        System.out.println("NOSE");
        if(calendarioController != null) {
            System.out.println("NOSEPEEEEEE");
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
    
    @PostConstruct
    public void init() {
       this.comidas = comidaController.getItems();
       if(comidasEnOrden == null){
        comidasEnOrden = new ArrayList();
       }
       
       if(comidaSeleccionadaOrden == null){
        comidaSeleccionadaOrden = new ArrayList();
       }
       
       
    }
    
    /**
     * Creates a new instance of OrderController
     */
    public OrderController() {

      System.out.println("OrderController started!");   
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((Comida) event.getObject()).getIdComida()+"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((Comida) event.getObject()).getIdComida()+"");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
}
