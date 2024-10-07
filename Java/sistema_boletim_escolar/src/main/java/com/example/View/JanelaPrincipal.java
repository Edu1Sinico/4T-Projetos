package com.example.View;

import javax.swing.*;

public class JanelaPrincipal extends JFrame {
    private JTabbedPane jTPane;

    public JanelaPrincipal() {
        super("Sistema de Boletim Escolar");
        jTPane = new JTabbedPane();
        add(jTPane);
        // criandos as tabs
        // tab1 Professores
        JanelaProfessor tab1 = new JanelaProfessor();
        jTPane.add("Cadastrar Professor", tab1);
        // tab2 Alunos
        JanelaAluno tab2 = new JanelaAluno();
        jTPane.add("Cadastrar Aluno", tab2);
        // tab3 Materias
        // JanelaMateria tab3 = new JanelaMateria();
        // jTPane.add("Materias", tab3);

        setBounds(50, 50, 700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }
}
