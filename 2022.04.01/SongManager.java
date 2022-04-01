/**
 * @파일명 : SongManager.java
 * @프로젝트명 : HW#4
 * @날짜 : 2022. 4. 1.
 * @작성자 : 정광원
 * @프로그램설명 : Song 관리 프로그램
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Integer;
class Song{
	String title;
	String artist;
	int year;
	public Song(String title,String artist,int year) { // 생성자
		this.title = title;
		this.artist = artist;
		this.year = year;
	}
	
	public void show() { // 필드 출력
		System.out.printf("title= %s artist= %s year= %d%n",this.title,this.artist,this.year);
	}
}
public class SongManager {
	public final int ARRAY_NUM = 50;
	static Song songList[];
	static int nSong = 0;

	SongManager() { 
		songList = new Song[ARRAY_NUM]; // songList 배열 50개 생성
		for(int i=0;i<songList.length;i++) 
			songList[i] = new Song("-","-",-1); // NullPointerException을 피하기 위함
	}  
	

	public static void addSong(Song aSong) {
		int check = 0;
		for(int i=0;i<nSong;i++) { // 확인
			if(songList[i].title.equals(aSong.title)) {
				System.out.println("같은 이름의 노래가 있습니다.");
				check = 1;
				break;
			}
		}
		if(check!=1) { // 같은 이름의 노래가 없다면?
			songList[nSong++] = aSong;
		}
		
	}

	public static void deleteSong(String title) {
		int check =0;
		for(int i=0;i<nSong;i++) { // 확인
			if(songList[i].title.equals(title)) {
				songList[i] = new Song("-","-",-1); // NullPointerException을 피하기 위함
				
				for(int j=i;j<nSong-1;j++) 
					songList[j] = songList[j+1]; // 객체 하나씩 앞으로 밀기
				
				songList[nSong-1] = new Song("-","-",-1); // NullPointerException을 피하기 위함
				nSong--; // nSong -1
				check = 1;
				break;
			}
		}
		if(check == 0)
			System.out.println("입력하신 곡이 없습니다.");
	}

	public static Song[] searchSongByArtist(String artist) { 
		int index[] = new int[nSong]; // 같은 곡 개수는 최대 nSong개 
		int idx = 0;
		for(int i=0;i<nSong;i++) {
			if(artist.equals(songList[i].artist)) {
				index[idx++] = i; // 가수가 같은 곡 index 저장
			}
		}
		Song[] reArr = new Song[idx]; // 반환할 객체 배열 생성
		for (int i=0;i<idx;i++) reArr[i] = songList[index[i]];
		return reArr;
	}

	public static Song searchSongByTitle(String title) { 
		Song reSong = null; // 반환할 Song 객체
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
				songList[i] = newSong; // newSong으로 교체
				System.out.println("노래가 수정되었습니다.");
				check = 1;
				break;
			}
		}
		if (check ==0) System.out.printf("%s 노래가 없습니다.%n",title);
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
			fileReader.nextLine(); // song_list.txt 파일의 첫번째 줄 읽어서 다음 줄로 이동
			fileReader.nextLine(); // song_list.txt 파일의 두번째 줄 읽어서 다음 줄로 이동
			while (fileReader.hasNextLine()) {
				String all[] = fileReader.nextLine().split(":"); // : 기준으로 문자열 나누기
				int year = Integer.parseInt(all[2]); // 정수로 변경
				songList[nSong++] = new Song(all[0],all[1],year); // 노래 저장, nSong +1
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
			System.out.print("1. 추가  ");
			System.out.print("2. 삭제  ");
			System.out.print("3. 아티스트별검색  ");
			System.out.print("4. 제목별검색  ");
			System.out.print("5. 수정  ");
			System.out.print("6. 총 노래 개수  ");
			System.out.print("7. 모든노래보기  ");
			System.out.print("8. 배열보기  ");
			System.out.println("9. 종료  ");
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
				System.out.println("곡 정보를 수정합니다. 새로운 곡 정보를 입력하시오.");
				System.out.print("title = ");
				String nTitle = scan.next();
				System.out.print("artist = ");
				String nArtist = scan.next();
				System.out.print("year = ");
				int nYear = scan.nextInt();
				Song changeSong = new Song(nTitle,nArtist,nYear);
				System.out.print("수정할 title을 입력하시오 : ");
				nTitle = scan.next();
				modifySong(nTitle, changeSong);
				break;
			case "6":
				int songCount = howManySongs();
				System.out.printf("등록된 노래는 총 %d곡입니다.%n",songCount);
				break;
			case "7":
				showAllSong();
				break;
			case "8":
				showArray();
				break;
			case "9":
				System.out.println("프로그램을 종료합니다.");
				scan.close();
				System.exit(0);
				break;
			default:
				System.out.println("올바른 값을 입력해주세요!!");
				break;
			}
		}
	}

}
