/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entidades.Comida;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lecho
 */
@Local
public interface ComidaFacadeLocal {

    void create(Comida comida);

    void edit(Comida comida);

    void remove(Comida comida);

    Comida find(Object id);

    List<Comida> findAll();

    List<Comida> findRange(int[] range);

    int count();
    
}
