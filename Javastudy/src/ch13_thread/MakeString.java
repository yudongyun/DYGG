package ch13_thread;

public class MakeString {

	public static void main(String[] args) {
		// 문자열을 아주 길~ 게 만들어보자
		
		String str = "";
		StringBuffer strBuff = new StringBuffer();
		StringBuilder strBuild = new StringBuilder();
		
		// Buffer (동기화 지원 ) 로 할때는 동기화 개념이라서 속도가 빨라지는게 아님
		// 각 스레드가 일을 할때는 일하는 스레드를 제외하고 나머지는 주춤
		
		
		
		Thread jonghyun = new Thread(() -> {
			for(int i = 0; i < 50000000; i ++) {
				strBuff.append("1");
			}
			System.out.println(strBuff.length());
		});
		
		Thread seoyoung = new Thread(() -> {
			for(int i = 0; i < 50000000; i ++) {
				strBuff.append("1");
			}
			System.out.println(strBuff.length());
		});
		
		jonghyun.start();
		seoyoung.start();
		
		System.out.println(strBuff.length());
		
		
	}

}
