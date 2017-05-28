/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entidades.Comida;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lecho
 */
@Stateless
public class ComidaFacade extends AbstractFacade<Comida> implements ComidaFacadeLocal {

    @PersistenceContext(unitName = "mingeso_Cafeteria-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Comida> findByDescripcion(String asd)      
    {
       return this.em.createNamedQuery("Comida.findByDescripcion", Comida.class).setParameter("descripcion", asd).getResultList();
    }

    public ComidaFacade() {
        super(Comida.class);
    }
    
}
