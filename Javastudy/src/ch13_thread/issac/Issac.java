package ch13_thread.issac;

public class Issac {
	
	int toast = 0;
	
	// 싱글톤 적용 ( Issac 객체가 하나만 존재하도록 )
	private Issac() {}
	
	private static Issac instance = new Issac();
	
	public static Issac getInstance() {
		return instance;
	}
	
	// 토스트 만들기 ( Chef 클래스에서 사용 )
	public synchronized void makeToast() { // synchronized 동기화 // 여러개의 스레드에서 toast를 만지기 때매
		toast += 1;
		System.out.println("토스트를 하나 만들었습니다.");
		System.out.println("현재 수량 : " + toast );
		
		// wait set 에서 대기중인 임의의 스레드를 하나 깨운다.
		notifyAll();
		
//		notifyAll(); // 대기중인 모든 스레드를 깨운다.
	}
	
	// 토스트 구매 ( Customer 클래스에서 사용 )
	public synchronized void buyToast(int count, String name) { // 토스트 구매 수량 count
		
		
		// toast 수량이 구매하고자 하는 갯수보다 작다면 
		if(toast < count) {
			// 대기해야함
			try {
				System.out.println(name + ": .. 힝");
				wait(); // wait()를 실행한 스레드는 다른 스레드에서 notify() 로 깨울때까지 대기 상태
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			buyToast(count, name); // 재귀함수
			
		}else { // 그게 아니면 구매할수 있게
			toast -= count;
			System.out.println(name + "이가 토스트를 " + count + "개 구매하였습니다.");
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
