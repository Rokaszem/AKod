import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc= new Scanner(System.in);
		String asd = "asd";
		int score = 0;
		boolean end = false;
		boolean helyese = false;
		String[][] playerps = new String[9][9];
		// i a sor
		int i = 0;
		// k az oszlop
		int k = 0;
		for (i = 0; i < 9; i++) {
			for (k = 0; k < 9; k++) {
				playerps[i][k] ="0";
				if (k == 0 || k == 8 || i == 6 || ((k==1 || k==7 ) && i<=3) || ((k==2 || k==6) && i<=2) || ((k==3 || k==5) && i==0) ) {
					playerps[i][k] = "X";
				}
				//if(((k==1 || k==7 ) && i<=3) || ((k==2 || k==6) && i<=2) || ((k==3 || k==5) && i==0) ) {
					
				
			}
		}
		playerps[0][4] = "Y";
		System.out.println("Udvozollek a Kod nevu jatekban!");
		System.out.println("Kezdeshez nyomj ENTER-t.");
		System.out.println("---------------------");

		String[][] qs = new String[3559][6];
		Scanner scf = new Scanner(new File("kerdesekcsv.csv"));

		scf.useDelimiter(";");
		String helper;
		for (i = 0; i < 3559; i++) {
			helper = scf.nextLine();
			qs[i] = helper.split(";");
		}
		scf.close();
		questionGiver[] ql = new questionGiver[3559];

		for (i = 0; i < 3559; i++) {
			ql[i] = new questionGiver(i, qs[i][0], qs[i][1], qs[i][2], qs[i][3], qs[i][4], qs[i][5]);
		}
		//Scanner sc = new Scanner(System.in);
		if (sc.hasNextLine()) {
			
			
			
			while (end == false) {
				site.generateSite(playerps);
				System.out.println();
				System.out.println();
				if (ask(ql,sc)) {
					int[] pos = new int[2];
					pos = WhereAmI(playerps);
					while(!site.Lep(playerps, pos, sc));
				} else {
					break;
				}

			}
			for (k = 1; k < 8; k++) {
				if (playerps[6][k].equals("Y")) {
					end = true;
				}
			}
			
			
			
			
		}
		sc.close();
	}

	public static boolean ask(questionGiver[] asd, Scanner sca) {
		Random rand = new Random();
		int n = rand.nextInt(3559);
		System.out.println(asd[n].question);
		System.out.println("1: " + asd[n].answer1 + "\n2: " + asd[n].answer2 + "\n3: " + asd[n].answer3 + "\n4: "
				+ asd[n].answer4);
		String chosen = sca.next();
		if (chosen.equals(asd[n].realanswer)) {
			System.out.println("Helyes válasz! Merre szeretne továbbhaladni?");
			return true;
		} else {
			System.out.println("Helytelen válasz! Merre szeretne továbbhaladni?");
			return false;
		}
	}

	public static int[] WhereAmI(String[][] playerpos) {
		int[] pos = new int[2];
		for (int i = 0; i < playerpos.length; i++) {
			for (int k = 0; k < playerpos[i].length; k++) {
				if (playerpos[i][k].equals("Y")) {
					pos[0] = i;
					pos[1] = k;
				}
			}
		}
		return pos;
	}
}
