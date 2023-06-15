package com.example.proyecto_final_base_japyld.AdministradorJapyld.ModelsJ.DaosJ;

import com.example.proyecto_final_base_japyld.AdministradorJapyld.ModelsJ.DtoJ.JuegosPopulares;
import com.example.proyecto_final_base_japyld.BaseDaoJapyld;
import com.example.proyecto_final_base_japyld.BeansGenerales.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// DAO DE LAS LISTAS

public class AdminDao extends BaseDaoJapyld {

    // PAGINA INICIO
    public ArrayList<JuegosCompradosReservados> primeraTabla(){

            ArrayList<JuegosCompradosReservados> ultimasCompras= new ArrayList<>();

        String sql = "SELECT * FROM juegoscompradosreservados c\n" +
                "left join personas p on c.id_usuario = p.idPersona\n" +
                "left join juegos j on c.id_juego = j.idJuegos\n" +
                "ORDER BY c.fechaCompraJuego DESC\n" +
                "LIMIT 5;";

        try(Connection connection = this.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)){

            while (resultSet.next()){

                JuegosCompradosReservados compras =new JuegosCompradosReservados();
                compras.setIdJuegosCompradosReservados(resultSet.getInt(1));
                compras.setEstadoCompraJuego(resultSet.getString(3));

                Personas usuario = new Personas();
                usuario.setIdPersona(resultSet.getInt("p.idPersona"));
                usuario.setNombre(resultSet.getString("nombre"));
                compras.setUsuario(usuario);

                Juegos juego = new Juegos();
                juego.setIdJuegos((resultSet.getInt("j.idJuegos")));
                juego.setNombreJuegos(resultSet.getString("nombreJuegos"));

                compras.setJuego(juego);

                ultimasCompras.add(compras);

            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return ultimasCompras;
    }

    public ArrayList<VentaJuegosGeneral> segundaTabla(){

        ArrayList<VentaJuegosGeneral> ventas= new ArrayList<>();

        String sql1 = "SELECT * FROM ventajuegosgeneral v\n" +
                "left join personas p on v.id_usuario = p.idPersona\n" +
                "left join juegos j on v.id_juego = j.idJuegos\n" +
                "ORDER BY v.fechaPublicacion DESC\n" +
                "LIMIT 5;";


        try(Connection connection = this.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql1)){

            while (resultSet.next()){

                VentaJuegosGeneral venta = new VentaJuegosGeneral();
                venta.setIdVenta(resultSet.getInt(1));
                venta.setPrecioUsuario(resultSet.getBigDecimal(5));

                Personas usuario = new Personas();
                usuario.setIdPersona(resultSet.getInt("p.idPersona"));
                usuario.setNombre(resultSet.getString("nombre"));
                venta.setUsuario(usuario);

                Juegos juego = new Juegos();
                juego.setIdJuegos((resultSet.getInt("j.idJuegos")));
                juego.setNombreJuegos(resultSet.getString("nombreJuegos"));
                venta.setJuego(juego);

                ventas.add(venta);

            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return ventas;
    }

    // pagina videojuegos

    public ArrayList<JuegosPopulares> terceraTabla(){

        ArrayList<JuegosPopulares> lista= new ArrayList<>();


        String sql1 = "SELECT COUNT(nombreJuegos) as 'Juegos_comprados_por_título', rating, nombreJuegos, estadoCompraJuego, idJuegos\n" +
                "                FROM juegoscompradosreservados jc\n" +
                "                INNER JOIN juegos j ON jc.id_juego = j.idJuegos\n" +
                "                WHERE jc.estadoCompraJuego = 'Comprado'\n" +
                "                GROUP BY j.nombreJuegos, rating, estadoCompraJuego, idJuegos\n" +
                "                ORDER BY count(nombreJuegos) desc\n" +
                "                limit 5;";


        try(Connection connection = this.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql1)){

            while (resultSet.next()){

                JuegosPopulares videoJuego2 = new JuegosPopulares();
                videoJuego2.setNombre(resultSet.getString(3));
                videoJuego2.setCantidadVentasJuegos(resultSet.getInt(1));
                lista.add(videoJuego2);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return lista;
    }


    public ArrayList<JuegosPopulares> cuartaTabla(){

        ArrayList<JuegosPopulares> lista3= new ArrayList<>();


        String sql1 = "SELECT COUNT(nombreJuegos) as 'Juegos_comprados_por_título', rating, nombreJuegos, estadoCompraJuego, idJuegos\n" +
                "                FROM juegoscompradosreservados jc\n" +
                "                INNER JOIN juegos j ON jc.id_juego = j.idJuegos\n" +
                "                WHERE jc.estadoCompraJuego = 'Comprado'\n" +
                "                GROUP BY j.nombreJuegos, rating, estadoCompraJuego, idJuegos\n" +
                "                ORDER BY count(nombreJuegos) desc\n" +
                "                limit 5;";

        try(Connection connection = this.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql1)){

            while (resultSet.next()){
                JuegosPopulares videoJuego3 = new JuegosPopulares();
                videoJuego3.setNombre(resultSet.getString(3));
                videoJuego3.setCantidadVentasCategorias(resultSet.getInt(1));
                lista3.add(videoJuego3);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return lista3;
    }

    public ArrayList<Juegos> quintaTabla(){

        ArrayList<Juegos> juegos= new ArrayList<>();

        String sql = "SELECT * FROM juegos j\n" +
                "left join categorias c on j.id_categoria = c.idCategorias;";
        try(Connection connection = this.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)){

            while (resultSet.next()){

                Juegos juego =new Juegos();
                juego.setIdJuegos(resultSet.getInt(1));
                juego.setNombreJuegos((resultSet.getString(2)));
                juego.setPrecio(resultSet.getBigDecimal(4));
                juego.setStock(resultSet.getInt(3));

                Categoria categoria = new Categoria();
                categoria.setIdCategorias(resultSet.getString("c.idCategorias"));
                categoria.setNombre((resultSet.getString("nombre")));

                juego.setCategoria(categoria);

                juegos.add(juego);

            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return juegos;
    }

    // PAGINA DE OFERTAS GENERALES

    public ArrayList<VentaJuegosGeneral> sextaTabla(){

        ArrayList<VentaJuegosGeneral> ventas = new ArrayList<>();

        String sql = "SELECT * FROM ventajuegosgeneral c\n" +
                "left join personas p on c.id_usuario = p.idPersona\n" +
                "left join juegos j on c.id_juego = j.idJuegos\n" +
                "WHERE c.estadoVenta = 'Aceptado'\n" +
                "ORDER BY c.fechaPublicacion DESC\n" +
                "LIMIT 5";
        try(Connection connection = this.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)){

            while (resultSet.next()){

                VentaJuegosGeneral venta = new VentaJuegosGeneral();
                venta.setIdVenta(resultSet.getInt(1));

                Juegos juego = new Juegos();
                juego.setIdJuegos((resultSet.getInt("j.idJuegos")));
                juego.setNombreJuegos(resultSet.getString("nombreJuegos"));
                juego.setStock(resultSet.getInt("stock"));
                venta.setJuego(juego);

                Personas usuario = new Personas();
                usuario.setIdPersona(resultSet.getInt("p.idPersona"));
                usuario.setNombre(resultSet.getString("nombre"));
                venta.setUsuario(usuario);

                ventas.add(venta);

            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return ventas;
    }

    public ArrayList<VentaJuegosGeneral> setimaTabla(){

        ArrayList<VentaJuegosGeneral> nuevosJuegos = new ArrayList<>();

        String sql = "SELECT * FROM ventajuegosgeneral c\n" +
                "left join personas p on c.id_usuario = p.idPersona\n" +
                "left join juegos j on c.id_juego = j.idJuegos\n" +
                "WHERE c.estadoVenta = 'Aceptadp' and disponibilidad = 'Deshabilitado' \n" +
                "ORDER BY c.fechaPublicacion DESC\n" +
                "LIMIT 5;";
        try(Connection connection = this.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)){

            while (resultSet.next()){

                VentaJuegosGeneral venta = new VentaJuegosGeneral();
                venta.setIdVenta(resultSet.getInt(1));

                Juegos juego = new Juegos();
                juego.setIdJuegos((resultSet.getInt("j.idJuegos")));
                juego.setNombreJuegos(resultSet.getString("nombreJuegos"));
                venta.setJuego(juego);

                Personas usuario = new Personas();
                usuario.setIdPersona(resultSet.getInt("p.idPersona"));
                usuario.setNombre(resultSet.getString("nombre"));
                venta.setUsuario(usuario);

                nuevosJuegos.add(venta);

            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return nuevosJuegos;
    }

    public ArrayList<VentaJuegosGeneral> octavaTabla(){

        ArrayList<VentaJuegosGeneral> nuevosOfertas = new ArrayList<>();


        String sql = "SELECT * FROM ventajuegosgeneral c\n" +
                "left join personas p on c.id_usuario = p.idPersona\n" +
                "left join juegos j on c.id_juego = j.idJuegos\n" +
                "WHERE c.estadoVenta = 'Aceptado' \n" +
                "ORDER BY c.fechaPublicacion DESC;";

        try(Connection connection = this.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)){

            while (resultSet.next()){

                VentaJuegosGeneral venta = new VentaJuegosGeneral();
                venta.setIdVenta(resultSet.getInt(1));
                venta.setPrecioUsuario(resultSet.getBigDecimal(5));

                Juegos juego = new Juegos();
                juego.setIdJuegos((resultSet.getInt("j.idJuegos")));
                juego.setNombreJuegos(resultSet.getString("nombreJuegos"));
                venta.setJuego(juego);

                Personas usuario = new Personas();
                usuario.setIdPersona(resultSet.getInt("p.idPersona"));
                usuario.setNombre(resultSet.getString("nombre"));
                venta.setUsuario(usuario);

                nuevosOfertas.add(venta);

            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return nuevosOfertas;
    }

    // AGREGAR UN JUEGO QUE EL USUARIO VENDIO

    public ArrayList<Juegos> infoJuegoNuevo(){

        ArrayList<Juegos> juegos= new ArrayList<>();

        String sql = "SELECT * FROM juegos j\n" +
                "left join categorias c on j.id_categoria = c.idCategorias\n" +
                "left join imagenes i on j.id_imagen = i.idImagenes\n" +
                "WHERE  j.nombreJuegos = 'Resident Evil 4';";
        try(Connection connection = this.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)){

            while (resultSet.next()){

                Juegos juego =new Juegos();
                juego.setIdJuegos(resultSet.getInt(1));
                juego.setNombreJuegos((resultSet.getString(2)));
                juego.setPrecio(resultSet.getBigDecimal(4));
                juego.setDescripcion(resultSet.getString(6));

                Categoria categoria = new Categoria();
                categoria.setIdCategorias(resultSet.getString("c.idCategorias"));
                categoria.setNombre((resultSet.getString("nombre")));

                Imagen imagen = new Imagen();
                imagen.setIdImagenes(resultSet.getInt("i.idImagenes"));
                imagen.setDireccionArchivo((resultSet.getString("direccion_archivo")));

                juego.setCategoria(categoria);
                juego.setImagen(imagen);

                juegos.add(juego);

            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return juegos;
    }

    // PAGINA INCIO
    public ArrayList<Personas> perfil(){

        ArrayList<Personas> ventas = new ArrayList<>();

        String sql = "SELECT * FROM personas\n" +
                "WHERE id_roles = 'ADM' and idPersona=1;";
        try(Connection connection = this.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)){

            while (resultSet.next()){

                Personas admi = new Personas();
                admi.setIdPersona(resultSet.getInt(1));
                admi.setNombre(resultSet.getString(4));
                admi.setFechaDeNacimiento(resultSet.getDate(6));
                admi.setCorreo(resultSet.getString(2));
                ventas.add(admi);

            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return ventas;
    }

}
