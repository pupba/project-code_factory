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
