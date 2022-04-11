
/**
 * @파일명 : StackApp.java
 * @프로젝트명 : StudyClass
 * @날짜 : 2022. 4. 11.
 * @작성자 : 정광원
 * @프로그램설명 : 스택 연습
 */
import java.util.Scanner;
interface Stack{
	int length(); // 현재 스택에 저장된 개수
	int capacity(); // 스택 전체 저장 개수
	String pop(); // 스택의 톱(top)에 저장된 문자열 리턴
	boolean push(String val); // 스택의 Top에 문자열 저장
	public String peek();
	public boolean isFull();
	public boolean isEmpty();
}

class StringStack implements Stack{
	private String stack[];
	private int stackP;
	StringStack(){
		stackP = 0;
	}
	public int length() {
		return this.stack.length;
	}
	public int capacity() {
		Scanner s = new Scanner(System.in);
		System.out.print("총 스택 저장 공간의 크기 입력 >> ");
		int capacity =  s.nextInt();
		return capacity;
	}
	public boolean push(String val) {
		if (stackP <= length()-1) {
			stack[stackP++] = val;
			return true;
		}
		else 
			return false;
	}
	public String pop() {
		String pop = stack[stackP];
		stack[stackP] = "";
		stackP--;
		return pop;
	}
	public String peek() {
		return stack[stackP-1];
	}
	public boolean isEmpty() {
		if(stack.length == 0) 
			return true;
		else 
			return false;
	}
	public boolean isFull() {
		if(stackP == stack.length)
			return true;
		else 
			return false;
	}
	public void run() {
		Scanner s = new Scanner(System.in);
		System.out.print("총 스택 저장 공간의 크기 입력 >> ");
		int size = s.nextInt();
		this.stack = new String[size];
		while(true) {
			System.out.print("문자열 입력 >> ");
			String val = s.next();
			
			if(val.equals("그만")) break;
			else if(val.equals("peek")) System.out.println("peek --> "+ peek());
			else if(isFull()) System.out.println("스택이 꽉 차서 푸시 불가!");
			else if(push(val)) System.out.println("푸시 성공!");
		}
		if(isEmpty()) {
			System.out.print("스택이 비어있습니다!");
		}
		else {
			System.out.print("스택에 저장된 모든 문자열 팝 : ");
			for(int i=stackP-1;i>=0;i--) System.out.printf("%s ",stack[i]);
			System.out.println("");
		}
		s.close();
	}
}
public class StackApp {

	public static void main(String[] args) {
		StringStack strstack = new StringStack();
		strstack.run();
	}
}
