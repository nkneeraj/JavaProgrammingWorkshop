package com.org.javaworkshop;

public class TicTacToe {

	//master
	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe Game");
		char[] gameBoard = createBoard();
	}

	//UC1 
	public static char[] createBoard() {
		char[] gameBoard = new char[10];
		for (int i = 0; i < 10; i++) {
			gameBoard[i] = ' ';
		}
		return gameBoard;
	}
}
