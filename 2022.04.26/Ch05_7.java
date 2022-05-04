/**
 * 
 */

/**
 * @파일명 : Ch05_5.java
 * @프로젝트명 : StudyClass
 * @날짜 : 2022. 4. 8.
 * @작성자 : 정광원
 * @프로그램설명 : 
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
		String str = "("+Integer.toString(getX())+","+Integer.toString(getY())+","+Integer.toString(this.z)+")의 점";
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
		System.out.println(p.toString()+"입니다.");
		
		p.moveUp(); 
		System.out.println(p.toString() + "입니다.");
		p.moveDown();
		p.move(10,10);
		System.out.println(p.toString()+"입니다.");
		p.move(100,200,300);
		System.out.println(p.toString()+"입니다.");
	}

}
