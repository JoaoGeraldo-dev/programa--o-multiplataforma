package org.example;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        EmpresaDAO empresaDAO = new EmpresaDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        int opcao;

        do {

            opcao = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "1 - CADASTRAR EMPRESA\n" +
                                    "2 - CADASTRAR FUNCIONARIO\n" +
                                    "3 - CONSULTAR EMPRESA\n" +
                                    "4 - CONSULTAR FUNCIONARIO\n" +
                                    "5 - SAIR"
                    )
            );

            switch (opcao){

                case 1:

                    Empresa empresa = new Empresa();

                    empresa.setNome(
                            JOptionPane.showInputDialog("Nome da empresa:")
                    );

                    empresa.setQtdFunc(
                            Integer.parseInt(
                                    JOptionPane.showInputDialog(
                                            "Quantidade de funcionários:"
                                    )
                            )
                    );

                    empresa.setLocal(
                            JOptionPane.showInputDialog("Local:")
                    );

                    empresaDAO.Cadastrar(empresa);

                    break;

                case 2:

                    Funcionario funcionario = new Funcionario();

                    funcionario.setNome(
                            JOptionPane.showInputDialog("Nome:")
                    );

                    funcionario.setDataNascimento(
                            JOptionPane.showInputDialog(
                                    "Data nascimento (AAAA-MM-DD):"
                            )
                    );

                    funcionario.setCodEmp(
                            Integer.parseInt(
                                    JOptionPane.showInputDialog(
                                            "Código da empresa:"
                                    )
                            )
                    );

                    funcionarioDAO.cadastrar(funcionario);

                    break;

                case 3:


                    empresaDAO.Consultar();

                    break;

                case 4:


                    funcionarioDAO.consultar();

                    break;

                case 5:

                    JOptionPane.showMessageDialog(null,
                            "Sistema encerrado!");
                    break;

                default:

                    JOptionPane.showMessageDialog(null,
                            "Opção inválida!");
            }

        } while (opcao != 5);
    }
}