/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContractorPack;

import Entities.Contractor;
import computersales.ConnectionClass;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sasha
 */
public class ContractorModel extends AbstractTableModel {

    List<Contractor> entities = new ArrayList<>();    
    ConnectionClass con=new ConnectionClass();

    public ContractorModel() {
        super();

        entities=con.getContractors();
        rowsCount = entities.size();
    }

    public void updateData() {     
        entities=con.getContractors();
        rowsCount = entities.size();
    }
    int rowsCount = 5;
    int colCount = 3;

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
                return entities.get(rowIndex).getAdress();
            case 2:
                return entities.get(rowIndex).getPhone_address();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Name";
            case 1:
                return "Adress";
            case 2:
                return "Phone number";
        }
        return null;
    }

    public Contractor getSelectedEntity(int row) {
        return entities.get(row);
    }
}
