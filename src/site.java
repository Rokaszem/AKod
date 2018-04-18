
public class site {
	public static void generateSite(String[][] playerpos){
		
		int h,i,j,k,b;
		
		//1-2 sor
		for (h = 6; h > 4; h--) {
			for (i = 1; i < 8; i++) {
				//if(playerpos[h-1][i].equals("0")) {
					System.out.print("["+playerpos[h-1][i]+"]");
				//}
			}
			System.out.println("");
		}
		//3 sor
		System.out.print("   ");
		for (j = 1; j < 6; j++) {
			//if(playerpos[3][j].equals("0")) {
				System.out.print("["+playerpos[3][j]+"]");
			//}
		}
		System.out.println();
		//4-5 sor
		for (k = 3; k > 1; k--) {
			System.out.print("      ");
			for (b = 1; b < 4; b++) {
				//if(playerpos[k-1][b].equals("0")) {
					System.out.print("["+playerpos[k-1][b]+"]");
				//}
			}
			System.out.println();
		}
		//6 sor
		/*if(playerpos[0][0].equals("0")) {
			System.out.print("         [ ]");
		}else if(playerpos[0][0].equals("Y")) {*/
			System.out.print("         ["+playerpos[0][0]+"]");
		//}

	}
}

/*	if(playerpos[7][x].equals("Y")){
 *		end 
 *
 * 	}
*/