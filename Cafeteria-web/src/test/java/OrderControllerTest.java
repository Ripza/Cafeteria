/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controladores.ComidaController;
import controladores.MenusController;
import entidades.Comida;
import entidades.Menus;
import java.util.Date;
import java.util.List;
import javax.faces.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Lene
 */
public class OrderControllerTest {
    
    public OrderControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMenu method, of class OrderController.
     */
    @org.junit.Test
    public void testGetMenu() {
        System.out.println("getMenu");
        OrderController instance = new OrderController();
        List<Menus> expResult = null;
        List<Menus> result = instance.getMenu();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMenu method, of class OrderController.
     */


    /**
     * Test of getComidaSeleccionadaOrden method, of class OrderController.
     */
    @org.junit.Test
    public void testGetComidaSeleccionadaOrden() {
        System.out.println("getComidaSeleccionadaOrden");
        OrderController instance = new OrderController();
        Comida result = instance.getComidaSeleccionadaOrden();
        assertEquals("asd", result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
}
