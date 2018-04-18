import java.util.Scanner;

public class site {
	public static void generateSite(String[][] playerpos) {

		int h, i, j, k, b;

		// 1-2 sor
		for (h = 6; h > 4; h--) {
			for (i = 1; i < 8; i++) {
				// if(playerpos[h-1][i].equals("0")) {
				System.out.print("[" + playerpos[h - 1][i] + "]");
				// }
			}
			System.out.println("");
		}
		// 3 sor
		System.out.print("   ");
		for (j = 2; j < 7; j++) {
			// if(playerpos[3][j].equals("0")) {
			System.out.print("[" + playerpos[3][j] + "]");
			// }
		}
		System.out.println();
		// 4-5 sor
		for (k = 3; k > 1; k--) {
			System.out.print("      ");
			for (b = 3; b < 6; b++) {
				// if(playerpos[k-1][b].equals("0")) {
				System.out.print("[" + playerpos[k - 1][b] + "]");
				// }
			}
			System.out.println();
		}
		// 6 sor
		System.out.print("         [" + playerpos[0][4] + "]");

	}

	public static boolean Lep(String[][] playerps, int[] pos, Scanner sca) {
		String irany = sca.next();
		boolean lepette=false;
		switch (irany) {
		case "w":
			if (playerps[pos[0] + 1][pos[1]].equals("0")) {
				playerps[pos[0] + 1][pos[1]] = "Y";
				playerps[pos[0]][pos[1]]="X";
				lepette=true;
				break;
			} else if (playerps[pos[0] + 1][pos[1]].equals("X")) {
				System.out.println("Oda nem lephet!");
				break;
			}
		case "a":
			if (playerps[pos[0]][pos[1] - 1].equals("0")) {
				playerps[pos[0]][pos[1] - 1] = "Y";
				playerps[pos[0]][pos[1]]="X";
				lepette=true;
				break;
			} else if (playerps[pos[0]][pos[1] - 1].equals("X")) {
				System.out.println("Oda nem lephet!");
				break;
			}
		case "d":
			if (playerps[pos[0]][pos[1] + 1].equals("0")) {
				playerps[pos[0]][pos[1] + 1] = "Y";
				playerps[pos[0]][pos[1]]="X";
				lepette=true;
				break;
			} else if (playerps[pos[0]][pos[1] + 1].equals("X")) {
				System.out.println("Oda nem lephet!");
				break;
			}
		}
		return lepette;
	}
}

/*
 * if(playerpos[7][x].equals("Y")){ end
 *
 * }
 */