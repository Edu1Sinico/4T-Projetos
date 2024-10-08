package com.example.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.example.Connection.AlunoDAO;
import com.example.Connection.MateriaDAO;
import com.example.Connection.ProfessorDAO;
import com.example.Controller.AlunoController;
import com.example.Controller.MateriaController;
import com.example.Exception.CpfValidiationException;
import com.example.Exception.RaValidiationException;
import com.example.Exception.SelectedTableException;
import com.example.Model.Aluno;
import com.example.Model.Materia;
import com.example.Model.Professor;

import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

public class JanelaAvaliacao extends JFrame {

    private JButton aplicar, apagar, editar, limpar, sair;
    private JTextField idField, nomeMateriaField, nota1Field, nota2Field, nota3Field, raAlunoField;
    private List<Aluno> alunos;
    private List<Professor> professores;
    private List<Materia> materias;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;
    private int id = 0;
    private String nomeAluno;
    private String nomeProfessor;
    // MaskFormatter
    private MaskFormatter raFormatter, doubleFormatter;

    public JanelaAvaliacao(Professor professor) {
        super("Sistema de Boletim Escolar - Avaliar Aluno");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JPanel headerPanel = new JPanel();
        headerPanel.add(sair = new JButton("Sair"));
        headerPanel.add(new JLabel("Avaliar o Aluno"));
        mainPanel.add(headerPanel);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        // ID - 1
        inputPanel.add(new JLabel("ID"));
        idField = new JTextField(20);
        idField.setText(Integer.toString(MateriasID()));
        inputPanel.add(idField);
        // Nome da Matéria - 2
        inputPanel.add(new JLabel("Nome da Matéria"));
        nomeMateriaField = new JTextField(20);
        nomeMateriaField.setText(professor.getEspecializacao());
        inputPanel.add(nomeMateriaField);
        // RA do Aluno - 3
        inputPanel.add(new JLabel("RA do Aluno"));
        try {
            raFormatter = new MaskFormatter("######");
            raAlunoField = new JFormattedTextField(raFormatter);
            raAlunoField.setColumns(10);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        inputPanel.add(raAlunoField);
        // Nota 1 - 4
        inputPanel.add(new JLabel("Nota 1"));
        nota1Field = new JTextField(4);
        inputPanel.add(nota1Field);
        // Nota 2 - 5
        inputPanel.add(new JLabel("Nota 2"));
        nota2Field = new JTextField(4);
        inputPanel.add(nota2Field);
        // Nota 3 - 6
        inputPanel.add(new JLabel("Nota 3"));
        nota3Field = new JTextField(4);
        inputPanel.add(nota3Field);

        mainPanel.add(inputPanel);

        // Botões
        JPanel botoes = new JPanel();
        botoes.add(aplicar = new JButton("Aplicar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        botoes.add(limpar = new JButton("Limpar"));
        mainPanel.add(botoes);

        // tabela de notas
        JScrollPane jSPane = new JScrollPane();
        mainPanel.add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "ID", "Nome do Aluno", "Matéria", "Nota 1", "Nota 2", "Nota 3", "Média",
                        "Professor" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Criar a tabela
        new MateriaDAO().criaTabela();

        // Atualizar a tabela
        atualizarTabela();

        add(mainPanel);
        setSize(700, 600);
        // Método para centralizar a tela
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((screenWidth - this.getWidth()) / 2, (screenHeight - this.getHeight()) / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Tratamento de eventos;

        // Adiciona o event listener para capturar quando a janela é carregada
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                nomeMateriaField.setEditable(false);
                idField.setEditable(false);
            }
        });

        // selecionar os elementos nas linhas da tabela
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (professor.getEspecializacao().equals(((String) table.getValueAt(linhaSelecionada, 2)))) {
                    if (linhaSelecionada != -1) {
                        for (Aluno aluno : listarAlunos()) {
                            if (aluno.getNome().equals((String) table.getValueAt(linhaSelecionada, 1))) {
                                raAlunoField.setText(aluno.getRa());
                            }
                        }
                        idField.setText(String.valueOf(table.getValueAt(linhaSelecionada, 0)));
                        nota1Field.setText(String.valueOf(table.getValueAt(linhaSelecionada, 3)));
                        nota2Field.setText(String.valueOf(table.getValueAt(linhaSelecionada, 4)));
                        nota3Field.setText(String.valueOf(table.getValueAt(linhaSelecionada, 5)));
                        // Desativa o textfield da cpf
                        idField.setEditable(false);
                        // Desativa o botão
                        aplicar.setEnabled(false);
                    } else {
                        // Ativa o botão
                        aplicar.setEnabled(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma matéria da sua especialidade.",
                            "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        listarAlunos();
        MateriaController operacoes = new MateriaController(materias, tableModel, table);

        // aplicar
        aplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método "aplicar" do objeto operacoes com os valores dos
                // campos de entrada
                try {
                    if (!(idField.getText().isEmpty() || nomeMateriaField.getText().isEmpty()
                            || nota1Field.getText().isEmpty()
                            || nota2Field.getText().isEmpty()
                            || nota3Field.getText().isEmpty() || raAlunoField.getText().isEmpty())) {
                        boolean raValido = false; // Variável para marcar se o RA foi encontrado

                        for (Aluno aluno : listarAlunos()) {
                            if (aluno.getRa().equals(raAlunoField.getText())) {
                                raValido = true;
                                break; // RA encontrado, sai do loop
                            }
                        }

                        if (!raValido) { // Se o RA não foi encontrado, lança a exceção
                            throw new RaValidiationException(
                                    "RA não encontrado, por favor verifique novamente o RA do aluno.");
                        }

                        // Método para calcular a média
                        double media = calcMedia(Double.parseDouble(nota1Field.getText()),
                                Double.parseDouble(nota2Field.getText()), Double.parseDouble(nota3Field.getText()));

                        operacoes.cadastrar(Integer.parseInt(idField.getText()), nomeMateriaField.getText(),
                                Double.parseDouble(nota1Field.getText()), Double.parseDouble(nota2Field.getText()),
                                Double.parseDouble(nota3Field.getText()), media, raAlunoField.getText(),
                                professor.getCpf());

                        // Limpa os campos de entrada após a operação de cadastro
                        idField.setText(Integer.toString(MateriasID()));
                        raAlunoField.setText("");
                        nota1Field.setText("");
                        nota2Field.setText("");
                        nota3Field.setText("");
                        atualizarTabela();

                    } else {
                        throw new NullPointerException(
                                "Informações inválidas. Por favor preencha as informações vazias.");
                    }
                } catch (RaValidiationException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "RaValidationException",
                            JOptionPane.WARNING_MESSAGE);
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

        // Configura a ação do botão "editar" para atualizar um registro no banco de
        // dados
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método "atualizar" do objeto operacoes com os valores dos

                // campos de entrada
                try {
                    if (linhaSelecionada != -1) {
                        if (!(idField.getText().isEmpty() || nomeMateriaField.getText().isEmpty()
                                || nota1Field.getText().isEmpty()
                                || nota2Field.getText().isEmpty()
                                || nota3Field.getText().isEmpty() || raAlunoField.getText().isEmpty())) {
                            boolean raValido = false; // Variável para marcar se o RA foi encontrado

                            for (Aluno aluno : listarAlunos()) {
                                if (aluno.getRa().equals(raAlunoField.getText())) {
                                    raValido = true;
                                    break; // RA encontrado, sai do loop
                                }
                            }

                            if (!raValido) { // Se o RA não foi encontrado, lança a exceção
                                throw new RaValidiationException(
                                        "RA não encontrado, por favor verifique novamente o RA do aluno.");
                            }

                            // Método para calcular a média
                            double media = calcMedia(Double.parseDouble(nota1Field.getText()),
                                    Double.parseDouble(nota2Field.getText()), Double.parseDouble(nota3Field.getText()));
                            operacoes.atualizar(Integer.parseInt(idField.getText()),
                                    nomeMateriaField.getText(),
                                    Double.parseDouble(nota1Field.getText()),
                                    Double.parseDouble(nota2Field.getText()),
                                    Double.parseDouble(nota3Field.getText()), media,
                                    professor.getCpf(), raAlunoField.getText());

                            // Limpa os campos de entrada após a operação de atualização
                            // Limpa os campos de entrada após a operação de cadastro
                            idField.setText(Integer.toString(MateriasID()));
                            raAlunoField.setText("");
                            nota1Field.setText("");
                            nota2Field.setText("");
                            nota3Field.setText("");
                            atualizarTabela();

                        } else {
                            throw new NullPointerException(
                                    "Informações inválidas. Por favor preencha as informações vazias.");
                        }
                    } else {
                        throw new SelectedTableException("Erro de Seleção, por favor selecione uma linha.");
                    }
                } catch (RaValidiationException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "RaValidationException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (SelectedTableException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "SelectedTableException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "NullPointerException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "NumberFormatException",
                            JOptionPane.WARNING_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro.", "Exception",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Configura a ação do botão "apagar" para excluir um registro no banco de dados
        apagar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método "apagar" do objeto operacoes com o valor do campo de

                // entrada "ra"
                try {
                    if (linhaSelecionada != -1) {
                        if (JOptionPane.showConfirmDialog(null, "Deseja excluir esse cadastro?",
                                "Excluindo Tarefa...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            operacoes.apagar(Integer.parseInt(idField.getText()));
                            // // Limpa os campos de entrada após a operação de exclusão
                            idField.setText(Integer.toString(MateriasID()));
                            raAlunoField.setText("");
                            nota1Field.setText("");
                            nota2Field.setText("");
                            nota3Field.setText("");
                            atualizarTabela();
                        }
                    } else {
                        throw new SelectedTableException("Erro de Seleção, por favor selecione uma linha.");
                    }
                } catch (SelectedTableException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "SelectedTableException",
                            JOptionPane.WARNING_MESSAGE);
                }
            }

        });

        // Limpar campos
        limpar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                idField.setText(Integer.toString(MateriasID()));
                raAlunoField.setText("");
                nota1Field.setText("");
                nota2Field.setText("");
                nota3Field.setText("");
                table.clearSelection();
            }
        });

    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        materias = new MateriaDAO().listarTodos();
        // Obtém os materias atualizados do banco de dados
        for (Materia materia : materias) {
            // Verifica se o nome do aluno esta na lista
            for (Aluno aluno : listarAlunos()) {
                if (aluno.getRa().equals(materia.getRaAluno())) {
                    nomeAluno = aluno.getNome();
                }
            }

            // Verifica se o nome do professor esta na lista
            for (Professor professor : listarProfessores()) {
                if (professor.getCpf().equals(materia.getCpfProfessor())) {
                    nomeProfessor = professor.getNome();
                }
            }
            // Adiciona os dados de cada materia como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { materia.getId(), nomeAluno, materia.getNomeMateria(),
                    materia.getNota1(), materia.getNota2(), materia.getNota3(), materia.getMedia(), nomeProfessor,
            });
        }

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

    // Métodos de alterar o ID
    public int MateriasID() {
        materias = new MateriaDAO().listarTodos();
        for (Materia materia : materias) {
            if (materia.getId() != 0) {
                id = materia.getId() + 1;
            } else {
                id = 1;
            }
        }
        return id;
    }

    // Métodos de listagem de alunos
    public List<Aluno> listarAlunos() {
        return alunos = new AlunoDAO().listarTodos();
    }

    // Métodos de listagem de professores
    public List<Professor> listarProfessores() {
        return professores = new ProfessorDAO().listarTodos();
    }

    // Método para calcular a média
    public double calcMedia(double n1, double n2, double n3) {
        double media = (n1 + n2 + n3) / 3;
        return media;
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }
}
