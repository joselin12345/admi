package com.example.proyecto_final_base_japyld.AdministradorJapyld.ModelsJ.DaosJ;

import com.example.proyecto_final_base_japyld.BaseDaoJapyld;
import com.example.proyecto_final_base_japyld.BeansGenerales.Categoria;
import com.example.proyecto_final_base_japyld.BeansGenerales.Imagen;
import com.example.proyecto_final_base_japyld.BeansGenerales.Juegos;

import java.sql.*;

public class CrudDao extends BaseDaoJapyld {

    // LISTADO DE JUEGOS

    public Juegos ObtenerJuego( int id){

        Juegos juegos =null;


        String sql = "SELECT * FROM juegos j\n" +
                "left join categorias c on c.idCategorias = j.id_categoria \n" +
                "left join imagenes i on i.idImagenes = j.id_imagen \n " +
                "WHERE j.idJuegos = ? \n" +
                "order by j.idJuegos";

        try(Connection connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setInt(1,id);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    juegos = infojuegos(resultSet);

                }
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return juegos;
    }

    // ACTUALIZA JUEGO

    public void editarJuego(Juegos juegos){

        String sql = "UPDATE juegos  \n" +
                "SET nombreJuegos = ?,\n" +
                "precio = ?, \n" +
                "descripcion = ?, \n" +
                "id_imagen = ?, \n" +
                "id_categoria = ?\n" +
                "WHERE idJuegos = ?;";

        try(Connection connection = this.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1,juegos.getNombreJuegos());
            preparedStatement.setBigDecimal(2,juegos.getPrecio());
            preparedStatement.setString(3,juegos.getDescripcion());
            preparedStatement.setInt(4,juegos.getImagen().getIdImagenes());
            preparedStatement.setString(5,juegos.getCategoria().getIdCategorias());
            preparedStatement.setInt(6,juegos.getIdJuegos());
            preparedStatement.executeUpdate();


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    // METODO QUE GUARDA TODA LA INFORMACION DE UN JUEGO

    private Juegos infojuegos( ResultSet resultSet) throws SQLException{

        Juegos juegos = new Juegos();
        juegos.setIdJuegos(resultSet.getInt(1));
        juegos.setNombreJuegos(resultSet.getString(2));
        juegos.setStock(resultSet.getInt(3));
        juegos.setPrecio(resultSet.getBigDecimal(4));
        juegos.setEstaoJuego(resultSet.getString(5));
        juegos.setDescripcion(resultSet.getString(6));

        Imagen imagen = new Imagen();
        imagen.setIdImagenes(resultSet.getInt(7));
        imagen.setDireccionArchivo(resultSet.getString(14));
        juegos.setImagen(imagen);

        Categoria categoria = new Categoria();
        categoria.setIdCategorias(resultSet.getString(8));
        categoria.setNombre(resultSet.getString(10));
        juegos.setCategoria(categoria);

        return juegos;
    }

}
