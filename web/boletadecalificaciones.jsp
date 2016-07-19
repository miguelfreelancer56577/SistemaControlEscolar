<%-- 
    Document   : boletadecalificaciones
    Created on : 4/04/2012, 04:09:30 PM
    Author     : mary
--%>

<%@page import="utileria.recupera_tabla_ultimo_semestre"%>
<%@page import="utileria.recuperar_ultimo"%>
<%@page import="utileria.var_globales"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Boleta de Calificaciones</title>
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
        

        <h3 align="center">Verifica que tus calificaciones obtenidas en el ultimo periodo sean correctas.</h3>

        <%

        recuperar_ultimo url_foto= new recuperar_ultimo();
        
       out.print("<p align=\"center\" ><img src=\"images/fotos_alumnos/"+url_foto.recuperar_foto_alumno(var_globales.matri)+".jpg\" width=\"175\" height=\"200\" alt=\"fotoalumno\"/></p>");

        %>
        

<center>
<table width="40%"   border="0" align="center" cellpadding="1" cellspacing="1">
    <%
out.print(var_globales.datos_consulta);
//var_globales.datos_consulta="";
    %>
   </table>
</center>

        <%
   recupera_tabla_ultimo_semestre alumno= new recupera_tabla_ultimo_semestre();

out.print(alumno.busca_semestre(alumno.recupera_numero_ultimo_semestre()));
//var_globales.datos_consulta="";
    %>
        <br>

         <p align="center" ><img src="images/firma.jpg" width="275" height="134" ALT="imprimir" /></p>
        <center>
        <table>           
    <tr>
    <td align="center" colspan="3" height="90" ><a href="pdf_boleta" target="_blank"><img src="images/imprimir.jpg" width="92" height="90" ALT="imprimir" /></a></td>
    </tr>
    <tr>
    <td align="center" colspan="3" height="10" >GENERAR PDF</td>
    </tr>
    
       </table>
       </center>
    </body>
</html>
