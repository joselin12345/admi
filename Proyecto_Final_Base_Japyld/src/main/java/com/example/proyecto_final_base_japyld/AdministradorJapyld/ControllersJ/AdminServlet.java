package com.example.proyecto_final_base_japyld.AdministradorJapyld.ControllersJ;

import com.example.proyecto_final_base_japyld.AdministradorJapyld.ModelsJ.DaosJ.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        AdminDao adminDao = new AdminDao();

        String action = request.getParameter("action") == null ? "lista" :request.getParameter("action");
        switch (action){
            case "lista":
                request.setAttribute("ultimasCompras",adminDao.primeraTabla());
                request.setAttribute("ventas",adminDao.segundaTabla());
                request.getRequestDispatcher("admi/adminPaginaInicio.jsp").forward(request,response);
                break;
            case "listasPaginaVideojuegos":
                request.setAttribute("lista",adminDao.terceraTabla());
                request.setAttribute("lista1",adminDao.cuartaTabla());
                request.setAttribute("juegos",adminDao.quintaTabla());
                request.getRequestDispatcher("admi/adminVideojuegos.jsp").forward(request,response);
                break;
            case "listaPaginaOfertas":
                request.setAttribute("ventas",adminDao.sextaTabla());
                request.setAttribute("nuevosJuegos",adminDao.setimaTabla());
                request.setAttribute("nuevosOfertas", adminDao.octavaTabla());
                request.getRequestDispatcher("admi/OfertasAdmi.jsp").forward(request,response);
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
