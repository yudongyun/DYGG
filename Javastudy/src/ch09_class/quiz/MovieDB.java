package ch09_class.quiz;

import java.util.ArrayList;

public class MovieDB {

	private ArrayList<Movie> movieList = new ArrayList<>();
	
	// 싱근톤 패턴
	private MovieDB() {
		movieList.add(new Movie("달콤한 인생", "넌 나에게 모욕감을 줬어", "이병헌, 김영철, 황정민 ", "ㄷㅋㅎㅇㅅ"));
		movieList.add(new Movie("해바라기", "꼭 그렇게 다 가져가야만 속이 후련했냐", "김래원", "ㅎㅂㄹㄱ"));
		movieList.add(new Movie("범죄도시", "응 아직 싱글이야", "마동석", "ㅂㅈㄷㅅ"));
		movieList.add(new Movie("타짜", "마포대교는 무너졌냐 이새끼야", "조승우, 김혜수, 유해진", "ㅌㅉ"));
		movieList.add(new Movie("바람", "아니믄 ,, 끄지라, 쓰바라마", "정우", "ㅂㄹ"));
		movieList.add(new Movie("신세계", "거 죽기 딱 좋은 날씨네", "이정재, 황정민, 박성웅", "ㅅㅅㄱ"));
		
		
		
		
		
		
	}
	
	private static MovieDB instance = new MovieDB();
	
	public static MovieDB getInstance() {
		return instance;
		
	}
	
	public ArrayList<Movie> getMovieList(){
		return movieList;
		
	}
	
	
	
	
	
	
	
	
}
