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
public class Contractor 
//        extends AbstractEntity
{
    private int id;
    private String name;
    private String adress;
    private String phone_address;

    public Contractor(int id, String name, String adress, String phone_address) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.phone_address = phone_address;
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
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return the phone_address
     */
    public String getPhone_address() {
        return phone_address;
    }

    /**
     * @param phone_address the phone_address to set
     */
    public void setPhone_address(String phone_address) {
        this.phone_address = phone_address;
    }
    
    @Override public String toString(){
        return name+" ("+adress+")";
    }

//    @Override
//    public Dictionary<String, String> getParms() {
//         Map<String,String> parms= new HashMap<>();
//         parms.put(name, name)
//    }
//
//    @Override
//    public String getTableName() {
//        return "contractor";
//    }
//
//    @Override
//    public List<String> getColumns() {
//        return Arrays.asList(columns);
//    }
//    
//    String [] columns = new String[]{"name","adress","phone_number"};
}
