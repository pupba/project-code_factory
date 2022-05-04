import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;


public class Ch07_3 {

	public static void main(String[] args) {
		HashMap<String,Integer> nations = new HashMap<String,Integer>();
		Scanner s = new Scanner(System.in);
		System.out.print("나라 이름과 인구를 입력하세요.");
		System.out.println("(예 : Korea 5000)");
		while(true) {
			System.out.print("나라 이름, 인구 >> ");
			String tmpl = s.nextLine();
			if(tmpl.equals("그만")) break;
			String tmp[] = tmpl.split(" ");
			int tmpInt = Integer.parseInt(tmp[1]);
			nations.put(tmp[0], tmpInt);
		}
		while(true) {
			System.out.print("인구 검색 >> ");
			String tmp = s.next();
			if(tmp.equals("그만")) break;
			else if(nations.get(tmp) == null)
				System.out.println(tmp+" 나라는 없습니다.");
			else {
				System.out.println(tmp+"의 인구는 "+nations.get(tmp));
			}
		}
		Set<String> keys = nations.keySet();
		Iterator <String> it = keys.iterator();
		while(it.hasNext()) {
			String name = it.next();
			int num = nations.get(name);
			System.out.println(name+","+num);
		}
		s.close();
	}

}
