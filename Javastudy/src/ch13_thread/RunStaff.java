package ch13_thread;

public class RunStaff extends Thread{

	private String name;
	private int num;
	
	public RunStaff(String name, int num) {
		this.num = num;
		this.name = name;
	}
	
	
	
	@Override
	public void run() {
		
		for(int i = 0; i < 5; i++) {
			System.out.println(name + ": " + num++);
			
			
			// 최종 실행부에서 try / catch
			try {
				// 현재 이 코드를 실행 중인 스레드가 멈추는 것.
				// 다른 스레드는 영향을 받지 않는다
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
