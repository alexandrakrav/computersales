/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SellerPack;

import Entities.Seller;
import computersales.ConnectionClass;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sasha
 */
public class SellerModel extends AbstractTableModel {

    List<Seller> entities = new ArrayList<>();    
    ConnectionClass con=new ConnectionClass();

    public SellerModel() {
        super();
        entities=con.getSellers();
        rowsCount = entities.size();
    }

    public void updateData() {     
        entities=con.getSellers();
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
                return entities.get(rowIndex).getName();
            case 1:
                return entities.get(rowIndex).getSurname();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Name";
            case 1:
                return "Surname";
        }
        return null;
    }

    public Seller getSelectedEntity(int row) {
        return entities.get(row);
    }
}
