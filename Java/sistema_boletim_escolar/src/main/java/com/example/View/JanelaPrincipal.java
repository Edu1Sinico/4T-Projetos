package com.example.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaPrincipal extends JFrame {
    private JTabbedPane jTPane;
    private JButton sair;

    public JanelaPrincipal() {
        super("Sistema de Boletim Escolar - Página Principal");
        jTPane = new JTabbedPane();
        add(jTPane);
        JPanel headerPanel = new JPanel();
        headerPanel.add(sair = new JButton("Sair"));
        jTPane.add("Sair", headerPanel);
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

        setSize(700, 600);
        // Método para centralizar a tela
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((screenWidth - this.getWidth()) / 2, (screenHeight - this.getHeight()) / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

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
