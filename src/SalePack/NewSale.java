/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalePack;

import Entities.Product;
import Entities.Sale;
import Entities.SaleProducts;
import Entities.Seller;
import computersales.ConnectionClass;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Sasha
 */
public class NewSale extends javax.swing.JDialog {
    
    Sale editEntity;
    List<Seller> list;
    List<Product> productList;
    ConnectionClass c = new ConnectionClass();

    /**
     * Creates new form NewSale
     */
    public NewSale(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        combos();
    }
    
    public NewSale(java.awt.Frame parent, boolean modal, Sale u) {
        super(parent, modal);
        initComponents();
        
        editEntity = u;
        combos();
        fillFields();
    }
    
    private void combos() {
        list = new ArrayList<>();
        list = c.getSellers();
        seller.setModel(new DefaultComboBoxModel(list.toArray()));
        
        TableColumn productColumn = productsTable.getColumnModel().getColumn(0);
        
        JComboBox comboBox = new JComboBox();
        productList = new ArrayList<>();
        productList = c.getProducts();
        comboBox.setModel(new DefaultComboBoxModel(productList.toArray()));
        productColumn.setCellEditor(new DefaultCellEditor(comboBox));
        
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        java.util.Date data = new java.util.Date();
        date.setText(dateFormat.format(data));
    }
    
    private void fillFields() {
        
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        java.util.Date data = editEntity.getData();
        date.setText(dateFormat.format(data));
        
        seller.setSelectedItem(-1);
        
        for (Seller s : list) {
            if (s.getId() == editEntity.getSeller_id()) {
                seller.setSelectedItem((s));
            }
        }
        
        List<SaleProducts> entities = new ArrayList<>();
        entities = c.getSalesProducts(editEntity.getId());
        
        DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
        model.removeRow(0);
        int i = 0;
        for (SaleProducts s : entities) {
            model.addRow(new Object[]{null, 0});
            
            for (Product p : productList) {
                if (p.getId() == s.getProducts_id()) {
                    model.setValueAt(p, i, 0);
                    break;
                }
            }
            model.setValueAt(s.getQuantity(), i, 1);
            i++;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        seller = new javax.swing.JComboBox<>();
        date = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        seller.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        date.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Name", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(productsTable);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("-");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Дата");

        jLabel2.setText("Продавец");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seller, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jButton1)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seller, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean check() {
        if ("".equals(date.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "name cannot be empty");
            return false;
        }
        return true;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (productsTable.isEditing()) {
            productsTable.getCellEditor().stopCellEditing();
        }
        
        if (!check()) {
            return;
        }
        
        if (editEntity == null) {
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            java.util.Date data = new java.util.Date();
            try {
                data = format.parse(date.getText());
            } catch (ParseException ex) {
                Logger.getLogger(NewSale.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Sale sale = new Sale(-1, data, ((Seller) seller.getSelectedItem()).getId());
            ArrayList<SaleProducts> sales = new ArrayList<SaleProducts>();
            
            DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
            
            for (int i = 0; i < model.getRowCount(); i++) {
                SaleProducts oneMore = new SaleProducts(-1,
                        ((Product) model.getValueAt(i, 0)).getId(), Integer.parseInt(model.getValueAt(i, 1).toString()));
                sales.add(oneMore);
            }
            
            c.addSale(sale, sales);
        } else {

//            DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
//            java.util.Date data = new java.util.Date();
//            try {
//                data = format.parse(date.getText());
//            } catch (ParseException ex) {
//                Logger.getLogger(NewSale.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            editEntity.setData(data);
//            editEntity.setSeller_id(((Seller) seller.getSelectedItem()).getId());
//            
//            ArrayList<SaleProducts> sales = new ArrayList<SaleProducts>();
//            
//            DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
//            
//            for (int i = 0; i < model.getRowCount(); i++) {
//                SaleProducts oneMore = new SaleProducts(-1,
//                        ((Product) model.getValueAt(i, 0)).getId(), Integer.parseInt(model.getValueAt(i, 1).toString()));
//                sales.add(oneMore);
//            }
//            
//            c.editSale(editEntity, sales);
            
            
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            java.util.Date data = new java.util.Date();
            try {
                data = format.parse(date.getText());
            } catch (ParseException ex) {
                Logger.getLogger(NewSale.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Sale sale = new Sale(-1, data, ((Seller) seller.getSelectedItem()).getId());
            ArrayList<SaleProducts> sales = new ArrayList<SaleProducts>();
            
            DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
            
            for (int i = 0; i < model.getRowCount(); i++) {
                SaleProducts oneMore = new SaleProducts(-1,
                        ((Product) model.getValueAt(i, 0)).getId(), Integer.parseInt(model.getValueAt(i, 1).toString()));
                sales.add(oneMore);
            }
            
//            c.deleteSale(editEntity.getId());
//            c.addSale(sale, sales);
            
            c.editSale(editEntity.getId(),sale, sales);
        }
        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
        if (productsTable.getSelectedRow() > -1) {
            model.removeRow(productsTable.getSelectedRow());
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
        model.addRow(new Object[]{null, 0});
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productsTable;
    private javax.swing.JComboBox<String> seller;
    // End of variables declaration//GEN-END:variables
}
