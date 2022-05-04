import java.util.Random;
import java.util.Scanner;

class Student{
	String name;
	int number;
	double gpa;
	
	public Student(String name,int number,double gpa) {
		this.name = name;
		this.number = number;
		this.gpa = gpa;
	}
	public void info() {
		System.out.printf("이름 : %s, 학번 : %d, GPA : %1.1f %n",name,number,gpa);
	}
}

public class ClassManagement {

	public static void main(String[] args) {
		Student s[] = new Student[50];
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름과 학번 입력 : ");
		String name = scanner.next();
		int number = scanner.nextInt();
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		double gpa;
		for (int i=0;i<s.length;i++) {
			String str = name + Integer.toString(i+1);
			gpa = rand.nextFloat() * 4.5;
			s[i] = new Student(str,(number+i),gpa);
		}
		for (int i=0;i<s.length;i++) {
			s[i].info();
		}
		double best = 0.0;
		int idx = 0;
		for (int i=0; i<s.length;i++) {
			if(i==0) best = s[i].gpa;
			else {
				if (best < s[i].gpa) {
					best = s[i].gpa;
					idx = i;
				}
			}
		}
		System.out.print("학점이 가장 높은 학생 --> ");
		s[idx].info();
		scanner.close();
	}
}
