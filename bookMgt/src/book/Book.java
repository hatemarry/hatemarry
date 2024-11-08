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
					.println("[1] ���� ���\t [2] ��ü ��ȸ\t [3] ���� ��ȸ\t [4] å ���� ����\t [5] å ����\t [6] ���� �ݳ� �� �뿩\t[0] ����");
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
				System.out.println("���α׷� ����");
				sc.close();
				System.exit(0);
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
				break;
			}

		} // end while
	}

	public void insertBook() throws InterruptedException {
		while (true) {
			Book book = new Book();

			// ���� ��ȣ�� �ߺ��Ǹ� �� ��
			while (true) {
				int cnt = 0;
				System.out.println("���� ��ȣ �Է�");
				String temp = sc.nextLine();
				for (int i = 0; i < bookList.size(); i++) {

					Book bookSc = new Book();
					bookSc = new Book();
					bookSc = (Book) bookList.get(i);

					if (temp.equals(bookSc.getbNo())) {
						cnt++;
						System.out.println("���� ��ȣ �ߺ��Դϴ�. �ٽ� �Է��ϼ���.");
						break;
					} // end if
				} // end for
				if (cnt == 0) {
					book.setbNo(temp);
					break;
				}
			} // end while
			System.out.println("å ���� �Է�");
			book.setbTitle(sc.nextLine());
			System.out.println("�۰� �Է�");
			book.setbAuthor(sc.nextLine());
			System.out.println("�帣 �Է�");
			book.setbGenre(sc.nextLine());
			book.setbAvailable(true);
			Thread.sleep(1000);

			// ���� �Ŀ� ����Ʈ�� ��ü ����
			System.out.println("������ȣ : " + book.getbNo());
			System.out.println("�������� : " + book.getbTitle());
			System.out.println("�� �� ��  : " + book.getbAuthor());
			System.out.println("��     ��  : " + book.getbGenre());
			System.out.println("�뿩���� : " + book.isbAvailable());

			System.out.println("�Է��Ͻ� ������ ��� �½��ϱ�? ��(Y) �ƴϿ�(N)");
			String confirm = sc.nextLine();
			if (confirm.equalsIgnoreCase("y")) {
				bookList.add(book);
				System.out.println("======�Է� �Ϸ�=====");
				break;
			} else if (confirm.equalsIgnoreCase("n")) {
				System.out.println("���� ������ ���� �Է��ϼ���.");
			} else {
				System.out.println("�߸� �����̽��ϴ�. �ʱ� �޴��� �̵��մϴ�");
				break; // �ʱ�޴��� �̵�
			} // if-else end
		} // end while

		Thread.sleep(1000);
	}// end main

	public void selectAll() throws InterruptedException {
		while (true) {
			System.out.println("���� ������:  " + bookList.size());

			for (int i = 0; i < bookList.size(); i++) {

				Book bookSc = new Book();
				bookSc = (Book) bookList.get(i);

				System.out.println("===============================");
				System.out.println("å ��ȣ : " + bookSc.getbNo());
				System.out.println("å ���� : " + bookSc.getbTitle());
				System.out.println("������  : " + bookSc.getbAuthor());
				System.out.println("��   ��  : " + bookSc.getbGenre());
				System.out.println("�뿩���� : " + bookSc.isbAvailable());
				System.out.println("===============================\n");

			} // end for
			System.out.println("�ʱ� �޴� �̵� : [b] \t ���α׷� ���� : [0]");
			String temp = sc.nextLine();
			if (temp.equalsIgnoreCase("b")) {
				break;
			} else if (temp.equals("0")) {
				System.out.println("���α׷��� �����մϴ�.");
				Thread.sleep(1000);
				System.exit(0);
			} else {
				System.out.println("�߸� �����̽��ϴ�. �ʱ�ȭ������ �̵��մϴ�.");
				Thread.sleep(1000);
				break; // �������� ���ư�
			} // if-else end
		} // while end
	}// end selectAll 

	public void selectOne() {
		while (true) {
			System.out.println("�˻� �� å�� ��ȣ�� �Է����ּ���");
			String temp = sc.nextLine();
			int cnt = 0;
			for (int i = 0; i < bookList.size(); i++) {

				Book bookSc = new Book();
				bookSc = (Book) bookList.get(i);

				if (temp.equals(bookSc.getbNo())) {
					System.out.println("===============================");
					System.out.println("å ��ȣ : " + bookSc.getbNo());
					System.out.println("å ���� : " + bookSc.getbTitle());
					System.out.println("������  : " + bookSc.getbAuthor());
					System.out.println("��   ��  : " + bookSc.getbGenre());
					System.out.println("�뿩���� : " + bookSc.isbAvailable());
					System.out.println("===============================\n");
					cnt++;
					break;
				}
			} // end for
			if (cnt == 0) {
				System.out.println("�ش� ������ �������� �ʽ��ϴ�. ���� ��ȣ�� �ٽ� �Է��ϼ���.");
			} else {
				break;// ��������
			}

		} // end while
	}

	public void updateBook() {
		while (true) {
			System.out.println("���� �� å�� ��ȣ�� �Է����ּ���");
			String temp = sc.nextLine();
			int cnt = 0;
			for (int i = 0; i < bookList.size(); i++) {

				Book bookSc = new Book();
				bookSc = (Book) bookList.get(i);

				if (temp.equals(bookSc.getbNo())) {
					System.out.println("���ο� ���� �Է�: ");
					bookSc.setbTitle(sc.nextLine());
					System.out.println("���ο� ������ �Է�: ");
					bookSc.setbAuthor(sc.nextLine());
					System.out.println("���ο� �帣 �Է�: ");
					bookSc.setbGenre(sc.nextLine());
					cnt++;
					System.out.println("���� ���� �Ϸ�");
					break;
				}
			} // end for
			if (cnt == 0) {
				System.out.println("�ش� ������ �������� �ʽ��ϴ�. ���� ��ȣ�� �ٽ� �Է��ϼ���.");
			} else {
				break;// ��������
			}
		} // end while
	}

	public void deletebook() {
		while (true) {
			System.out.println("���� �� å�� ��ȣ�� �Է����ּ���");
			String temp = sc.nextLine();
			int cnt = 0;
			for (int i = 0; i < bookList.size(); i++) {

				Book bookSc = new Book();
				bookSc = (Book) bookList.get(i);

				if (temp.equals(bookSc.getbNo())) {
					bookList.remove(i);
					cnt++;
					System.out.println("���� ���� �Ϸ�");
					break;
				}
			} // end for
			if (cnt == 0) {
				System.out.println("�ش� ������ �������� �ʽ��ϴ�. ���� ��ȣ�� �ٽ� �Է��ϼ���.");
			} else {
				break;// ��������
			}
		} // end while

	} // end delete book

	public void checkBook() {
		while (true) {
			System.out.println("�ش� ���� ��ȣ�� �Է����ּ���");
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
						System.out.println("������ �뿩�Ǿ����ϴ�.");
					} else {
						bStatus = true;
						System.out.println("������ �ݳ��Ǿ����ϴ�.");
					}
					bookSc.setbAvailable(bStatus);
					break;
				}
			} // end for
			if (cnt == 0) {
				System.out.println("�ش� ������ �������� �ʽ��ϴ�. ���� ��ȣ�� �ٽ� �Է��ϼ���.");
			} else {
				break;// ��������
			}
		} // end while

	}

}