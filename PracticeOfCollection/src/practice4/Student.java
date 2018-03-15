package practice4;

public class Student {
	private int sNo; // 학생번호
	private String sName;
	private int kor, eng, mat, tot, avg;
	
	public Student() {}

	public Student(int sNo, String sName, int kor, int eng, int mat, int tot, int avg) {
		this.sNo = sNo;
		this.sName = sName;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = tot;
		this.avg = avg;
	}

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "|"+sNo+"|"+sName+"|"+kor+"|"+eng+"|"+mat+"|"+tot+"|"+avg+"|";
	}
	
}
