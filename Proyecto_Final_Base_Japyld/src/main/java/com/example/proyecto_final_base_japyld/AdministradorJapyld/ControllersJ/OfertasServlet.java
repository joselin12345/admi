package com.example.proyecto_final_base_japyld.AdministradorJapyld.ControllersJ;

import com.example.proyecto_final_base_japyld.AdministradorJapyld.ModelsJ.DaosJ.OfertasDao;
import com.example.proyecto_final_base_japyld.BeansGenerales.Juegos;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "OfertasServlet", value = "/OfertasServlet")
public class OfertasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        OfertasDao ofertasDao = new OfertasDao();
        String id_venta = request.getParameter("id");
        int id_veta_int = Integer.parseInt(id_venta);
        Juegos juegos = ofertasDao.obtenerJuego(id_veta_int);
        request.setAttribute("juegos", juegos);
        request.getRequestDispatcher("AdministradorJapyld/NuevaOferta.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
