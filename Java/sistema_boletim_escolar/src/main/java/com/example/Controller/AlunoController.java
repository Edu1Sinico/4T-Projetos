package com.example.Controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.Connection.AlunoDAO;
import com.example.Model.Aluno;

public class AlunoController {

    private List<Aluno> alunos;
    private DefaultTableModel tableModel;
    private JTable table;

    public AlunoController(List<Aluno> alunos, DefaultTableModel tableModel, JTable table) {
        this.alunos = alunos;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        alunos = new AlunoDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (Aluno aluno : alunos) {
            // Adiciona os dados de cada aluno como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { aluno.getRa(), aluno.getNome(), aluno.getIdade(),

                    aluno.getCpf(), aluno.getEmail(), aluno.getTurma()});
        }
    }

    // ATUALIZAR OS MÉTODOS DEPOIS

    // Método para cadastrar um novo aluno no banco de dados
    public void cadastrar(String ra, String nome, String idade, String cpf, String email, String senha, String turma) {
        new AlunoDAO().cadastrar(ra, nome, idade, cpf, email, senha, turma);
        // Chama o método de cadastro no banco de dados

        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

    // Método para atualizar os dados de um aluno no banco de dados
    public void atualizar(String ra, String nome, String idade, String cpf, String email, String senha, String turma) {
        new AlunoDAO().atualizar(ra, nome, idade, cpf, email, senha, turma);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um aluno do banco de dados
    public void apagar(String ra) {
        new AlunoDAO().apagar(ra);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }
}
