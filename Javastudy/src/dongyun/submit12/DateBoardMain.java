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

		for (int i = 0; i < 100; i++) {
			int randDay = (int) (Math.random() * 365) + 1; // 1~365
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, randDay * -1);

			String strDate = sdf.format(cal.getTime());
			dbList.add(new DateBoard((i + 1) + "번째 생성된 글", strDate));
		}

//		for (int i = 0; i < dbList.size(); i++) {
//			System.out.println(dbList.get(i));
//		}
		// TODO 코드작성 시작 ~!!

		System.out.println("\n===========3번 문제=============\n");
		
		
		System.out.println("날짜별로 정렬 후 출력 (최신순)");
		for (int i = 0; i < dbList.size() - 1; i++) {

			for (int k = 0; k < dbList.size() - 1; k++) {
				long t1 = sdf.parse(dbList.get(k).getDate()).getTime();
				long t2 = sdf.parse(dbList.get(k + 1).getDate()).getTime();

				if (t1 < t2) {
					DateBoard t3 = dbList.get(k); // 첫번째 취득 해서 t3 보관
					dbList.set(k, dbList.get(k + 1));// 두번째 글을 취득해서 첫번째글로 이동 시킨거고
					dbList.set(k + 1, t3); // 첫번째 글 취득해서 두번째 이동 시킨
					// System.out.println(dbList.get(i + 1).toString());
				}
			}
		}

		for (int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}
		
		
		System.out.println("\n============3번 문제============\n");

		System.out.println("날짜별로 정렬 후 출력 (오래된순)");
		for (int i = 0; i < dbList.size() - 1; i++) {

			for (int k = 0; k < dbList.size() - 1; k++) {
				long t1 = sdf.parse(dbList.get(k).getDate()).getTime();
				long t2 = sdf.parse(dbList.get(k + 1).getDate()).getTime();

				if (t1 > t2) {
					DateBoard t3 = dbList.get(k); // 첫번째 취득 해서 t3 보관
					dbList.set(k, dbList.get(k + 1));// 두번째 글을 취득해서 첫번째글로 이동 시킨거고
					dbList.set(k + 1, t3); // 첫번째 글 취득해서 두번째 이동 시킨
					// System.out.println(dbList.get(i + 1).toString());
				}
			}
		}

		for (int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}

		System.out.println("\n============4번 문제============\n");

		System.out.println("최근 한달 내 작성된 게시글");
		Calendar calToday = Calendar.getInstance();

		String calToDate = sdf.format(calToday.getTime());
//		System.out.println(calToDate); // 현재 시간 출력

		String calToDate30 = "2023.03.21 18:55:55"; // 현재 시간 - 30일 출력

		Date oneDate = sdf.parse(calToDate); // date 타입으로 변환
		Date twoDate = sdf.parse(calToDate30); // date 타입으로 변환

//		System.out.println(oneDate.getTime()); // 밀리초 출력
//		System.out.println(twoDate.getTime()); // 밀리초 출력

		for (int i = 0; i < dbList.size(); i++) {

			long t1 = sdf.parse(dbList.get(i).getDate()).getTime();

			// 최근 30일 이내 생성된 글 출력
			if (twoDate.getTime() < t1 && t1 < oneDate.getTime()) {
				System.out.println(dbList.get(i));
			}

		}

		System.out.println("\n============5번 문제============\n");

		System.out.println("이번달 작성된 게시글");

		Calendar calTomonth = Calendar.getInstance(); // 새로운 객체 생성

//		calTomonth.get(Calendar.MONTH) + 1; // 이번달이 몇월인지 출력

		calTomonth.set(2023, calTomonth.get(Calendar.MONTH), 1);

		System.out.println(calTomonth.getTime()); // 이번달 1일날짜

		System.out.println(calTomonth.getTimeInMillis()); // 이번달 1일 날짜를 밀리세컨드로 치환

//		long t1 = calTomonth.getTimeInMillis(); // 롱타입에 담음

//		Date ctm = calTomonth.getTime();

		for (int i = 0; i < dbList.size(); i++) {

			long t1 = sdf.parse(dbList.get(i).getDate()).getTime(); // dbList 안에 date를 밀리세컨드로 치환
			long t2 = calTomonth.getTimeInMillis(); // 이번달 1일 날짜를 밀리세컨드로 치환한걸 롱타입에 담음

			if (t2 < t1) { // 이번달 1일 이후에 작성된 글만 출력함
				System.out.println(dbList.get(i));
			}
		}

		System.out.println("\n============6번 문제============\n");

		System.out.println("2월에 작성된 게시글");
		Calendar calfemonth = Calendar.getInstance(); // 새로운 객체 생성 / 2월 1일
		Calendar calfemonth28 = Calendar.getInstance(); // 새로운 객체 생성 / 2월 28일

		calfemonth.set(2023, calTomonth.get(Calendar.MONTH - 2), 1); // 2023년 2월 1일
		calfemonth28.set(2023, calTomonth.get(Calendar.MONTH - 2), 28); // 2023년 2월 28일

		System.out.println(calfemonth.getTime());
		System.out.println(calfemonth28.getTime());

		System.out.println(calfemonth.getTimeInMillis()); // 2월 1일 밀리세컨드 변환
		System.out.println(calfemonth28.getTimeInMillis()); // 2월 28일 밀리세컨드 변환

		for (int i = 0; i < dbList.size(); i++) {

			long t0 = sdf.parse(dbList.get(i).getDate()).getTime(); // dbList 안에 date를 밀리세컨드로 치환
			long t1 = calfemonth.getTimeInMillis();
			long t2 = calfemonth28.getTimeInMillis();

			if (t1 < t0 && t0 < t2) {
				System.out.println(dbList.get(i));
			}
		}

		System.out.println("\n============7번 문제============\n");

		System.out.println("2022.2.14 ~ 2023.3.21 게시글");
		Calendar calmonth2 = Calendar.getInstance(); // 새로운 객체 생성
		Calendar calmonth3 = Calendar.getInstance(); // 새로운 객체 생성

		calmonth2.set(2022, 1, 14); // 2022년 2월 14일
		calmonth3.set(2023, 2, 21); // 2023년 3월 21일

		System.out.println(calmonth2.getTime());
		System.out.println(calmonth3.getTime());

		System.out.println(calmonth2.getTimeInMillis());
		System.out.println(calmonth3.getTimeInMillis());

		for (int i = 0; i < dbList.size(); i++) {

			long t0 = sdf.parse(dbList.get(i).getDate()).getTime(); // dblist
			long t1 = calmonth2.getTimeInMillis();
			long t2 = calmonth3.getTimeInMillis();

			if (t1 < t0 && t0 < t2) {
				System.out.println(dbList.get(i));
			}
		}

	}

}