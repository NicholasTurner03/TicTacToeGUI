import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;


public class TicTacToeFrame extends JFrame implements ActionListener {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
   JFrame game = new JFrame("Tic Tac Toe");
    JPanel board;
    JPanel buttonPnl;
  JButton scoreBtn=new JButton("Score");
  JButton button1 = new JButton("");
  JButton button2 = new JButton("");
  JButton button3 = new JButton("");
     JButton button4 = new JButton("");
     JButton button5 = new JButton("");
     JButton button6 = new JButton("");
     JButton button7 = new JButton("");
     JButton button8 = new JButton("");
     JButton button9 = new JButton("");
     JButton quitBtn = new JButton("Quit");
     JButton PlayAgainBtn = new JButton("Play Again");
     String letter = "";
     int count = 0;
     int XWins, OWins, Ties = 0;
     boolean win = false;
    public TicTacToeFrame() {
        board = new JPanel();
        board.setLayout(new GridLayout(3, 3));
        buttonPnl= new JPanel();

        buttonPnl.add(PlayAgainBtn);
        PlayAgainBtn.addActionListener((ActionEvent ae) -> {
            int reply = JOptionPane.showConfirmDialog(null, "PlayAgain?", "Confirm", JOptionPane.YES_NO_OPTION);
            if(reply == JOptionPane.YES_OPTION) {
                PlayAgain();
                count = 0;
            }
        });

        buttonPnl.add(scoreBtn);
        scoreBtn.addActionListener((ActionEvent ae) -> {
            JOptionPane.showMessageDialog(null, "Player X's number of Wins: " + " " + XWins + " \nPlayer O's number of Wins: " + " " + OWins + "\nNumber of Ties: " + " "+ Ties);
        });

        buttonPnl.add(quitBtn);
        quitBtn.addActionListener((ActionEvent ae) -> {
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exiting Tic Tac Toe", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        board.add(button1);
        board.add(button2);
        board.add(button3);
        board.add(button4);
        board.add(button5);
        board.add(button6);
        board.add(button7);
        board.add(button8);
        board.add(button9);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);

        game.setSize(WIDTH, HEIGHT);

        game.add(board);
        game.add(buttonPnl);

        board.setSize(400,400);
        board.setLocation(550,150);
        buttonPnl.setLocation(550,300);
        buttonPnl.setSize(400,100);

        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent b)
    {
        count++;
        if (count == 1 || count == 3 || count == 5 || count == 7 || count == 9) {
            letter = "X";
        }
        else if (count == 2 || count == 4 || count == 6 || count == 8 || count == 10) {
            letter = "O";
        }
        if (b.getSource() == button1) {
            button1.setText(letter);
            button1.setEnabled(false);
            CheckWin();
        }
        else if (b.getSource() == button2) {
            button2.setText(letter);
            button2.setEnabled(false);
            CheckWin();
        }
        else if (b.getSource() == button3) {
            button3.setText(letter);
            button3.setEnabled(false);
            CheckWin();
        }
        else if (b.getSource() == button4) {
            button4.setText(letter);
            button4.setEnabled(false);
            CheckWin();
        }
        else if (b.getSource() == button5) {
            button5.setText(letter);
            button5.setEnabled(false);
            CheckWin();
        }
        else if (b.getSource() == button6) {
            button6.setText(letter);
            button6.setEnabled(false);
            CheckWin();
        }
        else if (b.getSource() == button7) {
            button7.setText(letter);
            button7.setEnabled(false);
            CheckWin();
        }
        else if (b.getSource() == button8) {
            button8.setText(letter);
            button8.setEnabled(false);
            CheckWin();
        }
        else if (b.getSource() == button9) {
            button9.setText(letter);
            button9.setEnabled(false);
            CheckWin();
        }
    }

    public void CheckWin() {
        if (button1.getText() == button2.getText() && button2.getText() == button3.getText() && button1.getText() != "") {
            win = true;
            Win();
        }
        else if (button4.getText() == button5.getText() && button5.getText() == button6.getText() && button4.getText() != "") {
            win = true;
            Win();
        }
        else if (button7.getText() == button8.getText() && button8.getText() == button9.getText() && button7.getText() != ""){
            win = true;
            Win();
        }
        else if (button1.getText() == button4.getText() && button4.getText() == button7.getText() && button1.getText() != "") {
            win = true;
            Win();
        }
        else if (button2.getText() == button5.getText() && button5.getText() == button8.getText() && button2.getText() != "") {
            win = true;
            Win();
        }
        else if (button3.getText() == button6.getText() && button6.getText() == button9.getText() && button3.getText() != "") {
            win = true;
            Win();
        }
        else if (button1.getText() == button5.getText() && button5.getText() == button9.getText() && button1.getText() != "") {
            win = true;
            Win();
        }
        else if (button3.getText() == button5.getText() && button5.getText() == button7.getText() && button3.getText() != "") {
            win = true;
            Win();
        }
        else {
            win = false;
            Win();
        }
    }
    public void Win() {
        if (win == true) {
            JOptionPane.showMessageDialog(null, "Player " + letter + " Won!");
            if(letter.equalsIgnoreCase("X")) {
                XWins++;
            }
            else {
                OWins++;
            }
        }
        else if (count == 9 && win == false) {
            JOptionPane.showMessageDialog(null, "It's a Tie!");
            Ties++;
        }
    }
    public void PlayAgain() {
        button1.setText("");
        button1.setEnabled(true);
        button2.setText("");
        button2.setEnabled(true);
        button3.setText("");
        button3.setEnabled(true);
        button4.setText("");
        button4.setEnabled(true);
        button5.setText("");
        button5.setEnabled(true);
        button6.setText("");
        button6.setEnabled(true);
        button7.setText("");
        button7.setEnabled(true);
        button8.setText("");
        button8.setEnabled(true);
        button9.setText("");
        button9.setEnabled(true);
        win = false;
        count = 0;
    }

}
