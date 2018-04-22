/**
 * 
 * @author Toth Istvan
 * 
 * @version 1.0
 *
 */
public class questionGiver {
	int id;
	String question;
	String answer1;
	String answer2;
	String answer3;
	String answer4;
	String realanswer;

	public questionGiver(int id, String question, String answer1, String answer2, String answer3, String answer4,
			String realanswer) {
		super();
		this.id = id;
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.realanswer = realanswer;
	}

	@Override
	public String toString() {
		return question + "\n1: " + answer1 + "\n2: " + answer2 + "\n3: " + answer3 + "\n4: " + answer4;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getRealanswer() {
		return realanswer;
	}

	public void setRealanswer(String realanswer) {
		this.realanswer = realanswer;
	}
	
}
