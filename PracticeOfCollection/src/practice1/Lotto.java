package practice1;

import java.util.Set;
import java.util.TreeSet;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lottoDisplay();
	}
	
	public static void lottoDisplay() {
		Set<Integer> lottoSet = new TreeSet<>(); // 자동 정렬해주는 Set
		while(lottoSet.size() != 6) { // 6개가 채워질 때까지
			lottoSet.add( (int)(Math.random() * 45 + 1) );
		}
		
		Integer[] intArr = lottoSet.toArray(new Integer[6]); // Integer 배열로 반환
		for(int num : intArr) {
			System.out.println(num);
		}
		
	}
}
