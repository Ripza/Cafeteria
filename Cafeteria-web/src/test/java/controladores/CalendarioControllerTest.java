/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Lene
 */
public class CalendarioControllerTest {
    
    public CalendarioControllerTest() {
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
     * Test of getNombre method, of class CalendarioController.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        CalendarioController instance = new CalendarioController();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class CalendarioController.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        CalendarioController instance = new CalendarioController();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEjemplo method, of class CalendarioController.
     */
    @Test
    public void testGetEjemplo() {
        System.out.println("getEjemplo");
        CalendarioController instance = new CalendarioController();
        String expResult = "";
        String result = instance.getEjemplo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEjemplo method, of class CalendarioController.
     */
    @Test
    public void testSetEjemplo() {
        System.out.println("setEjemplo");
        String ejemplo = "";
        CalendarioController instance = new CalendarioController();
        instance.setEjemplo(ejemplo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onDateSelect method, of class CalendarioController.
     */
    @Test
    public void testOnDateSelect() {
        System.out.println("onDateSelect");
        SelectEvent event = null;
        CalendarioController instance = new CalendarioController();
        instance.onDateSelect(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of conectar_orden method, of class CalendarioController.
     */
    @Test
    public void testConectar_orden() {
        System.out.println("conectar_orden");
        CalendarioController instance = new CalendarioController();
        String expResult = "";
        String result = instance.conectar_orden();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of click method, of class CalendarioController.
     */
    @Test
    public void testClick() {
        System.out.println("click");
        CalendarioController instance = new CalendarioController();
        instance.click();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate4 method, of class CalendarioController.
     */
    @Test
    public void testGetDate4() {
        System.out.println("getDate4");
        CalendarioController instance = new CalendarioController();
        Date expResult = null;
        Date result = instance.getDate4();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate4 method, of class CalendarioController.
     */
    @Test
    public void testSetDate4() {
        System.out.println("setDate4");
        Date date4 = null;
        CalendarioController instance = new CalendarioController();
        instance.setDate4(date4);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate11 method, of class CalendarioController.
     */
    @Test
    public void testGetDate11() {
        System.out.println("getDate11");
        CalendarioController instance = new CalendarioController();
        Date expResult = null;
        Date result = instance.getDate11();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate11 method, of class CalendarioController.
     */
    @Test
    public void testSetDate11() {
        System.out.println("setDate11");
        Date date11 = null;
        CalendarioController instance = new CalendarioController();
        instance.setDate11(date11);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
