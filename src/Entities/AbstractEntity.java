/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Masha
 */
public abstract class AbstractEntity {
    
    public abstract Map<String, String> getParms();
    public abstract List<String> getColumns();
    public abstract String getTableName();
}
