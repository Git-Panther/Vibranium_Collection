package practice4;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestProperties test = new TestProperties();
		Student[] array = test.readFile();
		test.printConsole(array);
		test.saveXMLFile(array);
	}
	
	public Student[] readFile() {		
		Properties prop = new Properties();
		LinkedList<Student> students = null;
		
		try(BufferedReader reader = new BufferedReader(new FileReader("score.txt"));) {
			String line = null; // 한 줄
			String[] scoreString = null; // 스플릿한 거 저장
			Student student = null; // 학생 개개인. 메소드 호출이 너무 길어져서 만듬
			while( (line = reader.readLine()) != null) {
				scoreString = line.split(", ");
				if(scoreString.length != 5) // 잘못된 입력 파일이면
					throw new Exception("잘못된 파일입니다.");
					
				student = new Student();
				// 아쉽게도, 무조건 번호, 이름, 국영수 순으로 받아야 한다. 그게 한계
				student.setsNo(Integer.parseInt(scoreString[0]));
				student.setsName(scoreString[1]);
				student.setKor(Integer.parseInt(scoreString[2]));
				if(!isScore(student.getKor()))
					throw new Exception("잘못된 파일입니다.");
				student.setEng(Integer.parseInt(scoreString[3]));
				if(!isScore(student.getEng()))
					throw new Exception("잘못된 파일입니다.");
				student.setMat(Integer.parseInt(scoreString[4]));
				if(!isScore(student.getMat()))
					throw new Exception("잘못된 파일입니다.");
				// 합계, 평균 계산
				student.setTot(student.getKor() + student.getEng() + student.getMat());
				student.setAvg(student.getTot() / 3);
				
				prop.put(student.getsNo(), student);
			}
			students = new LinkedList<Student>();
			Iterator<Object> itr = prop.keySet().iterator();
			while(itr.hasNext()) {
				students.add((Student)prop.get(itr.next()));
			}
			return students.toArray(new Student[students.size()]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("입출력 과정에서 오류가 났습니다.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return null; // catch로 잡히면 null 반환
	}
	
	public void printConsole(Student[] sr) {
		if(sr != null) {
			int[] totalOfSubject = new int[] {0, 0, 0}; // 국영수 합계 각각
			
			System.out.println("|번호|이름|국어|영어|수학|합계|평균|");
			for(Student student : sr) {
				totalOfSubject[0] += student.getKor();
				totalOfSubject[1] += student.getEng();
				totalOfSubject[2] += student.getMat();
				System.out.println(student);
			}
			
			System.out.println("국어 합계 : " + totalOfSubject[0]);
			System.out.println("영어 합계 : " + totalOfSubject[1]);
			System.out.println("수학 합계 : " + totalOfSubject[2]);
			System.out.println("국어 평균 : " + totalOfSubject[0] / sr.length);
			System.out.println("영어 평균 : " + totalOfSubject[1] / sr.length);
			System.out.println("수학 평균 : " + totalOfSubject[2] / sr.length);
		} else {
			
		}
		
	}
	
	public void saveXMLFile(Student[] sr) {
		if(sr != null) {
			Properties prop = new Properties();
			for(Student student : sr) {
				prop.setProperty(String.valueOf(student.getsNo()), student.toString());
			}
			
			try(BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("student.xml"));) {
//			try(FileOutputStream stream = new FileOutputStream("student.xml");)	{	
				prop.storeToXML(stream, "Student Score"); // OutputStream만 가능
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("파일을 찾을 수 없습니다.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("입출력 과정에서 오류가 났습니다.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
				
	}
	
	public boolean isScore(int score) {
		if(score > 100 || score < 0)
			return false;
		else
			return true;
	}
}
