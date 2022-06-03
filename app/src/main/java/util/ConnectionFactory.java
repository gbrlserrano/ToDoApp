/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util; /*Pacote criado para linkar o DB com o app.*/
/**
 *
 * @author fgabr
 * 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConnectionFactory {
    
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver"; 
       
    /*o jdbc é uma dependencia responsável pela conexão com o DB. Para rodar essa dependencia precisamos utilizar 
    um gerenciador de dependencias (Gradle) porque tal dependencia não está na biblioteca JAVA.
    
    RVMRepository > copiar o código referente a dependencia que queremos > 
    colar em "dependencies" dentro da pasta Build Scripts */
        
    public static final String URL = "jdbc:mysql://localhost:3306/TodoApp";
    public static final String USER = "root";
    public static final String PASS = "";
    
    /*criação de 3 métodos: 1 para conexão com o DB e duas para fechar essa conexão*/
    public static java.sql.Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Erro na conexão com o Banco de Dados", ex);
        }
    }
    
    public static void closeConnection(Connection connection){
        try {
            if (connection != null){
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados", ex);
        }
    }  
    
     public static void closeConnection(Connection connection, PreparedStatement statement){
         try {
            if (connection != null){
                connection.close();
            }
            
            if (statement != null){
                statement.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados", ex);
        }
    }  
     
      public static void closeConnection(Connection connection, 
              PreparedStatement statement, ResultSet resultSet){
         try {
            if (connection != null){
                connection.close();
            }
            
            if (statement != null){
                statement.close();
            }
            
            if (resultSet != null){
                resultSet.close();
            }
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o Banco de Dados", ex);
        }
    }  
}


