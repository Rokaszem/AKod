import java.io.File;
import java.io.FileNotFoundException;
import java.text.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		String asd = "asd";
		double score = 0;
		String[][] playerps = new String[9][9];
		ArrayList<String> kodlista=new ArrayList<String>();
		int[] pos = new int[2];
		int lepesekszama=1;
		DecimalFormat df=new DecimalFormat("0");
		// i a sor
		int i = 0;
		// k az oszlop
		int k = 0;
		for (i = 0; i < 9; i++) {
			for (k = 0; k < 9; k++) {
				playerps[i][k] = "0";
				if (k == 0 || k == 8 || ((k == 1 || k == 7) && i <= 3) || ((k == 2 || k == 6) && i <= 2)
						|| ((k == 3 || k == 5) && i == 0) || (i==6)) {
					playerps[i][k] = "X";
				}

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
		if (sc.hasNextLine()) {

			
			while (true) {
				System.out.println("Kódlista: "+kodlista);
				
				site.generateSite(playerps);
				System.out.println();
				System.out.println();
				pos = WhereAmI(playerps);
				if (ask(ql, sc, kodlista)) {
					while (!site.Lep(playerps, pos, sc));
					score = pontozas(score, pos);
				} else {
					playerps[pos[0] + 1][pos[1]] = "X";
					if(elakadte(playerps,pos)) {
						score = 0;
						playerps=lokes(playerps,pos);
					}else {
						while (!site.Lep(playerps, pos, sc));
					}
				}
				lepesekszama++;
				for (k = 1; k < 8; k++) {
					if ((playerps[5][k].equals("Y") && elakadte(playerps,pos)) || (playerps[6][k].equals("Y") && lepesekszama>=8)) {
						score=vegjatek(score, sc, kodlista);
						System.out.println("Gratulálok! Az ön pontszáma: "+df.format(score));
						System.exit(1);
					}else if(playerps[6][k].equals("Y") && lepesekszama<8){
						while (!site.Lep(playerps, pos, sc));
					}
					if((playerps[5][k].equals("Y") && lepesekszama>=8)) {
						playerps[6][k]="0";
					}
				}
				System.out.println("Pontszám: " + df.format(score)+" Érintett mezõk: "+lepesekszama+" Kódlista.size:"+kodlista.size());
			}

		}
		sc.close();
	}

	private static boolean ask(questionGiver[] asd, Scanner sca,ArrayList<String> kodlista) {
		Random rand = new Random();
		int n = rand.nextInt(3559);
		System.out.println(asd[n].question);
		System.out.println("1: " + asd[n].answer1 + "\n2: " + asd[n].answer2 + "\n3: " + asd[n].answer3 + "\n4: "
				+ asd[n].answer4);
		String chosen=sca.next();
		if (chosen.equals(asd[n].realanswer)) {
			switch (asd[n].realanswer) {
			case "1":
				kodlista.add(asd[n].answer1);
				break;
			case "2":
				kodlista.add(asd[n].answer2);
				break;
			case "3":
				kodlista.add(asd[n].answer3);
				break;
			case "4":
				kodlista.add(asd[n].answer4);
				break;
			}
			System.out.println("Helyes válasz! Merre szeretne továbbhaladni?");
			return true;
		} else {
			kodlista.add(asd[n].answer1);
			kodlista.add(asd[n].answer2);
			kodlista.add(asd[n].answer3);
			kodlista.add(asd[n].answer4);
			System.out.println("Helytelen válasz! Merre szeretne továbbhaladni?");
			return false;
		}
	}

	private static int[] WhereAmI(String[][] playerpos) {
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

	private static double pontozas(double score, int[] pos) {
		switch (pos[0]) {
		case 0:
			score += 50;
			break;
		case 1:
			score += 100;
			break;
		case 2:
			score += 150;
			break;
		case 3:
			score += 200;
			break;
		case 4:
			score += 300;
			break;
		case 5:
			score += 500;
			break;
		}
		return score;
	}
	
	private static boolean elakadte(String[][] playerpos,int[] pos) {
		if(playerpos[pos[0]+1][pos[1]].equals("X")  &&
				playerpos[pos[0]][pos[1]+1].equals("X") && 
				playerpos[pos[0]][pos[1]-1].equals("X")) {
			return true;
		}
		return false;
	}
	private static String[][] lokes(String[][] playerpos,int[] pos) {
		playerpos[pos[0]+1][pos[1]]="Y";
		playerpos[pos[0]][pos[1]]="X";
		return playerpos;
	}
	private static double vegjatek(double score,Scanner sca,ArrayList<String> kodlista) {
		Random rand = new Random();
		int h=0;
		double n = 35+(50-35)*rand.nextDouble();
		double newscore= Math.round(score*(n/100));
		System.out.println("Garantált nyereménye: "+newscore+"\n Elfogadja, vagy szeretne KÓDOLNI? (e/k)");
		String valasz=sca.next();
		final int ALSIZE=kodlista.size();
		if(valasz.equals("e")) {
			return newscore;
		}else if(valasz.equals("k")){
			do{
				for(h=0;h<=ALSIZE;h++) {
					kodlista.remove(sca.nextLine());
				}
				if(kodlista.isEmpty()) {
					return score;
				}else if(!kodlista.isEmpty()) {

					System.out.println(kodlista);
					System.out.println("szavak: ");
					return 0;
				}
			}while(true);
		}else {
			return -2;
		}
	}
}
