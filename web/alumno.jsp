<%-- 
    Document   : alumno
    Created on : 13/03/2012, 07:24:51 PM
    Author     : mary
--%>


<%@page import="utileria.var_globales"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%--
 HttpSession sesion=request.getSession();// se obtiene la sesion que ya se creo
 // en el atributo se se guarda tipo(se castea con integer)
if(sesion.getAttribute("se")==null){
    response.sendRedirect("index.jsp");
}
 --%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONTROL_ESCOLAR_ALUMNOS</title>
    </head>
   <BODY  LINK="#0000FF" VLINK="0000FF" ALINK="0000FF" background="images/logoestadodemex.jpg">


<center>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0" BGCOLOR="#FFFFFF" >

<tr>
           <td width="900" bgcolor="#FFFFFF"><img src="images/Imagenalumno.jpg" width="900" height="120" border="0" ALT="FONDO LOGO"></td>
</tr>


</table>
</center>
       <br>
       <br>
       <P ALIGN="CENTER"><% java.util.Calendar fecha = java.util.Calendar.getInstance();out.println("IXTAPALUCA ESTADO DE MEXICO A "+fecha.get(java.util.Calendar.DATE) + " DEL MES "  + fecha.get(java.util.Calendar.MONTH)    + " DEL "  + fecha.get(java.util.Calendar.YEAR));%></P>
       <br>
<P ALIGN="CENTER">BIENVENIDO</P>

<center>
<table width="40%"   border="0" align="center" cellpadding="1" cellspacing="1">
    <%
out.print(var_globales.datos_consulta);
//var_globales.datos_consulta="";
    %>
   </table>
</center>

       <br>
       <br>
       <%
        
       out.print("<H3 ALIGN=\"CENTER\"> <a href=\"consultacalificaciones.jsp?usu2="+request.getParameter("usu")+"\"><img src=\"images/CONSULTA DE CALIFICACIONES.jpg\" width=\"76\" height=\"76\" ALT=\"BOTON\" /></a>   CONSULTA DE CALIFICACIONES</H3>"
               + "<H3 ALIGN=\"CENTER\"> <a href=\"boletadecalificaciones.jsp?usu2="+request.getParameter("usu")+"\"><img src=\"images/BOLETA DE CALIFICACIONES.jpg\" width=\"76\" height=\"76\" ALT=\"BOTON\" /></a>  BOLETA DE CALIFICACIONES</H3>");

        %>
    </body>   
    
</html>
