<%-- 
    Document   : consultacalificaciones
    Created on : 4/04/2012, 05:31:55 PM
    Author     : mary
--%>

<%@page import="utileria.var_globales"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONSULTA DE CALIFICACIONES</title>
    </head>
    <body background="images/logoestadodemex.jpg" LINK="#0000FF" VLINK="0000FF" ALINK="0000FF" >


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

        <center>
        <table>
    <tr>
        <td align="center" colspan="3" height="10" >REGRESAR</td>
        <td align="right" colspan="3" height="60" ><a href="alumno.jsp" ><img src="images/regresar.bmp" width="90" height="60" ALT="imprimir" /></a></td>
    </tr>
       </table>
       </center>
        
        <h2 align="center">Cuando se Genere la Tabla Verifica que tus calificaciones sean las correctas.</h2>
        
        
<center>
<table width="40%"   border="0" align="center" cellpadding="1" cellspacing="1">
    <%
out.print(var_globales.datos_consulta);
//var_globales.datos_consulta="";
    %>
   </table>
</center>

   <FORM action="buscar_semestre" method="post">

       
       <h2 align="center">Seleccionar Semestre que desea Consultar:  <select name="semestre">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
              </select></h2>

       <h1 align="center"><input type="submit" value="BUSCAR" /></h1>
   </FORM>
    </body>
</html>
