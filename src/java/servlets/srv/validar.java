/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets.srv;

import beans.bean.operacion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utileria.var_globales;

/**
 *
 * @author mary
 */
@WebServlet(name="validar", urlPatterns={"/validar"})
public class validar extends HttpServlet {
   
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            operacion valida=new operacion();
            String usuario=request.getParameter("usu");
            String contra=request.getParameter("pas");
           int tipo=valida.usuario(usuario, contra);
           // HttpSession sesion=request.getSession(true);// se cra la session
           // sesion.setAttribute("se", tipo);// en el atributo se se guarda tipo
                    if(tipo==1){
                        response.sendRedirect("administrativo.jsp");
                    }
 else if(tipo==2) {

     String datos=valida.regresa_datos(usuario, contra);

     var_globales.matri=Integer.parseInt(usuario);
     var_globales.datos_consulta=valida.regresa_datos(usuario, contra);

     response.sendRedirect("alumno.jsp?usu="+usuario+"&datos1="+datos);
            
 }//termina else if

 else{
 response.sendRedirect("index.jsp");
 }
                }//termina try

        finally {
            out.close();
        }//termina finally
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
