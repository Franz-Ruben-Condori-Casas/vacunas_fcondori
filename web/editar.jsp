<%@page import="com.emergentes.modelo.Vacuna"%>
<%
    Vacuna reg = (Vacuna)request.getAttribute("miobjvac");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Registro de vacunas</h1>
        <form action="MainServlet" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" value="<%= reg.getId() %>" size="2" readonly></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="<%= reg.getNombre() %>"></td>
                </tr>
                 <tr>
                    <td>Peso</td>
                    <td><input type="text" name="peso" value="<%= reg.getPeso() %>"></td>
                </tr>
                <tr>
                    <td>Talla</td>
                    <td><input type="text" name="talla" value="<%= reg.getTalla() %>"></td>
                </tr>
                <tr>
                    <td>Vacuna</td>
                    <td><input type="checkbox" name="vacuna" value="si">si
                        <input type="checkbox" name="vacuna" value="no"/>no
                </tr>
                <tr>
                <tr></tr>
                <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
