package tictac;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		char v;
		final char x = 'x'; // define constant
		final char o = 'o';

		//
		char[][] xoArray = new char[3][3]; // Declaring and Creating array of character
		initializing(xoArray);// passing array to method to initializing
		v = x;// set initial value
		do {
			System.out.println(v + "  chose your location  ");
			int n = input.nextInt();
			int m = input.nextInt();
			xoArray[n][m] = v; // Choosing locations in game
			printArray(xoArray);// passing array to method to print
			if (v == x) {
				v = o;
			} else {
				v = x;
			} // exchange players

		} while (check(xoArray) == true);// Infinite loop until wins or draw

		if (v == x) {
			v = o;
		} else {
			v = x;
		}

		if ((checkRows(xoArray)) || (checkColumn(xoArray)) || (checkX(xoArray))) {
			System.out.println("The winner is   " + v);
		} else if (isFull(xoArray)) {
			System.out.println("The game is tie");
		}

	}

	// set intial symbol for xoArray
	public static char[][] initializing(char array[][]) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j] = '-';
			}
		}
		return array;

	}

	// print the result
	public static void printArray(char array[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				System.out.print(array[i][j] + " ");
			System.out.println();
		}
	}

	// method to check win or draw
	public static boolean check(char a[][]) {
		if (checkRows(a))
			return false;
		if (checkColumn(a))
			return false;
		if (checkX(a))
			return false;
		if (isFull(a))
			return false;
		return true;
	}

	// check if array is full without winner

	public static boolean isFull(char[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == '-') {
					return false;
				}

			}
		}
		return true;
	}
	// check if any row is full with x or o

	public static boolean checkRows(char a[][]) {
		for (int i = 0; i < a.length; i++) {
			//
			if (((a[i][0] == a[i][1]) && (a[i][1] == a[i][2]) && (a[i][2] == 'x' || a[i][2] == 'o'))) {
				return true;
			}
		}
		return false;
	}

	// check if any column is full with x or o

	public static boolean checkColumn(char a[][]) {
		for (int i = 0; i < a.length; i++) {
			if (((a[0][i] == a[1][i]) && (a[1][i] == a[2][i]) && (a[2][i] == 'x' || a[2][i] == 'o'))) {
				return true;
			}
		}
		return false;
	}
	// check if any main diagonals is full with x or o

	public static boolean checkX(char a[][]) {
		if (((a[0][0] == a[1][1]) && (a[1][1] == a[2][2]) && (a[2][2] == 'x' || a[2][2] == 'o'))
				|| ((a[0][2] == a[1][1]) && (a[1][1] == a[2][0]) && (a[0][2] == 'x' || a[0][2] == 'o'))) {
			return true;
		}
		return false;
	}
}
