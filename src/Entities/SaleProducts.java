/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Sasha
 */
public class SaleProducts {
    private int sale_id;
    private int products_id;
    private int quantity;

    public SaleProducts(int sale_id, int products_id, int quantity) {
        this.sale_id = sale_id;
        this.products_id = products_id;
        this.quantity = quantity;
    }

    /**
     * @return the sale_id
     */
    public int getSale_id() {
        return sale_id;
    }

    /**
     * @param sale_id the sale_id to set
     */
    public void setSale_id(int sale_id) {
        this.sale_id = sale_id;
    }

    /**
     * @return the products_id
     */
    public int getProducts_id() {
        return products_id;
    }

    /**
     * @param products_id the products_id to set
     */
    public void setProducts_id(int products_id) {
        this.products_id = products_id;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
