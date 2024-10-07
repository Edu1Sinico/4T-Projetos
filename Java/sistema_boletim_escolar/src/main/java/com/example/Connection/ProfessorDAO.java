package com.example.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.example.Connection.ConnectionFactory;

import com.example.Model.Professor;

/**
 * CarrosDAO
 */
public class ProfessorDAO {
    // atributo
    private Connection connection;
    private List<Professor> professores;

    // construtor
    public ProfessorDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS professor (NOME VARCHAR(255), IDADE VARCHAR(2), CPF VARCHAR(14) PRIMARY KEY, EMAIL VARCHAR(255), SENHA VARCHAR(255), ESPECIALIZACAO VARCHAR(255))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela Professor criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os valores cadastrados
    public List<Professor> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        professores = new ArrayList<>();
        // Cria uma lista para armazenar os carros recuperados do banco de dados
        try {
            String sql = "SELECT * FROM professor";
            stmt = connection.prepareStatement(sql);

            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Professor com os valores do
                // registro

                Professor professor = new Professor(
                        rs.getString("nome"),
                        rs.getString("idade"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("especializacao"));
                professores.add(professor); // Adiciona o objeto Professor na lista de professores
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return professores; // Retorna a lista de professores recuperados do banco de dados
    }

    // Cadastrar Carro no banco
    public void cadastrar(String nome, String idade, String cpf, String email, String senha, String especializacao) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO professor (nome, idade, cpf, email, senha, especializacao) VALUES ( ?, ?, ?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, idade);
            stmt.setString(3, cpf);
            stmt.setString(4, email);
            stmt.setString(5, senha);
            stmt.setString(6, especializacao);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Atualizar dados no banco
    public void atualizar(String nome, String idade, String cpf, String email, String senha, String especializacao) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para atualizar dados pela placa
        String sql = "UPDATE professor SET nome = ?, idade = ?, email = ?, senha = ?, especializacao = ? WHERE cpf = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, idade);
            stmt.setString(3, email);
            stmt.setString(4, senha);
            stmt.setString(5, especializacao);
            // cpf é chave primaria não pode ser alterada.
            stmt.setString(6, cpf);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apagar dados do banco
    public void apagar(String cpf) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pela placa
        String sql = "DELETE FROM professor WHERE cpf = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
}