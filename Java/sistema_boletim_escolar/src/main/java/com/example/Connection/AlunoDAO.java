package com.example.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.Model.Aluno;

public class AlunoDAO {
    // atributo
    private Connection connection;
    private List<Aluno> alunos;

    // construtor
    public AlunoDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS aluno (RA VARCHAR (6) PRIMARY KEY, NOME VARCHAR(255), IDADE VARCHAR(2), CPF VARCHAR(14), EMAIL VARCHAR(255), SENHA VARCHAR(255), TURMA VARCHAR(255))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela Alunos criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os valores cadastrados
    public List<Aluno> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        alunos = new ArrayList<>();
        // Cria uma lista para armazenar os clientes recuperados do banco de dados
        try {
            String sql = "SELECT * FROM aluno";
            stmt = connection.prepareStatement(sql);

            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto alunos com os valores do
                // registro

                Aluno aluno = new Aluno(
                        rs.getString("ra"),
                        rs.getString("nome"),
                        rs.getString("idade"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("turma"));
                alunos.add(aluno); // Adiciona o objeto Aluno na lista de alunos
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return alunos; // Retorna a lista de alunos recuperados do banco de dados
    }

    // Cadastrar Carro no banco
    public void cadastrar(String ra, String nome, String idade, String cpf, String email, String senha, String turma) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO aluno (ra, nome, idade, cpf, email, senha, turma) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, ra);
            stmt.setString(2, nome);
            stmt.setString(3, idade);
            stmt.setString(4, cpf);
            stmt.setString(5, email);
            stmt.setString(6, senha);
            stmt.setString(7, turma);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Atualizar dados no banco
    public void atualizar(String ra, String nome, String idade, String cpf, String email, String senha, String turma) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para atualizar dados pelo ra
        String sql = "UPDATE aluno SET nome = ?, idade = ?, cpf = ?, email = ?, senha = ?, turma = ? WHERE ra = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, idade);
            stmt.setString(3, cpf);
            stmt.setString(4, email);
            stmt.setString(5, senha);
            stmt.setString(6, turma);
            // RA é chave primaria não pode ser alterada.
            stmt.setString(7, ra);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apagar dados do banco
    public void apagar(String ra) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pelo ra
        String sql = "DELETE FROM aluno WHERE ra = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, ra);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}
