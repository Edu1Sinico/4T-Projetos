package com.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MinhaJanela extends JFrame {

    public MinhaJanela() {
        super("Exemplo Swing");

        // Cria o JFrame (janela)
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cria um JPanel (painel)
        JPanel panel = new JPanel();
        this.add(panel);

        // Adiciona um JButton (botão)
        JButton button = new JButton("Clique aqui");
        panel.add(button);

        // Adiciona um ActionListener ao botão
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão foi clicado!");
            }
        });

        // Torna a janela visível
        this.setVisible(true);
    }

}
