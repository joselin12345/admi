package com.example.proyecto_final_base_japyld.AdministradorJapyld.ModelsJ.DaosJ;
import com.example.proyecto_final_base_japyld.AdministradorJapyld.ModelsJ.DtoJ.JuegosReservadosDias;

import java.sql.*;
import java.util.ArrayList;

public class JuegosReservadosDaos {
    public ArrayList<JuegosReservadosDias> tabla30Dias(){

        ArrayList<JuegosReservadosDias> JR30D= new ArrayList<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String sql = "Select  juegos.nombreJuegos, personas.nombre, TIMESTAMPDIFF(DAY, fechaCompraJuego, '2023-06-01') as 'dias'\n" +
                ", juegoscompradosreservados.id_juego, juegos.idJuegos \n" +
                ", juegoscompradosreservados.id_usuario, estadoCompraJuego, personas.idPersona\n" +
                "from juegoscompradosreservados \n" +
                "inner join juegos \n" +
                "on juegoscompradosreservados.id_juego = juegos.idJuegos\n" +
                "inner join  personas\n" +
                "on juegoscompradosreservados.id_usuario = personas.idPersona\n" +
                "where TIMESTAMPDIFF(DAY, fechaCompraJuego, '2023-06-01') >30 and estadoCompraJuego like 'Reservado'\n";
        String url = "jdbc:mysql://localhost:3306/japyld";

        try(Connection connection = DriverManager.getConnection(url,"root","root");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql)){

            while (resultSet.next()){
                JuegosReservadosDias J30 =new JuegosReservadosDias();

                J30.setNombreJuegos(resultSet.getString(1));
                J30.setNombre(resultSet.getString(2));
                J30.setFechaCompraJuego(resultSet.getInt(3));
                JR30D.add(J30);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return JR30D;
    }
    public ArrayList<JuegosReservadosDias> tabla20Dias(){

        ArrayList<JuegosReservadosDias> JR20D = new ArrayList<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql1 = "Select  juegos.nombreJuegos, personas.nombre, TIMESTAMPDIFF(DAY, fechaCompraJuego, '2023-06-01') as 'dias'\n" +
                ", juegoscompradosreservados.id_juego, juegos.idJuegos \n" +
                ", juegoscompradosreservados.id_usuario, estadoCompraJuego, personas.idPersona\n" +
                "from juegoscompradosreservados \n" +
                "inner join juegos \n" +
                "on juegoscompradosreservados.id_juego = juegos.idJuegos\n" +
                "inner join  personas\n" +
                "on juegoscompradosreservados.id_usuario = personas.idPersona\n" +
                "where TIMESTAMPDIFF(DAY, fechaCompraJuego, '2023-06-01') >20 and TIMESTAMPDIFF(DAY, fechaCompraJuego, '2023-06-01') <30 \n" +
                "and estadoCompraJuego like 'Reservado'\n";
        String url = "jdbc:mysql://localhost:3306/japyld";


        try(Connection connection = DriverManager.getConnection(url,"root","root");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql1)){

            while (resultSet.next()){
                JuegosReservadosDias J20 =new JuegosReservadosDias();

                J20.setNombreJuegos(resultSet.getString(1));
                J20.setNombre(resultSet.getString(2));
                J20.setFechaCompraJuego(resultSet.getInt(3));
                JR20D.add(J20);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return JR20D;
    }

    public ArrayList<JuegosReservadosDias> tabla10Dias(){

        ArrayList<JuegosReservadosDias> JR10D = new ArrayList<>();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String sql1 = "Select  juegos.nombreJuegos, personas.nombre, TIMESTAMPDIFF(DAY, fechaCompraJuego, '2023-06-01') as 'dias'\n" +
                ", juegoscompradosreservados.id_juego, juegos.idJuegos \n" +
                ", juegoscompradosreservados.id_usuario, estadoCompraJuego, personas.idPersona\n" +
                "from juegoscompradosreservados \n" +
                "inner join juegos \n" +
                "on juegoscompradosreservados.id_juego = juegos.idJuegos\n" +
                "inner join  personas\n" +
                "on juegoscompradosreservados.id_usuario = personas.idPersona\n" +
                "where TIMESTAMPDIFF(DAY, fechaCompraJuego, '2023-06-01') >0 and TIMESTAMPDIFF(DAY, fechaCompraJuego, '2023-06-01') <20 \n" +
                "and estadoCompraJuego like 'Reservado'";
        String url = "jdbc:mysql://localhost:3306/japyld";


        try(Connection connection = DriverManager.getConnection(url,"root","root");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql1)){

            while (resultSet.next()){
                JuegosReservadosDias J10 =new JuegosReservadosDias();

                J10.setNombreJuegos(resultSet.getString(1));
                J10.setNombre(resultSet.getString(2));
                J10.setFechaCompraJuego(resultSet.getInt(3));
                JR10D.add(J10);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return JR10D;
    }
}
