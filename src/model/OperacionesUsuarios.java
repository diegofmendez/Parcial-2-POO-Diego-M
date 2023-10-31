package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class OperacionesUsuarios {
    
    final String tabla = "usuario";
    
    //Registro de usuario
    public void registrar(Connection conexion, String USUARIO, String NOMBRE, String CONTRASENA){
        MYSQLWork.getConnection();
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO "+ this.tabla +" (USUARIO, NOMBRE, CONTRASENA) VALUES (?,?,?)");
            
            consulta.setString(1, USUARIO);
            consulta.setString(2, NOMBRE);
            consulta.setString(3, CONTRASENA);

            consulta.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error en el registro: " + e.getMessage());
             // Mensaje de error
        } 
    }
    
    //Verifica que este en la base de datos
    public boolean revisar(Connection conexion, String USUARIO){
        Boolean check = false;
        try {
            MYSQLWork.getConnection();
            PreparedStatement consulta;
            
            consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla + " WHERE USUARIO ='"+USUARIO+"'");

            ResultSet result = consulta.executeQuery();

            while (result.next()) {

                String columnValue = result.getString("USUARIO");
                if (columnValue.equals(USUARIO)){
                    check=true;
                }  
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }
    
    //Verific
    public boolean verificar(Connection conexion, String USUARIO, String CONTRASENA){
        Boolean check = false;
        try {
            MYSQLWork.getConnection();
            PreparedStatement consulta;
            
            consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla + " WHERE USUARIO ='"+USUARIO+"'");

            ResultSet result = consulta.executeQuery();

            while (result.next()) {

                String columnUsuario = result.getString("USUARIO");
                String columnContrasena = result.getString("CONTRASENA");
                if (columnUsuario.equals(USUARIO) && columnContrasena.equals(CONTRASENA)){
                    check=true;
                }  
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }
    

}
    


    
