/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computersales;

import Entities.Contractor;
import Entities.Product;
import Entities.Sale;
import Entities.SaleProducts;
import Entities.Seller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sasha
 */
public class ConnectionClass {

    static public Connection connection;

//    private void addEntity(AbstractEntity entity) {
//        try {
//            Map<String, String> parms = entity.getParms();
//            String forBindKeys = "";
//            for(String key : entity.getColumns()) forBindKeys+=key+",";
//            forBindKeys = forBindKeys.substring(0, forBindKeys.length() - 1);
//            
//            String forBindValues = (String.join("", Collections.nCopies(parms.size(), "?,")));
//            forBindValues = forBindValues.substring(0, forBindValues.length() - 1);
//                        
//            PreparedStatement stmt = connection.prepareStatement("insert into "
//                    + entity.getTableName() +forBindKeys+ " values(" + forBindValues + ")");
//            
//            int nextBindNum=1;
//            for(String pairKey : parms.keySet()){
//                
//                nextBindNum++;
//            }
//            stmt.setInt(1, 101);
//            stmt.setString(2, "Ratan");
//
//            int i = stmt.executeUpdate();
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("insert into contractor (name,adress,phone_number) "
//                    + "values ('" + c.getName() + "','" + c.getAdress() + "','" + c.getPhone_address() + "');");
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
//        }
//
//    }
    public List<Contractor> getContractors() {
        List<Contractor> entities = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM contractor");

            while (rs.next()) {
                Contractor state = new Contractor(rs.getInt("id"), rs.getString("name"), rs.getString("adress"), rs.getString("phone_number"));

                entities.add(state);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        return entities;
    }

    public void addContractor(Contractor c) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into contractor (name,adress,phone_number) "
                    + "values ('" + c.getName() + "','" + c.getAdress() + "','" + c.getPhone_address() + "');");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    public void editContractor(Contractor c) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("update contractor set name='" + c.getName() + "',adress='" + c.getAdress()
                    + "',phone_number='" + c.getPhone_address() + "' where id=" + c.getId() + ";");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    public void deleteContractor(int id) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from contractor where id=" + id + ";");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    public List<Seller> getSellers() {
        List<Seller> entities = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM seller");

            while (rs.next()) {
                Seller state = new Seller(rs.getInt("id"), rs.getString("surname"),
                        rs.getString("name"));
                entities.add(state);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        return entities;
    }

    public void addSeller(Seller c) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into seller (name,surname) "
                    + "values ('" + c.getName() + "','" + c.getSurname() + "');");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    public void addSellerPrepared(Seller c) {
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into seller (name,surname) "
                    + "values (?,?);");

            stmt.setString(1, c.getName());
            stmt.setString(2, c.getSurname());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    public void addSellersPrepared(ArrayList<Seller> c) {
        try {
            PreparedStatement stmt = connection.prepareStatement("insert into seller (name,surname) "
                    + "values (?,?);");

            for (int i = 0; i < c.size(); i++) {
                stmt.setString(1, c.get(i).getName());
                stmt.setString(2, c.get(i).getSurname());

                stmt.addBatch();
            }
            stmt.executeBatch();

//            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    public void addSellers(ArrayList<Seller> c) {
        try {
            String s = "insert into seller (name,surname) "
                    + "values ";

            for (int i = 0; i < c.size(); i++) {
                s += "('" + c.get(i).getName() + "','" + c.get(i).getSurname() + "'),";
            }
            s = s.substring(0, s.length() - 1);

            Statement statement = connection.createStatement();
            statement.executeUpdate(s + ";");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    public void editSeller(Seller c) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("update seller set name='" + c.getName()
                    + "',surname='" + c.getSurname()
                    + "' where id=" + c.getId() + ";");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    public void deleteSeller(int id) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from seller where id=" + id + ";");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    public List<Product> getProducts() {
        List<Product> entities = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM products");

            while (rs.next()) {
                Product state = new Product(rs.getInt("id"), rs.getString("name"),
                        rs.getInt("price"), rs.getInt("quantity"), rs.getInt("contractor_id"));

                entities.add(state);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        return entities;
    }

    public Contractor getContractor(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM contractor where id=" + id);
            Contractor state;
            while (rs.next()) {
                state = new Contractor(rs.getInt("id"), rs.getString("name"),
                        rs.getString("adress"), rs.getString("phone_number"));
                return state;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        return null;
    }

    public void addProduct(Product c) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into products (name,price,quantity,contractor_id) "
                    + "values ('" + c.getName() + "','" + c.getPrice()
                    + "','" + c.getQuantity() + "','" + c.getContractor_id() + "');");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    public void editProduct(Product c) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("update products set name='" + c.getName()
                    + "',price='" + c.getPrice()
                    + "',quantity='" + c.getQuantity()
                    + "',contractor_id='" + c.getContractor_id()
                    + "' where id=" + c.getId() + ";");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    public void deleteProduct(int id) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from products where id=" + id + ";");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }

    public void addSale(Sale sale, ArrayList<SaleProducts> sales) {
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into sale (data,seller_id) "
                    + "values ('" + sale.getData() + "','" + sale.getSeller_id() + "');",
                    Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys();
            int sale_id = -1;
            if (rs.next()) {
                sale_id = rs.getInt(2);
            }

            for (int i = 0; i < sales.size(); i++) {

                Statement getStatement = connection.createStatement();
                ResultSet rsg = getStatement.executeQuery("SELECT * FROM products where id=" + sales.get(i).getProducts_id());
                int quantity = -1;
                while (rsg.next()) {
                    quantity = rsg.getInt("quantity");
                }
                if (quantity < sales.get(i).getQuantity()) {
                    JOptionPane.showMessageDialog(new JFrame(), "not enough product");
                    connection.rollback();
                    return;
                }
                statement.executeUpdate("insert into saleproducts (products_id,saleid,quantity) "
                        + "values ('" + sales.get(i).getProducts_id() + "','" + sale_id + "','"
                        + sales.get(i).getQuantity() + "');");

                statement.executeUpdate("update products set quantity='" + (quantity - sales.get(i).getQuantity())
                        + "' where id=" + sales.get(i).getProducts_id() + ";");
            }

            connection.commit();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Sale> getSales() {
        List<Sale> entities = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM sale");

            while (rs.next()) {
                Sale state = new Sale(rs.getInt("id"), rs.getDate("data"), rs.getInt("seller_id"));

                entities.add(state);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        return entities;
    }

    public Seller getSeller(int id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM seller where id=" + id);
            Seller state;
            while (rs.next()) {
                state = new Seller(rs.getInt("id"), rs.getString("surname"),
                        rs.getString("name"));

                return state;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        return null;
    }

    public List<SaleProducts> getSalesProducts(int sale_id) {
        List<SaleProducts> entities = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM saleproducts where saleid=" + sale_id);

            while (rs.next()) {
                SaleProducts state = new SaleProducts(sale_id, rs.getInt("products_id"),
                        rs.getInt("quantity"));
                entities.add(state);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        return entities;
    }

    public Product getProduct(int products_id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM products where id=" + products_id);
            Product state;
            while (rs.next()) {
                state = new Product(rs.getInt("id"), rs.getString("name"),
                        rs.getInt("price"), rs.getInt("quantity"), rs.getInt("contractor_id"));

                return state;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        return null;
    }

    public void deleteSale(int id) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from saleproducts where saleid=" + id + ";");
            statement.executeUpdate("delete from sale where id=" + id + ";");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
    }
//
//    public void editSale(Sale editEntity, ArrayList<SaleProducts> sales) {
//        try {
//            connection.setAutoCommit(false);
//            Statement statement = connection.createStatement();
//            statement.executeUpdate("insert into sale (data,seller_id) "
//                    + "values ('" + sale.getData() + "','" + sale.getSeller_id() + "');",
//                    Statement.RETURN_GENERATED_KEYS);
//
//            ResultSet rs = statement.getGeneratedKeys();
//            int sale_id = -1;
//            if (rs.next()) {
//                sale_id = rs.getInt(2);
//            }
//
//            for (int i = 0; i < sales.size(); i++) {
//
//                Statement getStatement = connection.createStatement();
//                ResultSet rsg = getStatement.executeQuery("SELECT * FROM products where id=" + sales.get(i).getProducts_id());
//                int quantity = -1;
//                while (rsg.next()) {
//                    quantity = rsg.getInt("quantity");
//                }
//                if (quantity < sales.get(i).getQuantity()) {
//                    JOptionPane.showMessageDialog(new JFrame(), "not enough product");
//                    connection.rollback();
//                    return;
//                }
//                statement.executeUpdate("insert into saleproducts (products_id,saleid,quantity) "
//                        + "values ('" + sales.get(i).getProducts_id() + "','" + sale_id + "','"
//                        + sales.get(i).getQuantity() + "');");
//
//                statement.executeUpdate("update products set quantity='" + (quantity - sales.get(i).getQuantity())
//                        + "' where id=" + sales.get(i).getProducts_id() + ";");
//            }
//
//            connection.commit();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
//        } finally {
//            try {
//                connection.setAutoCommit(true);
//            } catch (SQLException ex) {
//                Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }

    public void editSale(int id, Sale sale, ArrayList<SaleProducts> sales) {

        try {
            connection.setAutoCommit(false);

            deleteSale(id);

            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into sale (data,seller_id) "
                    + "values ('" + sale.getData() + "','" + sale.getSeller_id() + "');",
                    Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = statement.getGeneratedKeys();
            int sale_id = -1;
            if (rs.next()) {
                sale_id = rs.getInt(2);
            }

            for (int i = 0; i < sales.size(); i++) {

                Statement getStatement = connection.createStatement();
                ResultSet rsg = getStatement.executeQuery("SELECT * FROM products where id=" + sales.get(i).getProducts_id());
                int quantity = -1;
                while (rsg.next()) {
                    quantity = rsg.getInt("quantity");
                }
                if (quantity < sales.get(i).getQuantity()) {
                    JOptionPane.showMessageDialog(new JFrame(), "not enough product");
                    connection.rollback();
                    return;
                }
                statement.executeUpdate("insert into saleproducts (products_id,saleid,quantity) "
                        + "values ('" + sales.get(i).getProducts_id() + "','" + sale_id + "','"
                        + sales.get(i).getQuantity() + "');");

                statement.executeUpdate("update products set quantity='" + (quantity - sales.get(i).getQuantity())
                        + "' where id=" + sales.get(i).getProducts_id() + ";");
            }

            connection.commit();

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void fillMainTable(DefaultTableModel model) {

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        try {
            PreparedStatement pstm = connection.prepareStatement("SELECT  seller.name as Contractor,products.name as Product,saleproducts.quantity,data\n"
                    + "	FROM public.saleproducts, sale, products,seller where sale.id=saleproducts.saleid and products_id=products.id and seller.id=seller_id");
            ResultSet Rs = pstm.executeQuery();

            while (Rs.next()) {
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),
                    Rs.getString(3), Rs.getString(4)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
