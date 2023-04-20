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
		for (int i = 0; i < 100; i++) {
			int randDay = (int) (Math.random() * 365) + 1; // 1~365
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, randDay * -1);

			String strDate = sdf.format(cal.getTime());
			dbList.add(new DateBoard((i + 1) + "번째 생성된 글", strDate));
		}

		for (int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}
		// TODO 코드작성 시작 ~!!

		for (int i = 0; i < dbList.size(); i++) {
			for (int k = 0; k < dbList.size(); k++) {
				long t1 = sdf.parse(dbList.get(i).getDate()).getTime();
				long t2 = sdf.parse(dbList.get(i + 1).getDate()).getTime();

				if (t1 > t2) {
					DateBoard t3 = dbList.get(i);
					dbList.set(k, dbList.get(i + 1));
					dbList.set(k + 1, t3);
				}

			}
		}
		for (int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}

	}

}