/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalePack;

import Entities.SaleProducts;
import computersales.ConnectionClass;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sasha
 */
public class SalesProductModel  extends AbstractTableModel {

    List<SaleProducts> entities = new ArrayList<>();  
    ConnectionClass con=new ConnectionClass();

    int sale_id;
    public SalesProductModel(int sale_id) {
        super();
        this.sale_id=sale_id;
        
        entities= con.getSalesProducts(sale_id);
        rowsCount = entities.size();
    }

    public void updateData() {       
        entities= con.getSalesProducts(sale_id);
        rowsCount = entities.size();
    }
    int rowsCount = 5;
    int colCount = 2;

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
                return con.getProduct(entities.get(rowIndex).getProducts_id());
            case 1:
                return entities.get(rowIndex).getQuantity();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Product";
            case 1:
                return "Quantity";
        }
        return null;
    }

    public SaleProducts getSelectedEntity(int row) {
        return entities.get(row);
    }
}