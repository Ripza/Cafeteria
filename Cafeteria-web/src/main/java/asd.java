/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Lene
 */
@Named(value = "asd")
@RequestScoped
public class asd {
    private String valor1;

    public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }
    /**
     * Creates a new instance of asd
     */
    public asd() {
    }
    
}
