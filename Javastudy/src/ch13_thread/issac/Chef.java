package ch13_thread.issac;

public class Chef extends Thread{
	
	private Issac issac = Issac.getInstance(); 
	
	public EndCook endCook; // 인터페이스에 대한
	
	
	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			issac.makeToast();
		}
		endCook.finish(); // 추상메소드
	}
	
	
	
	
}
