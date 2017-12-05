package com.asad.xOGame;

import java.util.Scanner;

public class GameApplication {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Game game = new Game();
		System.out.println("welcom to  X O game.");
		System.out.println(game);
		System.out.println("enter first plyer name");
		String firstPlyerName = input.nextLine();
		System.out.println("your later is X");
		System.out.println("enter second plyer name");
		String secondPlyerName = input.nextLine();
		System.out.println("your later is O");
		GamerName gamersNames = new GamerName(firstPlyerName, secondPlyerName);

		boolean winner = false;
		while (!winner) {
			System.out.println(gamersNames.getFirstPlayerName() + " turn : X");
			boolean added = false;
			while (!added) {
				int firstPlayerXAxis = verifyCoordinatInput(input, "X");
				int firstPlayerYAxis = verifyCoordinatInput(input, "Y");
				added = game.addToTheBord("X", firstPlayerXAxis, firstPlayerYAxis);
				if (!added) {
					System.out.println("error the coordinat on the bord is not empty ");
				}
			}
			System.out.println(game);
			winner = game.winner("X");
			if (winner) {
				System.out.println(gamersNames.getFirstPlayerName() + " winner");
				return;
			}

			added = false;
			while (!added) {
				System.out.println(gamersNames.getSecondPlayerName() + " turn : O");
				int secondPlayerXAxis = verifyCoordinatInput(input, "X");
				int secondPlayerYAxis = verifyCoordinatInput(input, "Y");
				added = game.addToTheBord("O", secondPlayerXAxis, secondPlayerYAxis);
			}
			System.out.println(game);
			winner = game.winner("Y");
			if (winner) {
				System.out.println(gamersNames.getSecondPlayerName() + " winner");
				return;
			}
			if (winner = game.isTheBordFull()) {
				winner = true;
				System.out.println("it is a draw.....");
			}

		}

	}

	private static int verifyCoordinatInput(Scanner input, String coordinatAxsis) {
		boolean Verified = false;
		int coordinat = 0;
		while (!Verified) {
			System.out.print("enter the " + coordinatAxsis + " coordinat :");
			coordinat = input.nextInt();
			Verified = verifyCoordinatInput(coordinat);
		}
		return coordinat;
	}

	private static boolean verifyCoordinatInput(int Coordinat) {
		if (!(Coordinat >= 0 && Coordinat < 3)) {
			System.out.println("error coordinat most be in range of[0 - 2]");

			return false;
		}
		return true;
	}

}
