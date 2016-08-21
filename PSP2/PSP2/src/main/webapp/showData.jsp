
<%@page import="co.edu.udea.pruebas.psp2.utils.llcc.Nodo"%>
<%@page import="co.edu.udea.pruebas.psp2.utils.llcc.Dupla"%>
<%@page import="co.edu.udea.pruebas.psp2.utils.llcc.ListaLigadaConCabeza"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ListaLigadaConCabeza<Dupla<Double>> datos
            = (ListaLigadaConCabeza<Dupla<Double>>) request.getAttribute("datos");
    Dupla<String> encabezado = (Dupla<String>) request.getAttribute("encabezado");
    double[] resultado = (double[]) request.getAttribute("resultado");
    Nodo<Dupla<Double>> aux;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
        <title>Linear Regression Calculator</title>

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
            <nav class="blue" role="navigation">
                <div class="nav-wrapper container"><a id="logo-container" href="/PSP2" class="brand-logo">PSP2</a>

                    <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
                </div>
            </nav>
        </header>
        <main>
            <div class="section no-pad-bot" id="index-banner">
                <div class="container">
                    <br><br>
                    <h1 class="header center orange-text">Linear Regression Calculator</h1>

                    <div class="row">
                        <table class="bordered responsive-table">
                            <thead>
                                <tr>
                                    <th></th>
                                        <%
                                            for (int i = 1; i <= datos.getTamano(); i++) {
                                        %>
                                    <th><%=i%></th>
                                        <%
                                            }
                                        %>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th><%=encabezado.getObjeto1()%></th>
                                        <%
                                            aux = datos.getPrimero();
                                            while (!datos.finDeRecorrido(aux)) {

                                        %>
                                    <th><%=aux.getObjeto().getObjeto1()%></th>
                                        <%
                                                aux = aux.getSiguiente();
                                            }
                                        %>
                                </tr>
                                <tr>
                                    <th><%=encabezado.getObjeto2()%></th>
                                        <%
                                            aux = datos.getPrimero();
                                            while (!datos.finDeRecorrido(aux)) {

                                        %>
                                    <th><%=aux.getObjeto().getObjeto2()%></th>
                                        <%
                                                aux = aux.getSiguiente();
                                            }
                                        %>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col s12 m3 center-align">
                            <span class="val_header">β<sub>0</sub> = <span id="beta0"><%=resultado[0]%></span></span>
                        </div>
                        <div class="col s12 m3 center-align">
                            <span class="val_header">β<sub>1</sub> = <span id="beta1"><%=resultado[1]%></span></span>
                        </div>
                        <div class="col s12 m3 center-align">
                            <span class="val_header">r<sub>x,y</sub> = <span id="rsubxy"><%=resultado[2]%></span></span>
                        </div>
                        <div class="col s12 m3 center-align">
                            <span class="val_header">r<sup>2</sup> = <span id="rsub2"><%=resultado[3]%></span></span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col offset-m5 s12">
                            <div class="input-field col m3 s12">
                                <input step="any" id="xsubk" type="number" class="validate">
                                <label for="xsubk" class="val_header">Insert X<sub>k</sub></label>
                            </div>
                        </div>
                    </div>
                        <br>
                        <div class="row center">
                            <span class="val_header">Y<sub>k</sub> = <span id="ysubk">Insert X<sub>k</sub> first.</span></span>
                        </div>

                </div>
            </div>
        </main>
        <footer class="page-footer orange">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">PSP 2</h5>
                        <p class="grey-text text-lighten-4">Desarrollado por Jazmín, Alejandra, Juan y Christian.</p>
                    </div>

                </div>

            </div>

        </footer>


    </body>
</html>
