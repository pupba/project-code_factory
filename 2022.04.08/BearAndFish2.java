
/**
 * @���ϸ� : BearAndFish2.java
 * @������Ʈ�� : HW#5
 * @��¥ : 2022. 4. 8.
 * @�ۼ��� : ������
 * @���α׷����� : ���� ���, ������ ��� �߰�
 */
import java.util.Random;
import java.util.Scanner;
import jaco.mp3.player.MP3Player;
import java.io.File;
abstract class GameObject{
	protected int distance; // �� �� �̵��Ÿ�
	protected int x,y;
	public GameObject(int startX, int startY, int distance) {
		this.x = startX;
		this.y = startY;
		this.distance = distance;
	}
	public int getX() {return x;}
	public int getY() {return y;}
	public boolean collide(GameObject p) {
		if(this.x == p.getX() && this.y == p.getY())
			return true;
		else 
			return false;
	}
	protected abstract void move(); // �̵��� ���ο� x,y�� ����
	protected abstract char getShape(); // ��ü�� ����� ��Ÿ���� ���� ����
}
class Bear extends GameObject{
	protected char shape;
	public String control;
	Bear(){
		super(0,0,1);
		this.shape = 'B';
		this.control = " ";
	}
	Bear(int x, int y, int distance){ // �� ������
		super(x,y,distance);
		this.shape = 'B';
		this.control = " ";
	}
	@Override
	protected void move() {
		switch(this.control) {
		case "a":this.y = y-this.distance;break;
		case "s":this.x = x+this.distance;break;
		case "d":this.x = x-this.distance;break;
		case "f":this.y = y+this.distance;break;
		default: System.out.println("�߸��Ȱ�!!");
		}
	}
	@Override
	protected char getShape() {
		return this.shape;
	}
}
class Item extends Bear{
	Item(int x,int y){
		super(x,y,4);
		this.shape = '��';
	}
	public void useItem(Bear b) {
		if(this.collide(b)) {
			b.distance = this.distance;
		}
	}
}
class Fish extends GameObject{
	private int count;
	private char shape;
	Fish(int x,int y,int distance){
		super(x,y,distance);
		this.count = 0;
		this.shape = '@';
	}
	@Override
	protected void move() {
		this.count ++;
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		int randNum = rand.nextInt(4);
		// ĭ ������ ������ �ȵ�
		// ���� ����� ��ġ
		// ���� 20ĭ ���� 10ĭ
		if(count == 4) {
			switch(randNum) {
			case 0: {
				// ���������� ���� ���
				if(getY()<19) this.y= y+1;
				else if(getY()==19) this.y = y-1;
				break;
			}
			case 1: {
				// �������� ���� ���
				if(0<getY()) this.y = y-1;
				else if(getY()==0) this.y = y+1;
				break;
			}
			case 2:{
				// ���� ���� ���
				if(0<getX()) this.x = x-1;
				else if(getX()==0)this.x= x+1;
				break;
			}
			case 3:{
				// �Ʒ��� ���� ���
				if(getX()<9) this.x= x+1;
				else if(getX()==9)this.x = x-1;
				break;
			}
			}
		}
		else if(count == 5) {
			switch(randNum) {
			case 0: {
				// ���������� ���� ���
				if(getY()<19) this.y= y+1;
				else if(getY()==19) this.y = y-1;
				break;
			}
			case 1: {
				// �������� ���� ���
				if(0<getY()) this.y = y-1;
				else if(getY()==0) this.y = y+1;
				break;
			}
			case 2:{
				// ���� ���� ���
				if(0<getX()) this.x = x-1;
				else if(getX()==0)this.x= x+1;
				break;
			}
			case 3:{
				// �Ʒ��� ���� ���
				if(getX()<9) this.x= x+1;
				else if(getX()==9)this.x = x-1;
				break;
			}
			}
			this.count = 0;
		}
		else ;
		
	}
	@Override
	protected char getShape() {
		return shape;
	}
}
class Game{
	Game(){}
	public void gameStart() {
		File file = new File("DM.mp3");
		MP3Player mp3player = new MP3Player(file);
		
		Bear b = new Bear();
		Random rand = new Random();
		
		rand.setSeed(System.currentTimeMillis());
		int x = rand.nextInt(10);
		int y = rand.nextInt(20);
		
		Fish f = new Fish(x,y,1);
		x = rand.nextInt(10);
		y = rand.nextInt(20);
		Item itm = new Item(x,y);

 		System.out.println("** Bear�� Fish �Ա� ������ �����մϴ�.");
 		System.out.println("");
 		char map[][] = new char[10][20];
		for(int i=0;i<10;i++) {
			for(int j=0;j<20;j++)
				map[i][j] = '-';
		}
		Scanner s = new Scanner(System.in);
		mp3player.play();
		while(!b.collide(f)) {
			for(int i=0;i<10;i++) {
				for(int j=0;j<20;j++) {
					if(i == b.getX() && j == b.getY()) System.out.print(b.getShape());
					else if(i == f.getX() && j == f.getY()) System.out.print(f.getShape());
					else if(i == itm.getX() && j == itm.getY()) System.out.print(itm.getShape());
					else System.out.print(map[i][j]);
				}
				System.out.println("");
			}
			System.out.print("����(a), �Ʒ�(s), ��(d), ������(f) >> ");
			b.control = s.next();
			b.move(); // ���̵�
			f.move(); // ����� �̵�
			itm.useItem(b);
		}
		for(int i=0;i<10;i++) {
			for(int j=0;j<20;j++) {
				if(i == b.getX() && j == b.getY()) System.out.print(b.getShape());
				else if(i == f.getX() && j == f.getY()) System.out.print(f.getShape());
				else System.out.print(map[i][j]);
			}
			System.out.println("");
		}
		System.out.println("Bear Wins!!");
		s.close();
		mp3player.stop();
	}
}
public class BearAndFish2 {
	public static void main(String[] args) {
		Game g = new Game();
		g.gameStart();
	}
}