package practice2;

import java.util.Comparator;

public class DescCategory implements Comparator<Book> { // 내림차순

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o2.getCategory() - o1.getCategory(); // 뒤의 값이 앞보다 크면 바꿈
	}

}
