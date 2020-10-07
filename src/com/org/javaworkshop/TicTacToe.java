package com.org.javaworkshop;

import java.util.Scanner;

public class TicTacToe {

	private static Scanner sc = new Scanner(System.in);
	private static char playerMark;
	private static char computerMark;
	private static char[] gameBoard;
	private static int position;

	// master
	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe Game");
		gameBoard = createBoard();
		
		toss();
//		System.out.println("Enter player Mark");
//		playerMark = playerMark();
//		computerMark = (playerMark == 'X') ? 'O' : 'X';
//		System.out.println("Player Mark: " + playerMark);
//		System.out.println("Computer mark: " + computerMark);
		
		showBoard(gameBoard);

//		position = sc.nextInt();
//		userMove(position);
		
	}

	// UC1
	public static char[] createBoard() {
		char[] gameBoard = new char[10];
		for (int i = 0; i < 10; i++) {
			gameBoard[i] = ' ';
		}
		return gameBoard;
	}

	// UC2
	public static char playerMark() {
		System.out.println("Enter player mark from 'X' & 'O'");
		String player = sc.next();
		char playerMark = player.charAt(0);
		return playerMark;
	}

	// UC3
	public static void showBoard(char[] gameBoard) {
		System.out.println("ShowBoard");
		for (int i = 0; i < (gameBoard.length) / 3; i++) {
			System.out.println("Line:" + (i + 1) + ": " + gameBoard[i * 3 + 1] + "|" + gameBoard[3 * i + 2] + "|"
					+ gameBoard[3 * i + 3]);
		}
	}

	// UC4 & UC5
	public static void userMove(int pos) {
		if (position < 1 && position > 9 && gameBoard[position] != ' ') {
			System.out.println("Invalid position, enter again ");
			position = sc.nextInt();
			userMove(position);
		} else {
			gameBoard[position] = playerMark;
			System.out.println("valid user position");
			showBoard(gameBoard);
			win();
		}
//		return position;
	}
	
	//UC6
	public static void toss() {

		int random = (Math.random() <= 0.5) ? 1 : 2;		
		if(random==1)
		{
			System.out.println("Computer Start");
			playerMark =  playerMark();
			computerMark = (playerMark == 'X') ? 'O' : 'X';
		}
		else
		{
			System.out.println("Player Start");
			playerMark =  playerMark();
			computerMark = (playerMark == 'X') ? 'O' : 'X';
		}
		System.out.println("Player Mark: " + playerMark);
		System.out.println("Computer mark: " + computerMark);
	}
	
	//UC7 Win
	public static void win()
	{
		if(gameBoard[1]==gameBoard[2] && gameBoard[1]==gameBoard[3] && gameBoard[1] == playerMark
				|| gameBoard[4]==gameBoard[5] && gameBoard[4]==gameBoard[6] && gameBoard[4] == playerMark
				|| gameBoard[7]==gameBoard[8] && gameBoard[7]==gameBoard[9] && gameBoard[7] == playerMark
				|| gameBoard[1]==gameBoard[4] && gameBoard[1]==gameBoard[7] && gameBoard[1] == playerMark
				|| gameBoard[2]==gameBoard[5] && gameBoard[2]==gameBoard[8] && gameBoard[2] == playerMark
				|| gameBoard[3]==gameBoard[6] && gameBoard[9]==gameBoard[3] && gameBoard[3] == playerMark
				|| gameBoard[1]==gameBoard[5] && gameBoard[1]==gameBoard[9] && gameBoard[1] == playerMark
				|| gameBoard[3]==gameBoard[5] && gameBoard[9]==gameBoard[3] && gameBoard[3] == playerMark)
		{
			System.out.println("Player Win");
		}
		else if(gameBoard[1]==gameBoard[2] && gameBoard[1]==gameBoard[3] && gameBoard[1] != ' '
				|| gameBoard[4]==gameBoard[5] && gameBoard[4]==gameBoard[6] && gameBoard[4] != ' '
				|| gameBoard[7]==gameBoard[8] && gameBoard[7]==gameBoard[9] && gameBoard[7] != ' '
				|| gameBoard[1]==gameBoard[4] && gameBoard[1]==gameBoard[7] && gameBoard[1] != ' '
				|| gameBoard[2]==gameBoard[5] && gameBoard[2]==gameBoard[8] && gameBoard[2] != ' '
				|| gameBoard[3]==gameBoard[6] && gameBoard[9]==gameBoard[3] && gameBoard[3] != ' '
				|| gameBoard[1]==gameBoard[5] && gameBoard[1]==gameBoard[9] && gameBoard[1] != ' '
				|| gameBoard[3]==gameBoard[5] && gameBoard[9]==gameBoard[3] && gameBoard[3] != ' ')
		{
			System.out.println("Tie");
		}
	}
}
