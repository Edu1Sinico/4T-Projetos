package com.example.View;

// Importação básicas
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.example.Connection.ProfessorDAO;
import com.example.Controller.ProfessorController;
import com.example.Exception.*;
// Importação da Classe
import com.example.Model.Professor;

public class JanelaProfessor extends JPanel {

    private JButton cadastrar, apagar, editar, limpar;
    private JTextField nomeField, idadeField, cpfField, emailField, senhaField;
    private List<Professor> professores;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;
    private JComboBox especializacaoBox;
    private String[] especializacaoList = { "Selecione uma especialização", "Língua Portuguesa", "Inglês", "Espanhol",
            "Artes", "Educação Física", "Matemática", "Ciências Básicas", "Física", "Química", "Biologia",
            "História", "Geografia" };
    // MaskFormatter
    private MaskFormatter cpfFormatter, idadeFormatter;

    public JanelaProfessor() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro de Professores"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Nome"));
        nomeField = new JTextField(20);
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Idade"));
        try {
            idadeFormatter = new MaskFormatter("##");
            idadeField = new JFormattedTextField(idadeFormatter);
            idadeField.setColumns(10);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        inputPanel.add(idadeField);
        inputPanel.add(new JLabel("CPF"));
        try {
            cpfFormatter = new MaskFormatter("###.###.###-##");
            cpfField = new JFormattedTextField(cpfFormatter);
            cpfField.setColumns(10);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        inputPanel.add(cpfField);
        inputPanel.add(new JLabel("Email"));
        emailField = new JTextField(20);
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Senha"));
        senhaField = new JPasswordField(20);
        inputPanel.add(senhaField);
        inputPanel.add(new JLabel("Espelização"));
        especializacaoBox = new JComboBox(especializacaoList);
        inputPanel.add(especializacaoBox);

        add(inputPanel);
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        botoes.add(limpar = new JButton("Limpar"));
        add(botoes);
        // tabela de professores
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Nome", "Idade", "CPF", "Email", "Especialização" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Criar a tabela
        new ProfessorDAO().criaTabela();

        // Atualizar a tabela
        atualizarTabela();

        // Tratamento de eventos;

        // selecionar os elementos nas linhas da tabela
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    nomeField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    idadeField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    cpfField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    emailField.setText((String) table.getValueAt(linhaSelecionada, 3));
                    especializacaoBox.setSelectedItem((String) table.getValueAt(linhaSelecionada, 4));
                    // Desativa o textfield da cpf
                    cpfField.setEditable(false);
                    // Desativa o botão
                    cadastrar.setEnabled(false);
                } else {
                    // Ativa o textfield da cpf
                    cpfField.setEditable(true);
                    // Ativa o botão
                    cadastrar.setEnabled(true);
                }
            }
        });

        ProfessorController operacoes = new ProfessorController(professores, tableModel, table);

        // Cadastrar
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o método "cadastrar" do objeto operacoes com os valores dos

                // campos de entrada
                try {
                    if (!(nomeField.getText().isEmpty() || idadeField.getText().isEmpty()
                            || cpfField.getText().isEmpty()
                            || emailField.getText().isEmpty() || senhaField.getText().isEmpty()
                            || especializacaoBox.getSelectedItem().toString().equals("Selecione uma especialização"))) {

                        for (Professor professor : professores) {
                            if (cpfField.getText().equals(professor.getCpf())) {
                                throw new CpfValidiationException("CPF já cadastrado, por favor utilize outro CPF.");
                            }
                        }

                        if (cpfField.getText().matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")) {

                            operacoes.cadastrar(nomeField.getText(), idadeField.getText(),
                                    cpfField.getText(), emailField.getText(),
                                    senhaField.getText(),
                                    (String) especializacaoBox.getSelectedItem());

                            // Limpa os campos de entrada após a operação de cadastro
                            nomeField.setText("");
                            idadeField.setText("");
                            cpfField.setText("");
                            emailField.setText("");
                            senhaField.setText("");
                            especializacaoBox.setSelectedIndex(0);

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
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "NumberFormatException",
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
                nomeField.setText("");
                idadeField.setText("");
                cpfField.setText("");
                emailField.setText("");
                senhaField.setText("");
                especializacaoBox.setSelectedIndex(0);
                cpfField.setEditable(true);
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
                        if (!(nomeField.getText().isEmpty() || idadeField.getText().isEmpty()
                                || cpfField.getText().isEmpty()
                                || emailField.getText().isEmpty() || senhaField.getText().isEmpty()
                                || especializacaoBox.getSelectedItem().toString()
                                        .equals("Selecione uma especialização"))) {

                            operacoes.atualizar(nomeField.getText(), idadeField.getText(),
                                    cpfField.getText(), emailField.getText(),
                                    senhaField.getText(),
                                    (String) especializacaoBox.getSelectedItem());

                            // Limpa os campos de entrada após a operação de atualização
                            nomeField.setText("");
                            idadeField.setText("");
                            cpfField.setText("");
                            emailField.setText("");
                            senhaField.setText("");
                            especializacaoBox.setSelectedIndex(0);
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
                    JOptionPane.showMessageDialog(null,
                            "Formatação inválida, por favor digite somente números válidos.", "NumberFormatException",
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

                // entrada "cpf"
                try {
                    if (linhaSelecionada != -1) {
                        if (JOptionPane.showConfirmDialog(null, "Deseja excluir esse cadastro?",
                                "Excluindo cadastros...", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            operacoes.apagar(cpfField.getText());
                            // Limpa os campos de entrada após a operação de exclusão
                            nomeField.setText("");
                            idadeField.setText("");
                            cpfField.setText("");
                            cpfField.setEditable(true);
                            emailField.setText("");
                            senhaField.setText("");
                            especializacaoBox.setSelectedIndex(0);
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
        professores = new ProfessorDAO().listarTodos();
        // Obtém os professores atualizados do banco de dados
        for (Professor professor : professores) {
            // Adiciona os dados de cada professor como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { professor.getNome(), professor.getIdade(),
                    professor.getCpf(), professor.getEmail(), professor.getEspecializacao() });
        }
    }
}
