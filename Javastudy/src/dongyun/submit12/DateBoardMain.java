package dongyun.submit12;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class DateBoardMain {

	public static void main(String[] args) throws ParseException {
		// dbList에 랜덤 날짜를 가지는 DateBoard 객체 100개 삽입
				ArrayList<DateBoard> dbList = new ArrayList<DateBoard>();
		            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		            sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
				for(int i = 0; i < 100; i++) {
					int randDay = (int)(Math.random() * 365) + 1;		// 1~365	
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, randDay * -1);
							
					String strDate = sdf.format(cal.getTime());
					dbList.add(new DateBoard((i+1) + "번째 생성된 글", strDate));
				}
						
				for(int i = 0; i < dbList.size(); i++) {
					System.out.println(dbList.get(i));
				}
		            // TODO 코드작성 시작 ~!!
				
				
				
				for( int i = 0; i < dbList.size(); i++) {
					long ki = dbList.get(i).getDate();
				}
				
				
				
				
				
				
				
				
				
				
				
//				for (int k = 0; k < numbers.size() - 1; k++) {
//
//					for (int i = 0; i < numbers.size() - 1; i++) {
//						// i > i+1 하면 오름차순
//						// i < i+1 하면 내림차순
//						if (numbers.get(i) > numbers.get(i + 1)) {
//
//							int t = numbers.get(i);
//							numbers.set(i, numbers.get(i + 1));
//							numbers.set(i + 1, t);
//						}
//					}
//
//				}
				
				
				
				
				
				
				
				
				
		
		
		
	}

}