package com.qa.utils;

import java.util.Scanner;

public class Utils {

	private final Scanner scanner;

	public Utils(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public Utils() {
		scanner = new Scanner(System.in);
	}

	public int getInt() {
		int intInput = -1;
		do {
			String input = getString();
			try {
				intInput = Integer.parseInt(input);
			} catch (NumberFormatException nfe) {
				System.out.println("Error - Please enter a number");
			}
		} while (intInput == -1);
		return intInput;
	}

	public String getString() {
		return scanner.nextLine();
	}

	public Double getDouble() {
		Double doubleInput = null;
		do {
			String input = getString();
			try {
				doubleInput = Double.parseDouble(input);
			} catch (NumberFormatException nfe) {
				System.out.println("Error - Please enter a number");
			}
		} while (doubleInput == null);
		return doubleInput;
	}

}
