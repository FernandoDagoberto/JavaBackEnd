package com.proyecto_final;

// importamos librerias
import java.sql.*;

public class PruebaConexion {

    public static void main(String[] args) {
        // Declaración e inicialización de variables
        String url="jdbc:mysql://localhost:3306/mis_usuarios_24250";
        String usuario="root";
        String pass="root";

        // Declaramos un objeto connection
        Connection conexion= null;

        // Establecemos la conexion dentro de try - catch
        try {
            // Cargar driver JDVC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexion
            conexion=DriverManager.getConnection(url, usuario, pass);
            System.out.println("Conexión exitosa a Workbench");



        } catch(ClassNotFoundException e){
            System.out.println(e);

        }catch(SQLException e){
            System.out.println(e);
        }finally{
           // Cerrar los recursos
           try {
            if (conexion != null) {
                conexion.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error:"+e);
            e.printStackTrace();
        }


        }



    }
}
