<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Vacuna"%>
<%
    if (session.getAttribute("listavac") == null){
        ArrayList<Vacuna> la = new ArrayList<Vacuna>();
        session.setAttribute("listavac", la);
    }
    ArrayList<Vacuna> lista = (ArrayList<Vacuna>) session.getAttribute("listavac");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="">
            <tr>
                <th>PRIMER PARCIAL TEM-742 <h1>Nombre: Franz R. Condori Casas</h1>
             <h2>Carnet: 8350006</h2></th>
            </tr> 
        </table>
        <h1>REGISTRO DE VACUNAS</h1>
        <a href="MainServlet?op=nuevo">Nuevo registro</a>
        <table border="1">
            <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Peso</th>
            <th>Talla</th>
            <th>Vacuna</th>
            <th></th>
            <th></th>
            </tr>
            <%
            if (lista != null){
                for (Vacuna item : lista){
            %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getNombre() %></td>
                <td><%= item.getPeso() %></td>
                <td><%= item.getTalla() %></td>
                <td><%= item.getVacuna() %></td>
                <td><a href="MainServlet?op=editar&id=<%= item.getId() %>">Editar</a></td>
                <td><a href="MainServlet?op=eliminar&id=<%= item.getId() %>"
                       onclick="return(confirm('Esta seguro de eliminar??'))"
                       >Eliminar</a></td>
            </tr>
            <%
                }
            }
            %>
        </table>
    </body>
</html>
