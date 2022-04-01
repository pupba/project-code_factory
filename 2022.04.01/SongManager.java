/**
 * @���ϸ� : SongManager.java
 * @������Ʈ�� : HW#4
 * @��¥ : 2022. 4. 1.
 * @�ۼ��� : ������
 * @���α׷����� : Song ���� ���α׷�
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Integer;
class Song{
	String title;
	String artist;
	int year;
	public Song(String title,String artist,int year) { // ������
		this.title = title;
		this.artist = artist;
		this.year = year;
	}
	
	public void show() { // �ʵ� ���
		System.out.printf("title= %s artist= %s year= %d%n",this.title,this.artist,this.year);
	}
}
public class SongManager {
	public final int ARRAY_NUM = 50;
	static Song songList[];
	static int nSong = 0;

	SongManager() { 
		songList = new Song[ARRAY_NUM]; // songList �迭 50�� ����
		for(int i=0;i<songList.length;i++) 
			songList[i] = new Song("-","-",-1); // NullPointerException�� ���ϱ� ����
	}  
	

	public static void addSong(Song aSong) {
		int check = 0;
		for(int i=0;i<nSong;i++) { // Ȯ��
			if(songList[i].title.equals(aSong.title)) {
				System.out.println("���� �̸��� �뷡�� �ֽ��ϴ�.");
				check = 1;
				break;
			}
		}
		if(check!=1) { // ���� �̸��� �뷡�� ���ٸ�?
			songList[nSong++] = aSong;
		}
		
	}

	public static void deleteSong(String title) {
		int check =0;
		for(int i=0;i<nSong;i++) { // Ȯ��
			if(songList[i].title.equals(title)) {
				songList[i] = new Song("-","-",-1); // NullPointerException�� ���ϱ� ����
				
				for(int j=i;j<nSong-1;j++) 
					songList[j] = songList[j+1]; // ��ü �ϳ��� ������ �б�
				
				songList[nSong-1] = new Song("-","-",-1); // NullPointerException�� ���ϱ� ����
				nSong--; // nSong -1
				check = 1;
				break;
			}
		}
		if(check == 0)
			System.out.println("�Է��Ͻ� ���� �����ϴ�.");
	}

	public static Song[] searchSongByArtist(String artist) { 
		int index[] = new int[nSong]; // ���� �� ������ �ִ� nSong�� 
		int idx = 0;
		for(int i=0;i<nSong;i++) {
			if(artist.equals(songList[i].artist)) {
				index[idx++] = i; // ������ ���� �� index ����
			}
		}
		Song[] reArr = new Song[idx]; // ��ȯ�� ��ü �迭 ����
		for (int i=0;i<idx;i++) reArr[i] = songList[index[i]];
		return reArr;
	}

	public static Song searchSongByTitle(String title) { 
		Song reSong = null; // ��ȯ�� Song ��ü
		for(int i=0;i<nSong;i++) {
			if(title.equals(songList[i].title)) {
				reSong = songList[i];
				break;
			}
		}
		return reSong;
	}

	public static void modifySong(String title, Song newSong) {
		int check = 0;
		for(int i=0;i<nSong;i++) {
			if(title.equals(songList[i].title)) {
				songList[i] = newSong; // newSong���� ��ü
				System.out.println("�뷡�� �����Ǿ����ϴ�.");
				check = 1;
				break;
			}
		}
		if (check ==0) System.out.printf("%s �뷡�� �����ϴ�.%n",title);
	}

	public static int howManySongs() {
		return nSong;		
	}

	public static void showAllSong() {
		for(int i=0;i<nSong;i++) 
			System.out.printf("\"%s\" \"%s\" \"%d\"%n", songList[i].title,songList[i].artist,songList[i].year);
	}

	private static void showArray() {
		int changeLine=0;
		for(int i=0;i<songList.length;i++) {
			if(changeLine > 9) {
				System.out.println("");
				changeLine =0;
			}
			System.out.printf("%s ", songList[i].title);
			changeLine++;
		}
		System.out.println("");
	}

	private static void readSongsFromFile(SongManager manager) {
		try {
			Scanner fileReader = new Scanner(new File("song_list.txt"));
			fileReader.nextLine(); // song_list.txt ������ ù��° �� �о ���� �ٷ� �̵�
			fileReader.nextLine(); // song_list.txt ������ �ι�° �� �о ���� �ٷ� �̵�
			while (fileReader.hasNextLine()) {
				String all[] = fileReader.nextLine().split(":"); // : �������� ���ڿ� ������
				int year = Integer.parseInt(all[2]); // ������ ����
				songList[nSong++] = new Song(all[0],all[1],year); // �뷡 ����, nSong +1
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SongManager manager = new SongManager();
		readSongsFromFile(manager);
		Scanner scan = new Scanner(System.in);
		String choice;

		while (true) {
			System.out.print("1. �߰�  ");
			System.out.print("2. ����  ");
			System.out.print("3. ��Ƽ��Ʈ���˻�  ");
			System.out.print("4. ���񺰰˻�  ");
			System.out.print("5. ����  ");
			System.out.print("6. �� �뷡 ����  ");
			System.out.print("7. ���뷡����  ");
			System.out.print("8. �迭����  ");
			System.out.println("9. ����  ");
			choice = scan.next();
			switch (choice) {
			case "1":
				System.out.print("title = ");
				String title = scan.next();
				System.out.print("artist = ");
				String artist = scan.next();
				System.out.print("year = ");
				int year = scan.nextInt();
				Song newSong = new Song(title,artist,year);
				addSong(newSong);
				break;
			case "2":
				System.out.print("title = ");
				String dtitle = scan.next();
				deleteSong(dtitle);
				System.out.println("");
				break;
			case "3":
				System.out.print("artist = ");
				String name = scan.next();
				Song[] arr = searchSongByArtist(name);
				for(int i=0;i<arr.length;i++) {
					System.out.printf("%d) ", i+1);
					arr[i].show();
				}
				break;
			case "4":
				System.out.print("title = ");
				String searchTitle = scan.next();
				Song findedSong = searchSongByTitle(searchTitle);
				findedSong.show();
				System.out.println("");
				break;
			case "5":
				System.out.println("�� ������ �����մϴ�. ���ο� �� ������ �Է��Ͻÿ�.");
				System.out.print("title = ");
				String nTitle = scan.next();
				System.out.print("artist = ");
				String nArtist = scan.next();
				System.out.print("year = ");
				int nYear = scan.nextInt();
				Song changeSong = new Song(nTitle,nArtist,nYear);
				System.out.print("������ title�� �Է��Ͻÿ� : ");
				nTitle = scan.next();
				modifySong(nTitle, changeSong);
				break;
			case "6":
				int songCount = howManySongs();
				System.out.printf("��ϵ� �뷡�� �� %d���Դϴ�.%n",songCount);
				break;
			case "7":
				showAllSong();
				break;
			case "8":
				showArray();
				break;
			case "9":
				System.out.println("���α׷��� �����մϴ�.");
				scan.close();
				System.exit(0);
				break;
			default:
				System.out.println("�ùٸ� ���� �Է����ּ���!!");
				break;
			}
		}
	}

}
