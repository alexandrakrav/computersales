/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalePack;

import Entities.Sale;
import computersales.ConnectionClass;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sasha
 */
public class SaleModel extends AbstractTableModel {

    List<Sale> entities = new ArrayList<>();  
    ConnectionClass con=new ConnectionClass();

    public SaleModel() {
        super();
        
        entities= con.getSales();
        rowsCount = entities.size();
    }

    public void updateData() {       
        entities= con.getSales();
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
                return entities.get(rowIndex).getData();
            case 1:
                return con.getSeller(entities.get(rowIndex).getSeller_id());
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Date";
            case 1:
                return "Seller";
        }
        return null;
    }

    public Sale getSelectedEntity(int row) {
        return entities.get(row);
    }
}