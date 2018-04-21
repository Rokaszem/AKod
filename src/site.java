import java.util.Scanner;

public class site {
	public static void generateSite(String[][] playerpos) {

		int h, i, j, k, b;
		String cella="";

		// 1-2 sor
		for (h = 6; h > 4; h--) {
			for (i = 1; i < 8; i++) {
				switch(playerpos[h-1][i]) {
				case "0":
					cella="[ ]";
					break;
				case "X":
					cella="[X]";
					break;
				case "Y":
					cella="[Y]";
					break;
				}
				/*if(playerpos[h-1][i].equals("0")) {
					cella="[ ]";
				}else if(playerpos[h-1][i].equals("X")) {
					cella="[X]";
				}else if(playerpos[h-1][i].equals("Y")) {
					cella="[Y]";
				}*/
				System.out.print(cella);
			}
			System.out.println("");
		}
		// 3 sor
		System.out.print("   ");
		for (j = 2; j < 7; j++) {
			switch(playerpos[3][j]) {
			case "0":
				cella="[ ]";
				break;
			case "X":
				cella="[X]";
				break;
			case "Y":
				cella="[Y]";
				break;
			}
			/*if(playerpos[3][j].equals("0")) {
				cella="[ ]";
			}else if(playerpos[3][j].equals("X")) {
				cella="[X]";
			}else if(playerpos[3][j].equals("Y")) {
				cella="[Y]";
			}*/
			System.out.print(cella);
		}
		System.out.println();
		// 4-5 sor
		for (k = 3; k > 1; k--) {
			System.out.print("      ");
			for (b = 3; b < 6; b++) {
				switch(playerpos[k-1][b]) {
				case "0":
					cella="[ ]";
					break;
				case "X":
					cella="[X]";
					break;
				case "Y":
					cella="[Y]";
					break;
				}
				/*if(playerpos[k-1][b].equals("0")) {
					cella="[ ]";
				}else if(playerpos[k-1][b].equals("X")) {
					cella="[X]";
				}else if(playerpos[k-1][b].equals("Y")) {
					cella="[Y]";
				}*/
				System.out.print(cella);
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
		default:
			System.out.println("Irányítás: w - elõre | a - balra | d - jobbra");
			break;
		}
		return lepette;
	}
}