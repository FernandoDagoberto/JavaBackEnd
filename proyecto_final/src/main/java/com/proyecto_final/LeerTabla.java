package com.proyecto_final;

// Importamos las librerias
import java.sql.*;

public class LeerTabla {
    public static void main(String[] args) {

        // Información de conexión
        String url = "jdbc:mysql://localhost:3306/mis_usuarios";
        String user = "root";
        String password = "root";

        // Objetos de conexion y ejecución de codigo SQL
        Connection connection = null;
        Statement declaracion = null;
        ResultSet resultado = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexion
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");

            // Creamos una declaracion
            declaracion = connection.createStatement();

            String tabla = "usuarios";
            // Creamos la consulta
            String sqlTabla = "SELECT * FROM " + tabla;

            // Ejecutamos la sentencia
            resultado = declaracion.executeQuery(sqlTabla);

            // Procesamos los resultados mediante un bucle
            while (resultado.next()) {
                // Declaramos variables que nos ayudan con la lectura de la tabla
                int id = resultado.getInt("idUsuario");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String email = resultado.getString("email");
                int fkPais = resultado.getInt("fkPais");

                // Impresion de los datos obtenidos
                System.out.println("ID: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Email: " + email);
                System.out.println("fkPais: " + fkPais);
                System.out.println("--------------------");
            }

        } catch (ClassNotFoundException | SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (resultado != null)
                    resultado.close();
                if (declaracion != null)
                    declaracion.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
                e.printStackTrace();
            }
        }
    }
}
