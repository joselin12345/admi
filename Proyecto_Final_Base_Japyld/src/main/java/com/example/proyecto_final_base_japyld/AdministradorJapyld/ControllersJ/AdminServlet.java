package com.example.proyecto_final_base_japyld.AdministradorJapyld.ControllersJ;

import com.example.proyecto_final_base_japyld.AdministradorJapyld.ModelsJ.DaosJ.AdminDao;
import com.example.proyecto_final_base_japyld.AdministradorJapyld.ModelsJ.DaosJ.CrudDao;
import com.example.proyecto_final_base_japyld.BeansGenerales.Categoria;
import com.example.proyecto_final_base_japyld.BeansGenerales.Imagen;
import com.example.proyecto_final_base_japyld.BeansGenerales.Juegos;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "lista" :request.getParameter("action");

        RequestDispatcher view;
        AdminDao adminDao = new AdminDao();
        CrudDao crudDao = new CrudDao();

        switch (action){
            case "lista":
                request.setAttribute("ultimasCompras",adminDao.primeraTabla());
                request.setAttribute("ventas",adminDao.segundaTabla());
                request.getRequestDispatcher("AdministradorJapyld/adminPaginaInicio.jsp").forward(request,response);
                break;
            case "listasPaginaVideojuegos":
                request.setAttribute("lista",adminDao.terceraTabla());
                request.setAttribute("lista1",adminDao.cuartaTabla());
                request.setAttribute("juegos",adminDao.quintaTabla());
                request.getRequestDispatcher("AdministradorJapyld/adminVideojuegos.jsp").forward(request,response);
                break;
            case "listaPaginaOfertas":
                request.setAttribute("ventas",adminDao.sextaTabla());
                request.setAttribute("nuevosJuegos",adminDao.setimaTabla());
                request.setAttribute("nuevosOfertas", adminDao.octavaTabla());
                request.getRequestDispatcher("AdministradorJapyld/OfertasAdmi.jsp").forward(request,response);
                break;
            case "editar":

                if(request.getParameter("id") !=null){
                    String id = request.getParameter("id");
                    int id_int=0;
                    try{
                        id_int=Integer.parseInt(id);
                    }catch (NumberFormatException e){
                        response.sendRedirect("AdminServlet");
                    }

                    Juegos juego = crudDao.ObtenerJuego(id_int);

                    if(juego != null){

                        request.setAttribute("juego", juego);
                        // enviar lista de juegos
                        // enviar lista de categoria para combox
                        view = request.getRequestDispatcher("AdministradorJapyld/adminEditVideojuego.jsp");
                        view.forward(request,response);
                    }else{
                        response.sendRedirect("AdminServlet");
                    }

                }else {
                    response.sendRedirect("AdminServlet");
                }

            default:
                response.sendRedirect("AdminServlet");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "lista" :request.getParameter("action");

        CrudDao crudDao = new CrudDao();

        Juegos juegos = setJuegos(request);

        switch (action){
            case "actualizar":
                juegos.setIdJuegos(Integer.parseInt(request.getParameter("id_juego")));

                crudDao.editarJuego(juegos);

                response.sendRedirect("AdminServlet");
        }

    }

    private Juegos setJuegos(HttpServletRequest request){

        Juegos juegos = new Juegos();

        juegos.setNombreJuegos(request.getParameter("nombre"));
        juegos.setPrecio(new BigDecimal(request.getParameter("precio")));
        juegos.setDescripcion(request.getParameter("descripcion"));

        Imagen imagen = new Imagen();
        imagen.setIdImagenes(Integer.parseInt(request.getParameter("id_imagen")));
        juegos.setImagen(imagen);

        Categoria categoria = new Categoria();
        categoria.setIdCategorias(request.getParameter("id_categoria"));
        juegos.setCategoria(categoria);

        return juegos;
    }
}
