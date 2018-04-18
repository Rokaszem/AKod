
public class playerProgress {
	public int sor;
	public int oszlop;
	//public String[][] pos = new String[sor][oszlop];

	
	public playerProgress() {
		/*for(int i=0;i<5;i++) {
			for(int k=0;k<6;k++) {
				pos[i][k]="0";
			}
		}
		pos[5][3]="Y";*/
	}
	
	public playerProgress(int sor,int oszlop) {
		this.sor=sor;
		this.oszlop=oszlop;
	}

	public int getSor() {
		return sor;
	}

	public void setSor(int sor) {
		this.sor = sor;
	}

	public int getOszlop() {
		return oszlop;
	}

	public void setOszlop(int oszlop) {
		this.oszlop = oszlop;
	}

	public static String playerPos(boolean helyese) {

	return null;
	}
}
