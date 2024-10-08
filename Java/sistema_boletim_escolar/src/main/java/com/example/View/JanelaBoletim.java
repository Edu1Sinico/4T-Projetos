package com.example.View;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import com.example.Connection.AlunoDAO;
import com.example.Connection.MateriaDAO;
import com.example.Connection.ProfessorDAO;
import com.example.Model.Aluno;
import com.example.Model.Materia;
import com.example.Model.Professor;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class JanelaBoletim extends JFrame {

    // Atributos
    private JButton filtrar, sair;
    private JTextField raField, nomeField, idadeField, cpfField, emailField, turmaField, filtroField;
    private List<Aluno> alunos;
    private List<Materia> materias;
    private List<Professor> professores;
    private JTable table;
    private DefaultTableModel tableModel;
    private String nomeProfessor;
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

        JPanel botoes = new JPanel();
        filtroField = new JTextField(20);
        botoes.add(filtroField);
        botoes.add(filtrar = new JButton("Filtrar"));
        mainPanel.add(botoes);

        // tabela de notas do aluno
        JScrollPane jSPane = new JScrollPane();
        mainPanel.add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Matéria", "Nota 1", "Nota 2", "Nota 3", "Média",
                        "Professor" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Criar a tabela
        new MateriaDAO().criaTabela();

        // Atualizar a tabela
        atualizarTabela(aluno.getRa());

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

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela(String raAluno) {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        materias = new MateriaDAO().listarTodos();
        // Obtém os materias atualizados do banco de dados
        for (Materia materia : materias) {

            // Verifica se o nome do professor esta na lista
            for (Professor professor : listarProfessores()) {
                if (professor.getCpf().equals(materia.getCpfProfessor())) {
                    nomeProfessor = professor.getNome();
                }
            }

            if (raAluno.equals(materia.getRaAluno())) {
                // Adiciona os dados de cada materia como uma nova linha na tabela Swing
                tableModel.addRow(new Object[] { materia.getNomeMateria(),
                        materia.getNota1(), materia.getNota2(), materia.getNota3(), materia.getMedia(),
                        nomeProfessor
                });
            }

        }
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
