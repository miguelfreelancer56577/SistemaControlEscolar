/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets.srv;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import utileria.var_globales;

/**
 *
 * @author mary
 */
@WebServlet(name="pdf_tabla", urlPatterns={"/pdf_tabla"})
public class pdf_tabla extends HttpServlet {
   
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
            doGet(request, response);//retorna al metodo doGet
           
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

                    response.setContentType("application/pdf");
        try {

        Image imagen=Image.getInstance(("D:/5TO SEMESTRE/modelado_ramon/proyecto control escolar/proyecto control escolar/APLICACION/sistema1/web/images/Imagenalumno.jpg"));
        imagen.scaleAbsoluteHeight(65);
        imagen.scaleAbsoluteWidth(550);
        imagen.setAlignment(Image.ALIGN_CENTER | Image.ALIGN_TOP);//Image.TEXTWRAP);

        /*Primero definimos todas las cadenas del encabezado del documento y los demas datos a
utilizar*/
        String encabezado="\nVerifica que tus calificaciones del parcial "+var_globales.semestre+" sean las correctas.\n\n";
        /*colocaremos tambien la fecha de creacion*/
        java.util.Date date = new java.util.Date();
        /*Fuente utilizada para formatear el encabezado en este caso sera arial 12 en negrita*/
        Font fuente= new Font(Font.getFamily("VERDANA"), 16, Font.BOLD);
        /*Definimos un texto que se incluira antes de la tabla*/


         /*Primero pasaremos nuestras cadenas a elementos de iText*/
            /*definimos una frase que sera el string encabezado y le aplicamos la fuente*/
             Paragraph linea = new Paragraph(encabezado,fuente);

             
             /*Pasamos la fecha a un String y la agregamos a un parrafo*/
             Paragraph fecha=new Paragraph(String.valueOf(date)+"\n\n\n");
             /*Ahora definimos la tabla donde el arguemento recibido indica el numero de columnas
              y la propiedad setWidthPercentage permite indicarle que ocupe todo el ancho de la
pagina*/
              PdfPTable tabla=new PdfPTable(6);
              tabla.setWidthPercentage(100);

              /*Ahora que ya tenemos todos los elemtnos es hjora de agregarlos al documento, para ello
             primeramente definimos un docuemnto e indicando el tamaño*/
            Document documento = new Document(PageSize.LETTER);
            /*Definimos el nombre del archivo de salida con extension .PDF*/

             /*a  traves  del  siguiente  metodo  (getInstance)y  un  flujo  de  salida  del  paquete  .io
asociamos el documento de iText con el archivo de java*/
             PdfWriter.getInstance(documento, response.getOutputStream());

             /*Definimos las celdas que seran los encabezados de la tabla*/
             PdfPCell  celda1  =new  PdfPCell  (new  Paragraph("MATERIA",FontFactory.getFont("VERDANA",10,Font.BOLD,BaseColor.RED)));
             PdfPCell  celda2  =new  PdfPCell  (new  Paragraph("1ER. PARCIAL",FontFactory.getFont("VERDANA",10,Font.BOLD,BaseColor.RED)));
             PdfPCell  celda3  =new  PdfPCell  (new  Paragraph("2DO. PARCIAL",FontFactory.getFont("VERDANA",10,Font.BOLD,BaseColor.RED)));
             PdfPCell  celda4  =new  PdfPCell  (new  Paragraph("3ER PARCIAL",FontFactory.getFont("VERDANA",10,Font.BOLD,BaseColor.RED)));
             PdfPCell  celda5  =new  PdfPCell  (new  Paragraph("CALIFICACION TOTAL",FontFactory.getFont("VERDANA",10,Font.BOLD,BaseColor.RED)));
             PdfPCell  celda6  =new  PdfPCell  (new  Paragraph("CREDITOS",FontFactory.getFont("VERDANA",10,Font.BOLD,BaseColor.RED)));

              /*Abrimos el documento y agregamos los elementos en el orden que deben aparecer*/
             documento.open();
             documento.add(imagen);
             documento.add(linea);
             documento.add(fecha);
             tabla.addCell(celda1);
             tabla.addCell(celda2);
             tabla.addCell(celda3);
             tabla.addCell(celda4);
             tabla.addCell(celda5);
             tabla.addCell(celda6);

                         for(int i=0;i<15;i++){

            tabla.addCell(var_globales.materia[i]);
            tabla.addCell(""+var_globales.calificacion[i]);
            tabla.addCell(""+var_globales.calificacion[i+1]);
            tabla.addCell(""+var_globales.calificacion[i+2]);
            tabla.addCell(""+(var_globales.calificacion[i]+var_globales.calificacion[i+1]+var_globales.calificacion[i+2])/3);
            tabla.addCell(""+(var_globales.creditos[i]+var_globales.creditos[i+1]+var_globales.creditos[i+2]));

            i+=2;

            }

             documento.add(tabla);
             /*Cerramos el documento*/
             documento.close();
            /* LaunchApplication.execute(file);//Ignoren esta linea de codigo es una de mis clases
para pruebas*/


        } catch (DocumentException ex) {

            throw new IOException(ex.getMessage());
        }
          
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
        doGet(request, response);
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
