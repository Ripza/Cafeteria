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
import java.util.Calendar;
import java.util.Iterator;
import javax.faces.event.ActionEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Lene
 */
@ManagedBean(name = "orderctrl", eager = true)
@SessionScoped
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
    private Comida comidaSeleccionadaOrden;
    private int precio_total;
    private String diaSemana;

    public String getDiaSemana() {
        int dia_int;
        Calendar c = Calendar.getInstance();
         c.setTime(getCalendarioController().getDate4());
         dia_int = c.get(Calendar.DAY_OF_WEEK);
         System.out.println(""+c.getTime());
         System.out.println("Dia:"+dia_int);
         switch(dia_int){
             case 0: diaSemana = "S";
                     break;
             case 1: diaSemana = "D";
                     break;
             case 2: diaSemana = "L";
                     break;
             case 3: diaSemana = "M";
                     break;
             case 4: diaSemana = "W";
                     break;
             case 5: diaSemana = "J";
                     break;
             case 6: diaSemana = "V";
                     break;

         }
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(int precio_total) {
        this.precio_total = precio_total;
    }
   
    
    public Comida getComidaSeleccionadaOrden() {
        return comidaSeleccionadaOrden;
    }

    public void setComidaSeleccionadaOrden(Comida comidaSeleccionadaOrden) {
        this.comidaSeleccionadaOrden = comidaSeleccionadaOrden;
    }

    private List<Comida> comidasEnOrden;

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
        return "comidaConfirmada";
    }
    public void eliminarComida()
    {
        if(this.comidaSeleccionadaOrden == null)
            return;
        System.out.println("Comidas eliminadas");
        System.out.println("Comidad a eliminar:"+this.comidaSeleccionadaOrden);
        //List<Comida> nuevaListaComidaOrden = new ArrayList<>();
        
        Iterator comidaIterator = this.comidasEnOrden.iterator();

        while(comidaIterator.hasNext())
        {
            if(this.comidaSeleccionadaOrden == comidaIterator.next())
            {
                comidaIterator.remove();
                break;
            }
        }
        RequestContext.getCurrentInstance().update("checkboxDT2");
        //comidaSeleccionadaOrden = null;
    }
    public int totalSeleccion()
    {
        int total_precio = 0;
        for(int i=0;i<this.getComidasEnOrden().size();i++)
        {
            total_precio = total_precio + this.getComidasEnOrden().get(i).getPrecio();
        }
        this.precio_total = total_precio;
        return total_precio;
    }

    private String ejemplo;

    public String getEjemplo() {
        System.out.println("NOSE");
        if(calendarioController != null) {
            System.out.println("NOSEPEEEEEE");
         ejemplo = calendarioController.getEjemplo();
      }       
      return ejemplo;
    }

    public void setEjemplo(String ejemplo) {
        this.ejemplo = ejemplo;
    }

    public void mostrarValorEjemplo()
    {
        System.out.println("Nohay");
        System.out.println(calendarioController.getEjemplo());
    }
    
    @PostConstruct
    public void init() {
       this.comidas = comidaController.getItems();
       if(comidasEnOrden == null){
        comidasEnOrden = new ArrayList();
       }
       
       if(comidaSeleccionadaOrden == null){
        comidaSeleccionadaOrden = new Comida();
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
