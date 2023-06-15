package com.example.proyecto_final_base_japyld.AdministradorJapyld.ControllersJ;

import com.example.proyecto_final_base_japyld.AdministradorJapyld.ModelsJ.DaosJ.AdminDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AgregarJuegoUsuarioServlet", value = "/AgregarJuegoUsuarioServlet")
public class AgregarJuegoUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AdminDao adminDao = new AdminDao();

        String action = request.getParameter("action") == null ? "lista" :request.getParameter("action");
        switch (action){
            case "agregarJuegoUsuario":
                request.setAttribute("juegos",adminDao.infoJuegoNuevo());
                request.getRequestDispatcher("AdministradorJapyld/AgregarJuegoAdmi.jsp").forward(request,response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
