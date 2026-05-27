package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection conectar(){

        Connection con = null;

        try {

            String url = "jdbc:mysql://localhost:3306/empresa_db";
            String user = "root";
            String password = "";

            con = DriverManager.getConnection(url, user, password);

            System.out.println("Conexão realizada com sucesso!");

        } catch (SQLException e){

            System.out.println("Erro na conexão: " + e.getMessage());
        }

        return con;
    }
}