package br.com.game.model;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends JPanel {

    private ImageIcon image;
    private int x = 400;
    private int y = 300;
    private int imageIndex = 4;
    private String direction;
    private int speed = 16;
    private int spriteCounter = 0;
    private int spritePosition = 1;

    public Player() {
        setFocusable(true);
        image = new ImageIcon(getClass().getResource("/br/com/game/resources/sprite-sheet.png"));
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    y -= speed;
                    direction = "up";

                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    y += speed;
                    direction = "down";

                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    x -= speed;
                    direction = "left";

                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    x += speed;
                    direction = "right";

                }

                spriteCounter++;

                if (spriteCounter <= 4) {
                    if (spriteCounter == 1) {
                        spritePosition = 1;
                    } else if (spriteCounter == 2) {
                        spritePosition = 2;
                    } else if (spriteCounter == 3) {
                        spritePosition = 3;
                        spriteCounter = 0;
                    } else {
                        spritePosition = 1;
                        spriteCounter = 0;
                    }

                }

                switch (direction) {
                    case "up":
                        if (spritePosition == 1) { // Posição a direita
                            imageIndex = 6;
                        }
                        if (spritePosition == 2) { // Posição a esquerda
                            imageIndex = 8;
                        }
                        if (spritePosition == 3) { // Posição parado
                            imageIndex = 7;
                        }
                        break;

                    case "down":
                        if (spritePosition == 1) { // Posição a direita
                            imageIndex = 3;
                        }
                        if (spritePosition == 2) { // Posição a esquerda
                            imageIndex = 5;
                        }
                        if (spritePosition == 3) { // Posição parado
                            imageIndex = 4;
                        }
                        break;

                    case "left":
                        if (spritePosition == 1) { // Posição a direita
                            imageIndex = 0;
                        }
                        if (spritePosition == 2) { // Posição a esquerda
                            imageIndex = 2;
                        }
                        if (spritePosition == 3) { // Posição parado
                            imageIndex = 1;
                        }
                        break;

                    case "right":
                        if (spritePosition == 1) { // Posição a direita
                            imageIndex = 9;
                        }
                        if (spritePosition == 2) { // Posição a esquerda
                            imageIndex = 11;
                        }
                        if (spritePosition == 3) { // Posição parado
                            imageIndex = 10;
                        }
                        break;

                }

                repaint();

            }

        });

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.getImage(), x, y, x + 32, y + 32, imageIndex * 32, 0,
                (imageIndex + 1) * 32, 32, this);

    }

}
