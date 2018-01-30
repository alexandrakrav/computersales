/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductPack;

import Entities.Product;
import computersales.ConnectionClass;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sasha
 */
public class ProductModel extends AbstractTableModel {

    List<Product> entities = new ArrayList<>();  
    ConnectionClass con=new ConnectionClass();

    public ProductModel() {
        super();
        
        entities= con.getProducts();
        rowsCount = entities.size();
    }

    public void updateData() {       
        entities= con.getProducts();
        rowsCount = entities.size();
    }
    int rowsCount = 5;
    int colCount = 4;

    @Override
    public int getRowCount() {
        return rowsCount;
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return entities.get(rowIndex).getName();
            case 1:
                return entities.get(rowIndex).getPrice();
            case 2:
                return entities.get(rowIndex).getQuantity();
            case 3:
                return con.getContractor(entities.get(rowIndex).getContractor_id());
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Name";
            case 1:
                return "Price";
            case 2:
                return "Quantity";
            case 3:
                return "Contractor";
        }
        return null;
    }

    public Product getSelectedEntity(int row) {
        return entities.get(row);
    }
}

