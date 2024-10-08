package com.example.View;

import javax.swing.*;

import com.example.Connection.AlunoDAO;
import com.example.Connection.ProfessorDAO;
import com.example.Model.Aluno;
import com.example.Model.Professor;

import java.util.List;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaLogin extends JFrame {
    private JButton login, sair;
    private JTextField emailField, senhaField;
    private List<Aluno> alunos;
    private List<Professor> professores;
    private boolean loginConfirmado = false;

    public JanelaLogin() {
        super("Sistema de Boletim Escolar - Login");

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 1));

        // Campo do título
        JPanel tituloPanel = new JPanel();
        tituloPanel.setLayout(new FlowLayout());
        tituloPanel.add(new JLabel("Tela de Login"));
        inputPanel.add(tituloPanel);

        // Campo do Email
        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new FlowLayout());
        emailPanel.add(new JLabel("Email:"));
        emailField = new JTextField(20);
        emailPanel.add(emailField);
        inputPanel.add(emailPanel);

        // Campo da senha
        JPanel senhaPanel = new JPanel();
        senhaPanel.setLayout(new FlowLayout());
        senhaPanel.add(new JLabel("Senha:"));
        senhaField = new JPasswordField(20);
        senhaPanel.add(senhaField);
        inputPanel.add(senhaPanel);

        // Campo do botão
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(login = new JButton("Login"));
        buttonPanel.add(sair = new JButton("Sair"));
        inputPanel.add(buttonPanel);

        mainPanel.add(inputPanel);

        // Adiciona o painel principal ao JFrame
        add(mainPanel);

        setSize(300, 200);
        // Método para centralizar a tela
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((screenWidth - this.getWidth()) / 2, (screenHeight - this.getHeight()) / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Tratamento de eventos;
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (!(emailField.getText().isEmpty() || senhaField.getText().isEmpty())) {

                        // Usuário Aluno
                        for (Aluno aluno : listarAlunos()) {
                            if (aluno.getEmail().equals(emailField.getText())
                                    && aluno.getSenha().equals(senhaField.getText())) {
                                JOptionPane.showMessageDialog(null, "Bem-vindo, " + aluno.getNome() + "!", "Bem-vindo!",
                                        JOptionPane.INFORMATION_MESSAGE);
                                dispose();
                                new JanelaBoletim(aluno).run();
                                loginConfirmado = true;
                            }
                        }
                        // Usuário Professor
                        for (Professor professor : listarProfessores()) {
                            if (professor.getEmail().equals(emailField.getText())
                                    && professor.getSenha().equals(senhaField.getText())) {
                                JOptionPane.showMessageDialog(null, "Bem-vindo, " + professor.getNome() + "!",
                                        "Bem-vindo!",
                                        JOptionPane.INFORMATION_MESSAGE);
                                dispose();
                                new JanelaAvaliacao(professor).run();
                                loginConfirmado = true;
                            }
                        }

                        // Usuário Admin
                        if (emailField.getText().equals("admin@email.com") && senhaField.getText().equals("admin123")) {
                            JOptionPane.showMessageDialog(null, "Bem-vindo Admin!", "Bem-vindo!",
                                    JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                            new JanelaPrincipal().run();
                        } else if (loginConfirmado) {
                            loginConfirmado = false;
                        } else {
                            // Criar uma Exception para esta mensagem
                            JOptionPane.showMessageDialog(null,
                                    "Credenciais inválidas. Verifique o campo de email e senha.",
                                    "LoginValidationException",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        throw new NullPointerException(
                                "Informações inválidas. Por favor preencha as informações vazias.");
                    }
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "NullPointerException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Formatação inválida, por favor digite somente números válidos.", "NumberFormatException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro.", "Exception",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Botão de sair
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Deseja sair do programa?",
                        "Sair...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Obrigado por utilizar o meu programa!",
                            "Agradecimentos",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
        });
    }

    // Métodos de listagem de alunos
    public List<Aluno> listarAlunos() {
        return alunos = new AlunoDAO().listarTodos();
    }

    // Métodos de listagem de professores
    public List<Professor> listarProfessores() {
        return professores = new ProfessorDAO().listarTodos();
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }
}
