package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import edu.kh.collection.model.vo.Book;

public class BookService {
	
	
	private Scanner sc = new Scanner(System.in);
	
	private List<Book> bookList = new LinkedList<Book>();
	private List<Book> bookList2 = new LinkedList<Book>();
	List<Book> arr = new ArrayList<Book>();
	Set<Book> arr2= new HashSet<Book>(arr);
	public BookService() {
		bookList.add(new Book(111, "수학의정석", "홍성대", 30000, "미상"));
		bookList.add(new Book(222, "미술", "피카소", 1360000, "미상"));
		bookList.add(new Book(333, "영어", "미국", 50000, "미상"));
	}
	
	public void dp () {
		int input = 0;
		
		do {
			System.out.println("1. 등록");
			System.out.println("2. 조회");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 좋아요등록");
			System.out.println("6. 좋아요삭제");
			System.out.println("7. 좋아요목록");
			
			System.out.println("0. 종료");
			System.out.print("\n메뉴 번호 선택 : ");
			
			try {
				input = sc.nextInt();
				System.out.println();
				
				switch(input) {
				case 1: System.out.println(addBook()); break;
				case 2: selectAll(); break;
				case 3: updateBook(); break;
				case 4: System.out.println(removeBook()); break;
				case 5: System.out.println(likeGood()); break;
				case 6: System.out.println(removeLike()); break;
				case 7: likeAll(); break;
				default : System.out.println("잘못입력했습니다.");
				}
				
			} catch(InputMismatchException e) {
				System.out.println("\n잘못입력하셨습니다.");
				sc.nextLine();
				input = -1;
			}
		
			
			
			
		} while(input != 0);
				
		
	}
	
	public String addBook() {
		System.out.print("도서번호 : ");
		int bookNum = sc.nextInt();
		
		System.out.print("도서명 : ");
		sc.nextLine();
		String bookName = sc.nextLine();
		
		System.out.print("저자명 : ");
		
		String author = sc.nextLine();
		System.out.print("가격 : ");
		int won = sc.nextInt();
		System.out.print("출판사 : ");
		sc.nextLine();
		String hs = sc.nextLine();
		
		if (bookList.add(new Book(bookName, author, won, hs))) {
			return "성공";
			
		} else {
			return "실패";
			
		}
		
	}
	
	public void selectAll() {
		System.out.println("=====도서목록=====");
		if (bookList.isEmpty()) {
			System.out.println("정보가 없습니다.");
			return;
			
		}
		for (Book bk : bookList) {
			System.out.println(bk);
		} return;
	}
	
	public String updateBook() throws InputMismatchException{
		System.out.println("=====도서정보수정=====");
		System.out.println("수정할 도서명의 번호를 입력해주세요");
		System.out.print("번호 : ");
		int serch1 = sc.nextInt();
		System.out.println(bookList.get(serch1));
		int input = 0;
		int index = 0;
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBookName().equals(serch1)) {
				index = i;
			
			}
		}
		if (input >= bookList.size() || input < 0) {
			return "정보가 없습니다";
		}
		
		do {
			System.out.println("수정할 정보를 선택하세요");
			System.out.println("1. 도서명");
			System.out.println("2. 저자명");
			System.out.println("3. 가격");
			System.out.println("4. 출판사");
			System.out.println("0. 종료");
			System.out.print("입력 : ");
			input = sc.nextInt();
			
			switch(input) {
			case 1: 
			System.out.print("수정할 도서명 : ");
			sc.nextLine();
			String bookName = sc.nextLine();
			bookList.get(index).setBookName(bookName);
			System.out.println("수정완료");
			break;
			case 2: 
			System.out.print("수정할 저자명 : ");
			sc.nextLine();
			String author = sc.nextLine();
			bookList.get(index).setAuthor(author);
			System.out.println("수정완료");
			break;
			case 3: 
			System.out.print("수정할 가격 : ");
			int won = sc.nextInt();
			bookList.get(index).setWon(won);
			System.out.println("수정완료");
			break;
			case 4: 
			System.out.print("수정할 출판사명 : ");
			sc.nextLine();
			String hs = sc.nextLine();
			bookList.get(index).setHs(hs);
			System.out.println("수정완료");
			break;
			default : System.out.println("입력오류");
			}
		} while (input != 0);
		
		return "";
		
		
	}
	
	public String removeBook() {
		System.out.print("제거할 책 번호 : ");
		int input = sc.nextInt();
		
		if (bookList.isEmpty()) {
			return "정보없음";
		} else if (input <0) {
			return "0보다 큰 수를 입력하세요.";
					
		} else if ( input >= bookList.size()) {
			return "범위 초과";
		} else {
			System.out.print("정말 제거하시겠습니까? (Y/N) : ");
			char input2 = sc.next().toUpperCase().charAt(0);
			
			if ( input2 == 'Y') {
				Book temp = bookList.remove(input);
				return temp.getBookName()+"책 정보가 제거되었습니다";
				
			} else {
				return "종료...";
			}
		}
		
		
			
	}
	public String likeGood() {
		
		// 가변되는 배열 설정
		// 책번호 입력 쌓이게하고
		// 이걸 토대로 불러와야 연동 
		// list.get(i).getbooknum.equals(arr.(j))
		// 이때 list 에 있는걸 불러오게해야 연동됨.
		boolean flag = true;

		
		System.out.println("좋아요 목록에 등록할 책 번호 : ");
		int input = sc.nextInt();
		
		for (int i = 0; i < bookList.size(); i++) {
			if (input == bookList.get(i).getBookNum()) {
				arr.add(new Book(input));
				flag = false;
				
			}
		}
		if (flag == true) {
			return "저장되었음";
		} else {
		return "없는번호";
		}
				
	}
	
	public String removeLike() throws InputMismatchException{
		System.out.println("좋아요 목록을 우선 확인해주세요");
		System.out.println("좋아요 목록에서 제거할 책 번호 : ");
				
		int input = sc.nextInt();
		
		if (bookList.isEmpty()) {
			return "정보없음";
		} else if (input <0) {
			return "0보다 큰 수를 입력하세요.";
					
		} else if ( input >= bookList2.size()) {
			return "범위 초과";
		} else {
			System.out.print("정말 제거하시겠습니까? (Y/N) : ");
			char input2 = sc.next().toUpperCase().charAt(0);
			
			if ( input2 == 'Y') {
				Book temp = bookList2.remove(input);
				return temp.getBookName()+"책 정보가 제거되었습니다";
				
			} else {
				return "종료...";
			}
		}
		
		
			
	}
	public void likeAll() {
		System.out.println("=====좋아요 도서목록=====");
		for (int i = 0; i < bookList.size(); i++) {
			for (int j = 0; j< arr2.size(); j++)
			if (bookList.get(i).getBookNum() == arr.get(j).getBookNum()) {
				System.out.println(bookList.get(i).toString());
			}
		}
		
		
		
		
		
		if (bookList2.isEmpty()) {
			System.out.println("정보가 없습니다.");
			return;
			
		}
		int index = 0;
		for (Book bk : bookList2) {
			System.out.print(index++ +"번 도서 : ");
			System.out.println(bk);
		} return;
	}

}
