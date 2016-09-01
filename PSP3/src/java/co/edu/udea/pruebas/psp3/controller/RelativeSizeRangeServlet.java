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
@WebServlet(name = "RelativeSizeRangeServlet", urlPatterns = {"/RelativeSizeRangeServlet"})
@MultipartConfig
public class RelativeSizeRangeServlet extends HttpServlet {

    
    
    @Inject
    PSPFileProcess pspfp;
    
    
    @Inject
    RelativeSizeRangesService rsrs;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rq = null;
        Part filePart = null;
        
        double[] lnxi, lnxiavgsq, logRSR, RSR;
        double lnxiSum, lnxiavgsqSum, var, std;
        String info;
        boolean malformedRequest = false;
        String errMsg = "";
        
        String[] encabezados;
        List<Double> datos;
        List<String> encabezadosDatos;
        System.out.println("OIE ZYYYY");
        try{
            filePart = request.getPart("dataFile");
            info = pspfp.recuperarInfo(filePart);
            pspfp.procesarInfo(info);
            encabezados = pspfp.getEncabezados();
            datos = pspfp.getDatos();
            encabezadosDatos = pspfp.getEncabezadosDatos();
            /**
             * Aquí se calculan los valores de la tabla de tamaño relativo y se retornan 
             * 
             */
            rsrs.calcRelativeSizeRanges(datos);
            lnxi = rsrs.getLnXi();
            lnxiavgsq = rsrs.getSquaredAvgDiff();
            lnxiSum = rsrs.getLnXiSum();
            lnxiavgsqSum =rsrs.getSumSquaredAvgDiff();
            var = rsrs.getVariance();
            std = rsrs.getStandardDeviation();
            logRSR = rsrs.getLogarithmicRelativeSizeRanges();
            RSR = rsrs.getRelativeSizeRanges();
            request.setAttribute("encabezado", encabezados);
            request.setAttribute("datos", datos);
            request.setAttribute("encabezadosDatos", encabezadosDatos);
            request.setAttribute("lnxi", lnxi);
            request.setAttribute("lnxiavgsq", lnxiavgsq);
            request.setAttribute("lnxiSum", lnxiSum);
            request.setAttribute("lnxiavgsqSum", lnxiavgsqSum);
            request.setAttribute("variance", var);
            request.setAttribute("std", std);
            request.setAttribute("logRSR", logRSR);
            request.setAttribute("RSR", RSR);
            
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
