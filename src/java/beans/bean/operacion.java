/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans.bean;

import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utileria.conexion;

import utileria.var_global_busquedad_calificaciones;
import utileria.var_globales;

/**
 *
 * @author mary
 */
public class operacion implements Serializable {

    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";

    private String sampleProperty;

    private PropertyChangeSupport propertySupport;

    public operacion() {
        propertySupport = new PropertyChangeSupport(this);
    }

    public String getSampleProperty() {
        return sampleProperty;
    }

    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    public int usuario(String usuario, String contra) {
    int tipo=0;
    conexion con=new conexion();//se crea una instancia
    Connection micon= null;
    PreparedStatement st=null;
    ResultSet rs=null;
    micon=con.mySql();//para ya no realizar el mismo procedimiento de la coneccion

        try {
            st = micon.prepareStatement("SELECT clave FROM identificacion_personal WHERE usuario="+usuario+" AND contrasena="+contra);
            rs=st.executeQuery();
            rs.next();
            tipo=rs.getInt(1);//para solamente quiere traer un campo           
            micon.close();
            st.close();
            rs.close();
        }//termian try
            catch (SQLException ex) {
               Logger.getLogger(operacion.class.getName()).log(Level.SEVERE, null, ex);
            }//termina 1er catch

          return tipo;
    }//termina el metodo usuario

//____________________________________________________________________________________________________________________
public String regresa_datos(String usuario, String contra) {
    String datos="";
    conexion con=new conexion();//se crea una instancia
    Connection micon= null;
    PreparedStatement st=null;
    ResultSet rs=null;
    micon=con.mySql();//para ya no realizar el mismo procedimiento de la coneccion

        try {
            st = micon.prepareStatement("SELECT apeido_pa,apeido_ma,nombres,carrera,matricula FROM identificacion_personal WHERE usuario="+usuario+" and contrasena="+contra);
            rs=st.executeQuery();
            rs.next();
       
            datos+="<tr>"
                    + "<th align=\"center\" height=\"10\" >Nombre: </th>"
                    + "<td align=\"left\" height=\"10\" >"+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+"</td>"
                    + "<th align=\"center\" height=\"10\" >Carrera: </th>"
                    + "<td align=\"left\" height=\"10\" >"+rs.getString(4)+"</td></tr><tr>"
                    + "<th align=\"center\" height=\"10\" colspan=\"2\" >Matricula: </th>"
                    + "<td align=\"left\" height=\"10\" colspan=\"2\" >"+rs.getString(5)+"</td></tr>";
        

            micon.close();
            st.close();
            rs.close();
        }//termian try
            catch (SQLException ex) {
               Logger.getLogger(operacion.class.getName()).log(Level.SEVERE, null, ex);
               datos="no se pudo";
            }//termina 1er catch

          return datos;
    }//termina el metodo usuario

//____________________________________________________________________________________________________________________

    public String inserta_tabla (String a, String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m,String n,String o,String p,String q,String r,String s,String t,String u){
       String res="";
        conexion con= new conexion();
        Connection micon =null;
        PreparedStatement st=null;
        micon=con.mySql();

        try {
            st=micon.prepareStatement("INSERT INTO identificacion_personal values("+c+",'"+f+"','"+g+"','"+h+"',"+a+","+b+",'"+d+"',2)");
            st.executeUpdate();
            st=micon.prepareStatement("INSERT INTO datos_personales values("+c+","+e+","+i+",'"+j+"','"+k+"','"+l+"','"+m+"','"+n+"','"+o+"', '"+p+"',"+q+","+r+","+s+",'"+t+"','"+u+"')");
            st.executeUpdate();
            micon.close();
            st.close();
            res="<h1><a href=\"altas.jsp\">Se guardo correctamente desea Registrar Otro</a></H1><br><br><br>"
                    + "<h1><a href=\"administrativo.jsp\">Regresar al Menu principal</a></H1>";
        } catch (SQLException ex) {
            Logger.getLogger(operacion.class.getName()).log(Level.SEVERE, null, ex);
            res=res+ex;
        }
       return res;
   }//TERMINA LA CLASE inserta_tabla
//_________________________________________________________________________________________________________________________
    
        public String busca_grupos(String dato){
        String res="";
        conexion con=new conexion();
        Connection micon=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        micon=con.mySql();

        try {
            st=micon.prepareStatement("SELECT datos_personales.matricula,apeido_pa,apeido_ma,nombres,carrera FROM identificacion_personal,datos_personales where grupo="+dato+" AND identificacion_personal.matricula=datos_personales.matricula;");
            rs=st.executeQuery();
 res+="<html><head><title>genera_tab</title>"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head>"
                        + "<BODY  background=\"images/logoestadodemex.jpg\" LINK=\"#0000FF\" VLINK=\"0000FF\" ALINK=\"0000FF\" >"
                        + "<center><table width=\"900\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" BGCOLOR=\"#FFFFFF\" ><tr>"
                        + "<td width=\"900\" bgcolor=\"#FFFFFF\"><img src=\"images/Imagencontrol.jpg\" width=\"900\" height=\"120\" border=\"0\" ALT=\"FONDO LOGO\"/>"
                        + "</td></tr></table></center>"
                        + "<P align=\"center\">IXTAPALUCA ESTADO DE MEXICO A 03 DE ABRIL DEL 2012</P><br><br><br><center>"
                        + "<table border=\"3\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"><tr>"
                        + "<td align=\"center\" colspan=\"6\" height=\"10\" >No.</td>"
                        + "<td align=\"center\" colspan=\"6\" height=\"10\" >Matricula</td>"
                        + "<td align=\"center\" colspan=\"6\" height=\"10\" >Nombre</td>"
                        + "<td align=\"center\" colspan=\"6\" height=\"10\" >Carrera</td>"
                        + "<td align=\"center\" colspan=\"6\" height=\"10\" >Ingresar Calificacion</td></tr>";
            int cont=0;
            while(rs.next()){
                    res+="<tr>"
                            + "<td align=\"center\" colspan=\"6\" height=\"10\" >"+(cont+=1)+"</td>"
                            + "<td align=\"center\" colspan=\"6\" height=\"10\" >"+rs.getString(1)+"</td>"
                            + "<td align=\"center\" colspan=\"6\" height=\"10\" >"+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"</td>"
                            + "<td align=\"center\" colspan=\"6\" height=\"10\" >"+rs.getString(5)+"</td>"
                            + "<td align=\"center\" colspan=\"6\" height=\"10\" ><a href=\"calificaciones2.jsp?ma="+rs.getString(1)+"&nom="+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"&carr="+rs.getString(5)+"\" target=\"_blank\"><img src=\"images/calificaciones.jpg\" width=\"40\" height=\"40\" alt=\"calificaciones\"/>"
                            + "</a></td></tr>";
            }
res+="</table></center></body></html>";
            micon.close();
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(operacion.class.getName()).log(Level.SEVERE, null, ex);
//            res+="todo mal";
        }
 return res;
    }
//_________________________________________________________________________________________________


    public String almacena_calificaciones(int num,String a1,String a2,String a3,String a4,String a5,String a6){
       String res="";
        conexion con= new conexion();
        Connection micon =null;
        PreparedStatement st=null;
        micon=con.mySql();

        try {
            st=micon.prepareStatement("INSERT INTO situacion_academica values ("+num+","+a1+",'"+a2+"',"+a3+","+a4+","+a5+","+a6+");");
            st.executeUpdate();
            micon.close();
            st.close();
            res="<h1><a href=\"calificaciones2.jsp?ma="+a1+"&nom="+var_global_busquedad_calificaciones.var_global_busquedad_calificaciones_nom+"&carr="+var_global_busquedad_calificaciones.var_global_busquedad_calificaciones_carr+"\">Se guardo correctamente desea Registrar Otro</a></H1><br><br><br>";
        } catch (SQLException ex) {
            Logger.getLogger(operacion.class.getName()).log(Level.SEVERE, null, ex);
            res=res+ex;
        }
       return res;
   }//TERMINA LA CLASE inserta_tabla
//_________________________________________________________________________________________________________________________

    public String busca_semestre(String sem){
        
        var_globales.semestre=Integer.parseInt(sem);
        int usuario=var_globales.matri;
        String res="";
        conexion con=new conexion();
        Connection micon=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        micon=con.mySql();

        try {
            st=micon.prepareStatement("select materia,creditos,calificacion from situacion_academica,identificacion_personal where semestre="+sem+" and usuario="+usuario+" and identificacion_personal.matricula=situacion_academica.matricula");
            rs=st.executeQuery();
            
          res+="<html><head><title>genera_tabla_califiaciones</title>"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"></head>"
                + "<BODY  background=\"images/logoestadodemex.jpg\" LINK=\"#0000FF\" VLINK=\"0000FF\" ALINK=\"0000FF\" ><center>"
                + "<table width=\"900\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" BGCOLOR=\"#FFFFFF\" ><tr>"
                + "<td width=\"900\" bgcolor=\"#FFFFFF\"><img src=\"images/Imagencontrol.jpg\" width=\"900\" height=\"120\" border=\"0\" ALT=\"FONDO LOGO\"></td>"
                + "</tr></table></center>"+"<h2 align=\"center\">Verifica que tus calificaciones sean las correctas.</h2>" + "<P align=\"center\">IXTAPALUCA ESTADO DE MEXICO A 03 DE ABRIL DEL 2012</P><center><table><tr>"
                + "<td align=\"center\" colspan=\"3\" height=\"10\" >REGRESAR</td><td align=\"right\" colspan=\"3\""
                + " height=\"60\" ><a href=\"consultacalificaciones.jsp\" >"
                + "<img src=\"images/regresar.bmp\" width=\"90\" height=\"60\" ALT=\"imprimir\" /></a></td></tr></table></center><br><br><br>"+"<center><table width=\"40%\"   border=\"0\" align=\"center\" cellpadding=\"1\" cellspacing=\"1\">"
                + var_globales.datos_consulta+"</table></center>"+"<BR>"+"<BR>"+"<BR>"+"<center>"+"<table background=\"images/piensa_enG.jpg\" width=\"60%\"   border=\"3\" align=\"center\" cellpadding=\"2\" cellspacing=\"2\"><tr>" + "<th align=\"center\" height=\"10\" >Materia </th>"
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

            res+="</table></center><br><br><br><center><table><tr>"
                    + "<td align=\"center\" colspan=\"3\" height=\"90\" ><a href=\"pdf_tabla\" target=\"_blank\">"
                    + "<img src=\"images/imprimir.jpg\" width=\"92\" height=\"90\" ALT=\"imprimir\" /></a></td></tr><tr>"
                    + "<td align=\"center\" colspan=\"3\" height=\"10\" >GENERAR PDF</td></tr></table></center></body></html>";

           
            micon.close();
            st.close();
            rs.close();
        } catch (SQLException ex) {

            Logger.getLogger(operacion.class.getName()).log(Level.SEVERE, null, ex);
res+=ex;
        }
        
 return res;
    }
//_________________________________________________________________________________________________

//PARTE DE MARY_________________________________________________________________________________________________

    public String busca(String nom){

        String nombre=nom;

        String res="";
        conexion con=new conexion();
        Connection micon=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        micon=con.mySql();
        try {
            st=micon.prepareStatement("SELECT datos_personales.matricula,apeido_pa, apeido_ma, nombres, carrera,grupo,telefono,sexo,calle,mz,lt,colonia,municipio,nacimiento,dia,mes,ano,rfc,curp FROM identificacion_personal,datos_personales where identificacion_personal.nombres like '"+nom+"%' and datos_personales.matricula=identificacion_personal.matricula;");
            rs=st.executeQuery();
            res+="<center><table width=\"900\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" BGCOLOR=\"#FFFFFF\" ><tr>"
                    + "<td width=\"900\" bgcolor=\"#FFFFFF\"><img src=\"images/Imagenalumno.jpg\" width=\"900\" height"
                    + "=\"120\" border=\"0\" ALT=\"FONDO LOGO\"></td></tr></table></center><BODY  background=\"images/logoestadodemex.jpg\" LINK=\"#0000FF\" VLINK=\"0000FF\" ALINK=\"0000FF\" >"
                    +"<table background=\"images/logoestadodemex.jpg\" width=\"100%\"   border=\"3\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" >"
                    + "<thead>"
                    + "<tr>"
                    + "<th>MATRICULA</th>"
                    + "<th>NOMBRE COMPLETO</th>"
                    + "<th>CARRERA</th>"
                    + "<th>ELIMINAR</th>"
                    + "<th>MODIFICAR</th>"
                    + "</tr>"
                    + "</thead>"

                    + "</BODY>"
                    + "<a href=\"plantilla.jsp \"><img src=\"images/regresar.bmp\" width=\"80\" height=\"50\"></a>";
            while(rs.next()){
                    res+="<tr>"+ "<th>"+rs.getString(1)+"</th>"
                    + "<th>"+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"</th>"
                    + "<th>"+rs.getString(5)+"</th>"
                    +"<td><a href=\"eliminar?ma="+rs.getString(1)+"\"><img src=\"images/eliminar.jpg\"></td>"
                    + "<td><a href=\"modificar.jsp?mat="+rs.getString(1)+"&ape_pa="+rs.getString(2)+"&ape_ma="+rs.getString(3)+"&nom="+rs.getString(4)+"&car="+rs.getString(5)+"&grup="+rs.getString(6)+"&tel="+rs.getString(7)+"&sex="+rs.getString(8)+"&calle="+rs.getString(9)+"&mz="+rs.getString(10)+"&lt="+rs.getString(11)+"&col="+rs.getString(12)+"&mun="+rs.getString(13)+"&naci="+rs.getString(14)+"&dia="+rs.getString(15)+"&mes="+rs.getString(16)+"&ano="+rs.getString(17)+"&rfc="+rs.getString(18)+"&curp="+rs.getString(19)+"\"><img src=\"images/editar.jpg\"></a></td>"

                    + "</tr>";
            }
            res+="</table>";
            micon.close();
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(operacion.class.getName()).log(Level.SEVERE, null, ex);
//            res+="todo mal";
        }
        return res;
    }
    //------------------------------------------------------------------------------------------------------------------------------
    public String eliminar(String ma){
    String  res="";
    conexion con=new conexion();
        Connection micon=null;
        PreparedStatement st=null;
        micon=con.mySql();
        try {
             st=micon.prepareStatement("delete from datos_personales where matricula="+ma);
            st.executeUpdate();//es solo para agreagar modificar y eliminar se usa el update
            st=micon.prepareStatement("delete from identificacion_personal where matricula="+ma);
            st.executeUpdate();//es solo para agreagar modificar y eliminar se usa el update

             micon.close();
            st.close();
           res="<BODY  background=\"images/logoestadodemex.jpg\" LINK=\"#0000FF\" VLINK=\"0000FF\" ALINK=\"0000FF\" ><a href=\"plantilla.jsp \">se elimino el registro correcatamente</a></BODY>";
        } catch (SQLException ex) {
            Logger.getLogger(operacion.class.getName()).log(Level.SEVERE, null, ex);
            res+=ex;
        }

        return res;
    }
//----------------------------------------------------------------------------------------------------------------------------------
    public String modificado(String ma, String a,String b, String c,String d,String e, String f, String g, String h, String i, String j,String k, String l, String m, String n, String o, String p, String q, String r){
        int matricula=Integer.parseInt(ma);
        int dia=Integer.parseInt(n);
        int mes=Integer.parseInt(o);
        int ano=Integer.parseInt(p);
        String res="";
        conexion con=new conexion();
        Connection micon=null;
        PreparedStatement st=null;
        micon=con.mySql();
        try {
             st=micon.prepareStatement("update identificacion_personal set apeido_pa='"+a+"',apeido_ma='"+b+"',nombres='"+c+"',carrera='"+d+"' where matricula="+ma);
            st.executeUpdate();//es solo para agreagar modificar y eliminar se usa el update
            st=micon.prepareStatement("update datos_personales set grupo="+f+",telefono="+g+",sexo='"+e+"',calle='"+h+"',mz='"+i+"',lt='"+j+"',colonia='"+k+"',municipio='"+l+"',nacimiento='"+m+"',dia="+n+",mes="+o+",ano="+p+",rfc='"+r+"',curp='"+q+"' where matricula="+ma);
            st.executeUpdate();//es solo para agreagar modificar y eliminar se usa el update
             micon.close();
            micon.close();
            st.close();
            res="<BODY  background=\"images/logoestadodemex.jpg\" LINK=\"#0000FF\" VLINK=\"0000FF\" ALINK=\"0000FF\" ><a href=\"plantilla.jsp \">se modifico correctamente el registro</a></BODY>";
        } catch (SQLException ex) {
            Logger.getLogger(operacion.class.getName()).log(Level.SEVERE, null, ex);
            res=res+ex;
        }
        return res;
    }

//_________________________________________________________________________________________________

    public String busca_matricula(String nom){

        String nombre=nom;

        String res="";
        conexion con=new conexion();
        Connection micon=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        micon=con.mySql();
        try {
            st=micon.prepareStatement("SELECT datos_personales.matricula,apeido_pa, apeido_ma, nombres, carrera,grupo,telefono,sexo,calle,mz,lt,colonia,municipio,nacimiento,dia,mes,ano,rfc,curp FROM identificacion_personal,datos_personales where identificacion_personal.matricula like '"+nom+"%' and datos_personales.matricula=identificacion_personal.matricula;");
            rs=st.executeQuery();
            res+="<BODY  background=\"images/logoestadodemex.jpg\" LINK=\"#0000FF\" VLINK=\"0000FF\" ALINK=\"0000FF\" >"
                    +"<table background=\"images/logoestadodemex.jpg\" width=\"100%\"   border=\"3\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" >"
                    + "<thead>"
                    + "<tr>"
                    + "<th>MATRICULA</th>"
                    + "<th>NOMBRE COMPLETO</th>"
                    + "<th>CARRERA</th>"
                    + "<th>ELIMINAR</th>"
                    + "<th>MODIFICAR</th>"
                    + "</tr>"
                    + "</thead>"

                    + "</BODY>"
                    + "<a href=\"plantilla.jsp \"><img src=\"images/atras1.png\" width=\"80\" height=\"50\"></a>";
            while(rs.next()){
                    res+="<tr>"+ "<th>"+rs.getString(1)+"</th>"
                    + "<th>"+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+"</th>"
                    + "<th>"+rs.getString(5)+"</th>"
                    +"<td><a href=\"eliminar?ma="+rs.getString(1)+"\"><img src=\"images/eliminar.jpg\"></td>"
                    + "<td><a href=\"modificar.jsp?mat="+rs.getString(1)+"&ape_pa="+rs.getString(2)+"&ape_ma="+rs.getString(3)+"&nom="+rs.getString(4)+"&car="+rs.getString(5)+"&grup="+rs.getString(6)+"&tel="+rs.getString(7)+"&sex="+rs.getString(8)+"&calle="+rs.getString(9)+"&mz="+rs.getString(10)+"&lt="+rs.getString(11)+"&col="+rs.getString(12)+"&mun="+rs.getString(13)+"&naci="+rs.getString(14)+"&dia="+rs.getString(15)+"&mes="+rs.getString(16)+"&ano="+rs.getString(17)+"&rfc="+rs.getString(18)+"&curp="+rs.getString(19)+"\"><img src=\"images/editar.jpg\"></a></td>"

                    + "</tr>";
            }
            res+="</table>";
            micon.close();
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(operacion.class.getName()).log(Level.SEVERE, null, ex);
//            res+="todo mal";
        }
        return res;
    }
    //------------------------------------------------------------------------------------------------------------------------------

}//termina la clase
