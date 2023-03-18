package br.com.game.engine;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.com.game.model.Player;

public class Game extends JFrame {

    /**
     * Parâmetros do JFrame
     */
    public Game() {

        JFrame game = new JFrame("Game");
        Player player = new Player();

        game.setSize(800, 600);
        game.setResizable(false);
        game.setLocationRelativeTo(null);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.add(player);
        game.setVisible(true);

    }

}
