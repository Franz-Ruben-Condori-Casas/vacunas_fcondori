package com.emergentes.controller;

import com.emergentes.modelo.Vacuna;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String opcion = request.getParameter("op");
        Vacuna objvac = new Vacuna();
        int id, pos;
        HttpSession ses = request.getSession();
        List<Vacuna> lista = (List<Vacuna>) ses.getAttribute("listavac");
        switch (opcion) {
            case "nuevo":
                //Enviar objeto a editar
                request.setAttribute("miobjvac", objvac);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                //Obtener la posicion del elemento en la coleccion
                pos = buscarPorIndice (request, id);
                //Obtener el objeto
                objvac = lista.get (pos);
                //Enviarlo para edicion
                request.setAttribute("miobjvac", objvac);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
            case "eliminar":
                //Obtener la posicion del elemento en la coleccion
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarPorIndice(request, id);
                if (pos >=0)  {
                    lista.remove(pos);
                }
            //Actualizamos la lista debido a la eliminacion
            request.setAttribute("listavac", lista);
            response.sendRedirect("index.jsp");
            break;
            default:
                request.setAttribute("listavac", lista);
                response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession ses = request.getSession();
        ArrayList<Vacuna> lista = (ArrayList<Vacuna>) ses.getAttribute("listavac");
        Vacuna objvac = new Vacuna();
        objvac.setId(id);
        objvac.setNombre(request.getParameter("nombre"));
        objvac.setPeso(Integer.parseInt(request.getParameter("peso")));
        objvac.setTalla(Integer.parseInt(request.getParameter("talla")));
        objvac.setVacuna(request.getParameter("vacuna"));
        System.out.println("El ID es "+ id);
        if (id == 0) {
            //Colocar el ID
            int idNuevo = obtenerId(request);
            objvac.setId(idNuevo);
            
            lista.add(objvac);
            System.out.println(objvac.toString());
        }  else {
            //edicion
            int pos = buscarPorIndice(request, id);
            lista.set(pos,objvac);
            System.out.println(objvac.toString());
        }
        System.out.println("Enviando as index ");
        request.setAttribute("listavac", lista);
        response.sendRedirect("index.jsp");
    }
     
    public int buscarPorIndice(HttpServletRequest request, int id)  {
        HttpSession ses = request.getSession();
        List<Vacuna> lista = (List<Vacuna>) ses.getAttribute("listavac");
        
        int pos = -1;
        
        if (lista != null)  {
            for (Vacuna ele : lista)  {
                ++pos;
                if (ele.getId() == id)  {
                    break;
                }
            }
        }
        return pos;
    }

    
 public int obtenerId(HttpServletRequest request)  {
     HttpSession ses = request.getSession();
     ArrayList<Vacuna> lista = (ArrayList<Vacuna>) ses.getAttribute("listavac");
     //Conteo de Id desde 0
     int idn = 0;
     for (Vacuna ele : lista) {
         idn = ele.getId();
     }
     return idn + 1;
 }
}