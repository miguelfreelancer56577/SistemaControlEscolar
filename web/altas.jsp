<%-- 
    Document   : altas
    Created on : 4/04/2012, 08:07:21 AM
    Author     : mary
--%>



<%@page import="utileria.recuperar_ultimo"%>
<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dar_de_alta_Alumno</title>
    </head>
   <body  LINK="#0000FF" VLINK="0000FF" ALINK="0000FF" >


<center>
<table width="900" border="0" align="center" cellpadding="0" cellspacing="0" BGCOLOR="#FFFFFF" >

<tr>
           <td width="900" bgcolor="#FFFFFF"><img src="images/Imagencontrol.jpg" width="900" height="120" border="0" ALT="FONDO LOGO"></td>
</tr>

<tr>
           <td width="720" ><P><% java.util.Calendar fecha = java.util.Calendar.getInstance();out.println("IXTAPALUCA ESTADO DE MEXICO A "+fecha.get(java.util.Calendar.DATE) + " DEL MES "  + fecha.get(java.util.Calendar.MONTH)    + " DEL "  + fecha.get(java.util.Calendar.YEAR));%></P></td>
</tr>

</table>
</center>

    <center>

         <form action="dar_alta" method="POST">
<table background="images/logoestadodemex.jpg" width="100%"   border="3" align="center" cellpadding="0" cellspacing="0">
   
<tr>
            <tr >
                
                
                
                <td height="76"  ><%--IMAGEN QUE SELECCIONA DE MANERA ALEATORIA EL USUARIO Y LA MATRICULA--%>
                    <H4 ALIGN="center">
                        <% Random obten=new Random();
                        
        int aleatorios[]=new int [2];
        int a,b;
        aleatorios[0]=obten.nextInt(9999999); //se asigna el valor aleatorio al elemento cero
        for(a=1;a<2;a++){//se comiensa aiterar sobre el arreglo desde 1
            aleatorios[a]=obten.nextInt(9999999); //se inicializa el elemento 1 con otro valor aleatorio
            for(b=0;b<a;b++){//se reviza que sean diferentes los elementos comparado el 1 con el 0
                if(aleatorios[a]==aleatorios[b]){
                    a--;// si se cumple regresamos un valor en a
                }
            }
        }
 recuperar_ultimo matricula=new recuperar_ultimo();
                     int ultima=+matricula.recuperar_identificacion_personal()+1;

                     out.println("<a href=\"altas.jsp?mosusu="+aleatorios[0]+"&moscon="+aleatorios[1]+"&mat="+ultima+"\"><img src=\"images/altas.jpg\" width=\"76\" height=\"76\" ALT=\"DAR DE ALTA\" /></a>");
                    %>
                    ALTA</H4>
                </td><%--IMAGEN QUE SELECCIONA DE MANERA ALEATORIA EL USUARIO Y LA MATRICULA--%>


           <td height="50">Usuario</td>
           <td height="50" ALIGN="left"> <input type="text" name="usuario"  value="<%=request.getParameter("mosusu") %>" size="50" /></td>
            </tr>


                 <tr>
                     <td></td><td>Contraseña</td>
                     <td height="50" ALIGN="left"> <input type="text" name="contrasena" value="<%=request.getParameter("moscon") %>" size="50" /></td>
                    </tr>

                    <tr>
                     <td></td><td>Matricula</td>
                     <td height="50" ALIGN="left"> <input type="text" name="matri" value="<%=request.getParameter("mat")%>" size="50" /></td>
                    </tr>

                   <tr>
                    <td></td><td>Carrera</td>
                    <td height="50" ALIGN="left"><select name="carrera">
                            <option>Licenciatura en Administracion de Empresas</option>
                            <option>Ingenieria en Informatica</option>
                            <option>Ingenieria Ambiental</option>
                            <option>Ingenieria en Electronica</option>
                            <option>Ingenieria en Sistemas Computacionales</option>
                        </select> </td>
                  </tr>
                  <tr>
                     <td></td><td>Grupo</td>
                     <td height="50" ALIGN="left"><select name="grupo">
                            <option>2452</option>
                             <option>2451</option>
                            <option>2453</option>
                            <option>2454</option>
                            <option>2455</option>
                        </select></td>
                    </tr>
</tr>
<tr>
    <td align="center" colspan="3" height="10" >Datos Personales</td>
</tr>
<tr>
    <td align="center" colspan="0" height="50" >Apellido Paterno</td>
   <td align="left" colspan="2" height="50" ><input type="text" name="a_paterno" value="" size="50" /></td>
</tr>
<tr>
    <td align="center" colspan="0" height="50" >Apellido Materno</td>
   <td align="left" colspan="2" height="50" ><input type="text" name="a_materno" value="" size="50" /></td>
</tr>
<tr>
    <td align="center" colspan="0" height="50" >Nombres</td>
   <td align="left" colspan="2" height="50" ><input type="text" name="nombres" value="" size="50" /></td>
</tr>
<tr>
    <td align="center" colspan="0" height="50" >Telefono</td>
   <td align="left" colspan="2" height="50" ><input type="text" name="telefono" value="" size="50" /></td>
</tr>
<tr>
    <td align="center" colspan="0" height="50" >Sexo</td>
   <td align="left" colspan="2" height="50" >Masculino<input type="radio" name="sex" value="M"/>
                                             Femenino<input type="radio" name="sex" value="F"/>
   </td>
</tr>
<tr>
    <td align="center" colspan="0" height="50" >Domicilio Calle</td>
   <td align="left" colspan="2" height="50" ><input type="text" name="calle" value="" size="50" /></td>
</tr>
<tr>
    <td align="center" colspan="0" height="50" >Manzana</td>
   <td align="left" colspan="2" height="50" ><input type="text" name="mz" value="" size="50" /></td>
</tr>
<tr>
    <td align="center" colspan="0" height="50" >Lote</td>
   <td align="left" colspan="2" height="50" ><input type="text" name="lt" value="" size="50" /></td>
</tr>
<tr>
    <td align="center" colspan="0" height="50" >Colonia</td>
   <td align="left" colspan="2" height="50" ><input type="text" name="colonia" value="" size="50" /></td>
</tr>
<tr>
    <td align="center" colspan="0" height="50" >Municipio</td>
   <td align="left" colspan="2" height="50" ><input type="text" name="municipio" value="" size="50" /></td>
</tr>
<tr>
    <td align="center" colspan="0" height="50" >Lugar de nacimiento</td>
   <td align="left" colspan="2" height="50" ><input type="text" name="nacimiento" value="" size="50" /></td>
</tr>
<tr>
    <td align="center" colspan="3" height="10" >fecha de nacimiento</td>
</tr>
<tr>
    <td align="center" colspan="0" height="50" >Dia <select name="dia">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
            <option>11</option>
            <option>12</option>
            <option>13</option>
            <option>14</option>
            <option>15</option>
            <option>16</option>
            <option>17</option>
            <option>18</option>
            <option>19</option>
            <option>20</option>
            <option>21</option>
            <option>22</option>
            <option>23</option>
            <option>24</option>
            <option>25</option>
            <option>26</option>
            <option>27</option>
            <option>28</option>
            <option>29</option>
            <option>30</option>
            <option>31</option>
        </select></td>
        <td align="left" colspan="0" height="50" >Mes <select name="mes">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
                <option>6</option>
                <option>7</option>
                <option>8</option>
                <option>9</option>
                <option>10</option>
                <option>11</option>
                <option>12</option>
            </select>    </td>
        <td align="left" colspan="0" height="50" >Año <select name="allo">
                <option>1980</option>
                <option>1981</option>
                <option>1982</option>
                <option>1983</option>
                <option>1984</option>
                <option>1985</option>
                <option>1986</option>
                <option>1987</option>
                <option>1988</option>
                <option>1989</option>
                <option>1990</option>
                <option>1991</option>
                <option>1992</option>
                <option>1993</option>
                <option>1994</option>
                <option>1995</option>
                <option>1996</option>
                <option>1997</option>
                <option>1998</option>
                <option>1999</option>
                <option>2000</option>
                <option>2001</option>
                <option>2002</option>
                <option>2003</option>
                <option>2004</option>
                <option>2005</option>
                <option>2006</option>
                <option>2007</option>
                <option>2008</option>
                <option>2009</option>
                <option>2010</option>
                <option>2011</option>
                <option>2012</option>
            </select>   </td>
</tr>
<tr>
    <td align="center" colspan="0" height="50" >CURP</td>
   <td align="left" colspan="2" height="50" ><input type="text" name="curp" value="" size="50" /></td>
</tr>
<tr>
    <td align="center" colspan="0" height="50" >RFC</td>
   <td align="left" colspan="2" height="50" ><input type="text" name="rfc" value="" size="50" /></td>
</tr>
<tr>
    <td align="center" colspan="3" height="10" ><input type="submit" value="GUARDAR" name="ALMACENA" /></td>
</tr>
</table>
                     </form>
</center>
    
 </body>
</html>
