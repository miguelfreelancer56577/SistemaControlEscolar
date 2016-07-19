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

public class recupera_tabla_ultimo_semestre {

    public int recupera_numero_ultimo_semestre() {
    int tipo=0;//manda ala pag dpndiendo dl tipo d usuario
    conexion con=new conexion();//se crea una instancia conexion
    Connection micon= null;
    PreparedStatement st=null;
    ResultSet rs=null;
    micon=con.mySql();//para ya no realizar el mismo procedimiento de la coneccion

        try {
            st = micon.prepareStatement("SELECT semestre from situacion_academica,identificacion_personal where usuario="+var_globales.matri+" and identificacion_personal.matricula=situacion_academica.matricula order by semestre desc limit 1;");
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


    public String busca_semestre(int sem){

        int usuario=var_globales.matri;
        String res="";
        conexion con=new conexion();
        Connection micon=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        micon=con.mySql();

        try {
            st=micon.prepareStatement("select materia,creditos,calificacion from situacion_academica,identificacion_personal where semestre="+sem+" and usuario="+usuario+" and identificacion_personal.matricula=situacion_academica.matricula");

            //SELECT semestre from situacion_academica order by semestre desc;

            rs=st.executeQuery();

          res+="<center>"
                + "<table background=\"images/piensa_enG.jpg\" width=\"60%\"   border=\"3\" align=\"center\" cellpadding=\"2\" cellspacing=\"2\"><tr>"
                + "<th align=\"center\" height=\"10\" >Materia </th>"
                + "<th align=\"center\" height=\"10\" >1er. Parcial </th>"
                + "<th align=\"center\" height=\"10\" >2do. Parcial</th>"
                + "<th align=\"center\" height=\"10\" >3er. Parcial</th>"
                + "<th align=\"center\" height=\"10\" >Calificacion Total</th>"
                + "<th align=\"center\" height=\"10\" >Creditos</th></tr>";

            int[] cali=new int[15];
            String[] mat=new String[15];
            int[] credi=new int[15];

            int cont=0;

            while(rs.next()){
                mat[cont]=rs.getString(1);
                credi[cont]=rs.getInt(2);
                cali[cont]=rs.getInt(3);

                cont+=1;
            }

              cont=0;

           //rellena el arreglo para el archivo pdf

           for(int i=0;i<15;i++){
               var_globales.materia[i]=mat[i];
                var_globales.creditos[i]=credi[i];
                var_globales.calificacion[i]=cali[i];
            }

          /*  for(int i=0;i<15;i++){
            res+=mat[i]+"__"+cali[i]+"__"+credi[i]+"<br>";
            }
           *
           */

            for(int i=0;i<15;i++){
            res+="<tr>"
                            + "<td align=\"center\" height=\"10\" >"+mat[i]+"</td>"
                            + "<td align=\"center\" height=\"10\" >"+cali[i]+"</td>"
                            + "<td align=\"center\" height=\"10\" >"+(cali[i+1])+"</td>"
                            + "<td align=\"center\" height=\"10\" >"+(cali[i+2])+"</td>"
                            + "<td align=\"center\" height=\"10\" >"+((cali[i]+cali[i+1]+cali[i+2])/3)+"</td>"
                            + "<td align=\"center\" height=\"10\" >"+(credi[i]+credi[i+1]+credi[i+2])+"</td>"
                            + "</tr>";
            i+=2;

            }

            res+="</table></center>";


            micon.close();
            st.close();
            rs.close();
        } catch (SQLException ex) {

            Logger.getLogger(recupera_tabla_ultimo_semestre.class.getName()).log(Level.SEVERE, null, ex);
res+=ex;
        }

 return res;
    }

}
