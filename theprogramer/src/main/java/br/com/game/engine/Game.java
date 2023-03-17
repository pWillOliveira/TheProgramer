package br.com.game.engine;

import java.awt.Graphics;

import javax.swing.JFrame;
import br.com.game.model.Player;

public class Game extends JFrame {

    private boolean gameOn = false;
    private int FPS = 60;

    public boolean isGameOn() {
        return gameOn;
    }

    public void setGameOn(boolean gameOn) {
        this.gameOn = gameOn;
    }

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
        refreshRate();

    }

    public void refreshRate() {

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while (gameOn != false) {

            repaint();
            
            try {
                double rTime = nextDrawTime - System.nanoTime();
                rTime = rTime / 1000000;

                if (rTime < 0) {
                    rTime = 0;
                }

                Thread.sleep((long) rTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponents(g);
    }


}
