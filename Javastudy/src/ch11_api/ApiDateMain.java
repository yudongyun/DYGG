package ch11_api;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ApiDateMain {

	public static void main(String[] args) throws ParseException {

		// 현재 시간 출력
		// 1. Date 클래스 사용
		Date dateToday = new Date();

		// Date 객체가 new Date()로 생성되는 순간
		// 해당 Date 객체 내부에 그 때의 시간이 세팅된다.
		System.out.println(dateToday);

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Date dateAfter = new Date();
		System.out.println(dateAfter);

		// 날짜 포맷을 설정한다
		// 2023년 04월 18일 10시 39분 30초 -- 이런식으로 바꾸고싶다.
		// SimpleDateFormat 생성자 안에 날짜 포맷 문자열 넣기

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초"); // 새로운 포맷을 적용

		// .format의 파라미터에 Date 타입의 객체를 넣으면
		// 해당 Date 객체의 날짜에 대해 포맷을 적용한 문자열을 리턴함
		String strToday = sdf.format(dateToday);
		System.out.println(strToday);

		// 2023/04/18 10:39:40
		// 2023.04.18 10:39:40
		sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); // 기존 포맷에 새로운 포맷을 덮음
		strToday = sdf.format(dateToday);
		System.out.println(strToday);

		System.out.println("\n=========================\n");

		// 방법 2. Calendar 클래스 사용
		// .getInstance() 이지만 싱글톤 패턴이 적용되지 않음
		// new Date() 와 마찬가지로 .getInstance() 가 실행된 시점으로
		// 세팅된 Calender 객체가 생성된다.

		Calendar calToday = Calendar.getInstance();
		System.out.println(calToday);

		// calender 객체의 .getTime()을 실행하면
		// 해당 calendar 객체에 세팅된 날짜를 가지는
		// Date 객체를 리턴한다.
		Date calToDate = calToday.getTime();
		System.out.println(calToDate);

		// 날짜 포맷 적용 ( 위에서 만든 포맷에 맞춰서 적용한다 )
//		sdf.format(calToDate) 이렇게 넣어도 되고
		strToday = sdf.format(calToday.getTime());
		System.out.println(strToday);

		System.out.println("\n=========================\n");

		// 방법 3. system 클래스 사용

		long longToday = System.currentTimeMillis();
		System.out.println(longToday);

		// 날짜 포맷 적용
		// sdf.format() 은 파라미터로 Date 객체 또는 long 타입을 받는다.
		strToday = sdf.format(longToday);
		System.out.println(strToday);

		strToday = sdf.format(0l); // 1970년 1월 1일이 나옴
		System.out.println(strToday);

		System.out.println("\n=========================\n");

		// 다양한 날짜 포맷 만들기
		// 1. 23/04/18 11:16:33
		// 2. 2023-04-18 오전 11:16:33
		// 3. 화 오전 11:16:33
		// 4. 화요일 11:16
		// @. 2023.04.18 AM 11:16:33

		Date dateNow = new Date();
		sdf = new SimpleDateFormat("yy/MM/dd hh:mm:ss");
		System.out.println("1. " + sdf.format(dateNow));

		sdf = new SimpleDateFormat("yyyy-M-d a hh:mm:ss");
		System.out.println("2. " + sdf.format(dateNow));

		sdf = new SimpleDateFormat("E a hh:mm:ss");
		System.out.println("3. " + sdf.format(dateNow));

		sdf = new SimpleDateFormat("E" + "요일 " + "hh:mm");
		System.out.println("4. " + sdf.format(dateNow));

		sdf = new SimpleDateFormat("yyyy.MM.dd a hh:mm:ss", Locale.US);
		System.out.println("@. " + sdf.format(dateNow));

		System.out.println("\n=========================\n");

		// 미국 날짜는 ?

		sdf = new SimpleDateFormat("yyyy.MM.dd a hh:mm:ss", Locale.US);
		TimeZone tz = TimeZone.getTimeZone("America/New_York");

		sdf.setTimeZone(tz);
		System.out.format("미국날짜. " + sdf.format(dateNow));

		System.out.println("\n=========================\n");

		// 문자열 ( String ) -> Date 객체 변환
		// 유사) "1234" -> int 타입으로 변환
		// 예시) "2023/04/18" , "2023/04/16" 두 날짜 차이 계산이 안된다 .. 문자열이라

		String strTomorrow = "2023/04/19 12:01:10";

		// strTomorrow 문자열의 날짜 포맷에 대한 sdf 생성
		sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		Date dateTomorrow = sdf.parse(strTomorrow);

		System.out.println(dateTomorrow);
		System.out.println(sdf.format(dateTomorrow));

		String strYesterDay = "23.04.17 09:12:11";

		sdf = new SimpleDateFormat("yy.MM.dd HH:mm:ss"); // 정확히 일치시킴

		Date dateYesterDay = sdf.parse(strYesterDay);

		System.out.println(dateYesterDay);
		System.out.println(sdf.format(dateYesterDay));

		System.out.println("\n=========================\n");

		// 특정 날짜에 대한 객체 얻기
		// Date 를 얻는다면 "23/05/01" -> sdf.parse 이용한다.

		// Calendar로 얻기
		Calendar cal = Calendar.getInstance();

		// .set(년, 월, 일) 또는 .set(년, 월, 일, 시, 분, 초)
		// Month의 경우 1월이 0이고, 2월이 1임 .... 12월은 11
		cal.set(2023, 5 - 1, 1);

		// Calender 를 Date 객체로 변환한다.
		System.out.println(cal.getTime());

		// Date 객체를 Calender 객체로 변환
		Date temp = new Date(); // date 객체

		Calendar calTemp = Calendar.getInstance(); // calendar 객체

		calTemp.setTime(temp); // calendar 객체로 변환

		// Date 타입에서 long 날짜 얻기
		System.out.println(temp.getTime()); // 밀리세컨드 ~

		System.out.println("\n===========월 확인==============\n");

		// 날짜 꺼내기
		// Calendar 객체로 꺼내는게 편함
		Calendar anyCal = Calendar.getInstance();

		// 년도
		System.out.println(anyCal.get(Calendar.YEAR));

		// 월
		System.out.println(anyCal.get(Calendar.MONTH) + 1); // +1을 안하면 3이뜬다.

		// 일
		System.out.println(anyCal.get(Calendar.DATE));

		// 시간
		System.out.println(anyCal.get(Calendar.HOUR)); // 0 ~ 12
		System.out.println(anyCal.get(Calendar.HOUR_OF_DAY)); // 0 ~ 24

		// 분
		System.out.println(anyCal.get(Calendar.MINUTE));

		// 초
		System.out.println(anyCal.get(Calendar.SECOND));

		System.out.println("\n=========================\n");

		// 날짜 연산
		String oneDay = "2023.04.06 12:22:45";
		String twoDay = "2023.06.22 14:31:13";

		sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

		Date oneDate = sdf.parse(oneDay);
		Date twoDate = sdf.parse(twoDay);

		// 밀리초 값이 더 클수록 최신을 의미
		System.out.println(oneDate.getTime());
		System.out.println(twoDate.getTime());

		long diffMillSec = twoDate.getTime() - oneDate.getTime();
		System.out.println("차이 : " + diffMillSec);

		// diffMillSec 를 초 단위로 바꾸기
		long diffSec = diffMillSec / 1000;
		System.out.println(diffSec + " 초 차이");

		long diffMin = diffSec / 60;
		System.out.println(diffMin + " 분 차이");

		long diffHour = diffMin / 60;
		System.out.println(diffHour + " 시간 차이");

		long diffDay = diffHour / 24;
		System.out.println(diffDay + " 일 차이");

		// 한줄로
		long diff = diffMillSec / 1000 / 60 / 60 / 24;
		System.out.println(diff + " 일 차이");

		System.out.println("\n=========================\n");

		// 디데이 계산기

		sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date TToday = new Date();
		
		String strTToday = sdf.format(TToday);
		System.out.println("오늘 날짜 : " + strTToday); // 오늘 날짜
		
		
		
		
		
		String dday = "2023.05.01"; // 근로자의 날
		
		sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		// 문자열 형태를 Date 타입으로 만들기
		Date ddayDate = sdf.parse(dday);
		Date todayDate = sdf.parse(strTToday);
		
		System.out.println(todayDate);
		
		long ddaycir = todayDate.getTime() - ddayDate.getTime();
		long ddiff = ddaycir / (1000 * 60 * 60 * 24);
		
		System.out.println("근로자의 날까지 " + ddiff + "일 ");
		
		
		
		
		// 실행 결과
		String startday = "2023.03.20"; // 교육 시작일
		
		sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		// 문자열 형태를 Date 타입으로 만들기
		Date ddayDate1 = sdf.parse(strTToday);
		Date startDate = sdf.parse(startday);
		
		long lastday = ddayDate1.getTime() - startDate.getTime();
		long ddiiff = lastday / 1000 / 60 / 60 / 24;
		
		System.out.println("시작일로 부터 +" + ddiiff + "일 ");
		
		
		System.out.println("\n=========================\n");
		
		// 날짜 연산
		// 한 날짜를 기준으로 날짜를 더하거나 빼기
		// Calendar 가 편함
		
		Calendar toCal = Calendar.getInstance();
		sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		System.out.println(sdf.format(toCal.getTime()));
		
		// 3일 뒤 
		toCal.add(Calendar.DATE, 3); // calendar 객체 데이트 3일 뒤
		System.out.println(sdf.format(toCal.getTime()));
		
		// 57일 뒤 
		toCal.add(Calendar.DATE, 57); // calendar 객체 데이트 3일 뒤
		System.out.println(sdf.format(toCal.getTime()));
		
		// 7일 전
		toCal.add(Calendar.DATE, -7);
		System.out.println(sdf.format(toCal.getTime()));
		
		// 11달 뒤
		toCal.add(Calendar.MONTH, 11);
		System.out.println(sdf.format(toCal.getTime()));
		
		
		System.out.println("\n=========================\n");
		
		// 달력 만들기
		int year = 2023;
		int month = 4;
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1); // month 에서 -1 해줘야함
		System.out.println(sdf.format(calendar.getTime()));
		
		// 해당 달의 마지막 일자 얻기
		
		int lastdday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(lastdday); //6월의 마지막 일자
		
		// 해당 달의 시작요일
		
		int startdday = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(startdday); // 요일을 숫자로 알려줌 일요일 : 1 , 월요일 : 2 ....토요일 : 7
		
		System.out.println(year + "년 " + month + "월 달력");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		
		int current = 1;
		for(int i = 0; i < 42; i++) {
			
			if(i < startdday - 1) {
				System.out.print("\t");
			}else {
				System.out.printf("%2d\t",current);
				current++;
				
				if(current > lastdday) {
					break;
				}
			}
			
			// i가 6, 13, 20, 27, 34 일때 출력 후 줄바꿈
			if(i % 7 == 6) {
				System.out.println();
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
