package edu.upc.eetac.dsa;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class OrderTest {
    //Logger
    final static Logger log = Logger.getLogger(OrderTest.class.getName());

    //We have to create and object of type ProductManager, for then use its methods
    ProductManager pm;

    Usuario u1, u2;

    Producto producto1, producto2, producto3, producto4, producto5, producto6;

    Pedido pedido1, pedido2, pedido3;

    List<Pedido.LProducto> lp1, lp2, lp3;

    //Before the tests we have to add Users and some orders
    @Before
    public void setUp(){
        //Because ProductManagerImpl implements ProductManager, we can create on top of pm, new ProductManagerImpl
        pm = ProductManagerImpl.getInstance();
        lp1 = new ArrayList<>();
        lp2 = new ArrayList<>();
        lp3 = new ArrayList<>();

        //We create the products
        producto1 = new Producto("Manzana",1.5);
        producto2 = new Producto("Pastel",10);
        producto3 = new Producto("Cerveza",2.5);
        producto4 = new Producto("Calamares",5);
        producto5 = new Producto("Patatas",4);
        producto6 = new Producto("Fanta",2);
        pm.addProducto(producto1);
        pm.addProducto(producto2);
        pm.addProducto(producto3);
        pm.addProducto(producto4);
        pm.addProducto(producto5);
        pm.addProducto(producto6);

        //Create the list of users
        pm.addUser("Pepe");
        pm.addUser("Juan");
        pm.addUser("Carla");
        pm.addUser("Paula");
    }

    //When the test ends, it's properly to erase the contents added in @Before
    @After
    public void tearDown(){
        pm = null;
    }

    @Test
    public void placeAnOrder(){
        try {
            //Place new orders
            Pedido.LProducto l1 = new Pedido.LProducto();
            l1.producto = "Manzana";
            l1.q = 3;
            Pedido.LProducto l2 = new Pedido.LProducto();
            l2.producto = "Pastel";
            l2.q = 5;
            lp1.add(l1);
            lp1.add(l2);
            pedido1 = new Pedido(lp1);
            pm.placeAnOrder("Pepe", pedido1);
        }
        catch (UserNotFoundException e){
            log.error("EL usuario no existe en la lista " +e.getMessage());
        }
    }

    @Test
    public void serveAnOrder(){
        pedido1 = this.pm.serveAnOrder();
    }

    @Test
    public void getOrdersSortedByPrice(){
        List<Producto> ret = this.pm.getAllProductsSortedByPrice();

        assertEquals(ret.get(0).name, "Manzana", "Manzana");
        assertEquals(ret.get(1).name, "Fanta", "Fanta");
        assertEquals(ret.get(2).name, "Cerveza", "Cerveza");
        assertEquals(ret.get(3).name, "Patatas", "Patatas");
        assertEquals(ret.get(4).name, "Calamares", "Calamares");
        assertEquals(ret.get(5).name, "Pastel", "Pastel");

    }

    @Test
    public void getAllOrderOfAUser(){
        try {
            LinkedList<Pedido> l = this.pm.getAllOrdersOfAUser("Pepe");



        }
        catch(UserNotFoundException e){
            log.warn("El usuario del cual intenta visualizar su historial de pedidos NO existe en la lista! " +e.getMessage());
        }
    }


}
