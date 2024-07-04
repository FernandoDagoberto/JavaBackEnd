package com.proyecto_final;

//Importación de librerías
import java.sql.*;

public class AltaUsuarios {

    public static void main(String[] args) {

        // Información de conexión
        String url = "jdbc:mysql://localhost:3306/mis_usuarios";
        String user = "root";
        String password = "root";

        // Objetos de conexion y ejecución de codigo SQL
        Connection connection = null;
        PreparedStatement declaracion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexion
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");

            // Generamos la consulta SQL
            String sqlUsuarios = "INSERT INTO usuarios (nombre, apellido,email,fkPais) VALUES (?, ?, ?, ?)";

            // Cargamos los datos en la tabla
            declaracion = connection.prepareStatement(sqlUsuarios);
            declaracion.setString(1, "Melina");
            declaracion.setString(2, "Meza");
            declaracion.setString(3, "mmeza@gmail.com");
            declaracion.setInt(4, 2);

            // Ejecutamos la inserción
            int filasInsertadas = declaracion.executeUpdate();

            // Mediante una estructura if comunicamos de la inserción exitosa
            if (filasInsertadas > 0) {
                System.out.println("Inserción exitosa");
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
