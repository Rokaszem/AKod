import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String[][] playerps = new String[6][7];

		for (int i = 0; i < 6; i++) {
			for (int k = 0; k < 7; k++) {
				playerps[i][k] = "0";
			}
		}
		playerps[5][3] = "Y";
		site.generateSite(playerps);
		System.out.println();
		System.out.println("---------------------");
		System.out.println("Udvozollek a Kod nevu jatekban!");
		System.out.println("Kezdeshez nyomj ENTER-t.");

		String[][] qs = new String[3559][6];
		Scanner scf = new Scanner(new File("kerdesekcsv.csv"));

		scf.useDelimiter(";");
		String helper;
		int i = 0;
		for (i = 0; i < 3559; i++) {
			helper = scf.nextLine();
			qs[i] = helper.split(";");
		}
		scf.close();
		questionGiver[] ql = new questionGiver[3559];

		for (i = 0; i < 3559; i++) {
			ql[i] = new questionGiver(i, qs[i][0], qs[i][1], qs[i][2], qs[i][3], qs[i][4], qs[i][5]);
		}

		Scanner sc = new Scanner(System.in);
		if (sc.hasNextLine()) {
			ask(ql);

		}

		sc.close();
	}

	public static void ask(questionGiver[] asd) {
		Random rand = new Random();
		int n = rand.nextInt(3559);
		System.out.println(asd[n].question);
		System.out.println("1: " + asd[n].answer1 + "\n2: " + asd[n].answer2 + "\n3: " + asd[n].answer3 + "\n4: "
				+ asd[n].answer4);
		Scanner sca = new Scanner(System.in);
		String chosen = sca.nextLine();
		if (chosen.equals(asd[n].realanswer)) {
			System.out.println("Helyes valasz!");
		} else {
			System.out.println("Helytelen valasz!");
		}
		sca.close();
	}

}
