package com.example.Controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.Connection.AlunoDAO;
import com.example.Connection.MateriaDAO;
import com.example.Model.Materia;

public class MateriaController {

    private List<Materia> materias;
    private DefaultTableModel tableModel;
    private JTable table;

    public MateriaController(List<Materia> materias, DefaultTableModel tableModel, JTable table) {
        materias = materias;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        materias = new MateriaDAO().listarTodos();
        // Obtém os materias atualizados do banco de dados
        for (Materia materia : materias) {
            // Adiciona os dados de cada materia como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { materia.getId(), materia.getNomeMateria(),
                    materia.getNota1(), materia.getNota2(), materia.getNota3(), materia.getMedia(),
                    materia.getRaAluno() });
        }
    }

    // ATUALIZAR OS MÉTODOS DEPOIS

    // Método para cadastrar uma nova materia no banco de dados
    public void cadastrar(int id, String nomeMateria, double nota1, double nota2, double nota3, double media,
            String raAluno, String cpfProfessor) {
        new MateriaDAO().cadastrar(id, nomeMateria, nota1, nota2, nota3, media, cpfProfessor, raAluno);
        // Chama o método de cadastro no banco de dados

        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

    // Método para atualizar os dados de um aluno no banco de dados
    public void atualizar(int id, String nomeMateria, double nota1, double nota2, double nota3, double media,
            String raAluno, String cpfProfessor) {
        new MateriaDAO().atualizar(id, nomeMateria, nota1, nota2, nota3, media, cpfProfessor, raAluno);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um aluno do banco de dados
    public void apagar(int id) {
        new MateriaDAO().apagar(id);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }

}
