/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entidades.Comida;
import entidades.Ordermeal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lene
 */
@Local
public interface OrdermealFacadeLocal {

    void create(Ordermeal ordermeal);

    void edit(Ordermeal ordermeal);

    void remove(Ordermeal ordermeal);

    Ordermeal find(Object id);

    List<Ordermeal> findAll();

    List<Ordermeal> findRange(int[] range);

    int count();

    void insertarComidas(List<Comida> comidas, int idOrder);
    
}
