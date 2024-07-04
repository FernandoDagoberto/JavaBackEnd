package com.proyecto_final;

// Importacion de librerias
import java.sql.*;

public class CrearBDyTabla {
    public static void main(String[] args) {

        // Declaración e inicialización de variables
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "root";

        // Declaramos objetos que nos ayudan con la conexion y sentencias
        // SQLClientInfoException
        Connection connection = null;
        Statement statement = null;

        try {
            // Este bloque de código contiene lo que queremos hacer
            // Cargar driver JDVC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexion
            connection = DriverManager.getConnection(url, user, password);
            // Inicializamos el objeto Statement
            statement = connection.createStatement();

            // Creamos la base de datos si no existe
            String sql = "CREATE DATABASE IF NOT EXISTS mis_usuarios";
            // Ejecutamos la sentencia
            statement.executeUpdate(sql);
            // Aviso que todo fue ok
            System.out.println("La DB mis_usuarios fue creada o ya existe");

            // Nos conectamos a la DB
            // Establecer la conexion
            connection = DriverManager.getConnection(url + "mis_usuarios", user, password);
            // Inicializamos el objeto Statement
            statement = connection.createStatement();

            // Creamos la tabla países, SI NO EXISTE
            // Clausula SQL
            String createPaises = "CREATE TABLE IF NOT EXISTS paises ("
                    + "`idPais` int AUTO_INCREMENT PRIMARY KEY,"
                    + "`nombrePais` varchar(150) NOT NULL"
                    + ")";

            // Ejecutamos la clausula SQL createPaises
            statement.executeUpdate(createPaises);
            // Aviso de la tabla creada
            System.out.println("Tabla Países creada o existente");

            // Creamos la segunda tabla Usuarios (SI NO EXISTE)
            String createUsuarios = "CREATE TABLE IF NOT EXISTS usuarios ("
                    + "idUsuario INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombre VARCHAR(255) NOT NULL, "
                    + "apellido VARCHAR(255) NOT NULL, "
                    + "email VARCHAR(100) NOT NULL, "
                    + "fkPais INT, "
                    + "FOREIGN KEY (fkPais) REFERENCES paises(idPais)"
                    + ")";

            // Ejecutamos la clausula SQL createPaises
            statement.executeUpdate(createUsuarios);
            // Aviso de la tabla creada
            System.out.println("Tabla Usuarios creada o existente");

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            // Cerrar los recursos
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
