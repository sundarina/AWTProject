import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;

public class Game extends JFrame implements ActionListener {

	private JPanel contentPane;
	boolean playerChoose = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game frame = new Game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	JPanel panel;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	JButton btn6;
	JButton btn7;
	JButton btn8;
	JButton btn9;
	JPanel panel_1;
	JPanel panel_2;
	JPanel panel_3;
	JPanel panel_4;
	JButton btnFirstPlayer;
	JButton btnSecondPlayer;

	private JDialog dialog;
	private JLabel label;
	private JButton dialogButton;

	public Game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		dialog = new JDialog(this, "Massage", true);
		label = new JLabel();
		dialogButton = new JButton("Ok");

		dialog.setLayout(new FlowLayout());
		dialog.add(label);
		dialog.add(dialogButton);
		dialogButton.setBackground(Color.YELLOW);
		dialogButton.addActionListener(this);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 3, 0, 0));

		btn1 = new JButton("");
		btn1.setFont(new Font("Dialog", Font.BOLD, 24));
		btn1.addActionListener(this);
		panel.add(btn1);

		btn2 = new JButton("");
		btn2.setFont(new Font("Dialog", Font.BOLD, 24));
		btn2.addActionListener(this);
		panel.add(btn2);

		btn3 = new JButton("");
		btn3.setFont(new Font("Dialog", Font.BOLD, 24));
		btn3.addActionListener(this);
		panel.add(btn3);

		btn4 = new JButton("");
		btn4.setFont(new Font("Dialog", Font.BOLD, 24));
		btn4.addActionListener(this);
		panel.add(btn4);

		btn5 = new JButton("");
		btn5.setFont(new Font("Dialog", Font.BOLD, 24));
		btn5.addActionListener(this);
		panel.add(btn5);

		btn6 = new JButton("");
		btn6.setFont(new Font("Dialog", Font.BOLD, 24));
		btn6.addActionListener(this);
		panel.add(btn6);

		btn7 = new JButton("");
		btn7.setFont(new Font("Dialog", Font.BOLD, 24));
		btn7.addActionListener(this);
		panel.add(btn7);

		btn8 = new JButton("");
		btn8.setFont(new Font("Dialog", Font.BOLD, 24));
		btn8.addActionListener(this);
		panel.add(btn8);

		btn9 = new JButton("");
		btn9.setFont(new Font("Dialog", Font.BOLD, 24));
		btn9.addActionListener(this);
		panel.add(btn9);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);

		btnFirstPlayer = new JButton("Player X");
		btnFirstPlayer.setBackground(Color.YELLOW);
		panel_1.add(btnFirstPlayer);
		btnFirstPlayer.addActionListener(this);

		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);

		panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);

		btnSecondPlayer = new JButton("Player O");
		btnSecondPlayer.setBackground(Color.GREEN);
		panel_3.add(btnSecondPlayer);
		btnSecondPlayer.addActionListener(this);

		panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.SOUTH);
	}

	int counter = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == dialogButton) {
			dialog.setVisible(false);
		} else if (e.getSource() == btnFirstPlayer) {
			playerChoose = true;

		} else if (e.getSource() == btnSecondPlayer) {
			playerChoose = false;
		} else {
			if (e.getSource() instanceof JButton) {

				if (playerChoose == true) {

					((JButton) e.getSource()).setText("X");

					if ((btn1.getText() == btn2.getText())
							&& (btn2.getText() == btn3.getText() && (btn3.getText() == "X"))) {

						btn1.setBackground(Color.RED);
						btn2.setBackground(Color.RED);
						btn3.setBackground(Color.RED);
						label.setText("Х Winning!!!");
						dialog.setSize(150, 90);
						dialog.setResizable(false);
						dialog.setVisible(true);
						counter++;

					} else if ((btn4.getText() == btn5.getText()) && (btn5.getText() == btn6.getText())
							&& (btn6.getText() == "X")) {
						btn4.setBackground(Color.RED);
						btn5.setBackground(Color.RED);
						btn6.setBackground(Color.RED);
						label.setText("X Winning!!!");
						dialog.setSize(150, 90);
						dialog.setResizable(false);
						dialog.setVisible(true);
						counter++;
					} else if ((btn7.getText() == btn8.getText()) && (btn8.getText() == btn9.getText())
							&& (btn9.getText() == "X")) {
						btn7.setBackground(Color.RED);
						btn8.setBackground(Color.RED);
						btn7.setBackground(Color.RED);
						label.setText("X Winning!!!");
						dialog.setSize(150, 90);
						dialog.setResizable(false);
						dialog.setVisible(true);
						counter++;
					} else if ((btn1.getText() == btn4.getText()) && (btn4.getText() == btn7.getText())
							&& (btn7.getText() == "X")) {
						btn1.setBackground(Color.RED);
						btn4.setBackground(Color.RED);
						btn7.setBackground(Color.RED);
						label.setText("X Winning!!!");
						dialog.setSize(150, 90);
						dialog.setResizable(false);
						dialog.setVisible(true);
						counter++;

					} else if ((btn2.getText() == btn5.getText()) && (btn5.getText() == btn8.getText())
							&& (btn8.getText() == "X")) {
						btn2.setBackground(Color.RED);
						btn5.setBackground(Color.RED);
						btn8.setBackground(Color.RED);
						label.setText("X Winning!!!");
						dialog.setSize(150, 90);
						dialog.setResizable(false);
						dialog.setVisible(true);
						counter++;
					} else if ((btn3.getText() == btn6.getText()) && (btn6.getText() == btn9.getText())
							&& (btn9.getText() == "X")) {
						btn3.setBackground(Color.RED);
						btn6.setBackground(Color.RED);
						btn9.setBackground(Color.RED);
						label.setText("X Winning!!!");
						dialog.setSize(150, 90);
						dialog.setResizable(false);
						dialog.setVisible(true);
						counter++;
					} else if ((btn1.getText() == btn5.getText()) && (btn5.getText() == btn9.getText())
							&& (btn9.getText() == "X")) {
						btn1.setBackground(Color.RED);
						btn5.setBackground(Color.RED);
						btn9.setBackground(Color.RED);
						label.setText("X Winning!!!");
						dialog.setSize(150, 90);
						dialog.setResizable(false);
						dialog.setVisible(true);
						counter++;
					} else if ((btn3.getText() == btn5.getText()) && (btn5.getText() == btn7.getText())
							&& (btn7.getText() == "X")) {
						btn3.setBackground(Color.RED);
						btn5.setBackground(Color.RED);
						btn7.setBackground(Color.RED);
						label.setText("X Winning!!!");
						dialog.setSize(150, 90);
						dialog.setResizable(false);
						dialog.setVisible(true);
						counter++;
					}
				} else

					((JButton) e.getSource()).setText("O");

				if ((btn1.getText() == btn2.getText()) && (btn2.getText() == btn3.getText())
						&& (btn3.getText() == "O")) {
					btn1.setBackground(Color.RED);
					btn2.setBackground(Color.RED);
					btn3.setBackground(Color.RED);
					label.setText("O Winning!!!");
					dialog.setSize(150, 90);
					dialog.setResizable(false);
					dialog.setVisible(true);
					counter++;
				} else if ((btn4.getText() == btn5.getText()) && (btn5.getText() == btn6.getText())
						&& (btn6.getText() == "O")) {
					btn4.setBackground(Color.RED);
					btn5.setBackground(Color.RED);
					btn6.setBackground(Color.RED);
					label.setText("O Winning!!!");
					dialog.setSize(150, 90);
					dialog.setResizable(false);
					dialog.setVisible(true);
					counter++;
				} else if ((btn7.getText() == btn8.getText()) && (btn8.getText() == btn9.getText())
						&& (btn9.getText() == "O")) {
					btn7.setBackground(Color.RED);
					btn8.setBackground(Color.RED);
					btn9.setBackground(Color.RED);
					label.setText("O Winning!!!");
					dialog.setSize(150, 90);
					dialog.setResizable(false);
					dialog.setVisible(true);
					counter++;
				} else if ((btn1.getText() == btn4.getText()) && (btn4.getText() == btn7.getText())
						&& (btn7.getText() == "O")) {
					btn1.setBackground(Color.RED);
					btn4.setBackground(Color.RED);
					btn7.setBackground(Color.RED);
					label.setText("O Winning!!!");
					dialog.setSize(150, 90);
					dialog.setResizable(false);
					dialog.setVisible(true);
					counter++;
				} else if ((btn2.getText() == btn5.getText()) && (btn5.getText() == btn8.getText())
						&& (btn8.getText() == "O")) {
					btn2.setBackground(Color.RED);
					btn5.setBackground(Color.RED);
					btn8.setBackground(Color.RED);
					label.setText("O Winning!!!");
					dialog.setSize(150, 90);
					dialog.setResizable(false);
					dialog.setVisible(true);
					counter++;
				} else if ((btn3.getText() == btn6.getText()) && (btn6.getText() == btn9.getText())
						&& (btn9.getText() == "O")) {
					btn3.setBackground(Color.RED);
					btn6.setBackground(Color.RED);
					btn9.setBackground(Color.RED);
					label.setText("O Winning!!!");
					dialog.setSize(150, 90);
					dialog.setResizable(false);
					dialog.setVisible(true);
					counter++;
				} else if ((btn1.getText() == btn5.getText()) && (btn5.getText() == btn9.getText())
						&& (btn9.getText() == "O")) {
					btn1.setBackground(Color.RED);
					btn5.setBackground(Color.RED);
					btn9.setBackground(Color.RED);
					label.setText("O Winning!!!");
					dialog.setSize(150, 90);
					dialog.setResizable(false);
					dialog.setVisible(true);
					counter++;
				} else if ((btn3.getText() == btn5.getText()) && (btn5.getText() == btn7.getText())
						&& (btn7.getText() == "O")) {
					btn3.setBackground(Color.RED);
					btn5.setBackground(Color.RED);
					btn7.setBackground(Color.RED);
					label.setText("O Winning!!!");
					dialog.setSize(150, 90);
					dialog.setResizable(false);
					dialog.setVisible(true);
					counter++;
				}

			}
			((JButton) e.getSource()).setEnabled(false);
			
		}
		
		

		// (((JButton)e.getSource()).getText())
		/*if (counter == 0) {
		label.setText("EVERYONE WIN!!!!!!");
		dialog.setSize(150, 90);
		dialog.setResizable(false);
		dialog.setVisible(true);
	}*/
	}
	
	

}
