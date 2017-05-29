/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entidades.Comida;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Lene
 */
@ManagedBean(name = "ordenComidaController", eager = true)
@RequestScoped
public class OrdenComidaController {

    /**
     * Creates a new instance of OrdenComidaController
     */
    public OrdenComidaController() {
    }
    

    @ManagedProperty(value="#{orderctrl}")
    private OrderController orderController ;
    private List<Comida> comidaSeleccionada;

    public List<Comida> getComidaSeleccionada() {
        return comidaSeleccionada;
    }

    public String irCreacionOrden()
    {
        System.out.println("Confirmando orden segunda");
        return "propiedadesOrden";
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
    
    @PostConstruct
    public void init() {
       this.comidaSeleccionada = orderController.getComidasEnOrden();
       if(comidaSeleccionada == null){
        comidaSeleccionada = new ArrayList();
       }
    }
    
}
