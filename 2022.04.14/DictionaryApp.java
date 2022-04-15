/**
 * @파일명 : DictionaryApp.java
 * @프로젝트명 : StudyClass
 * @날짜 : 2022. 4. 15.
 * @작성자 : 정광원
 * @프로그램설명 : 딕셔너리 만들기
 */
abstract class PairMap{
	protected String keyArray[]; // key들을 저장하는 배열
	protected String valueArray[]; // value들을 저장하는 배열
	abstract String get(String key); // key 값을 가진 value 리턴, 없으면 null 리턴
	abstract void put(String key, String value); // key와 value를 쌍으로 저장,
	// 기존에 key가 있으면, 값을 value로 수정
	
	abstract String delete(String key); // key 값을 가진 아이템 삭제, 삭제된 value 리턴
	abstract int length(); // 현재 저장된 아템의 개수 리턴
	
	abstract String [] keys(); // 모든 key값
	abstract String [] values();
	abstract void showDic(); // Dic 모든 쌍을 보여줌
}
class Dictionary extends PairMap{
	int arrLength;
	int full;
	Dictionary(int n){
		keyArray = new String[n];
		valueArray = new String[n];
		this.arrLength = 0;
		this.full = n;
	}
	@Override
	public void put(String key,String value) {
		int check = 0;
		if(arrLength < this.full) {
			for(int i=0;i<arrLength;i++) {
				if(key.equals(keyArray[i])) { // key 값이 있는 경우
					keyArray[i] = key;
					valueArray[i] = value;
					check = 1;
				}
			} // key 검사
			if(check ==0) { // key 값이 없는 경우
				keyArray[arrLength] = key;
				valueArray[arrLength] = value;
				arrLength ++;
			}
		}
		else System.out.println("딕셔너리가 꽉찼습니다.");
	}
	@Override
	public String get(String key) {
		String reValue = null;
		for(int i=0;i<arrLength;i++) {
			if(key.equals(keyArray[i])) {
				reValue = valueArray[i];
			}
		}
		return reValue;
	}
	@Override
	public String delete(String key) {
		String reValue = null;
		for(int i=0;i<arrLength;i++) {
			if(key.equals(keyArray[i])) {
				reValue = valueArray[i];
				keyArray[i] = " ";
				valueArray[i] = " ";
				arrLength--;
			}
		}
		return reValue;
	}
	@Override
	public int length() {
		return arrLength;
	}
	@Override
	public String [] keys() {
		String keyList[] = new String[this.arrLength];
		for(int i=0;i<keyList.length;i++)
			keyList[i] = this.keyArray[i];
		return keyList;
	}
	@Override
	public String [] values() {
		String valueList[] = new String[this.arrLength];
		for(int i=0;i<valueList.length;i++)
			valueList[i] = this.valueArray[i];
		return valueList;
	}
	@Override
	public void showDic() {
		System.out.print("{");
		for(int i=0;i<arrLength;i++) 
			if(i==arrLength-1)
				System.out.printf("%s: %s",this.keyArray[i],this.valueArray[i]);
			else
				System.out.printf("%s: %s, ",this.keyArray[i],this.valueArray[i]);
		System.out.println("}");
	}
}
public class DictionaryApp {

	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이선");
		dic.put("이재문", "C++");
		dic.put("정광원", "React JS");
		System.out.println("이재문의 값은 "+ dic.get("이재문"));
		System.out.println("황기태의 값은 "+ dic.get("황기태"));
		String keys[] = dic.keys();
		String values[] = dic.values();
		for(int i=0;i<dic.arrLength;i++)
			System.out.print(keys[i]+","+values[i]+" ");
		System.out.println();
		dic.showDic();
		dic.delete("황기태");
		System.out.println("황기태의 값은 "+dic.get("황기태"));
	}

}
