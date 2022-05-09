/**
 * @파일명 : PBMSystem.java
 * @프로젝트명 : HW#8
 * @날짜 : 2022. 5. 10.
 * @작성자 : 정광원
 * @프로그램설명 : 전화번호부 관리 프로그램
 */
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
class PhoneBook
{
	private String name;
	private String tel;
	private String email;
	PhoneBook(String name,String tel,String email){
		this.name = name;
		this.tel = tel;
		this.email = email;
	}
	public void printField() {
		System.out.println("이름 : "+this.name);
		System.out.println("전화번호 : "+this.tel);
		System.out.println("이메일 : "+this.email);
	}
	public String getTel() {return this.tel;}
	public void setTel(String tel) {this.tel = tel;}
}
class PBManager{
	HashMap<String,PhoneBook> bpm = new HashMap<String,PhoneBook>();
	Scanner s = new Scanner(System.in);
	public void addTel() {
		System.out.print("이름 >> ");
		String name = s.next();
		System.out.print("전화번호 >> ");
		String tel = s.next();
		System.out.print("이메일 >> ");
		String email = s.next();
		bpm.put(name, new PhoneBook(name,tel,email));
		System.out.println("추가 완료!");
	}
	public void deleteTel(String n) {
		if(bpm.isEmpty()) {
			System.out.println("전화번호부가 비었습니다.");
		}
		else {
			bpm.remove(n);
			System.out.println("삭제 완료!");
		}
	}
	public boolean findTel(String n) {
		if(bpm.containsKey(n)) {
			System.out.println(n+"의 전화번호 >> "+bpm.get(n).getTel());
			return true;
		}
		else {
			return false;
		}
	}
	public void changeTel(String n) {
		System.out.print("수정할 번호를 입력해주세요>> ");
		String tel = s.next();
		bpm.get(n).setTel(tel);
		System.out.println("수정 완료!");
	}
	public void printPB() {
		if(bpm.isEmpty()){
			System.out.println("전화번호부가 비었습니다.");
		}
		else {
			TreeMap<String,PhoneBook> tbpm = new TreeMap<String,PhoneBook>();
			Set <String> keys = bpm.keySet();
			for (String key :keys) {
				tbpm.put(key, bpm.get(key));
			}
			Iterator<String> it = tbpm.keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				tbpm.get(key).printField();
			}
			tbpm.clear();
		}
	}
	public void run() {
		while(true) {
			System.out.printf("(1)번호추가 (2)번호삭제 (3)이름별검색 "
					+ "(4)번호수정 (5)이름순모든번호출력 (6)종료%n>> ");
			int pick = s.nextInt();
			if(pick==1) {
				addTel();
			}
			else if(pick==2) {
				System.out.print("삭제할 번호 이름을 입력해주세요>> ");
				String n = s.next();
				deleteTel(n);
			}
			else if(pick==3) {
				System.out.print("찾을 이름을 입력해주세요>> ");
				String n = s.next();
				if(findTel(n)==false) {
					System.out.println("전화번호부가 비었습니다!");
				}
			}
			else if(pick==4) {
				System.out.print("수정할 이름을 입력해주세요>> ");
				String n = s.next();
				changeTel(n);
			}
			else if(pick==5) {
				printPB();
			}
			else if(pick==6) {
				s.close();
				System.out.println("프로그램 종료.....");
				break;
			}
		}
	}
}
public class PBMSystem {
	public static void main(String[] args) {
		PBManager pbm = new PBManager();
		pbm.run();
	}

}
