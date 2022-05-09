/*
 * @파일명 : Ch07_13.java
 * @프로젝트명 : HW#8
 * @날짜 : 2022. 5. 1.
 * @작성자 : 정광원
 * @프로그램설명 : Ch07 13번 문제, 어셈블리어 구현
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
class Instruction{
	private String opcode;
	private String oprand1;
	private String oprand2;
	
	Instruction(String opcode,String oprand1,String oprand2){
		this.opcode = opcode;
		this.oprand1 = oprand1;
		this.oprand2 = oprand2;
	}
	
	public String getOpcode() {return this.opcode;}
	public String getOprand1() {return this.oprand1;}
	public String getOprand2() {return this.oprand2;}
}
public class Ch07_13 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList <Instruction>inst = new ArrayList<Instruction>();
		System.out.println("수퍼컴이 작동합니다. 프로그램을 입력해주세요. GO를 입력하면 작동합니다.");
		while(true) {
			System.out.print(">> ");
			String command=s.nextLine();
			if(command.equals("go")) {
				int i = 0;
				HashMap<String,Integer> oprator = new HashMap<String,Integer>();
				while(i < inst.size()) {
					// 변수와 값을 저장하는 컬렉션 필요
					Instruction cur = inst.get(i); // Instruction 객체 순서대로 꺼내기
					String opcode = cur.getOpcode();
					String oprand1 = cur.getOprand1();
					String oprand2 = cur.getOprand2();
					if(opcode.equals("mov")) {
						int opI2 = Integer.parseInt(oprand2);
						oprator.put(oprand1, opI2); // 변수 저장
						i++;
					}
					else if(opcode.equals("add")) {
						// 기존 값에 oprand2 더한 것을 oprand1에 넣기
						if(Character.isDigit(oprand2.charAt(0))) { // oprand2가 숫자 인 경우
							int opI2 = Integer.parseInt(oprand2);
							oprator.put(oprand1,((int)oprator.get(oprand1) + opI2));
						}
						else { // oprand2가 숫자가 아닌 경우
							int tmp = (int)oprator.get(oprand2);
							oprator.put(oprand1,((int)oprator.get(oprand1)+tmp));
						}
						i++;
					}
					else if(opcode.equals("sub")) {
						// 기존 값에 oprand2 뺀 것을 oprand1에 넣기
						int opI2 = Integer.parseInt(oprand2);
						oprator.put(oprand1, ((int)oprator.get(oprand1)-opI2));
						i++;
					}
					else if(opcode.equals("jn0")) {
						int tmp = (int)oprator.get(oprand1);
						if(tmp !=0) {
							int opI2 = Integer.parseInt(oprand2);
							// opI2번 명령으로
							i = opI2--;
						}
						else i++;
					}
					else if(opcode.equals("prt")) {
						System.out.println("["+opcode+" "+oprand1+" "+oprand2+"]");
						Set<String> keys = oprator.keySet();
						for(String key : keys) {
							System.out.print(key.toUpperCase()+":"+(int)oprator.get(key)+"  ");
						}
						System.out.println(" ");
						System.out.printf("출력할 결과는 %d. 프로그램 실행 끝%n",(int)oprator.get(oprand1));
						i++;
						oprator.clear();
						inst.clear();
					}
				}
			}
			else {
				String arr[] = command.split(" ");
				String opcode = arr[0];
				String oprand1 = arr[1];
				String oprand2 = arr[2];
				inst.add(new Instruction(opcode,oprand1,oprand2)); // ArrayList에 명령 추가
			}
		}
	}
}
