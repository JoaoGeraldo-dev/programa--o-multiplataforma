package org.example;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaDAO {

    public void Cadastrar(Empresa empresa){

        Connection con = Conexao.conectar();

        String sql = "INSERT INTO empresa(nome,qtd_func,local) values (?,?,?)";

        try{

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, empresa.getNome());
            stmt.setInt(2, empresa.getQtdFunc());
            stmt.setString(3, empresa.getLocal());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null,
                    "Empresa cadastrada com sucesso!");

            stmt.close();
            con.close();

        } catch (SQLException e){

            JOptionPane.showMessageDialog(null,
                    "Erro:" + e.getMessage());
        }
    }

    public void Consultar() {

        Connection con = Conexao.conectar();

        String sql = "SELECT * FROM empresa";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            StringBuilder res = new StringBuilder();

            while (rs.next()) {

                res.append(
                                "ID: ").append(rs.getInt("id"))
                        .append("\nNome: ").append(rs.getString("nome"))
                        .append("\nQuantidade Funcionários: ")
                        .append(rs.getInt("qtd_func"))
                        .append("\nLocal: ").append(rs.getString("local"))
                        .append("\n----------------------\n");
            }

            if (res.length() > 0) {

                JOptionPane.showMessageDialog(null, res.toString());

            } else {

                JOptionPane.showMessageDialog(null,
                        "Nenhuma empresa cadastrada!");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,
                    "Erro: " + e.getMessage());
        }
    }
    }
