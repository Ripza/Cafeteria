/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entidades.Comida;
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

    public ComidaFacade() {
        super(Comida.class);
    }
    
}
