/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAL.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Win 8 32bit VS7
 */
public class ConnectionDBa {

    protected Connection cn;
    String url = "jdbc:sqlserver://";
    String serverName = "localhost";
    String portNumber = "1433";
    String instanceName = ".";
    String databaseName = "CoffeManagement_DB";
    String userName = "sa";
    String password = "123";
    
    public void getConn(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            cn = DriverManager.getConnection(url + serverName + ";portNumber=" + portNumber + ";databaseName="
                    + databaseName, userName, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDBa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ConnectionDBa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ConnectionDBa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDBa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void closeConn(){
        try {
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDBa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
