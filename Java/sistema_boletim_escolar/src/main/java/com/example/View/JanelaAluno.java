package com.example.View;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.example.Connection.AlunoDAO;
import com.example.Controller.AlunoController;
import com.example.Exception.*;
// Importação da Classe
import com.example.Model.Aluno;

public class JanelaAluno extends JPanel {

    // Atributos
    private JButton cadastrar, apagar, editar, limpar;
    private JTextField raField, nomeField, idadeField, cpfField, emailField, senhaField;
    private List<Aluno> alunos;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;
    private JComboBox turmaBox;
    private String turmasList[] = { "Selecione uma turma", "1º Ano Ensino Fundamental", "2º Ano Ensino Fundamental",
            "3º Ano Ensino Fundamental", "4º Ano Ensino Fundamental", "5º Ano Ensino Fundamental",
            "6º Ano Ensino Fundamental", "7º Ano Ensino Fundamental", "8º Ano Ensino Fundamental",
            "9º Ano Ensino Fundamental", "1º Ano Ensino Médio", "2º Ano Ensino Médio", "3º Ano Ensino Médio", };
    // MaskFormatter
    private MaskFormatter cpfFormatter, raFormatter, idadeFormatter;

    public JanelaAluno() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro de Alunos"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2));
        // RA - 1
        inputPanel.add(new JLabel("RA"));
        try {
            raFormatter = new MaskFormatter("######");
            raField = new JFormattedTextField(raFormatter);
            raField.setColumns(10);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        inputPanel.add(raField);
        // Nome - 2
        inputPanel.add(new JLabel("Nome"));
        nomeField = new JTextField(20);
        inputPanel.add(nomeField);
        // Idade - 3
        inputPanel.add(new JLabel("Idade"));
        try {
            idadeFormatter = new MaskFormatter("##");
            idadeField = new JFormattedTextField(idadeFormatter);
            idadeField.setColumns(2);
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
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        inputPanel.add(cpfField);
        // Email - 5
        inputPanel.add(new JLabel("Email"));
        emailField = new JTextField(20);
        inputPanel.add(emailField);
        // Senha - 6
        inputPanel.add(new JLabel("Senha"));
        senhaField = new JPasswordField(20);
        inputPanel.add(senhaField);
        // Turma - 7
        inputPanel.add(new JLabel("Turma"));
        turmaBox = new JComboBox(turmasList);
        inputPanel.add(turmaBox);

        add(inputPanel);

        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        botoes.add(limpar = new JButton("Limpar"));
        add(botoes);
        // tabela de alunos
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "RA", "Nome", "Idade", "CPF", "Email", "Turma" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Criar a tabela
        new AlunoDAO().criaTabela();

        // Atualizar a tabela
        atualizarTabela();

        // Tratamento de eventos;

        // selecionar os elementos nas linhas da tabela
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    raField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    nomeField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    idadeField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    cpfField.setText((String) table.getValueAt(linhaSelecionada, 3));
                    emailField.setText((String) table.getValueAt(linhaSelecionada, 4));
                    turmaBox.setSelectedItem((String) table.getValueAt(linhaSelecionada, 5));
                    // Desativa o textfield da cpf
                    raField.setEditable(false);
                    // Desativa o botão
                    cadastrar.setEnabled(false);
                } else {
                    // Ativa o textfield da ra
                    raField.setEditable(true);
                    // Ativa o botão
                    cadastrar.setEnabled(true);
                }
            }
        });

        AlunoController operacoes = new AlunoController(alunos, tableModel, table);

        // Cadastrar
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método "cadastrar" do objeto operacoes com os valores dos

                // campos de entrada
                try {
                    if (!(raField.getText().isEmpty() || nomeField.getText().isEmpty() || idadeField.getText().isEmpty()
                            || cpfField.getText().isEmpty()
                            || emailField.getText().isEmpty() || senhaField.getText().isEmpty()
                            || turmaBox.getSelectedItem().toString().equals("Selecione uma turma"))) {

                        for (Aluno aluno : alunos) {
                            if (raField.getText().equals(aluno.getRa())) {
                                throw new CpfValidiationException("RA já cadastrado, por favor utilize outro RA.");
                            }
                        }

                        if (cpfField.getText().matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")) {

                            operacoes.cadastrar(raField.getText(), nomeField.getText(), idadeField.getText(),

                                    cpfField.getText(), emailField.getText(),
                                    senhaField.getText(), (String) turmaBox.getSelectedItem());

                            // Limpa os campos de entrada após a operação de cadastro
                            raField.setText("");
                            nomeField.setText("");
                            idadeField.setText("");
                            cpfField.setText("");
                            emailField.setText("");
                            senhaField.setText("");
                            turmaBox.setSelectedIndex(0);

                        } else {
                            throw new CpfValidiationException(
                                    "CPF inválido, Por favor digite um número de CPF válido. "
                                            + "\n\n Exemplo: "
                                            + "\n 123.456.789-99");
                        }
                    } else {
                        throw new NullPointerException(
                                "Informações inválidas. Por favor preencha as informações vazias.");
                    }
                } catch (CpfValidiationException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "CpfValidationException",
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

        // Limpar campos
        limpar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                raField.setText("");
                nomeField.setText("");
                idadeField.setText("");
                cpfField.setText("");
                emailField.setText("");
                senhaField.setText("");
                turmaBox.setSelectedIndex(0);
                raField.setEditable(true);
                cadastrar.setEnabled(true);
                table.clearSelection();
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
                        if (!(raField.getText().isEmpty() || nomeField.getText().isEmpty()
                                || idadeField.getText().isEmpty()
                                || cpfField.getText().isEmpty()
                                || emailField.getText().isEmpty() || senhaField.getText().isEmpty()
                                || turmaBox.getSelectedItem().toString().equals("Selecione uma turma"))) {

                            operacoes.atualizar(raField.getText(), nomeField.getText(), idadeField.getText(),

                                    cpfField.getText(), emailField.getText(),
                                    senhaField.getText(), (String) turmaBox.getSelectedItem());
                            // Limpa os campos de entrada após a operação de atualização
                            nomeField.setText("");
                            idadeField.setText("");
                            cpfField.setText("");
                            emailField.setText("");
                            senhaField.setText("");
                            turmaBox.setSelectedIndex(0);
                            cadastrar.setEnabled(true);
                            cpfField.setEditable(true);

                        } else {
                            throw new NullPointerException(
                                    "Informações inválidas. Por favor preencha as informações vazias.");
                        }
                    } else {
                        throw new SelectedTableException("Erro de Seleção, por favor selecione uma linha.");
                    }
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
                            operacoes.apagar(raField.getText());
                            // Limpa os campos de entrada após a operação de exclusão
                            raField.setText("");
                            raField.setEditable(true);
                            nomeField.setText("");
                            idadeField.setText("");
                            emailField.setText("");
                            cpfField.setText("");
                            senhaField.setText("");
                            turmaBox.setSelectedIndex(0);
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
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        alunos = new AlunoDAO().listarTodos();
        // Obtém os alunos atualizados do banco de dados
        for (Aluno aluno : alunos) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { aluno.getRa(), aluno.getNome(), aluno.getIdade(),
                    aluno.getCpf(), aluno.getEmail(), aluno.getTurma() });
        }
    }
}
