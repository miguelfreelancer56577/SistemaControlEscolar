/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utileria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mary
 */
public class conexion {

       public Connection mySql(){
       Connection con=null;

        try {
                 Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3308/control_escolar_tesi", "root", "usbw");

            }//termina try
                   catch (SQLException ex) {
                    Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            }//termina catch
                   catch (ClassNotFoundException ex) {
                    Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }//termina catch 
       return con;
       }
}
