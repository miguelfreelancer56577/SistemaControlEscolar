/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package utileria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class recuperar_ultimo {

public int recuperar_identificacion_personal() {
    int tipo=0;//manda ala pag dpndiendo dl tipo d usuario
    conexion con=new conexion();//se crea una instancia conexion
    Connection micon= null;
    PreparedStatement st=null;
    ResultSet rs=null;
    micon=con.mySql();//para ya no realizar el mismo procedimiento de la coneccion

        try {
            st = micon.prepareStatement("select count(*) from identificacion_personal;");
            rs=st.executeQuery();//realiza consulta
            rs.next();
            tipo=rs.getInt(1);//para solamente quiere traer un campo
            micon.close();
            st.close();
            rs.close();
        }//termian try
            catch (SQLException ex) {
               Logger.getLogger(recuperar_ultimo.class.getName()).log(Level.SEVERE, null, ex);
            }//termina 1er catch

          return tipo;
    }
//---------------------------------------------------------------------------------------

public int recuperar_situacion_academica() {
    int tipo=0;//manda ala pag dpndiendo dl tipo d usuario
    conexion con=new conexion();//se crea una instancia conexion
    Connection micon= null;
    PreparedStatement st=null;
    ResultSet rs=null;
    micon=con.mySql();//para ya no realizar el mismo procedimiento de la coneccion

        try {
            st = micon.prepareStatement("select count(*) from situacion_academica;");
            rs=st.executeQuery();//realiza consulta
            rs.next();
            tipo=rs.getInt(1);//para solamente quiere traer un campo
            micon.close();
            st.close();
            rs.close();
        }//termian try
            catch (SQLException ex) {
               Logger.getLogger(recuperar_ultimo.class.getName()).log(Level.SEVERE, null, ex);
            }//termina 1er catch

          return tipo;
    }

//---------------------------------------------------------------------------------------

public String recuperar_foto_alumno( int usuario) {
    String url_foto="";//manda ala pag dpndiendo dl tipo d usuario
    conexion con=new conexion();//se crea una instancia conexion
    Connection micon= null;
    PreparedStatement st=null;
    ResultSet rs=null;
    micon=con.mySql();//para ya no realizar el mismo procedimiento de la coneccion

        try {
            st = micon.prepareStatement("SELECT url from fotos_alumnos,identificacion_personal where usuario="+usuario+" and fotos_alumnos.matricula=identificacion_personal.matricula;");
            rs=st.executeQuery();//realiza consulta
            rs.next();
            url_foto=rs.getString(1);//recupera foto
            micon.close();
            st.close();
            rs.close();
        }//termian try
            catch (SQLException ex) {
               Logger.getLogger(recuperar_ultimo.class.getName()).log(Level.SEVERE, null, ex);
            }//termina 1er catch

          return url_foto;
    }

public int recuperar() {
    int tipo=0;//manda ala pag dpndiendo dl tipo d usuario
    conexion con=new conexion();//se crea una instancia conexion
    Connection micon= null;
    PreparedStatement st=null;
    ResultSet rs=null;
    micon=con.mySql();//para ya no realizar el mismo procedimiento de la coneccion

        try {
            st = micon.prepareStatement("select count(*) from identificacion_personal;");
            rs=st.executeQuery();//realiza consulta
            rs.next();
            tipo=rs.getInt(1);//para solamente quiere traer un campo
            micon.close();
            st.close();
            rs.close();
        }//termian try
            catch (SQLException ex) {
               Logger.getLogger(recuperar_ultimo.class.getName()).log(Level.SEVERE, null, ex);
            }//termina 1er catch

          return tipo;
    }

}
