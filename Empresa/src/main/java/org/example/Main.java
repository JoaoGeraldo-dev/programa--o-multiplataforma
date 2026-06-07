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
                                    "5 - ALTERAR EMPRESA\n" +
                                    "6 - ALTERAR FUNCIONARIO\n" +
                                    "7 - EXCLUIR EMPRESA\n" +
                                    "8 - EXCLUIR FUNCIONARIO\n" +
                                    "9 - SAIR"
                    )
            );

            switch (opcao) {

                case 1:
                    Empresa empresa = new Empresa();
                    empresa.setNome(JOptionPane.showInputDialog("Nome da empresa:"));
                    empresa.setQtdFunc(Integer.parseInt(
                            JOptionPane.showInputDialog("Quantidade de funcionários:")
                    ));
                    empresa.setLocal(JOptionPane.showInputDialog("Local:"));
                    empresaDAO.Cadastrar(empresa);
                    break;

                case 2:
                    Funcionario funcionario = new Funcionario();
                    funcionario.setNome(JOptionPane.showInputDialog("Nome:"));
                    funcionario.setDataNascimento(
                            JOptionPane.showInputDialog("Data nascimento (AAAA-MM-DD):")
                    );
                    funcionario.setCodEmp(Integer.parseInt(
                            JOptionPane.showInputDialog("Código da empresa:")
                    ));
                    funcionarioDAO.cadastrar(funcionario);
                    break;

                case 3:
                    empresaDAO.Consultar();
                    break;

                case 4:
                    funcionarioDAO.consultar();
                    break;

                case 5:
                    empresaDAO.Consultar();
                    int idAlt = Integer.parseInt(
                            JOptionPane.showInputDialog("ID da empresa a alterar:")
                    );
                    Empresa empAlt = new Empresa();
                    empAlt.setId(idAlt);
                    empAlt.setNome(JOptionPane.showInputDialog("Novo nome:"));
                    empAlt.setQtdFunc(Integer.parseInt(
                            JOptionPane.showInputDialog("Nova quantidade de funcionários:")
                    ));
                    empAlt.setLocal(JOptionPane.showInputDialog("Novo local:"));
                    empresaDAO.Alterar(empAlt);
                    break;

                case 6:
                    funcionarioDAO.consultar();
                    int idFuncAlt = Integer.parseInt(
                            JOptionPane.showInputDialog("ID do funcionário a alterar:")
                    );
                    Funcionario funcAlt = new Funcionario();
                    funcAlt.setId(idFuncAlt);
                    funcAlt.setNome(JOptionPane.showInputDialog("Novo nome:"));
                    funcAlt.setDataNascimento(
                            JOptionPane.showInputDialog("Nova data de nascimento (AAAA-MM-DD):")
                    );
                    funcAlt.setCodEmp(Integer.parseInt(
                            JOptionPane.showInputDialog("Código da empresa:")
                    ));
                    funcionarioDAO.alterar(funcAlt);
                    break;

                case 7:
                    empresaDAO.Consultar();
                    int idExcEmp = Integer.parseInt(
                            JOptionPane.showInputDialog("ID da empresa a excluir:")
                    );
                    empresaDAO.Excluir(idExcEmp);
                    break;

                case 8:
                    funcionarioDAO.consultar();
                    int idExcFunc = Integer.parseInt(
                            JOptionPane.showInputDialog("ID do funcionário a excluir:")
                    );
                    funcionarioDAO.excluir(idExcFunc);
                    break;

                case 9:
                    JOptionPane.showMessageDialog(null, "Sistema encerrado!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 9);
    }
}