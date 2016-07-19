<%-- 
    Document   : modificar
    Created on : 30/05/2012, 01:13:06 PM
    Author     : ATENA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MODIFICAR_DATOS_DEL_ALUMNO</title>
    </head>
    <BODY background="images/logoestadodemex.jpg"  LINK="#0000FF" VLINK="0000FF" ALINK="0000FF" >
        <form method="get" action="modifica_plantilla">

<table width="900" border="0" align="center" cellpadding="0" cellspacing="0" BGCOLOR="#FFFFFF" >
<tr>
<td width="900" bgcolor="#FFFFFF"><img src="images/Imagencontrol.jpg" width="900" height="120" border="0" ALT="FONDO LOGO"></td>
</tr>

</table>
        <P align="center"><% java.util.Calendar fecha = java.util.Calendar.getInstance();out.println("IXTAPALUCA ESTADO DE MEXICO A "+fecha.get(java.util.Calendar.DATE) + " DEL MES "  + fecha.get(java.util.Calendar.MONTH)    + " DEL "  + fecha.get(java.util.Calendar.YEAR));%></P>
<center>
<table  width="80%"   border="0" align="center" cellpadding="0" cellspacing="0">

<tr>
<td align="center" colspan="6" height="10" ><h2>DATOS DEL ALUMNO</h2></td>
</tr>

<tr>int a=1;
<td align="center" colspan="0" height="50" >matricula</td>
<td align="left" colspan="2" height="50" ><input type="text" name="matr" value="<%=request.getParameter("mat") %>" size="25" /></td>
</tr>

<tr>
<td align="center" colspan="0" height="50" >Apellido Paterno</td>
<td align="left" colspan="2" height="50" ><input type="text" name="a" value="<%=request.getParameter("ape_pa") %>" size="25" /></td>
</tr>

<tr>
 <td align="center" colspan="0" height="50" >Apellido Materno</td>
 <td align="left" colspan="2" height="50" ><input type="text" name="b"value="<%=request.getParameter("ape_ma") %>" size="25" /></td>
</tr>

<tr>
 <td align="center" colspan="0" height="50" >Nombres</td>
 <td align="left" colspan="2" height="50" ><input type="text" name="c" value="<%=request.getParameter("nom") %>"  size="25" /></td>
</tr>

<tr>
 <td align="center" colspan="0" height="50" >Carrera</td>
 <td align="left" colspan="2" height="50" ><input type="text" name="d" value="<%=request.getParameter("car") %>"  size="25" /></td>
</tr>


<tr>
 <td align="center" colspan="0" height="50" >Sexo</td>
 <td align="left" colspan="2" height="50" ><input type="text" name="e" value="<%=request.getParameter("sex") %>" size="25" /></td>
</tr>
<tr>
 <td align="center" colspan="0" height="50" >grupo</td>
 <td align="left" colspan="2" height="50" ><input type="text" name="f" value="<%=request.getParameter("grup") %>" size="25" /></td>
</tr>
<tr>
 <td align="center" colspan="0" height="50" >telefono</td>
 <td align="left" colspan="2" height="50" ><input type="text" name="g" value="<%=request.getParameter("tel") %>" size="25" /></td>
</tr>

<tr>
 <td align="center" colspan="0" height="50" >Domicilio Calle</td>
 <td align="left" colspan="2" height="50" ><input type="text" name="h" value="<%=request.getParameter("calle") %>" size="25" /></td>
</tr>
<tr>
  <td align="center" colspan="0" height="50" >Manzana</td>
  <td align="left" colspan="2" height="50" ><input type="text" name="i" value="<%=request.getParameter("mz") %>" size="25" /></td>
</tr>
<tr>
  <td align="center" colspan="0" height="50" >lt</td>
  <td align="left" colspan="2" height="50" ><input type="text" name="j" value="<%=request.getParameter("lo") %>" size="25" /></td>
</tr>

<tr>
  <td align="center" colspan="0" height="50" >Colonia</td>
  <td align="left" colspan="2" height="50" ><input type="text" name="k" value="<%=request.getParameter("col") %>" size="25" /></td>
</tr>

<tr>
  <td align="center" colspan="0" height="50" >Municipio</td>
  <td align="left" colspan="2" height="50" ><input type="text" name="l" value="<%=request.getParameter("mun") %>" size="25" /></td>
</tr>

<tr>
  <td align="center" colspan="0" height="50" >Lugar de nacimiento</td>
  <td align="left" colspan="2" height="50" ><input type="text" name="m" value="<%=request.getParameter("naci") %>" size="25" /></td>
</tr>


<tr>
 <td align="center" colspan="0" height="50" >fecha de nacimiento Dia</td>
 <td align="left" colspan="2" height="50" ><input type="text" name="n" value="<%=request.getParameter("dia") %>" size="15" /></td>

 <td align="left" colspan="0" height="50" >Mes</td>
 <td align="left" colspan="2" height="50" ><input type="text" name="o" value="<%=request.getParameter("mes") %>" size="15" /></td>

 <td align="left" colspan="0" height="50" >Año</td>
 <td align="left" colspan="2" height="50" ><input type="text" name="p" value="<%=request.getParameter("ano") %>" size="15" /></td>

</tr>

<tr>
 <td align="center" colspan="0" height="50" >CURP</td>
 <td align="left" colspan="2" height="50" ><input type="text" name="q" value="<%=request.getParameter("curp") %>" size="25" /></td>
</tr>

<tr>
 <td align="center" colspan="0" height="50" >RFC</td>
 <td align="left" colspan="2" height="50" ><input type="text" name="r" value="<%=request.getParameter("rfc") %>" size="25" /></td>
</tr>

 <tr>
 <td colspan="2" align="center"><input type="submit" value="guarda"/></td>
 </tr>
 </table>
</center>
</form>
 </body>
</html>
