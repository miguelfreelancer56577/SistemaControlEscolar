<%-- 
    Document   : calificaciones2
    Created on : 16/05/2012, 03:29:23 PM
    Author     : mary
--%>

<%@page import="utileria.var_global_busquedad_calificaciones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calificaciones2</title>
    </head>
    <body background="images/logoestadodemex.jpg" >
       <center>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0" BGCOLOR="#FFFFFF" >

<tr>
           <td width="900" bgcolor="#FFFFFF"><img src="images/Imagencontrol.jpg" width="900" height="120" border="0" ALT="FONDO LOGO"></td>
</tr>

</table>
</center>

        <P align="center">IXTAPALUCA ESTADO DE MEXICO A 03 DE ABRIL DEL 2012</P>


          <form action="almacena_calificaciones" method="POST">
        <center>
        <table  border="3" align="center" cellpadding="2" cellspacing="2">


            <%
            
            int a=0;
            var_global_busquedad_calificaciones mis_var_global_busquedad_calificaciones=new var_global_busquedad_calificaciones();
            var_global_busquedad_calificaciones.var_global_busquedad_calificaciones_ma=request.getParameter("ma");
            var_global_busquedad_calificaciones.var_global_busquedad_calificaciones_nom+=request.getParameter("nom");
            var_global_busquedad_calificaciones.var_global_busquedad_calificaciones_carr=request.getParameter("carr");
%>
          
<tr>
    <th align="center"  height="10" >Seleccione los Datos Correctos</th>
</tr>
<tr>
    <td align="center"  height="50" >Matricula</td>
    <td align="left"  height="50" ><input type="text" name="matri" value="<%=var_global_busquedad_calificaciones.var_global_busquedad_calificaciones_ma %>" /></td>
</tr>
<tr>
    <td align="center"  height="50" >Nombre Completo</td>
    <td align="left"  height="50" ><input type="text" name="" value="<%=var_global_busquedad_calificaciones.var_global_busquedad_calificaciones_nom %>" size="30"/></td>
</tr>
<tr>
    <td align="center"  height="50" >Carrera</td>
    <td align="left"  height="50" ><input type="text" name="" value="<%=var_global_busquedad_calificaciones.var_global_busquedad_calificaciones_carr %>" size="30" /></td>
</tr>
<tr>
    <td align="center"  height="50" >Semestre</td>
    <td align="left"  height="50" ><select name="semestre">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
        </select></td>
</tr>
<tr>
    <td align="center"  height="50" >Parcial</td>
    <td align="left"  height="50" ><select name="parcial">
            <option>1</option>
            <option>2</option>
            <option>3</option>
        </select></td>
</tr>
<tr>
    <td align="center"  height="50" >Materia</td>
    <td align="left"  height="50" ><select name="materia">
            <option>Calculo</option>
            <option>Programacion</option>
            <option>Bases de Datos</option>
            <option>Sistemas Operativos</option>
            <option>Arquitectura de Computadoras</option>
            <option>Fundamentos de Investigacion</option>
            <option>Taller de Etica</option>
            <option>Calculo Diferencial</option>
            <option>Administracion para Informatica</option>
            <option>Fisica Para Informatica</option>
            <option>Programacion Orientada a Objetos</option>
            <option>Contabilidad Orientada a los Negocios</option>
            <option>Calculo Integral</option>
        </select></td>
</tr>
<tr>
    <td align="center"  height="50" >Calificacion</td>
    <td align="left" height="50" ><input type="text" name="cali" value="" size="5" /></td>
</tr>
<tr>
    <td align="center" height="50" >Creditos</td>
    <td align="left"  height="50" ><input type="text" name="credi" value="" size="5" /></td>
</tr>
<tr>
    <td align="center" colspan="2" height="50" ><input type="submit" value="enviar" /></td>
</tr>
 </table>
        </center>
            </form>
    </body>
</html>
