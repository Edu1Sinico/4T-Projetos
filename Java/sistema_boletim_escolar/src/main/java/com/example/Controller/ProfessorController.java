package com.example.Controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.Connection.ProfessorDAO;
import com.example.Model.Professor;

/**
 * professoresController
 */
public class ProfessorController {
    // Atributos
    private List<Professor> professores;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public ProfessorController(List<Professor> professores, DefaultTableModel tableModel, JTable table) {
        this.professores = professores;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        professores = new ProfessorDAO().listarTodos();
        // Obtém os professores atualizados do banco de dados
        for (Professor professor : professores) {
            // Adiciona os dados de cada professor como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { professor.getNome(), professor.getIdade(),
                    professor.getCpf(), professor.getEmail(), professor.getEspecializacao() });
        }
    }

    // ATUALIZAR OS MÉTODOS DEPOIS

    // Método para cadastrar um novo professor no banco de dados
    public void cadastrar(String nome, String idade, String cpf, String email, String senha, String especializacao) {
        new ProfessorDAO().cadastrar(nome, idade, cpf, email, senha, especializacao);
        // Chama o método de cadastro no banco de dados

        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

    // Método para atualizar os dados de um professor no banco de dados
    public void atualizar(String nome, String idade, String cpf, String email, String senha, String especializacao) {
        new ProfessorDAO().atualizar(nome, idade, cpf, email, senha, especializacao);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um professor do banco de dados
    public void apagar(String cpf) {
        new ProfessorDAO().apagar(cpf);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }
}