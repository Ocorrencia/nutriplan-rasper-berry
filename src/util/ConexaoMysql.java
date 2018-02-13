/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author diogo.melo
 */
public class ConexaoMysql {

    public static String status = "Não conectou...";

//Método Construtor da Classe//
    public ConexaoMysql() {

    }

//Método de Conexão//
    public static java.sql.Connection getConexaoMySQL() {
        Connection connection = null;          //atributo do tipo Connection
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
           //    String url = "jdbc:mysql://10.1.1.234:3306/nutri_op?zeroDateTimeBehavior=convertToNull";
             String url = "jdbc:mysql://127.0.0.1:3306/nutri_op?zeroDateTimeBehavior=convertToNull";
            String username = "machine";        //nome de um usuário de seu BD      
            String password = "suporte";      //sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);
            //Testa sua conexão//  
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return connection;
        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println(e);
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    public static ResultSet executaQuery(String sql) {
        try {
            Statement stmt = ConexaoMysql.getConexaoMySQL().createStatement();
            return stmt.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String statusConection() {
        return status;
    }

    //Método que fecha sua conexão//
    public static boolean FecharConexao() {
        try {
            ConexaoMysql.getConexaoMySQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return ConexaoMysql.getConexaoMySQL();
    }

}
