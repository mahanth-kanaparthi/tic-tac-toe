package mk.game;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;



public class TicTacToe implements ActionListener {

	public int boardWidth = 550;
	public int boardHeight = 700;
	Random random = new Random();
	JFrame frame = new JFrame("Tic-Tac-Toe");

	JPanel titlePanel = new JPanel();
	JLabel titleText = new JLabel();
	EntryPanel entryPanel = new EntryPanel("Play");

	JPanel informationPanel = new JPanel();
	JLabel informationLabel = new JLabel();

	JPanel buttonPanel = new JPanel();
	JButton[] buttons = new JButton[9];

	boolean gameOver = false;
	String playerX = "X";
	String playerO = "O";
	String currentPlayer = playerX;
	int turn = 1;



	public TicTacToe (){

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(boardWidth,boardHeight);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);


		titleText = new JLabel("Tic-Tac-Toe");
		titleText.setBackground(new Color(25, 25, 25));
		titleText.setForeground(new Color(255, 255, 153));
		titleText.setFont(new Font("Tekton", Font.BOLD, 60));
		titleText.setHorizontalAlignment(JLabel.CENTER);
		titleText.setOpaque(true);

		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 600, 75);
		titlePanel.add(titleText);


		//Text displayed on bottom --> it changes
		informationLabel.setBackground(new Color(46,139,87));
		informationLabel.setForeground(new Color(255,255,153));
		informationLabel.setFont(new Font("Arial",Font.BOLD,60));
		informationLabel.setHorizontalAlignment(JLabel.CENTER);
		informationLabel.setOpaque(true);
		informationLabel.setVisible(true);

		informationPanel.setLayout(new BorderLayout());
		informationPanel.setBounds(0, 0, 600, 75);
		informationPanel.add(informationLabel);


		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150,150,150));
		for(int i=0;i<9;i++){
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);

			buttons[i].setBackground(Color.WHITE);
			buttons[i].setForeground(Color.white);
			buttons[i].setFont(new Font("Roboto",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);

		}
		entryPanel.setOpaque(true);
		entryPanel.setFocusable(false);
		entryPanel.setVisible(true);
		frame.getContentPane().add(entryPanel);
		frame.add(titlePanel,BorderLayout.NORTH);
		frame.add(buttonPanel,BorderLayout.CENTER);
		frame.add(informationPanel,BorderLayout.SOUTH);
		firstTurn();
	}

	//@Override
	public void actionPerformed(ActionEvent e) {

		for(int i=0;i<9;i++) {
			if(e.getSource() == buttons[i]) {
				if(currentPlayer.equals(playerX)) {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(48,252,3));
						buttons[i].setText(currentPlayer);
						checkWin();
						if(!gameOver && turn < 10) {
							currentPlayer = playerO;
							setInformationText(currentPlayer+"'s turn");
						}
						else if (turn == 10 && !gameOver)
							setTie();
					}
				}
				else {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(252,157,3));
						buttons[i].setText(currentPlayer);
						checkWin();
						if(!gameOver && turn < 10) {
							currentPlayer = playerX;
							setInformationText(currentPlayer+"'s turn");
						}
						else if (turn == 10 && !gameOver)
							setTie();
					}
				}
			}
		}

	}


	private void setInformationText(String text){
		informationLabel.setText(text);
	}

	private void firstTurn() {
		if(random.nextInt(2)==0) {
			currentPlayer = playerX;
			setInformationText(currentPlayer+" 's Turn.");
		}
		else {
			currentPlayer = playerO;
			setInformationText(currentPlayer+" 's Turn.");
		}
	}
	private void checkWin() {
		turn++;
		// Horizontal
		if(buttons[0].getText()==buttons[1].getText() &&
				buttons[1].getText()==buttons[2].getText() &&
				buttons[2].getText() != ""
				) {
			if(currentPlayer == playerX) 
				xWin(0,1,2);
			else
				oWin(0,1,2);
		}
		if(buttons[3].getText()==buttons[4].getText() &&
				buttons[4].getText()==buttons[5].getText() &&
				buttons[5].getText() != ""
				) {
			if(currentPlayer == playerX) 
				xWin(3,4,5);
			else
				oWin(3,4,5);
		}
		if(buttons[6].getText()==buttons[7].getText() &&
				buttons[7].getText()==buttons[8].getText() &&
				buttons[8].getText() != ""
				) {
			if(currentPlayer == playerX) 
				xWin(6,7,8);
			else
				oWin(6,7,8);
		}

		//vertical
		if(buttons[0].getText()==buttons[3].getText() &&
				buttons[3].getText()==buttons[6].getText() &&
				buttons[6].getText() != ""
				) {
			if(currentPlayer == playerX) 
				xWin(0,3,6);
			else
				oWin(0,3,6);
		}
		if(buttons[1].getText()==buttons[4].getText() &&
				buttons[4].getText()==buttons[7].getText() &&
				buttons[7].getText() != ""
				) {
			if(currentPlayer == playerX) 
				xWin(1,4,7);
			else
				oWin(1,4,7);
		}
		if(buttons[2].getText()==buttons[5].getText() &&
				buttons[5].getText()==buttons[8].getText() &&
				buttons[8].getText() != ""
				) {
			if(currentPlayer == playerX) 
				xWin(2,5,8);
			else
				oWin(2,5,8);
		}
		// Diagonally
		if(buttons[0].getText()==buttons[4].getText() &&
				buttons[4].getText()==buttons[8].getText() &&
				buttons[8].getText() != ""
				) {
			if(currentPlayer == playerX) 
				xWin(0,4,8);
			else
				oWin(0,4,8);
		}
		if(buttons[2].getText()==buttons[4].getText() &&
				buttons[4].getText()==buttons[6].getText() &&
				buttons[6].getText() != ""
				) {
			if(currentPlayer == playerX) 
				xWin(2,4,6);
			else
				oWin(2,4,6);
		}
		return;
	}


	private void xWin(int i, int j, int k) {
		buttons[i].setBackground(new Color(143,221,242));
		buttons[j].setBackground(new Color(143,221,242));
		buttons[k].setBackground(new Color(143,221,242));

		for(int x=0;x<9;x++) {
			buttons[x].setEnabled(false);
		}
		gameOver = true;
		setInformationText(currentPlayer+" has won.");
		return;
	}
	private void oWin(int i, int j, int k) {
		buttons[i].setBackground(new Color(143,221,242));
		buttons[j].setBackground(new Color(143,221,242));
		buttons[k].setBackground(new Color(143,221,242));

		for(int o=0;o<9;o++) {
			buttons[o].setEnabled(false);
		}
		gameOver = true;
		setInformationText(currentPlayer+" has won.");
		return;
	}
	private void setTie() {
		for(int i = 0;i < 9;i++) {
			buttons[i].setBackground(Color.gray);
			buttons[i].setForeground(Color.orange);
		}
		setInformationText("its a Tie!");
		gameOver = true;
		return;
	}
	

}
