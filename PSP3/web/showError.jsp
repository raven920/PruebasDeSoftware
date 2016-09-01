<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    String resultado = (String) request.getAttribute("errorText");

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
            <nav class="blue" role="navigation">
                <div class="nav-wrapper container"><a id="logo-container" href="/PSP3" class="brand-logo">PSP3</a>

                    <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
                </div>
            </nav>
        </header>
        <main>
            <div class="section no-pad-bot" id="index-banner">
                <div class="container">
                    <br><br>
                    <h1 class="header center orange-text">Relative Size Ranges</h1>
                    <br><br>
                    <div class="row center">
                        <h5 class="header col s12 light" style="font-weight: bold;">Error:</h5>
                    </div>
                   
                    <div class="row center">
                        <h5 class="header col s12 light"><%=resultado%>.</h5>
                    </div>
                </div>
            </div>
        </main>
        <footer class="page-footer orange">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">PSP 3</h5>
                        <p class="grey-text text-lighten-4">Desarrollado por Jazmín, Alejandra, Juan y Christian.</p>
                    </div>

                </div>

            </div>

        </footer>


    </body>
</html>
