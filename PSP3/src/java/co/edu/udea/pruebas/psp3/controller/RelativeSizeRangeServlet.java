/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp3.controller;

import co.edu.udea.pruebas.psp3.controller.util.PSPFileProcess;
import co.edu.udea.pruebas.psp3.domain.process.RelativeSizeRangesService;
import co.edu.udea.pruebas.psp3.exception.PSPException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author raven
 */
@WebServlet(name = "RelativeSizeRangeServlet", urlPatterns = {"/RelativeSizeRangeServlet"})
public class RelativeSizeRangeServlet extends HttpServlet {

    
    
    @Inject
    PSPFileProcess pspfp;
    
    
    @Inject
    RelativeSizeRangesService rsrs;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rq = null;
        Part filePart = null;
        
        double[] resultado;
        String info;
        boolean malformedRequest = false;
        String errMsg = "";
        
        String[] encabezados;
        List<Double> datos;
        try{
            filePart = request.getPart("dataFile");
            info = pspfp.recuperarInfo(filePart);
            pspfp.procesarInfo(info);
            encabezados = pspfp.getEncabezados();
            datos = pspfp.getDatos();
            
            /**
             * Aquí se calculan los valores de la tabla de tamaño relativo y se retornan 
             * 
             */
            resultado = rsrs.calcRelativeSizeRanges(datos);
            
            request.setAttribute("encabezado", encabezados);
            request.setAttribute("datos", datos);
            request.setAttribute("resultado", resultado);
            rq = request.getRequestDispatcher("/showData.jsp");
            
        }catch(PSPException e){
            malformedRequest = true;
            errMsg = e.getMessage();
        }catch(ServletException e){
            malformedRequest = true;
            errMsg = "You didn't send any file";
        }
        
        if(malformedRequest || rq == null){
            request.setAttribute("errorText", errMsg);
            rq = request.getRequestDispatcher("/showError.jsp");
        }
        rq.forward(request,response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
