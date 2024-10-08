package com.example.View;

import javax.swing.*;

import com.example.Model.Aluno;

import java.awt.*;
import java.awt.event.*;

public class JanelaBoletim extends JFrame {
    public JanelaBoletim(Aluno aluno) {
        super("Sistema de Boletim Escolar - Boletim do Aluno");

        setSize(700, 600);
        // Método para centralizar a tela
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((screenWidth - this.getWidth()) / 2, (screenHeight - this.getHeight()) / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }
}
