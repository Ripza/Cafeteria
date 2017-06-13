/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entidades.Comida;
import entidades.Menus;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Lene
 */
@Stateless
public class MenusFacade extends AbstractFacade<Menus> implements MenusFacadeLocal {

    @PersistenceContext(unitName = "mingeso_Cafeteria-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @Override
    public List<Menus> getMenuByDay(String date)
    {
        System.out.println("MenuFacade");
        TypedQuery<Menus> query =
        em.createNamedQuery("Menus.findByEspecialDelDia", Menus.class).setParameter("especialDelDia",date);
        
        return query.getResultList();
    }

    public MenusFacade() {
        super(Menus.class);
    }
    
}
