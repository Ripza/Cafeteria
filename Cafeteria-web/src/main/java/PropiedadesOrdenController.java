/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controladores.ComidaController;
import controladores.OrdermealController;
import entidades.Comida;
import entidades.Ordermeal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.eclipse.persistence.jpa.jpql.Assert;

/**
 *
 * @author Lene
 */
@ManagedBean(name = "propiedadesOrdenController", eager = true)
@RequestScoped
public class PropiedadesOrdenController implements Serializable {

    /**
     * Creates a new instance of PropiedadesOrdenController
     */
    
    private String metodopago;
    private String nombre;
    private String calle;
    private String numeroCalle;
    private String depto;
    private String ciudad;
    private String comuna;
    private String numeroContacto;
    private String correo;

    
    @ManagedProperty(value="#{orderctrl}")
    private OrderController orderController ;
    private List<Comida> comidaSeleccionada;

    public List<Comida> getComidaSeleccionada() {
        return comidaSeleccionada;
    }

    public void setComidaSeleccionada(List<Comida> comidaSeleccionada) {
        this.comidaSeleccionada = comidaSeleccionada;
    }

    public OrderController getOrderController() {
        return orderController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }
    
    public String irCreacionOrden()
    {
        return "propiedadesOrden";
    }
    @PostConstruct
    public void init() {
       this.comidaSeleccionada = orderController.getComidasEnOrden();
       if(comidaSeleccionada == null){
        comidaSeleccionada = new ArrayList();
       }
    }
    
    @ManagedProperty(value="#{comidaController}")
    private ComidaController comidaController ;

    public ComidaController getComidaController() {
        return comidaController;
    }

    public void setComidaController(ComidaController comidaController) {
        this.comidaController = comidaController;
    }
    
    @ManagedProperty(value="#{ordermealController}")
    private OrdermealController ordermealController ;

    public OrdermealController getOrdermealController() {
        return ordermealController;
    }

    public void setOrdermealController(OrdermealController ordermealController) {
        this.ordermealController = ordermealController;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(String numeroCalle) {
        this.numeroCalle = numeroCalle;
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

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMetodopago() {
        return metodopago;
    }

    public void setMetodopago(String metodopago) {
        this.metodopago = metodopago;
    }
    
    
    
    public void guardarFormulario() {
        boolean bTodoBueno = false;
        
        //Almacenar en la DB con Facade
        System.out.println("COMIDA SELECCIONADA : "+getComidaSeleccionada());
        Ordermeal nuevaOrden = new Ordermeal();
        nuevaOrden.setNombrePersona(getNombre());
        nuevaOrden.setCalle(getCalle());
        nuevaOrden.setNumCalle(getNumeroCalle());
        nuevaOrden.setDepto(getDepto());
        nuevaOrden.setCiudad(getCiudad());
        nuevaOrden.setComuna(getComuna());
        nuevaOrden.setNroContacto(getNumeroContacto());
        nuevaOrden.setCorreo(getCorreo());
        nuevaOrden.setMetodoPago(getMetodopago());
        nuevaOrden.setComidaList(getComidaSeleccionada());
        
        try{
            ordermealController.setSelected(nuevaOrden);
            ordermealController.create();
        }catch (EJBException e) {
                @SuppressWarnings("ThrowableResultIgnored")
                Exception cause = e.getCausedByException();
                if (cause instanceof ConstraintViolationException) {
                    @SuppressWarnings("ThrowableResultIgnored")
                    ConstraintViolationException cve = (ConstraintViolationException) e.getCausedByException();
                    for (Iterator<ConstraintViolation<?>> it = cve.getConstraintViolations().iterator(); it.hasNext();) {
                        ConstraintViolation<? extends Object> v = it.next();
                        System.err.println(v);
                        System.err.println("==>>"+v.getMessage());
                    }
                }
                Assert.fail("ejb exception");
            
        }      

        
        bTodoBueno = true;
        if(bTodoBueno)
        {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Elementos guardados satisfactoriamente"));
        }
    }
    
    public PropiedadesOrdenController() {
    }
    
}
