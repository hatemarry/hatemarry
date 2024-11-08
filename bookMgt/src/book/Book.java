package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Book {
	Scanner sc = new Scanner(System.in);

	private String bNo;

	private String bTitle;

	private String bAuthor;

	private String bGenre;

	private boolean bAvailable;

	private ArrayList bookList = new ArrayList();

	public Book() {

//		Book book = new Book();
//		this.bookList.add(book);
	}
	
	public void setbookList() {		
		
		Book book = new Book();
		this.bookList.add(book);
	}	

	public String getbNo() {
		return bNo;
	}

	public void setbNo(String bNo) {
		this.bNo = bNo;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbAuthor() {
		return bAuthor;
	}

	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	public String getbGenre() {
		return bGenre;
	}

	public void setbGenre(String bGenre) {
		this.bGenre = bGenre;
	}

	public boolean isbAvailable() {
		return bAvailable;
	}

	public void setbAvailable(boolean bAvailable) {
		this.bAvailable = bAvailable;
	}

	public void showMain() throws InterruptedException {
		while (true) {
			System.out.println("Welcome to the Library");
			System.out
					.println("[1] 도서 등록\t [2] 전체 조회\t [3] 개별 조회\t [4] 책 정보 수정\t [5] 책 삭제\t [6] 도서 반납 및 대여\t[0] 종료");
			String userInput = sc.nextLine();

			int userin = Integer.parseInt(userInput);

			switch (userin) {
			case (1):
				insertBook();
				break;

			case (2):
				selectAll();
				break;
			case (3):
				selectOne();
				break;

			case (4):
				updateBook();
				break;
			case (5):
				deletebook();
				break;
			case (6):
				checkBook();
				break;
			case (0):
				System.out.println("프로그램 종료");
				sc.close();
				System.exit(0);
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
				break;
			}

		} // end while
	}

	public void insertBook() throws InterruptedException {
		while (true) {
			Book book = new Book();

			// 도서 번호는 중복되면 안 됨
			while (true) {
				int cnt = 0;
				System.out.println("도서 번호 입력");
				String temp = sc.nextLine();
				for (int i = 0; i < bookList.size(); i++) {

					Book bookSc = new Book();
					bookSc = new Book();
					bookSc = (Book) bookList.get(i);

					if (temp.equals(bookSc.getbNo())) {
						cnt++;
						System.out.println("도서 번호 중복입니다. 다시 입력하세요.");
						break;
					} // end if
				} // end for
				if (cnt == 0) {
					book.setbNo(temp);
					break;
				}
			} // end while
			System.out.println("책 제목 입력");
			book.setbTitle(sc.nextLine());
			System.out.println("작가 입력");
			book.setbAuthor(sc.nextLine());
			System.out.println("장르 입력");
			book.setbGenre(sc.nextLine());
			book.setbAvailable(true);
			Thread.sleep(1000);

			// 컨펌 후에 리스트에 객체 저장
			System.out.println("도서번호 : " + book.getbNo());
			System.out.println("도서제목 : " + book.getbTitle());
			System.out.println("지 은 이  : " + book.getbAuthor());
			System.out.println("장     르  : " + book.getbGenre());
			System.out.println("대여가능 : " + book.isbAvailable());

			System.out.println("입력하신 사항이 모두 맞습니까? 예(Y) 아니오(N)");
			String confirm = sc.nextLine();
			if (confirm.equalsIgnoreCase("y")) {
				bookList.add(book);
				System.out.println("======입력 완료=====");
				break;
			} else if (confirm.equalsIgnoreCase("n")) {
				System.out.println("도서 정보를 새로 입력하세요.");
			} else {
				System.out.println("잘못 누르셨습니다. 초기 메뉴로 이동합니다");
				break; // 초기메뉴로 이동
			} // if-else end
		} // end while

		Thread.sleep(1000);
	}// end main

	public void selectAll() throws InterruptedException {
		while (true) {
			System.out.println("보유 도서량:  " + bookList.size());

			for (int i = 0; i < bookList.size(); i++) {

				Book bookSc = new Book();
				bookSc = (Book) bookList.get(i);

				System.out.println("===============================");
				System.out.println("책 번호 : " + bookSc.getbNo());
				System.out.println("책 제목 : " + bookSc.getbTitle());
				System.out.println("지은이  : " + bookSc.getbAuthor());
				System.out.println("장   르  : " + bookSc.getbGenre());
				System.out.println("대여가능 : " + bookSc.isbAvailable());
				System.out.println("===============================\n");

			} // end for
			System.out.println("초기 메뉴 이동 : [b] \t 프로그램 종료 : [0]");
			String temp = sc.nextLine();
			if (temp.equalsIgnoreCase("b")) {
				break;
			} else if (temp.equals("0")) {
				System.out.println("프로그램을 종료합니다.");
				Thread.sleep(1000);
				System.exit(0);
			} else {
				System.out.println("잘못 누르셨습니다. 초기화면으로 이동합니다.");
				Thread.sleep(1000);
				break; // 메인으로 돌아감
			} // if-else end
		} // while end
	}// end selectAll 

	public void selectOne() {
		while (true) {
			System.out.println("검색 할 책의 번호를 입력해주세요");
			String temp = sc.nextLine();
			int cnt = 0;
			for (int i = 0; i < bookList.size(); i++) {

				Book bookSc = new Book();
				bookSc = (Book) bookList.get(i);

				if (temp.equals(bookSc.getbNo())) {
					System.out.println("===============================");
					System.out.println("책 번호 : " + bookSc.getbNo());
					System.out.println("책 제목 : " + bookSc.getbTitle());
					System.out.println("지은이  : " + bookSc.getbAuthor());
					System.out.println("장   르  : " + bookSc.getbGenre());
					System.out.println("대여가능 : " + bookSc.isbAvailable());
					System.out.println("===============================\n");
					cnt++;
					break;
				}
			} // end for
			if (cnt == 0) {
				System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요.");
			} else {
				break;// 메인으로
			}

		} // end while
	}

	public void updateBook() {
		while (true) {
			System.out.println("수정 할 책의 번호를 입력해주세요");
			String temp = sc.nextLine();
			int cnt = 0;
			for (int i = 0; i < bookList.size(); i++) {

				Book bookSc = new Book();
				bookSc = (Book) bookList.get(i);

				if (temp.equals(bookSc.getbNo())) {
					System.out.println("새로운 제목 입력: ");
					bookSc.setbTitle(sc.nextLine());
					System.out.println("새로운 지은이 입력: ");
					bookSc.setbAuthor(sc.nextLine());
					System.out.println("새로운 장르 입력: ");
					bookSc.setbGenre(sc.nextLine());
					cnt++;
					System.out.println("도서 수정 완료");
					break;
				}
			} // end for
			if (cnt == 0) {
				System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요.");
			} else {
				break;// 메인으로
			}
		} // end while
	}

	public void deletebook() {
		while (true) {
			System.out.println("삭제 할 책의 번호를 입력해주세요");
			String temp = sc.nextLine();
			int cnt = 0;
			for (int i = 0; i < bookList.size(); i++) {

				Book bookSc = new Book();
				bookSc = (Book) bookList.get(i);

				if (temp.equals(bookSc.getbNo())) {
					bookList.remove(i);
					cnt++;
					System.out.println("도서 삭제 완료");
					break;
				}
			} // end for
			if (cnt == 0) {
				System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요.");
			} else {
				break;// 메인으로
			}
		} // end while

	} // end delete book

	public void checkBook() {
		while (true) {
			System.out.println("해당 도서 번호를 입력해주세요");
			String temp = sc.nextLine();
			int cnt = 0;
			for (int i = 0; i < bookList.size(); i++) {

				Book bookSc = new Book();
				bookSc = (Book) bookList.get(i);

				if (temp.equals(bookSc.getbNo())) {
					cnt++;
					boolean bStatus = bookSc.isbAvailable();

					if (bStatus) {
						bStatus = false;
						System.out.println("도서가 대여되었습니다.");
					} else {
						bStatus = true;
						System.out.println("도서가 반납되었습니다.");
					}
					bookSc.setbAvailable(bStatus);
					break;
				}
			} // end for
			if (cnt == 0) {
				System.out.println("해당 도서가 존재하지 않습니다. 도서 번호를 다시 입력하세요.");
			} else {
				break;// 메인으로
			}
		} // end while

	}

}