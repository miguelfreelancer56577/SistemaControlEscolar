<%-- 
    Document   : plantilla
    Created on : 4/04/2012, 09:13:57 AM
    Author     : mary
--%>

<%@page import="utileria.recuperar_ultimo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plantilla</title>
    </head>
    <BODY  background="images/logoestadodemex.jpg" LINK="#0000FF" VLINK="0000FF" ALINK="0000FF" >


<center>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0" BGCOLOR="#FFFFFF" >

<tr>
           <td width="900" bgcolor="#FFFFFF"><img src="images/Imagencontrol.jpg" width="100%" height="100%" border="0" ALT="FONDO LOGO"></td>
</tr>

<tr>
    <td width="720" ><P><% java.util.Calendar fecha = java.util.Calendar.getInstance();out.println("IXTAPALUCA ESTADO DE MEXICO A "+fecha.get(java.util.Calendar.DATE) + " DEL MES "  + fecha.get(java.util.Calendar.MONTH)    + " DEL "  + fecha.get(java.util.Calendar.YEAR));%></P></td>
</tr>
</table>
</center>

        <form action="buscar" method="post">

        <center>
        <table    border="0" align="center" cellpadding="0" cellspacing="0">

<tr>

    <td align="center" colspan="6" height="10" ><h2>Plantilla de Alumnos</h2></td>
</tr>
<tr>

    <th align="center" colspan="6" height="10" >No. de Registros
     <%
 recuperar_ultimo registrados=new recuperar_ultimo();
                     int ultima=+registrados.recuperar();

                     out.println(ultima);
                    %>                    

    </th>
</tr>


<tr>
             <th align="left" colspan="3" height="50" >Filtar</th>
</tr>
<tr>
             <td>ingresa el nombre<input type="text" name="texto" value=""/></td>
</tr>
<tr>
             <td align="center">seleccione el filtro</td>
</tr>
<tr>
    <td align="center">Matricula<input type="radio" name="opcion" value="numero" /> Nombre<input type="radio" name="opcion" value="nombre" /></td>
</tr>

<tr>
<td align="center" colspan="3" height="50" > <input type="submit" value="BUSCAR" name="BUS" /></td>
</tr>
 </table>
</center>
        </form>

    </body>
</html>
