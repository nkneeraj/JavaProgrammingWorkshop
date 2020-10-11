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
	public static void playerMove(int position) {
		if (position < 1 || position > 9 || gameBoard[position] != ' ') {
			System.out.println("Invalid position, enter again ");
			position = sc.nextInt();
			sc.nextLine();
			playerMove(position);
		} else {
			gameBoard[position] = playerMark;
			System.out.println("valid user position");
			showBoard(gameBoard);
			if (win(playerMark)) {
				System.out.println("Player won");
				return;
			}

			computerMove();
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
			System.out.println("Player Mark: " + playerMark);
			System.out.println("Computer mark: " + computerMark);
			computerMove();
		} else {
			System.out.println("Player Start");
			playerMark = playerMark();
			computerMark = (playerMark == 'X') ? 'O' : 'X';
			System.out.println("Player Mark: " + playerMark);
			System.out.println("Computer mark: " + computerMark);
			System.out.println("Player turn, enter position:");
			int pos = sc.nextInt();
			sc.nextLine();
			playerMove(pos);
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
				|| gameBoard[3] == gameBoard[5] && gameBoard[7] == gameBoard[3] && gameBoard[3] == Mark) {
			System.out.println(Mark + "Won");
			return true;
		} else if (gameBoard[1] == gameBoard[2] && gameBoard[1] == gameBoard[3] && gameBoard[1] != ' '
				|| gameBoard[4] == gameBoard[5] && gameBoard[4] == gameBoard[6] && gameBoard[4] != ' '
				|| gameBoard[7] == gameBoard[8] && gameBoard[7] == gameBoard[9] && gameBoard[7] != ' '
				|| gameBoard[1] == gameBoard[4] && gameBoard[1] == gameBoard[7] && gameBoard[1] != ' '
				|| gameBoard[2] == gameBoard[5] && gameBoard[2] == gameBoard[8] && gameBoard[2] != ' '
				|| gameBoard[3] == gameBoard[6] && gameBoard[9] == gameBoard[3] && gameBoard[3] != ' '
				|| gameBoard[1] == gameBoard[5] && gameBoard[1] == gameBoard[9] && gameBoard[1] != ' '
				|| gameBoard[3] == gameBoard[5] && gameBoard[7] == gameBoard[3] && gameBoard[3] != ' ') {
			System.out.println("Tie");
		}
		return false;
	}

	// UC8 Computer Move
	public static void computerMove() {
		int position = winPosition(computerMark);
		if (position != 0) {
			System.out.println("Computer position at:" + position);
			gameBoard[position] = computerMark;
			System.out.println("Computer won");
			return;
		} else if (winPosition(playerMark) != 0) {
			gameBoard[winPosition(playerMark)] = computerMark;
			showBoard(gameBoard);
			if (win(computerMark)) {
				System.out.println("Computer won");
				return;
			}
			System.out.println("Player turn, enter position");
			int pos = sc.nextInt();
			sc.nextLine();
			playerMove(pos);
		} else if (cornerPosition() != 0) {
			gameBoard[cornerPosition()] = computerMark;
			showBoard(gameBoard);
			if (win(computerMark)) {
				System.out.println("Computer won");
				return;
			}
			System.out.println("Player turn, enter position");
			int pos = sc.nextInt();
			sc.nextLine();
			playerMove(pos);
		} else if (sidePosition() != 0) {
			gameBoard[sidePosition()] = computerMark;
			showBoard(gameBoard);
			if (win(computerMark)) {
				System.out.println("Computer won");
				return;
			}
			System.out.println("Player turn, enter position");
			int pos = sc.nextInt();
			sc.nextLine();
			playerMove(pos);
		}
	}

	public static int winPosition(char Mark) {

		int position = 0;
		for (int i = 1; i < gameBoard.length && gameBoard[i] == ' '; i++) {
			gameBoard[i] = Mark;
			if (win(Mark)==true) {
				gameBoard[i] = ' ';
				System.out.println("Win pos"+i);
				position = i;
				return i;
			} else
				gameBoard[i] = ' ';
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

	// UC11 if corners not available then take centre and then sides.
	public static int sidePosition() {

		if (cornerPosition() == 0) {
			if (gameBoard[5] == ' ')
				return (int) 5;
			if (gameBoard[2] == ' ')
				return (int) 2;
			else if (gameBoard[4] == ' ')
				return (int) 4;
			else if (gameBoard[6] == ' ')
				return (int) 6;
			else if (gameBoard[8] == ' ')
				return (int) 8;
		}
		return 0;
	}
}
