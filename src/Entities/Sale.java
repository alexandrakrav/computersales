/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Sasha
 */
public class Sale {
    private int id;
    private Date data;
    private int seller_id;

    public Sale(int id, Date data, int seller_id) {
        this.id = id;
        this.data = data;
        this.seller_id = seller_id;
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
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the seller_id
     */
    public int getSeller_id() {
        return seller_id;
    }

    /**
     * @param seller_id the seller_id to set
     */
    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }
    
}
