class Point{
	private int x,y;
	public Point(int x,int y) {this.x =x; this.y = y;}
	public int getX() {return x;}
	public int getY() {return y;}
	protected void move(int x,int y) {this.x=x; this.y=y;}
}
class ColorPoint extends Point{
	String color;
	ColorPoint(){
		super(0,0);
		this.color = "BLACK";
	}
	ColorPoint(int x,int y){
		super(x,y);
		this.color = "BLACK";
	}
	ColorPoint(int x,int y, String color){
		super(x,y);
		this.color = color;
	}
	public void setXY(int x, int y) {
		super.move(x,y);
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String toString() {
		String str = this.color + "색의 ("+Integer.toString(getX())+","+Integer.toString(getY())+")의 점";
		return str;
	}
}
public class Ch05_6 {

	public static void main(String[] args) {
		ColorPoint zeroPoint = new ColorPoint();
		System.out.println(zeroPoint.toString()+"입니다.");
		
		ColorPoint cp = new ColorPoint(10,10);
		cp.setXY(5, 5);
		cp.setColor("RED");
		System.out.println(cp.toString()+"입니다.");
	}

}
