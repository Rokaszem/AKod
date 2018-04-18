
public class site {
	public static void generateSite(String[][] playerpos){
		
		int h,i,j,k,b;
		
		//1-2 sor
		for (h = 5; h > 3; h--) {
			for (i = 0; i < 7; i++) {
				if(playerpos[h-1][i].equals("0")) {
					System.out.print("[ ]");
				}
			}
			System.out.println("");
		}
		//3 sor
		System.out.print("   ");
		for (j = 0; j < 5; j++) {
			if(playerpos[3][j].equals("0")) {
				System.out.print("[ ]");
			}
		}
		System.out.println();
		//4-5 sor
		for (k = 2; k > 0; k--) {
			System.out.print("      ");
			for (b = 0; b < 3; b++) {
				if(playerpos[k-1][b].equals("0")) {
					System.out.print("[ ]");
				}
			}
			System.out.println();
		}
		//6 sor
		if(playerpos[5][3].equals("0")) {
			System.out.print("         [ ]");
		}else if(playerpos[5][3].equals("Y")) {
			System.out.print("         [Y]");
		}

	}
}
