package org.example;

import javax.swing.*;
import java.sql.*;

public class FuncionarioDAO {

    public void cadastrar(Funcionario funcionario) {

        Connection con = Conexao.conectar();

        String sql = "INSERT INTO funcionario(nome, data_nascimento, cod_emp) VALUES (?, ?, ?)";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getDataNascimento());
            stmt.setInt(3, funcionario.getCodEmp());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Funcionário cadastrado!");

            stmt.close();
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    public void consultar() {

        Connection con = Conexao.conectar();

        String sql = "SELECT * FROM funcionario";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            StringBuilder dados = new StringBuilder();

            while (rs.next()) {
                dados.append("\nID: ").append(rs.getInt("id"))
                        .append("\nNome: ").append(rs.getString("nome"))
                        .append("\nNascimento: ").append(rs.getString("data_nascimento"))
                        .append("\nCódigo Empresa: ").append(rs.getInt("cod_emp"))
                        .append("\n-----------------------");
            }

            if (dados.length() > 0) {
                JOptionPane.showMessageDialog(null, dados.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum funcionário cadastrado!");
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    public void alterar(Funcionario funcionario) {

        String sql = "UPDATE funcionario SET nome = ?, data_nascimento = ?, cod_emp = ? WHERE id = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getDataNascimento());
            stmt.setInt(3, funcionario.getCodEmp());
            stmt.setInt(4, funcionario.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Funcionário alterado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }

    public void excluir(int id) {

        String sql = "DELETE FROM funcionario WHERE id = ?";

        try (Connection con = Conexao.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
}