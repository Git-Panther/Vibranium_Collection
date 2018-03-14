package practice2;

import java.util.Comparator;

public class AscCategory implements Comparator<Book> { // 오름차순

	@Override
	public int compare(Book arg0, Book arg1) {
		// TODO Auto-generated method stub
		return arg0.getCategory() - arg1.getCategory(); // 앞 값이 더 크면 바꾼다
	}

}
