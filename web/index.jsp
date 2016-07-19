<%-- 
    Document   : index
    Created on : 13/03/2012, 07:09:10 PM
    Author     : mary
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina_de_inicio(Control Escolar)</title>
        <script type="text/javascript" src="wforms.js"></script>
			<script type="text/javascript">
			wFORMS.behaviors['validation'].errMsg_required;// = "Campo Obligatorio";
			wFORMS.behaviors['validation'].errMsg_notification = "Verifica que tu usuario o contraseña no se encuentren vacios.\n# de campos vacios %%"; // %% will be replaced by the actual number of errors
			</script>
    </head>

    <BODY BGCOLOR="#FFFFFF" TEXT="#000000" LINK="#FF0000" VLINK="#800000" ALINK="#FF00FF"
          background="images/Imagen3.jpg" width="%100" height="%100" alt="Imagen3"/>
          
       
       

           <center>
<table width="690" border="0" align="center" cellpadding="0" cellspacing="0" BGCOLOR="#FFFFFF" >

<tr>
    <td width="690" bgcolor="#FFFFFF"> <img src="images/tesi_iet_img_2.jpg" width="690" height="112" border="0" alt="tesi_iet_img_2"/>
    </td>
</tr>

<tr>
    <td width="690" bgcolor="#FFFFFF"> <img src="images/Imagen4.jpg" width="690" height="50" border="0" alt="Imagen4"/>
    </td>
</tr>
<tr>

       <td><center>


  <form action="validar" method="POST">
              <table border="1" align="center">

                    <tr>
                        <th>Usuario</th>
                        <td align="left"><input class="required" type="text" name="usu" value="" /> </td>
                    </tr>
                    <tr>
                        <th>Contraseña</th>
                        <td align="left"><input class="required" type="password" name="pas" value=""  /> </td>
                    </tr>
                    <tr>

                        <td align="center" colspan="2" ><input type="submit" value="enviar" /></td>

                    </tr>

            </table>
 </form>




           </center>

       </td>

</tr>

</table>
</center>
    </body>
</html>
