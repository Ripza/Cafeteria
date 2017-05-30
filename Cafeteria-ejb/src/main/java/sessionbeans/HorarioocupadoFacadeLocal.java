/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entidades.Horarioocupado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lene
 */
@Local
public interface HorarioocupadoFacadeLocal {

    void create(Horarioocupado horarioocupado);

    void edit(Horarioocupado horarioocupado);

    void remove(Horarioocupado horarioocupado);

    Horarioocupado find(Object id);

    List<Horarioocupado> findAll();

    List<Horarioocupado> findRange(int[] range);

    int count();
    
}
