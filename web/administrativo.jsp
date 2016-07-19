<%--

<%recuperar_ultimo matricula=new recuperar_ultimo();
                     int ultima=+matricula.recuperar();
                     //out.println("<a href=\"altas.jsp?mosusu="+aleatorios[0]+"&moscon="+aleatorios[1]+"&mat="+ultima+"\"><img src=\"images/altas.jpg\" width=\"76\" height=\"76\" ALT=\"DAR DE ALTA\" /></a>");
                    %>
    Document   : administrativo
    Created on : 13/03/2012, 07:26:51 PM
    Author     : mary
--%>


<%@page import="utileria.recuperar_ultimo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal_de_Control_Escolar_Tesi</title>
    </head>
   <BODY background="images/logoestadodemex.jpg" LINK="#0000FF" VLINK="0000FF" ALINK="0000FF" >


<center>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0" BGCOLOR="#FFFFFF" >

<tr>
           <td width="900" bgcolor="#FFFFFF"><img src="images/Imagencontrol.jpg" width="900" height="120" border="0" ALT="FONDO LOGO"></td>
</tr>


</table>
</center>
       <br>
       <br>
<P ALIGN="CENTER"><% java.util.Calendar fecha = java.util.Calendar.getInstance();out.println("IXTAPALUCA ESTADO DE MEXICO A "+fecha.get(java.util.Calendar.DATE) + " DEL MES "  + fecha.get(java.util.Calendar.MONTH)    + " DEL "  + fecha.get(java.util.Calendar.YEAR));%></P>
<br>
       <br>
<H3 ALIGN="CENTER"> <a href="altas.jsp" ><img src="images/altas.jpg" width="76" height="76" ALT="BOTON" /></a>   DAR DE ALTA ALUMNO EN PLANTILLA</H3>
    <H3 ALIGN="CENTER"> <a href="plantilla.jsp"><img src="images/plantilla.jpg" width="76" height="76" ALT="BOTON" /></a>  PLANTILLA</H3>
<H3 ALIGN="CENTER"> <a href="calificaciones.jsp"><img src="images/situacion_academica.jpg" width="76" height="76" ALT="BOTON" /></a>  INGRESAR CALIFICACIONES</H3>


    </body>
</html>
