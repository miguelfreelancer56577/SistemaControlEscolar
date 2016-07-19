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

/**
 *
 * @author mary
 */
@WebServlet(name="dar_alta", urlPatterns={"/dar_alta"})
public class dar_alta extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        String[] altas= new String[21];

        altas[0]=request.getParameter("usuario");
        altas[1]=request.getParameter("contrasena");
        altas[2]=request.getParameter("matri");
        altas[3]=request.getParameter("carrera");
        altas[4]=request.getParameter("grupo");
        altas[5]=request.getParameter("a_paterno");
        altas[6]=request.getParameter("a_materno");
        altas[7]=request.getParameter("nombres");
        altas[8]=request.getParameter("telefono");
        altas[9]=request.getParameter("sex");
        altas[10]=request.getParameter("calle");
        altas[11]=request.getParameter("mz");
        altas[12]=request.getParameter("lt");
        altas[13]=request.getParameter("colonia");
        altas[14]=request.getParameter("municipio");
        altas[15]=request.getParameter("nacimiento");
        altas[16]=request.getParameter("dia");
        altas[17]=request.getParameter("mes");
        altas[18]=request.getParameter("allo");
        altas[19]=request.getParameter("rfc");
        altas[20]=request.getParameter("curp");

      //  if(!altas[0].equalsIgnoreCase(null)){}
// else{}
        operacion ingresa=new operacion();
        out.print(ingresa.inserta_tabla(altas[0],altas[1],altas[2],altas[3],altas[4],altas[5],altas[6],altas[7],altas[8],altas[9],altas[10],altas[11],altas[12],altas[13],altas[14],altas[15],altas[16],altas[17],altas[18],altas[19],altas[20]));

        } finally { 
            out.close();
        }
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
