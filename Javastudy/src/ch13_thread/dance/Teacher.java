package ch13_thread.dance;

public class Teacher extends Thread{
	
	boolean state = true;
	
	// 게임 오버시 dance main 에서 run 내 while문을 종료 시키기 위함
	boolean isRun = true; 
	
	
	@Override
	public void run() {
		
		while(isRun) {
			// 랜덤한 시간만큼 sleep 을 시킨다
			int rand = (int)(Math.random() * 3000) + 500;
			
			try {
				Thread.sleep(rand);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// 선생님의 앞, 뒤 상태를 바꿔주기
			state = !state; // true이면 false, false이면 true
			
			// 상태변화를 알림
			if(state == true) {
				System.out.println("앞을 보셨다.");
			}else {
				System.out.println("뒤를 보셨다 ㅋㅋㅋ");
			}
			
		}
		
	}
	
	

}
