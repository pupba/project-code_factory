/**
 * 
 */

/**
 * @���ϸ� : Ch05_1_2.java
 * @������Ʈ�� : StudyClass
 * @��¥ : 2022. 4. 8.
 * @�ۼ��� : ������
 * @���α׷����� : 
 */
class TV{
	private int size;
	public TV(int size) {this.size =size;}
	protected int getSize() {return size;}
}
class ColorTV extends TV{
	private int color;
	ColorTV(int size, int color){
		super(size); // �θ� ��ü�� size ����
		this.color = color;
	}
	public void printProperty() {
		System.out.printf("%d��ġ %d�÷�%n",getSize(),this.color);
	}
}
public class Ch05_1_2 {
	
	public static void main(String[] args) {
		ColorTV myTV = new ColorTV(32,1024);
		myTV.printProperty();
	}

}
