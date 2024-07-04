package com.proyecto_final;
//Importar las librerías
import java.sql.*;

public class BorrarRegistro {
    public static void main(String[] args) {
        // Información de conexión
        String url = "jdbc:mysql://localhost:3306/mis_usuarios";
        String user = "root";
        String password = "root";

        // Objetos de conexion y ejecución de codigo SQL
        Connection connection = null;
        PreparedStatement declaracion = null;

        try {
            // Cargamos el controlador
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexion
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");

            String sqlBorrar = "Delete  from usuarios WHERE idUsuario = ?";

            // Preparamos la interfase para pasar la consulta
            declaracion = connection.prepareStatement(sqlBorrar);
            
            // Pasamos el ID del usuario a actualizar
            declaracion.setInt(1, 2);

            // Ejecutamos la inserción
            int filaBorrada = declaracion.executeUpdate();

            // Mediante una estructura if comunicamos de la inserción exitosa
            if (filaBorrada > 0) {
                System.out.println("Datos eliminados exitosamente.");
            } else {
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
