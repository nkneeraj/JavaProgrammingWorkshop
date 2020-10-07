package com.org.javaworkshop;

import java.util.Scanner;

public class TicTacToe {

	private static Scanner sc = new Scanner(System.in);
	private static char playerMark;
	private static char computerMark;
	
	//master
	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe Game");
		char[] gameBoard = createBoard();
		
		System.out.println("Enter player Mark");
		playerMark = playerMark();
		computerMark = (playerMark== 'X')? 'O':'X';
		System.out.println("Player Mark: "+ playerMark);
		System.out.println("Computer mark: "+ computerMark);
	}

	//UC1 
	public static char[] createBoard() {
		char[] gameBoard = new char[10];
		for (int i = 0; i < 10; i++) {
			gameBoard[i] = ' ';
		}
		return gameBoard;
	}
	
	public static char playerMark()
	{
		System.out.println("Choose player option from 'X' & 'O'");
		String player = sc.next();
		char playerMark = player.charAt(0);
		return playerMark;
	}
}
