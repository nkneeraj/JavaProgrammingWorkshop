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

		position = sc.nextInt();
		playerMove(position);
		computerMove();
		showBoard(gameBoard);
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
	public static void playerMove(int pos) {
		if (position < 1 && position > 9 && gameBoard[position] != ' ') {
			System.out.println("Invalid position, enter again ");
			position = sc.nextInt();
			playerMove(position);
		} else {
			gameBoard[position] = playerMark;
			System.out.println("valid user position");
			showBoard(gameBoard);
			win(playerMark);
		}
//		return position;
	}

	// UC6
	public static void toss() {

		int random = (Math.random() <= 0.5) ? 1 : 2;
		if (random == 1) {
			System.out.println("Computer Start");
			playerMark = playerMark();
			computerMark = (playerMark == 'X') ? 'O' : 'X';
		} else {
			System.out.println("Player Start");
			playerMark = playerMark();
			computerMark = (playerMark == 'X') ? 'O' : 'X';
		}
		System.out.println("Player Mark: " + playerMark);
		System.out.println("Computer mark: " + computerMark);
	}

	// UC7 Win
	public static boolean win(char Mark) {
		if (gameBoard[1] == gameBoard[2] && gameBoard[1] == gameBoard[3] && gameBoard[1] == Mark
				|| gameBoard[4] == gameBoard[5] && gameBoard[4] == gameBoard[6] && gameBoard[4] == Mark
				|| gameBoard[7] == gameBoard[8] && gameBoard[7] == gameBoard[9] && gameBoard[7] == Mark
				|| gameBoard[1] == gameBoard[4] && gameBoard[1] == gameBoard[7] && gameBoard[1] == Mark
				|| gameBoard[2] == gameBoard[5] && gameBoard[2] == gameBoard[8] && gameBoard[2] == Mark
				|| gameBoard[3] == gameBoard[6] && gameBoard[9] == gameBoard[3] && gameBoard[3] == Mark
				|| gameBoard[1] == gameBoard[5] && gameBoard[1] == gameBoard[9] && gameBoard[1] == Mark
				|| gameBoard[3] == gameBoard[5] && gameBoard[9] == gameBoard[3] && gameBoard[3] == Mark) {
			return true;
		} else
			return false;
	}

	// UC8 Computer Move
	public static void computerMove() {
		int position = winPosition(computerMark);
		if (position != 0) {
			System.out.println("Computer position at:" + position);
			gameBoard[position] = computerMark;
		} else {
			System.out.println("No winning position, picking random value.");
			int random = (int) (Math.random() * 10) % 9 + 1;
			int marked = 0;
			while (marked == 0) {
				if (gameBoard[random] == ' ') {
					gameBoard[random] = computerMark;
					marked = 1;
					showBoard(gameBoard);
				}
			}
		}
	}

	public static int winPosition(char Mark) {

		int position = 0;
		for (int i = 1; i < gameBoard.length && gameBoard[i] == ' '; i++) {
			boolean win = false;
			gameBoard[i] = Mark;
			win = win(Mark);
			if (win == true) {
				gameBoard[i] = ' ';
				return i;
			}
		}
		return position;
	}

	// UC9 Block Opponent Move
	public static int blockOpponent(char Mark) {
		int position = winPosition(Mark);
		if (position != 0) {
			gameBoard[position] = (Mark == 'X') ? 'O' : 'X';
		}
		return position;
	}

	// UC10 take corners
	public static int cornerPosition() {
		if (winPosition(playerMark) == 0 && winPosition(computerMark) == 0) {
			if (gameBoard[1] == ' ')
				return (int) 1;
			else if (gameBoard[3] == ' ')
				return (int) 3;
			else if (gameBoard[7] == ' ')
				return (int) 7;
			else if (gameBoard[9] == ' ')
				return (int) 9;
		}
		return 0;
	}
}
