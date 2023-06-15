package com.example.proyecto_final_base_japyld.AdministradorJapyld.ControllersJ;

import com.example.proyecto_final_base_japyld.AdministradorJapyld.ModelsJ.DaosJ.JuegosReservadosDaos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "JuegosReservadosServlet", value = "/JuegosReservadosServlet")
public class JuegosReservadosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JuegosReservadosDaos juegosReservadosDaos = new JuegosReservadosDaos();
        request.setAttribute("lista30dias", juegosReservadosDaos.tabla30Dias());
        request.setAttribute("lista20dias", juegosReservadosDaos.tabla20Dias());
        request.setAttribute("lista10dias", juegosReservadosDaos.tabla10Dias());

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("AdministradorJapyld/ReservasAdmi.jsp");
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
