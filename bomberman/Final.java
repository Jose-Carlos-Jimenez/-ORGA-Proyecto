/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Isaac Maldonado
 */
public class Final extends JFrame implements KeyListener {

    Space[][] buttonArray;
    JPanel panel;
    boolean active;
    boolean test = true;
    int size = 12;
    public static int x = 0;
    public static int y = 0;

    public Final() {
        setSize(700, 700);
        setLocationRelativeTo(null);
        addKeyListener(this);
        buttonArray = new Space[12][12];

        active = true;
        panel();
        buttons();

        TimerTask timerTask = new TimerTask() {
            public void run() {
                enemies();
            }
        };

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 1000, 1000);

    }

    public void panel() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(12, 12, 2, 2));
        this.getContentPane().add(panel);
        this.setFocusable(true);
    }

    public void buttons() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Space instance = new Space(new JButton(), "none", false);
                buttonArray[i][j] = instance;
                buttonArray[i][j].square.setBackground(Color.red);
                buttonArray[i][j].square.setSize(10, 10);
                buttonArray[i][j].square.setText("N");
                panel.add(buttonArray[i][j].square);
            }
        }

        Random xPosition = new Random();
        Random yPosition = new Random();
        for (int i = 0; i < 50; i++) {
            int first = xPosition.nextInt(12);
            int second = yPosition.nextInt(12);
            buttonArray[first][second].square.setBackground(Color.gray);
            buttonArray[first][second].type = "block";
            buttonArray[first][second].square.setText("W");

        }
        buttonArray[y][x].square.setBackground(Color.blue);
        buttonArray[y][x].type = "bomberman";
        buttonArray[y][x].square.setText("P");

        buttonArray[4][4].square.setBackground(Color.green);
        buttonArray[4][4].type = "enemy";
        buttonArray[4][4].square.setText("E");

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == 39) {
            if (x < 11) {
                if (!buttonArray[y][x].type.equalsIgnoreCase("bomb")) {
                    buttonArray[y][x].square.setBackground(Color.red);
                    buttonArray[y][x].type = "none";
                    buttonArray[y][x].square.setText("N");
                }

                x = x + 1;

                if (buttonArray[y][x].type.equalsIgnoreCase("bomb") || buttonArray[y][x].type.equalsIgnoreCase("block")) {
                    x = x - 1;
                    buttonArray[y][x].square.setBackground(Color.blue);
                    buttonArray[y][x].type = "bomberman";
                    buttonArray[y][x].square.setText("P");

                } else {
                    buttonArray[y][x].square.setBackground(Color.blue);
                    buttonArray[y][x].type = "bomberman";
                    buttonArray[y][x].square.setText("P");
                }
            }
        }

        if (e.getKeyCode() == 37) {
            if (x > 0) {
                if (!buttonArray[y][x].type.equalsIgnoreCase("bomb")) {
                    buttonArray[y][x].square.setBackground(Color.red);
                    buttonArray[y][x].type = "none";
                    buttonArray[y][x].square.setText("N");
                }

                x = x - 1;
                if (buttonArray[y][x].type.equalsIgnoreCase("bomb") || buttonArray[y][x].type.equalsIgnoreCase("block")) {
                    x = x + 1;
                    buttonArray[y][x].square.setBackground(Color.blue);
                    buttonArray[y][x].type = "bomberman";
                    buttonArray[y][x].square.setText("P");
                } else {
                    buttonArray[y][x].square.setBackground(Color.blue);
                    buttonArray[y][x].type = "bomberman";
                    buttonArray[y][x].square.setText("P");
                }

            }

        }

        if (e.getKeyCode() == 40) {
            if (y < 11) {
                if (!buttonArray[y][x].type.equalsIgnoreCase("bomb")) {
                    buttonArray[y][x].square.setBackground(Color.red);
                    buttonArray[y][x].type = "none";
                    buttonArray[y][x].square.setText("N");
                }

                y = y + 1;
                if (buttonArray[y][x].type.equalsIgnoreCase("bomb") || buttonArray[y][x].type.equalsIgnoreCase("block")) {
                    y = y - 1;
                    buttonArray[y][x].square.setBackground(Color.blue);
                    buttonArray[y][x].type = "bomberman";
                    buttonArray[y][x].square.setText("P");
                } else {
                    buttonArray[y][x].square.setBackground(Color.blue);
                    buttonArray[y][x].type = "bomberman";
                    buttonArray[y][x].square.setText("P");
                }

            }

        }
        if (e.getKeyCode() == 38) {
            if (y > 0) {
                if (!buttonArray[y][x].type.equalsIgnoreCase("bomb")) {
                    buttonArray[y][x].square.setBackground(Color.red);
                    buttonArray[y][x].type = "none";
                    buttonArray[y][x].square.setText("N");
                }

                y = y - 1;
                if (buttonArray[y][x].type.equalsIgnoreCase("bomb") || buttonArray[y][x].type.equalsIgnoreCase("block")) {
                    y = y + 1;
                    buttonArray[y][x].square.setBackground(Color.blue);
                    buttonArray[y][x].type = "bomberman";
                    buttonArray[y][x].square.setText("P");
                } else {
                    buttonArray[y][x].square.setBackground(Color.blue);
                    buttonArray[y][x].type = "bomberman";
                    buttonArray[y][x].square.setText("P");
                }

            }
        }
        if (e.getKeyChar() == 'b') {
            int _x = x;
            int _y = y;

            buttonArray[y][x].square.setBackground(Color.yellow);
            buttonArray[y][x].type = "bomb";
            buttonArray[y][x].square.setText("B");

            int _x1 = _x + 1;
            int _x2 = _x - 1;
            int _y1 = _y + 1;
            int _y2 = _y - 1;

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {

                            if (active) {

                                buttonArray[_y][_x].square.setBackground(Color.red);
                                buttonArray[_y][_x].type = "none";
                                buttonArray[_y][_x].square.setText("N");

                                //Block destruction
                                System.out.println("CALCULOS: ");
                                System.out.println("Y1: " + _y1 + " Y2: " + _y2);
                                System.out.println("X1: " + _x1 + " X2: " + _x2);
                                System.out.println("");

                                boolean gameOver = false;

                                if (_y1 < 12) {
                                    String t1 = check(_y1, _x);
                                    System.out.println("Y1: " + _y1 + " X: " + _x);
                                    if (t1.equalsIgnoreCase("block")) {
                                        buttonArray[_y1][_x].square.setBackground(Color.red);
                                        buttonArray[_y1][_x].type = "none";
                                        buttonArray[_y1][_x].square.setText("N");
                                    } else if (t1.equalsIgnoreCase("bomberman")) {
                                        gameOver = true;
                                    }

                                }
                                if (_y2 > -1) {
                                    String t2 = check(_y2, _x);
                                    System.out.println("Y2: " + _y2 + " X: " + _x);
                                    if (t2.equalsIgnoreCase("block")) {
                                        buttonArray[_y2][_x].square.setBackground(Color.red);
                                        buttonArray[_y2][_x].type = "none";
                                        buttonArray[_y2][_x].square.setText("N");
                                    } else if (t2.equalsIgnoreCase("bomberman")) {
                                        gameOver = true;
                                    }

                                }
                                if (_x1 < 12) {
                                    String t3 = check(_y, _x1);
                                    System.out.println("Y: " + _y + " X1: " + _x1);
                                    if (t3.equalsIgnoreCase("block")) {
                                        buttonArray[_y][_x1].square.setBackground(Color.red);
                                        buttonArray[_y][_x1].type = "none";
                                        buttonArray[_y][_x1].square.setText("N");
                                    } else if (t3.equalsIgnoreCase("bomberman")) {
                                        gameOver = true;
                                    }

                                }
                                if (_x2 > -1) {
                                    String t4 = check(_y, _x2);
                                    System.out.println("Y: " + _y + " X2: " + _x2);
                                    if (t4.equalsIgnoreCase("block")) {
                                        buttonArray[_y][_x2].square.setBackground(Color.red);
                                        buttonArray[_y][_x2].type = "none";
                                        buttonArray[_y][_x2].square.setText("N");
                                    } else if (t4.equalsIgnoreCase("bomberman")) {
                                        gameOver = true;
                                    }

                                }

                                if (gameOver) {
                                    reset();

                                }
                            }
                        }
                    },
                    5000
            );
        }

    }

    public String check(int _y, int _x) {
        if (buttonArray[_y][_x].type.equalsIgnoreCase("bomberman")) {
            return "bomberman";
        } else if (buttonArray[_y][_x].type.equalsIgnoreCase("bomb")) {
            return "bomb";
        } else if (buttonArray[_y][_x].type.equalsIgnoreCase("block")) {
            return "block";
        } else if (buttonArray[_y][_x].type.equalsIgnoreCase("enemy")) {
            return "enemy";
        }
        return "none";
    }

    public void reset() {
        active = false;
        JOptionPane.showMessageDialog(null, "Game over...");
        dispose();
        x = 0;
        y = 0;
        Final instance = new Final();
        instance.setVisible(true);
    }

    public void enemies() {
        System.out.println("ENEMIGO?");
        boolean change = false;
        if (active) {

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 12; j++) {
                    if (buttonArray[i][j].type.equalsIgnoreCase("enemy") && !change) {
                        System.out.println("FOUND!");
                        int _x1 = j + 1;
                        int _x2 = j - 1;
                        int _y1 = i + 1;
                        int _y2 = i - 1;

                        int first[] = new int[2];
                        int second[] = new int[2];

                        int xAxis;
                        int yAxis;

                        Random Dice = new Random();
                        int n1 = 0;
                        int n2 = 0;
                        int n3 = 0;

                        boolean c1 = false;
                        boolean c2 = false;
                        boolean c3 = false;
                        boolean c4 = false;
                        if (_y1 < 12) {
                            if (check(_y1, j).equalsIgnoreCase("none")) {
                                first[0] = _y1;
                                n1 = 0;
                                n3 = 0;
                                c1 = true;
                            } else if (check(_y1, j).equalsIgnoreCase("bomberman")) {
                                reset();
                            }
                        }
                        if (_y2 > -1) {
                            if (check(_y2, j).equalsIgnoreCase("none")) {
                                if (c1) {
                                    n1 = Dice.nextInt(2);
                                    n3 = 0;
                                } else {
                                    n1 = 1;
                                    n3 = 0;
                                }
                                first[1] = _y2;
                                c2 = true;

                            } else if (check(_y2, j).equalsIgnoreCase("bomberman")) {
                                reset();
                            }
                        }
                        if (_x1 < 12) {
                            if (check(i, _x1).equalsIgnoreCase("none")) {
                                if (!c1 && !c2) {
                                    n3 = 1;
                                } else {
                                    n3 = Dice.nextInt(2);
                                }

                                n2 = 0;
                                second[0] = _x1;
                                c3 = true;
                            } else if (check(i, _x1).equalsIgnoreCase("bomberman")) {
                                reset();
                            }
                        }
                        if (_x2 > -1) {

                            if (check(i, _x2).equalsIgnoreCase("none")) {
                                if (!c1 && !c2) {
                                    n3 = 1;
                                } else {
                                    n3 = Dice.nextInt(2);
                                }
                                if (c3) {
                                    n2 = Dice.nextInt(2);
                                } else {
                                    n2 = 1;
                                }
                                second[1] = _x2;
                                c4 = true;
                            } else if (check(i, _x2).equalsIgnoreCase("bomberman")) {
                                reset();
                            }
                        }

                        int third[] = {first[n1], second[n2]};

                        if (n3 == 1) {
                            xAxis = third[n3];
                            yAxis = i;
                        } else {
                            yAxis = third[n3];
                            xAxis = j;
                        }

                        if (c1 || c2 || c3 || c4) {
                            change = true;

                            buttonArray[yAxis][xAxis].square.setBackground(Color.green);
                            buttonArray[yAxis][xAxis].type = "enemy";
                            buttonArray[yAxis][xAxis].square.setText("E");

                            buttonArray[i][j].square.setBackground(Color.red);
                            buttonArray[i][j].type = "none";
                            buttonArray[i][j].square.setText("N");
                        }

                    }

                }

            }
        }
    }
}
