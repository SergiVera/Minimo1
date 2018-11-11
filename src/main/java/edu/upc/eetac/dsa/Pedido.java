package edu.upc.eetac.dsa;

import java.util.List;

public class Pedido {
    //Attributes
    List<LProducto> products;
    private Usuario user;

    public Pedido(List<LProducto> products) {
        this.products = products;
    }

    public List<LProducto> getProducts() {
        return products;
    }

    public void setUser(Usuario theUser) {
        this.user = theUser;
    }

    public Usuario getUser() {
        return this.user;

    }

    //Each field of products List has the name of the product and the quantity. A tuple of two fields (columns)
    //For that reason we create an inner class, which is protected
    public static class LProducto {
        public int q;
        public String producto;

        @Override
        public String toString() {
            return "Pedido [Name=" + producto + ", Quantity=" + q + "]";
        }

    }


}
