/**
 * 
 */

/**
 * @파일명 : Ch05_1_2.java
 * @프로젝트명 : StudyClass
 * @날짜 : 2022. 4. 8.
 * @작성자 : 정광원
 * @프로그램설명 : 
 */
class TV{
	private int size;
	public TV(int size) {this.size =size;}
	protected int getSize() {return size;}
}
class ColorTV extends TV{
	private int color;
	ColorTV(int size, int color){
		super(size); // 부모 객체에 size 전달
		this.color = color;
	}
	public void printProperty() {
		System.out.printf("%d인치 %d컬러%n",getSize(),this.color);
	}
}
public class Ch05_1_2 {
	
	public static void main(String[] args) {
		ColorTV myTV = new ColorTV(32,1024);
		myTV.printProperty();
	}

}
