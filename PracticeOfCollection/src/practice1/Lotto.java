package practice1;

import java.util.Set;
import java.util.TreeSet;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lottoDisplay();
	}
	
	public static void lottoDisplay() {
		Set<Integer> lottoSet = new TreeSet<>();
		while(lottoSet.size() != 6) {
			lottoSet.add( (int)(Math.random() * 45 + 1) );
		}
		
		Integer[] intArr = lottoSet.toArray(new Integer[6]);
		for(int num : intArr) {
			System.out.println(num);
		}
		
	}
}
