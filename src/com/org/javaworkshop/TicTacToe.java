package com.org.javaworkshop;

import java.util.Scanner;

public class TicTacToe {

	private static Scanner sc = new Scanner(System.in);
	private static char playerMark;
	private static char computerMark;
	private static char[] gameBoard;

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
		int position;
		System.out.println("Enter the pos for user move");
		position = sc.nextInt();
		userMove(position);
		toss();
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
	public static void userMove(int position) {

		if (position < 1 && position > 9 && gameBoard[position] != ' ') {
			System.out.println("Invalid position, enter again ");
			position = sc.nextInt();
			userMove(position);
		} else {
			gameBoard[position] = playerMark;
			System.out.println("valid user position");
			showBoard(gameBoard);
		}
//		return position;
	}

	public static void toss() {
		int random = (Math.random() <= 0.5) ? 1 : 2;
		
		if(random==1)
		{
			System.out.println("Computer Start");
			computerMark = (Math.random() <= 0.5) ? 'X' : 'O';
			playerMark =   (computerMark == 'X') ? 'O' : 'X';
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
}
