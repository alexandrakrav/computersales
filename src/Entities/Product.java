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
public class Product {
    
    private int id;
    private String name;
    private int price;
    private int quantity;
    private int contractor_id;

    public Product(int id, String name, int price, int quantity, int contractor_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.contractor_id = contractor_id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
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

    /**
     * @return the contractor_id
     */
    public int getContractor_id() {
        return contractor_id;
    }

    /**
     * @param contractor_id the contractor_id to set
     */
    public void setContractor_id(int contractor_id) {
        this.contractor_id = contractor_id;
    }
    
    @Override public String toString(){
        return name;
    }
}
