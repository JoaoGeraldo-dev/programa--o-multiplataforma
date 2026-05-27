package org.example;

import javax.swing.*;
import java.sql.*;

public class FuncionarioDAO {

    public void cadastrar(Funcionario funcionario){

        Connection con = Conexao.conectar();

        String sql =
                "INSERT INTO funcionario(nome, data_nascimento, cod_emp) VALUES (?, ?, ?)";

        try{

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getDataNascimento());
            stmt.setInt(3, funcionario.getCodEmp());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Funcionário cadastrado!");

            stmt.close();
            con.close();

        } catch (SQLException e){

            JOptionPane.showMessageDialog(null,
                    "Erro: " + e.getMessage());
        }
    }

    public void consultar(){

        Connection con = Conexao.conectar();

        String sql = "SELECT * FROM funcionario";

        try{

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            String dados = "";

            while(rs.next()){

                dados +=
                        "\nID: " + rs.getInt("id") +
                                "\nNome: " + rs.getString("nome") +
                                "\nNascimento: " + rs.getString("data_nascimento") +
                                "\nCódigo Empresa: " + rs.getInt("cod_emp") +
                                "\n-----------------------";
            }

            JOptionPane.showMessageDialog(null, dados);

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e){

            JOptionPane.showMessageDialog(null,
                    "Erro: " + e.getMessage());
        }
    }
}