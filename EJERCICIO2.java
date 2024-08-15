/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class EJERCICIO2 {

    public static void main(String[] args) throws SQLException{
        String usuario="root";
        String password="";
        String url="jdbc:mysql://localhost/ejercicio";
        
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM `usuario`");
            while(rs.next()){
                System.out.println(rs.getString("Nombres"));
            }
            // insercion de datos
            statement.execute("INSERT INTO `usuario` (`id`, `Documento`, `Nombres`) VALUES (NULL, '1075657614', 'john triviño');");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM 'usuario'");
            while(rs.next()){
                System.out.println(rs.getString("Nombres"));
            } 
            //actualizacion de datos 
            statement.execute("UPDATE `usuario` SET `id` = '3' WHERE `usuario`.`id` = 4;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM 'usuario'");
            while(rs.next()){
                System.out.println(rs.getString("Nombres"));
            }    
            // eliminacion de datos
            
            statement.execute("DELETE FROM usuario WHERE `usuario`.`id` = 4");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM 'usuario'");
            while(rs.next()){
                System.out.println(rs.getString("Nombres"));
            }    
        } catch (SQLException ex) {
            Logger.getLogger(EJERCICIO2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
