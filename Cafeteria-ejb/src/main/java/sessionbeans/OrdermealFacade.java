/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entidades.Comida;
import entidades.Ordermeal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lene
 */
@Stateless
public class OrdermealFacade extends AbstractFacade<Ordermeal> implements OrdermealFacadeLocal {

    @PersistenceContext(unitName = "mingeso_Cafeteria-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public void insertarComidas(List<Comida> comidas, int idOrder)
    {
        if(comidas == null)
            System.out.println("Comidas NULL");
        if(idOrder <= 1)
            System.out.println("OrderMeal ID NULL");
        
        System.out.println("JOIN TABLE CON ID: "+idOrder);
        for(Comida comida:comidas)
        {
            String query = "INSERT INTO ordermeal_has_comida VALUES ("+idOrder+","+comida.getIdComida().toString()+"); ";
            System.out.println(query);
            getEntityManager().createNativeQuery(query, Comida.class);
        }
    }

    public OrdermealFacade() {
        super(Ordermeal.class);
    }
    
}
