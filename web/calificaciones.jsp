<%-- 
    Document   : calificaciones
    Created on : 4/04/2012, 09:59:41 AM
    Author     : mary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://wf3ww.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calificaciones</title>
    </head>
      <BODY  background="images/logoestadodemex.jpg" LINK="#0000FF" VLINK="0000FF" ALINK="0000FF" >
      <center>
        <table width="900" border="0" align="center" cellpadding="0" cellspacing="0" BGCOLOR="#FFFFFF" >

<tr>
           <td width="900" bgcolor="#FFFFFF"><img src="images/Imagencontrol.jpg" width="900" height="120" border="0" ALT="FONDO LOGO"></td>
</tr>

<tr>
           <td width="720" ><P>IXTAPALUCA ESTADO DE MEXICO A 03 DE ABRIL DEL 2012</P></td>
</tr>
</table>
</center>

          <form action="ingresar_calificaciones" method="POST">
        <center>
          <table border="3" align="center" cellpadding="0" cellspacing="0">

<tr>

    <td align="center" colspan="2"  height="10" ><h2>Para Ingresar Calificaciones</h2></td>
</tr>
<tr>
    <th align="center" colspan="2"  height="10" >Filtar</th>
</tr>
<tr>
    <td align="center"  height="50" >Grupo</td>
    <td align="center" height="50" >
      <select name="grupo">
            <option>2451</option>
            <option>2452</option>
            <option>2453</option>
            <option>2454</option>
            <option>2455</option>
        </select></td>
</tr>

<tr>
    <td align="center" colspan="2" ><input type="submit" value="enviar" /></td>
</tr>
 </table>
        </center>
      </form>
    </body>
  
</html>
