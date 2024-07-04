package com.proyecto_final;
//Importar las librerías
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Actualizar {
    public static void main(String[] args) {
        
        // Información de conexión
        String url = "jdbc:mysql://localhost:3306/mis_usuarios";
        String user = "root";
        String password = "root";

          // Declaramos interfases que nos ayudan con conexiones y sentencias SQL
          Connection connection = null;
          PreparedStatement declaracion = null;

          try {
            //Cargamos el controlador
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexion
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");

            String sqlActualizar = "UPDATE usuarios SET nombre= ?, apellido = ?,"+
            "email = ?, fkPais = ? WHERE idUsuario = ?";

            // Preparamos la interfase para pasar la consulta
            declaracion = connection.prepareStatement(sqlActualizar);
            declaracion.setString(1, "Alfonso");
            declaracion.setString(2, "Dagoberto");
            declaracion.setString(3, "alfonso@gmail.com");
            declaracion.setInt(4, 1);

            //Pasamos el ID del usuario a actualizar
            declaracion.setInt(5, 2);

            // Ejecutamos la inserción
            int filaActualizada = declaracion.executeUpdate();

            // Mediante una estructura if comunicamos de la inserción exitosa
            if (filaActualizada > 0) {
                System.out.println("Datos actualizados exitosamente.");
            }else{
                System.out.println("No se encontró registro para el ID solicitado");
            }
            
            

        } catch (Exception e) {
           e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (connection != null)
                    connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
