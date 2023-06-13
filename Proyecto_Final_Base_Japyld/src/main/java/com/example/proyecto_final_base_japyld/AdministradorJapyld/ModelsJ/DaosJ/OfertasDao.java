package com.example.proyecto_final_base_japyld.AdministradorJapyld.ModelsJ.DaosJ;

import com.example.proyecto_final_base_japyld.BaseDaoJapyld;
import com.example.proyecto_final_base_japyld.BeansGenerales.Imagen;
import com.example.proyecto_final_base_japyld.BeansGenerales.Juegos;
import com.example.proyecto_final_base_japyld.BeansGenerales.VentaJuegosGeneral;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OfertasDao extends BaseDaoJapyld {
    public Juegos obtenerJuego(int id_venta){
        VentaJuegosGeneral ventaJuegosGeneral = null;
        Juegos juegos = null;
        Imagen imagen = null;

        try(Connection connection = this.getConnection();
            PreparedStatement psmt =connection.prepareStatement("SELECT * FROM ventajuegosgeneral v\n" +
                    "left join juegos j on v.idVenta = j.idJuegos\n" +
                    "left join imagenes i on j.id_imagen = i.idImagenes\n" +
                    "WHERE  v.idVenta =?")){

            psmt.setInt(1,id_venta);

            try(ResultSet rs = psmt.executeQuery()){
                if(rs.next()){
                    ventaJuegosGeneral = new VentaJuegosGeneral();
                    ventaJuegosGeneral.setIdVenta(rs.getInt(1));
                    ventaJuegosGeneral.setPrecioUsuario(rs.getBigDecimal(5));

                    juegos = new Juegos();
                    juegos.setIdJuegos(rs.getInt("j.idJuegos"));
                    juegos.setNombreJuegos(rs.getString("nombreJuegos"));

                    imagen = new Imagen();
                    imagen.setIdImagenes(rs.getInt("i.idImagenes"));
                    imagen.setDireccionArchivo(rs.getString("direccion_archivo"));

                }
            }


        }catch (SQLException e){
            throw new RuntimeException(e);
        }


        return juegos;
    }
}
