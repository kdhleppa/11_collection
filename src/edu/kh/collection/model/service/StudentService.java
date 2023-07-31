package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Student;

public class StudentService {
	
	private Scanner sc = new Scanner(System.in);
	
	// 학생 정보를 저장할 List 생성
	
	// java.util.List 인터페이스 : List 에 반드시 필요한 필수 기능을 모아둔 인터페이스
	// * 인터페이스 객체 생성 X, 부모 참조변수 O
	
	// java.util.ArrayList : 배열 형태 List (가장 대표적인 List의 자식 클래스)
	
	// ArrayList() 기본생성자 : 기본 크기 10 짜리 리스트 생성
	//							-> 하지만 리스트는 크기가 늘었다 줄었다 하기때문에 큰 의미 없음.
	// ArrayList(용량) : 용량만큼의 리스트 생성
	// 					-> 너무 큰값을 작성하면 메모리를 많이 소모함.;
	
	// private List<Student> studentList = new ArrayList<Student>(); // 검색(조회)에 효율적
	private List<Student> studentList = new LinkedList<Student>(); // 데이터 추가, 수정, 삭제에 효율적
	
	// Student 로 저장되는 타입이 제한된 리스트 생성
	// == Student만 저장 가능 == 모든게 Student
	// == Student임을 검사할 필요가 없다.
	
	public StudentService() {
		studentList.add(new Student("홍길동", 25, "서울시 중구", 'm', 90));
		studentList.add(new Student("고영희", 23, "경기도 안산시", 'f', 100));
		studentList.add(new Student("강아지", 30, "서울시 강남구", 'm', 80));
		studentList.add(new Student("오미나", 27, "충북 청주시", 'f', 90));
		studentList.add(new Student("박주희", 24, "서울시 서대문구", 'f', 70));
		
	}
	
	
	
	/* public void ex() {
		// List 테스트
		
		// List.add(Object e) : 리스트에 객체를 추가
		// * 매개변수 타입이 Object == 모든 객체 매개변수로 전달할 수 있음
		
		
		studentList.add(new Student()); // 0번 인덱스
		//studentList.add(sc); // 1번
		//studentList.add("문자열"); // 2번
		//studentList.add(new Object()); // 3번
		// -> 컬렉션 특징 : 여러 타입의 데이터를 저장할 수 있다.
		
		// (반환형)
		// Object List.get(index i) : 리스트에서 i번째 인덱스에 있는 객체를 반환
		
		
		if (studentList.get(0) instanceof Student ) {
			System.out.println(( (Student)studentList.get(0) ).getName() );
		}
		// 제네릭스 (Generics)
		// 보통 제네릭
		// -> 컬렉션에 저장되는 객체 타입을 한가지로 제한
		System.out.println( studentList.get(0).getName());
		
	}
	*/
	
	
	
	
	
	// 메뉴 출력용 메서드
	/**
	 * alt + shift + j
	 * 메서드 설명용 주석
	 * @author leppa
	 * 
	 */
	public void displayMenu() {
		
		int menuNum = 0;
		
		do {
			
			System.out.println("\n============학생 관리 프로그램===========");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 학생 정보 제거");
			System.out.println("5. 이름으로 검색(일치)");
			System.out.println("6. 이름으로 검색(포함)");
			
			System.out.println("0. 프로그램 종료");
			
			System.out.print("\n메뉴 번호 선택 >>");
			
			
			try {
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum) {
				case 1: System.out.println( addStudent() );break;
				case 2:  selectAll() ;break;
				case 3: System.out.println(updateStudent());break;
				case 4: System.out.println(removeStudent());break;
				case 5: System.out.println(searchName1()); break;
				case 6: searchName2(); break;
				case 0: System.out.println("프로그램 종료...");break;
				default : System.out.println("메뉴에 작성된 번호만 입력해주세요.");
				
				}
				
			} catch(InputMismatchException e) {
				System.out.println("\nerror : 입력형식이 유효하지 않습니다. 다시 시도해주세요.");
				sc.nextLine(); // 입력 버퍼에 남아있는 잘못된 문자열 제거
				menuNum = -1; // 첫 반복시 잘못 입력하는 경우
				// menuNum 이 0을 가지고 있어 종료되는데 이를 방지하기 위해서 임의값 -1 대입
				
			}
			
		}while (menuNum != 0);
		
		
	}
	
	/**
	 * 1. 학생 정보 추가 메서드
	 * - 추가 성공 시 "성공" 실패 시 "실패 문자열 반환
	 */
	public String addStudent() {
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("지역 : ");
		sc.next();
		
		String region = sc.nextLine();
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		System.out.print("점수: ");
		int score = sc.nextInt();
		
		if ( studentList.add(new Student(name,age,region,gender,score)) ) {
			return "성공";
		} else {
			return "실패";
		}
	}
	
	public void selectAll() throws InputMismatchException {
		System.out.println("===전체조회===");
		if (studentList.isEmpty()) {
			System.out.println("정보가 없습니다.");
			return;
		}
		int index = 0;
		for ( Student std : studentList) {
			System.out.print(index++ +"번째 인덱스");
			System.out.println(std);
			
		}return;
	}
	
	public String updateStudent() throws InputMismatchException{
		System.out.println("===회원수정===");
		System.out.print("수정할 인덱스 넘버 : ");
		int input = sc.nextInt();
		
		if (studentList.isEmpty()) {
			return "정보가 없습니다.";
		} else if( input < 0) {
			return "잘못 입력하셨습니다.";
		} else if ( input >= studentList.size()){	
			return "범위를 초과하였습니다.";
		} else {
			System.out.print(input + "번째 회원 정보\n");
			System.out.println(studentList.get(input));
			
			System.out.print("수정할 이름 : ");
			String name = sc.next();
			System.out.print("수정할 나이 : ");
			int age = sc.nextInt();
			System.out.print("수정할 지역 : ");
			sc.next();
			
			String region = sc.nextLine();
			System.out.print("수정할 성별(M/F) : ");
			char gender = sc.next().charAt(0);
			System.out.print("수정할 점수: ");
			int score = sc.nextInt();
			
			Student temp = studentList.set(input, new Student(name, age, region, gender, score));
			return temp.getName() + "의 정보가 수정되었습니다.";
			
		}
		
		// 수정할 정보 인덱스 넘버 입력
		
	}
	
	public String removeStudent () throws InputMismatchException{
		System.out.print("제거할 인덱스 넘버 : ");
		int input = sc.nextInt();
		
		if (studentList.isEmpty()) {
			return "정보가 없습니다.";
		} else if (input < 0) {
			return "잘못 입력하셨습니다.";
		}  else if ( input >= studentList.size()) {	
			return "범위를 초과하였습니다.";
		} else {
		
		
			System.out.print("정말 제거하시겠습니까?(Y/N) : ");
			char input2 = sc.next().toUpperCase().charAt(0);
		
			if ( input2 == 'Y') {
				Student temp = studentList.remove(input);
				return temp.getName() + "의 정보가 제거되었습니다.";
			} else {
				return "종료...";
			}
		
		}
	}
	
	
	public String searchName1() {
		System.out.print("찾을사람을 입력하세요 : ");
		String input = sc.next();
		for (int i = 0; i< studentList.size(); i++) {
			
			if ( studentList.get(i).getName().equals(input)) {
				return studentList.get(i).toString();
			} 
		}
		return "정보가 없습니다";
		
	}
	
	public void searchName2() {
		
		System.out.print("찾을 문자열을 입력하세요 : ");
		String input = sc.next();
		boolean flag = true;
		for (Student std : studentList) {
			if (std.getName().contains(input)) {
				System.out.println(std);
				flag = false;
			}
			
		}
		if (flag) {
			System.out.println("찾는 문자열이 없습니다.");
		}
	}
}
