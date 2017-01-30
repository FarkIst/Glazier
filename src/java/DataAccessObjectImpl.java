

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DataAccessObjectImpl implements DataAccessObject {

    public double getFrameprice(Calculator.FRAMETYPE frametype) throws Exception {
        try {
            DBConnector con = new DBConnector();
            Statement stmt = con.getConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT price FROM `prices` WHERE `prod_type` = '" + frametype.toString().toLowerCase() + "';");
            if (!res.next()) {
                throw new Exception("Empty ResultSet!");
            }
            double price = res.getDouble("price");
            return price;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new Exception("Database exception:\n" + e.getMessage() + "!");
        }
    }

    public double getGlassprice() throws Exception {
        try {
            DBConnector con = new DBConnector();
            Statement stmt = con.getConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT price FROM `prices` WHERE `prod_name` = 'glass';");
            if (!res.next()) {
                throw new Exception("Empty ResultSet!");
            }
            double price = res.getDouble("price");
            return price;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new Exception("Database exception:\n" + e.getMessage() + "!");
        }
    }
}
