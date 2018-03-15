package practice3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import practice2.Book;

public class BookManagerMap {
	private HashMap<String, Book> booksMap; // 키는 도서번호
	
	public BookManagerMap() {
		booksMap = new HashMap<String, Book>();
		putBook(new Book("1357", 4, "SKT는 어떻게 몰락했는가", "이현우"));
		putBook(new Book("5959", 1, "단유기", "김의중"));
		putBook(new Book("6974", 3, "완벽한 편이야", "PraY"));
	}
	
	public BookManagerMap(HashMap<String, Book> booksMap) {
		this.booksMap = booksMap;
	}
	
	public void putBook(Book book) {
		booksMap.put(book.getbNo(), book);
	}
	
	public void removeBook(String key) {
		booksMap.remove(key);
	}
	
	public String searchBook(String bTitle) {
		Book book = null; // 찾고 있는 책
		Iterator<Entry<String, Book>> itr = booksMap.entrySet().iterator();
		while(itr.hasNext()) {
			book = itr.next().getValue();
			if(book.getTitle().equals(bTitle))
				return book.getbNo(); // 책 번호가 키값이므로 책 번호 반환
		}
		
		return null; // 못 찾았을 때
	}
	
	public void displayAll() {
		Iterator<String> itr = booksMap.keySet().iterator();
		while(itr.hasNext()) {
			System.out.println(booksMap.get(itr.next()));
		}
		
	}
	
	public Book[] sortedBookMap() { 
		List<Book> bookList = new LinkedList<Book>();
		Iterator<Entry<String, Book>> itr = booksMap.entrySet().iterator();
		while(itr.hasNext()) {
			bookList.add(itr.next().getValue()); // 책들을 리스트에 우선 옮긴다.
		}
		
		if(bookList.size() > 1) { // 두 개 이상일 경우에만 정렬
			bookList.sort(new Comparator<Book>() { // 도서명 오름차순

				@Override
				public int compare(Book b1, Book b2) {
					// TODO Auto-generated method stub
					return b1.getTitle().compareTo(b2.getTitle());
				}
			});
		}
		
		return bookList.toArray(new Book[bookList.size()]);
	}
	
	public void printBookMap(Book[] br) {
		for(Book book : br) {
			System.out.println(book);
		}
	}
	
	public void printBook(String key) {
		System.out.println(booksMap.get(key));
	}
	
	public boolean hasNoDuplicateTitle(String title) { // 책 이름 중복이 없는지 검사. 중복 없으면 true
		Iterator<String> itr = booksMap.keySet().iterator();
		while(itr.hasNext()) {
			if(booksMap.get(itr.next()).getTitle().equals(title)) // 타이틀 중에 중복이 있다면
				return false;
		}
		
		return true;
	}
	
	public boolean hasNoDuplicatebNo(String bNo) { // 책 번호 중복이 없는지 검사. 중복 없으면 true
		Iterator<String> itr = booksMap.keySet().iterator(); // 도서번호가 키값이므로 직접 부딪쳐본다.
		while(itr.hasNext()) {
			if(itr.next().equals(bNo)) // 북 넘버 중에 중복이 있다면
				return false;
		}
		
		return true;
	}
	
	public int getBookCount() {
		return booksMap.size();
	}
}
