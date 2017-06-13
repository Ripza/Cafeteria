
import entidades.Ordermeal;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lene
 */
@SessionScoped
public class VarHandler {
    
    private Ordermeal nueva_orden;

    public Ordermeal getNueva_orden() {
        return nueva_orden;
    }

    public void setNueva_orden(Ordermeal nueva_orden) {
        this.nueva_orden = nueva_orden;
    }
    
    public VarHandler() {
    }
    
}
