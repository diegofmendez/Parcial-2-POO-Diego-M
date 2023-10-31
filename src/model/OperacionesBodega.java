package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class OperacionesBodega {
    
    final String tabla = "juguetes";
    
    //Registro de usuario
    public void registrar(Connection conexion, String JUGUETE, String MARCA, int BODEGA){
        MYSQLWork.getConnection();
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO "+ this.tabla +" (JUGUETE, MARCA, BODEGA) VALUES (?,?,?)");
            
            consulta.setString(1, JUGUETE);
            consulta.setString(2, MARCA);
            consulta.setInt(3,BODEGA);

            consulta.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error en el registro: " + e.getMessage());
             // Mensaje de error
        } 
    }
    
    //Verifica que este en la base de datos
    public boolean revisar(Connection conexion, String JUGUETE){
        Boolean check = false;
        try {
            MYSQLWork.getConnection();
            PreparedStatement consulta;
            
            consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla + " WHERE JUGUETE='"+JUGUETE+"'");

            ResultSet result = consulta.executeQuery();

            while (result.next()) {

                String columnValue = result.getString("JUGUETE");
                if (columnValue.equals(JUGUETE)){
                    check=true;
                }  
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return check;
    }

}
    


    
