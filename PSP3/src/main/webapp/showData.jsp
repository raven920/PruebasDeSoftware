
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<Double> datos = (List<Double>) request.getAttribute("datos");
    List<String> encabezadosDatos = (List<String>) request.getAttribute("encabezadosDatos");
    String[] encabezado = (String[]) request.getAttribute("encabezado");
    double[] lnxi = (double[]) request.getAttribute("lnxi");
    double[] RSR = (double[]) request.getAttribute("RSR");
    double[] logRSR = (double[]) request.getAttribute("logRSR");
    double[] lnxiavgsq = (double[]) request.getAttribute("lnxiavgsq");
    double lnxiavgsqSum = (Double) request.getAttribute("lnxiavgsqSum");
    double lnxiSum = (Double) request.getAttribute("lnxiSum");
    double std = (Double) request.getAttribute("std");
    double variance = (Double) request.getAttribute("variance");
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumFractionDigits(4);
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Relative Size Ranges</title>

        <script src="js/jquery-2.1.1.min.js"></script>
        <script src="js/materialize.js"></script>
        <script src="js/calcRegression.js"></script>

        <!-- CSS  -->
        <link href="css/MaterialIcons.css" rel="stylesheet">
        <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>

        <link href="css/settings.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <nav class="teal lighten-2" role="navigation">
                <div class="nav-wrapper container"><a id="logo-container" href="/PSP3" class="brand-logo">PSP3</a>

                    <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
                </div>
            </nav>
        </header>
        <main>
            <div class="section no-pad-bot" id="index-banner">
                <div class="container">
                    <br><br>
                    <h1 class="header center red-text text-lighten-1">Relative Size Ranges</h1>

                    <div class="row">
                        <table class="bordered responsive-table">
                            <thead>
                                <tr>
                                    <th>
                                        <span class="theader"><%=encabezado[0]%></span>
                                    </th>
                                    <th>
                                        <span class="theader"><%=encabezado[1]%>
                                        <%
                                            if(encabezado.length == 3){
                                                %>
                                                <%=" / "+encabezado[2]%>
                                                <%
                                            }
                                        %>
                                        ( x<sub>i</sub> )
                                        </span>
                                    </th>
                                    <th>
                                        <span class="theader" style="font-style: italic;">
                                            ln(x<sub>i</sub>)
                                        </span>
                                    </th>
                                    <th
                                        <span class="theader" style="font-style: italic;"> 
                                            (ln(x<sub>i</sub>)-avg)<sup>2</sup>
                                        </span>
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for(int i = 0; i < datos.size(); i++){
                                %>
                                <tr>
                                    <th>
                                        <%=encabezadosDatos.get(i)%>
                                    </th>
                                    <td>
                                        <%=nf.format(datos.get(i))%>
                                    </td>
                                    <td>
                                        <%=nf.format(lnxi[i])%>
                                    </td>
                                    <td>
                                        <%=nf.format(lnxiavgsq[i])%>
                                    </td>
                                </tr>
                                <%
                                }
                                %>
                                <tr>
                                    <th>
                                        Total
                                    </th>
                                    <td></td>
                                    <td><%=nf.format(lnxiSum)%></td>
                                    <td><%=nf.format(lnxiavgsqSum)%></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col s12 m6 center-align">
                            <span class="val_header">σ = <span id="beta0"><%=nf.format(std)%></span></span>
                        </div>
                        <div class="col s12 m6 center-align">
                            <span class="val_header">σ<sup>2</sup> = <span id="beta1"><%=nf.format(variance)%></span></span>
                        </div>
                        
                    </div>
                        
                        <br>
                        
                        <br>
                        
                    <div class="row">
                        <table class="bordered responsive-table">
                            <thead>
                                <tr>
                                    <th>
                                        <span class="theader"></span>
                                    </th>
                                    <th>
                                        <span class="theader">Very Small</span>
                                    </th>
                                    <th>
                                        <span class="theader">Small </span>
                                    </th>
                                    <th>
                                        <span class="theader">Medium </span>
                                    </th>
                                    <th>
                                        <span class="theader">Large </span>
                                    </th>
                                    <th>
                                        <span class="theader">Very Large</span>
                                    </th>
                                </tr>
                            </thead>
                            <tbody>
                                
                                <tr>
                                    <th>Natural Logarithm</th>
                                    <%
                                    for(int i = 0; i < logRSR.length; i++){
                                    %>
                                    <td><%=nf.format(logRSR[i])%></td>
                                    <%}%>
                                </tr>
                                <tr>
                                    <th>
                                        Final Result
                                    </th>
                                    <%
                                    for(int i = 0; i < RSR.length; i++){
                                    %>
                                    <td><%=nf.format(RSR[i])%></td>
                                    <%}%>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    
                </div>
            </div>
        </main>
        <footer class="page-footer red lighten-1">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">PSP3</h5>
                        <p class="grey-text text-lighten-4">Desarrollado por Jazmín, Alejandra, Juan y Christian.</p>
                    </div>

                </div>

            </div>

        </footer>


    </body>
</html>
