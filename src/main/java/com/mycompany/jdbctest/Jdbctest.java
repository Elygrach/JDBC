package com.mycompany.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jdbctest {

    public static void main(String[] args) {
        String usuario="root";
        String password="";
        String url="jdbc:mysql://localhost:3306/jdbctest";
        
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT*FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //INSERCION DE DATOS
            statement.execute("INSERT INTO `usuarios` (`ID`, `nombre`) VALUES (NULL, 'Miriam');");
             System.out.println("");
            rs = statement.executeQuery("SELECT*FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //ACTUALIZACIÓN DE DATOS
            statement.execute("UPDATE `usuarios` SET `nombre` = 'Luz Ana' WHERE `usuarios`.`ID` = 2;");
             System.out.println("");
            rs = statement.executeQuery("SELECT*FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
            //ELIMINACION DE DATOS
            statement.execute("DELETE FROM usuarios WHERE `usuarios`.`ID` = 3");
             System.out.println("");
            rs = statement.executeQuery("SELECT*FROM usuarios");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Jdbctest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
