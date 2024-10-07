package com.example.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.Model.Materia;

public class MateriaDAO {
    // atributo
    private Connection connection;
    private List<Materia> materias;

    // construtor
    public MateriaDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS materia (ID INTEGER PRIMARY KEY, NOME-MATERIA VARCHAR(255), NOTA1 DECIMAL, NOTA2 DECIMAL, NOTA3 DECIMAL, MEDIA DECIMAL,"
                + "CONSTRAINT fk_professor FOREIGN KEY (cpfProfessor) REFERENCES professores(cpf),"
                + "CONSTRAINT fk_aluno FOREIGN KEY (raAluno) REFERENCES alunos(ra))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de Materias criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os valores cadastrados
    public List<Materia> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        materias = new ArrayList<>();
        // Cria uma lista para armazenar as vendas recuperados do banco de dados
        try {
            String sql = "SELECT * FROM materia";
            stmt = connection.prepareStatement(sql);

            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto materia com os valores do
                // registro

                Materia materia = new Materia(
                        rs.getInt("id"),
                        rs.getString("nomeMateria"),
                        rs.getDouble("nota1"),
                        rs.getDouble("nota2"),
                        rs.getDouble("nota3"),
                        rs.getDouble("media"),
                        rs.getString("cpfProfessor"),
                        rs.getString("raAluno"));
                materias.add(materia); // Adiciona o objeto Materia na lista de materias
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return materias; // Retorna a lista de materias recuperados do banco de dados
    }

    // Cadastrar Carro no banco
    public void cadastrar(int id, String nome, double nota1, double nota2, double nota3, double media, String cpfProfessor, String raAluno) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO materia (id, nome-materia, nota1, nota2, nota3, media, cpfProfessor, raAluno) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, nome);
            stmt.setDouble(3, nota1);
            stmt.setDouble(4, nota2);
            stmt.setDouble(5, nota3);
            stmt.setDouble(6, media);
            stmt.setString(7,cpfProfessor);
            stmt.setString(8,raAluno);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}
