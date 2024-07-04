package com.proyecto_final;
// Importamos las librerias
import java.sql.*;

public class AltaPaises {
    public static void main(String[] args) {
        // Información de conexión
        String url = "jdbc:mysql://localhost:3306/mis_usuarios";
        String user = "root";
        String password = "root";

        // Objetos de conexion y ejecución de codigo SQL
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexion
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");

            // Generamos la consulta SQL
            String AltaPaises = "INSERT INTO paises (nombrePais) VALUES ('Argentina'), ('Uruguay'), "
                    + "('Chile'),('Perú'),('Bolivia'),('Paraguay')";

            // Inicializamos el objeto Statement
            statement = connection.createStatement();
            // Ejecutamos las clausulas SQL
            statement.executeUpdate(AltaPaises);
            System.out.println("Datos cargados correctamente");


        } catch (Exception e) {
            System.out.println(e);
        }finally {
            // Cerrar los recursos
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
