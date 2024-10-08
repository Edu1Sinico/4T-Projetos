package com.example.View;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import com.example.Model.Aluno;
import com.example.Model.Materia;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class JanelaBoletim extends JFrame {

    // Atributos
    private JButton filtrar, sair;
    private JTextField raField, nomeField, idadeField, cpfField, emailField, senhaField, turmaField;
    private List<Aluno> alunos;
    private List<Materia> materias;
    // MaskFormatter
    private MaskFormatter cpfFormatter, raFormatter, idadeFormatter;

    public JanelaBoletim(Aluno aluno) {
        super("Sistema de Boletim Escolar - Boletim do Aluno");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel headerPanel = new JPanel();
        headerPanel.add(sair = new JButton("Sair"));
        headerPanel.add(new JLabel("Informações do Aluno"));
        mainPanel.add(headerPanel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        // RA - 1
        inputPanel.add(new JLabel("RA"));
        try {
            raFormatter = new MaskFormatter("######");
            raField = new JFormattedTextField(raFormatter);
            raField.setColumns(10);
            raField.setText(aluno.getRa());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        inputPanel.add(raField);
        // Nome - 2
        inputPanel.add(new JLabel("Nome"));
        nomeField = new JTextField(20);
        nomeField.setText(aluno.getNome());
        inputPanel.add(nomeField);
        // Idade - 3
        inputPanel.add(new JLabel("Idade"));
        try {
            idadeFormatter = new MaskFormatter("##");
            idadeField = new JFormattedTextField(idadeFormatter);
            idadeField.setColumns(2);
            idadeField.setText(aluno.getIdade());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        inputPanel.add(idadeField);
        // CPF - 4
        inputPanel.add(new JLabel("CPF"));
        try {
            cpfFormatter = new MaskFormatter("###.###.###-##");
            cpfField = new JFormattedTextField(cpfFormatter);
            cpfField.setColumns(10);
            cpfField.setText(aluno.getCpf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        inputPanel.add(cpfField);
        // Email - 5
        inputPanel.add(new JLabel("Email"));
        emailField = new JTextField(20);
        emailField.setText(aluno.getEmail());
        inputPanel.add(emailField);
        // Turma - 6
        inputPanel.add(new JLabel("Turma"));
        turmaField = new JTextField(20);
        turmaField.setText(aluno.getTurma());
        inputPanel.add(turmaField);

        mainPanel.add(inputPanel);

        add(mainPanel);

        setSize(700, 600);
        // Método para centralizar a tela
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((screenWidth - this.getWidth()) / 2, (screenHeight - this.getHeight()) / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Tratamentos de Eventos

        // Adiciona o event listener para capturar quando a janela é carregada
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                raField.setEditable(false);
                nomeField.setEditable(false);
                cpfField.setEditable(false);
                turmaField.setEditable(false);
                idadeField.setEditable(false);
                emailField.setEditable(false);
            }
        });

        // Sair
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Deseja sair do seu login?",
                        "Sair...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    dispose();
                    new JanelaLogin().run();
                }
            }
        });
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }
}
