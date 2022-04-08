
/**
 * @파일명 : BearAndFish2.java
 * @프로젝트명 : HW#5
 * @날짜 : 2022. 4. 8.
 * @작성자 : 정광원
 * @프로그램설명 : 음악 기능, 아이템 기능 추가
 */
import java.util.Random;
import java.util.Scanner;
import jaco.mp3.player.MP3Player;
import java.io.File;
abstract class GameObject{
	protected int distance; // 한 번 이동거리
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
	protected abstract void move(); // 이동후 새로운 x,y로 변경
	protected abstract char getShape(); // 객체의 모양을 나타내는 문자 리턴
}
class Bear extends GameObject{
	protected char shape;
	public String control;
	Bear(){
		super(0,0,1);
		this.shape = 'B';
		this.control = " ";
	}
	Bear(int x, int y, int distance){ // 곰 생성자
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
		default: System.out.println("잘못된값!!");
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
		this.shape = '♥';
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
		// 칸 밖으로 나가면 안됨
		// 현재 물고기 위치
		// 가로 20칸 세로 10칸
		if(count == 4) {
			switch(randNum) {
			case 0: {
				// 오른쪽으로 가는 경우
				if(getY()<19) this.y= y+1;
				else if(getY()==19) this.y = y-1;
				break;
			}
			case 1: {
				// 왼쪽으로 가는 경우
				if(0<getY()) this.y = y-1;
				else if(getY()==0) this.y = y+1;
				break;
			}
			case 2:{
				// 위로 가는 경우
				if(0<getX()) this.x = x-1;
				else if(getX()==0)this.x= x+1;
				break;
			}
			case 3:{
				// 아래로 가는 경우
				if(getX()<9) this.x= x+1;
				else if(getX()==9)this.x = x-1;
				break;
			}
			}
		}
		else if(count == 5) {
			switch(randNum) {
			case 0: {
				// 오른쪽으로 가는 경우
				if(getY()<19) this.y= y+1;
				else if(getY()==19) this.y = y-1;
				break;
			}
			case 1: {
				// 왼쪽으로 가는 경우
				if(0<getY()) this.y = y-1;
				else if(getY()==0) this.y = y+1;
				break;
			}
			case 2:{
				// 위로 가는 경우
				if(0<getX()) this.x = x-1;
				else if(getX()==0)this.x= x+1;
				break;
			}
			case 3:{
				// 아래로 가는 경우
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

 		System.out.println("** Bear의 Fish 먹기 게임을 시작합니다.");
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
			System.out.print("왼쪽(a), 아래(s), 위(d), 오른쪽(f) >> ");
			b.control = s.next();
			b.move(); // 곰이동
			f.move(); // 물고기 이동
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