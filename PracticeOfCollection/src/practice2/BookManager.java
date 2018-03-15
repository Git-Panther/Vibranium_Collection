package practice2;

import java.util.ArrayList;
import java.util.Iterator;

public class BookManager { // 북 매니저
	private ArrayList<Book> bookList;

	public BookManager(ArrayList<Book> bookList) {
		this.bookList = bookList; // 다른 리스트를 전달받아 생성
	}

	public BookManager() {
		bookList = new ArrayList<Book>(); // 초기화
		bookList.add(new Book("1234", 3, "KSV", "Kevin Choo"));
		bookList.add(new Book("1111", 1, "킹존 드래곤 X", "강동훈"));
	}
	
	public void addBook(Book book) {
		bookList.add(book);
	}
	
	public void deleteBook(int index) {
		bookList.remove(index);
	}
	
	public int searchBook(String bTitle) {
		Iterator<Book> itr = bookList.iterator();
		Book book = null; // 찾은 책의 인덱스를 찾기 위한 객체 공간
		
		while(itr.hasNext()) {
			book = itr.next();
			if(book.getTitle().equals(bTitle))
				return bookList.indexOf(book); // 찾으면 반환
		}
		
		return Integer.MIN_VALUE; // 못 찾으면 이렇게 반환
	}
	
	public void printBook(int index) {
		System.out.println(bookList.get(index));
	}
	
	public void displayAll() {
		Iterator<Book> itr = bookList.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	@SuppressWarnings("unchecked")
	public Book[] sortedBookList() {
		ArrayList<Book> sortedList = (ArrayList<Book>) (bookList.clone());
		if(sortedList.size() > 1) { // 책이 두 개 이상일 경우에만 정렬
			sortedList.sort(new AscCategory());
		}
		
		return sortedList.toArray(new Book[sortedList.size()]);
	}
	
	public void printBookList(Book[] br) {
		for(Book book : br) {
			System.out.println(book);
		}
	}
	
	public boolean hasNoDuplicateTitle(String title) { // 책 이름 중복이 없는지 검사. 중복 없으면 true
		Iterator<Book> itr = bookList.iterator();
		while(itr.hasNext()) {
			if(itr.next().getTitle().equals(title)) // 타이틀 중에 중복이 있다면
				return false;
		}
		
		return true;
	}
	
	public boolean hasNoDuplicatebNo(String bNo) { // 책 번호 중복이 없는지 검사. 중복 없으면 true
		Iterator<Book> itr = bookList.iterator();
		while(itr.hasNext()) {
			if(itr.next().getbNo().equals(bNo)) // 북 넘버 중에 중복이 있다면
				return false;
		}
		
		return true;
	}
	
	public int getBookCount() {
		return bookList.size();
	}
}
