
public class site {
	public static void generateSite(){
		for (int h = 0; h < 2; h++) {
			for (int i = 0; i < 7; i++) {
				System.out.print("[ ]");
			}
			System.out.println("");
		}

		System.out.print("   ");
		for (int i = 0; i < 5; i++) {
			System.out.print("[ ]");
		}
		System.out.println();

		for (int k = 0; k < 2; k++) {
			System.out.print("      ");
			for (int i = 0; i < 3; i++) {
				System.out.print("[ ]");
			}
			System.out.println();
		}

		System.out.print("         [ ]");

	}
}
