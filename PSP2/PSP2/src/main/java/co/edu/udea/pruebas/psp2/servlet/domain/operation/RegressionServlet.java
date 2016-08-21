/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas.psp2.servlet.domain.operation;

import co.edu.udea.pruebas.psp2.exception.PSP2Exception;
import co.edu.udea.pruebas.psp2.servlet.domain.operation.process.LinearRegressionService;
import co.edu.udea.pruebas.psp2.servlet.domain.operation.process.ProcessPSP2File;
import co.edu.udea.pruebas.psp2.utils.llcc.Dupla;
import co.edu.udea.pruebas.psp2.utils.llcc.ListaLigadaConCabeza;
import java.io.IOException;
import java.util.Scanner;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author raven
 */
@WebServlet(name = "RegressionServlet", urlPatterns = {"/RegressionServlet"})
@MultipartConfig
public class RegressionServlet extends HttpServlet {

    
    @Inject
    ProcessPSP2File processPSP2File;
    
    @Inject
    LinearRegressionService lrs;
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
        
        RequestDispatcher rq = null;
        Part filePart = null;
        
        double[] resultado;
        String[] info;
        Dupla<String> encabezados = null;
        ListaLigadaConCabeza< Dupla<Double> > datos;        
        boolean malformedRequest = false;
        String errMsg = "";
        try{
            filePart = request.getPart("dataFile");
            info = processPSP2File.recuperarInfo(filePart).split("\n");
            encabezados = processPSP2File.getEncabezado(info);
            datos = processPSP2File.getDatos(info);
            
            /**
             * Aquí se calculan los valores de la regresión y se retornan 
             * en el siguiente orden:
             * B0, B1, Rxy, R2
             */
            resultado = lrs.getLinearRegressionParameters(datos);
            
            request.setAttribute("encabezado", encabezados);
            request.setAttribute("datos", datos);
            request.setAttribute("resultado", resultado);
            rq = request.getRequestDispatcher("/showData.jsp");
            
        }catch(PSP2Exception e){
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
    
    
    private String fileError(String error){
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html><head>");
        sb.append("<title>Error</title>");
        sb.append("</head><body>");
        sb.append("<h1>Error</h1>");
        sb.append("<p>").append(error).append("</p>");
        sb.append("</body></html>");
        return sb.toString();
    }
    
    private String readData(Scanner s){
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html><head>");
        sb.append("<title>Éxito</title>");
        sb.append("</head><body>");
        sb.append("<h1>Datos Ingresados</h1>");
        while(s.hasNext()){
            sb.append("<p>"+s.nextLine()+"</p>");
        }
        sb.append("</body></html>");
        return sb.toString();
        
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
