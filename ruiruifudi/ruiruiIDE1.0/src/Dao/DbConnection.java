
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    public static void main(String[] args) {
        System.out.println(DbConnection.getDB());
    }
    
    //連接資料庫的方法
    public static Connection getDB()
    {
        Connection conn=null;
        String url="jdbc:mysql://localhost:3306/liuruirui";
        String user="root";
        String passwodr="870527";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url, user, passwodr);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

         return conn;
    }
    
    
}
