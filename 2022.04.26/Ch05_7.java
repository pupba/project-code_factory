/**
 * 
 */

/**
 * @���ϸ� : Ch05_5.java
 * @������Ʈ�� : StudyClass
 * @��¥ : 2022. 4. 8.
 * @�ۼ��� : ������
 * @���α׷����� : 
 */

class Point{
	private int x,y;
	public Point(int x,int y) {this.x =x; this.y = y;}
	public int getX() {return x;}
	public int getY() {return y;}
	protected void move(int x,int y) {this.x=x; this.y=y;}
}
class Point3D extends Point{
	int z;
	Point3D(int x,int y,int z){
		super(x,y);
		this.z = z;
	}
	public String toString() {
		String str = "("+Integer.toString(getX())+","+Integer.toString(getY())+","+Integer.toString(this.z)+")�� ��";
		return str;
	}
	public void moveUp() {
		this.z = z+1;
	}
	public void moveDown() {
		this.z = z-1;
	}
	public void move(int x, int y, int z) {
		super.move(x,y);
		this.z = z;
	}
}
public class Ch05_7 {

	public static void main(String[] args) {
		Point3D p = new Point3D(1,2,3);
		System.out.println(p.toString()+"�Դϴ�.");
		
		p.moveUp(); 
		System.out.println(p.toString() + "�Դϴ�.");
		p.moveDown();
		p.move(10,10);
		System.out.println(p.toString()+"�Դϴ�.");
		p.move(100,200,300);
		System.out.println(p.toString()+"�Դϴ�.");
	}

}
