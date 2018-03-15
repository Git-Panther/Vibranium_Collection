package practice3;

import java.util.Scanner;

import practice2.Book;

public class TestBookManagerMap {
	private static Scanner sc = new Scanner(System.in);
	private static final int ERROR = Integer.MIN_VALUE; 
	private static BookManagerMap manager = new BookManagerMap();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice = ERROR;
		String key =  null;
		
		while(true) {
			choice = ERROR; // 매번 초기화
			key = null;
			System.out.println("*** 도서 관리 프로그램 ***");
			System.out.println("1. 새 도서 추가");
			System.out.println("2. 도서 정보 정렬 후 출력");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 검색 출력");
			System.out.println("5. 전체 출력");
			System.out.println("6. 끝내기");
			
			System.out.print("메뉴 선택 : ");
			try {
				choice = sc.nextInt();
			} catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				continue;
			} finally {
				sc.nextLine(); // 엔터 읽기
			}
			
			switch(choice) {
			case 1:
				try {
					manager.putBook(inputBook());
					System.out.println("새 도서가 추가되었습니다.");
				} catch(Exception e) {
					System.out.println("도서를 추가할 수 없습니다!");
				} 
				break;
			case 2:
				if(manager.getBookCount() != 0)
					manager.printBookMap(manager.sortedBookMap());
				else
					System.out.println("도서 정보가 하나도 없습니다!");
				break;
			case 3:
				if(manager.getBookCount() != 0) {
					if(manager.getBookCount() > 1) {
						System.out.print("삭제할 도서명을 입력하세요 : ");
						try {
							key = manager.searchBook(inputBookTitle());
							if(key != null) {
								manager.printBook(key);
								manager.removeBook(key);
								System.out.println("해당 도서를 삭제했습니다.");
							}
							else
								throw new Exception(); // 삭제 실패시 던진다.
							
						} catch(Exception e) {
							System.out.println("해당 도서는 존재하지 않습니다.");
						}
						
//						System.out.print("삭제할 도서 번호를 입력하세요(0~" + (manager.sortedBookList().length - 1) + ") : ");
//						try {
//							manager.deleteBook(sc.nextInt());
//							System.out.println("해당 도서를 삭제했습니다.");
//						} catch(Exception e) {
//							System.out.println("잘못 입력하셨습니다.");
//							continue;
//						} finally {
//							sc.nextLine(); // 엔터 읽기
//						}
					} else {
						manager.printBook(manager.sortedBookMap()[0].getbNo()); // 출력하는 책 삭제
						manager.removeBook(manager.sortedBookMap()[0].getbNo());
						System.out.println("저장된 도서가 위의 1개뿐입니다. 그 도서를 삭제했습니다.");
					}
				} else {
					System.out.println("도서 정보가 하나도 없습니다!");
				}
				break;
			case 4:
				if(manager.getBookCount() != 0) {
					System.out.print("검색할 도서명을 입력하세요 : ");
					try {
						key = manager.searchBook(inputBookTitle());
						if( key != null)
							manager.printBook(key);
						else
							throw new Exception(); // 검색 실패시 던진다.
					} catch(Exception e) {
						System.out.println("해당 도서는 존재하지 않습니다.");
					}
				} else {
					System.out.println("도서 정보가 하나도 없습니다!");
				}
				break;
			case 5:
				if(manager.getBookCount() != 0)
					manager.displayAll();
				else
					System.out.println("도서 정보가 하나도 없습니다!");
				break;
			case 6:
				System.out.println("도서 관리 프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
			
		}
		
	}

	public static Book inputBook() {
		String bNo =  null;
		int category = ERROR;
		String title = null;
		String author = null;
		
		while(true) {
			System.out.print("도서 번호(숫자 4자) : ");
			try {
				bNo = sc.nextLine();
				if(bNo.length() == 0 || !(bNo.matches("^\\d{4}$")) ){ // 숫자가 아니거나 4자가 아니면
					throw new Exception();
//					System.out.println("도서 번호 형식 4자로 맞춰야 합니다.");
				} else if(!manager.hasNoDuplicatebNo(bNo)) {
					System.out.println("해당 도서 번호를 가진 책이 이미 존재합니다.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("도서 번호를 잘못 입력하셨습니다.");
				continue;
			}
			
		}
		
		while(true) {
			System.out.print("도서 분류 코드(1. 인문 / 2. 자연과학 / 3. 의료 / 4. 기타) : ");
			try {
				category = sc.nextInt();
				if(category < 1 || category > 4) { 
					throw new Exception();
				}
				break;
			} catch(Exception e) {
				System.out.println("카테고리를 잘못 입력하셨습니다.");
				continue;
			} finally {
				sc.nextLine();
			}
			
		}
		
		while(true) {
			System.out.print("책 제목 : ");
			try {
				title = sc.nextLine();
				if(title.length() == 0 || title.matches("^[ ]+.*$") ) { // 책 제목 앞에 공백이 있다면, 또는 길이가 0이면
					throw new Exception();
				} else if(!manager.hasNoDuplicateTitle(title)) {
					System.out.println("이미 같은 이름의 책이 저장되어 있습니다.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("책 제목을 잘못 입력하셨습니다.");
				continue;
			}
			
		}
		
		while(true) {
			System.out.print("저자 : ");
			try {
				author = sc.nextLine();		
				if(author.length() == 0
						|| !(author.matches("^[가-힣]{2,5}$") || author.matches("^[a-zA-Z]{1}[a-zA-Z ]{5,31}$")) ) { // 이름 앞에 공백 또는 한글이나 영문 형식에 안 맞으면
					throw new Exception();
				}
				break;
			} catch(Exception e) {
				System.out.println("저자명을 잘못 입력하셨습니다.");
				continue;
			}
			
		}
		
		return new Book(bNo, category, title, author);
	}
	
	public static String inputBookTitle() {
		return sc.nextLine(); // sc.nextLine()과의 차이가 없다.
	}
}
