package ch15_file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileBasic {

	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		System.out.println(path); // 프로젝트의 풀 경로에 해당한다.
		
		// 프로젝트에 대해 자바에서 file 객체 생성하기
		
		// File에 생성자 안에는 풀 경로 입력
		File proj = new File(path);
		
		// proj 내의 파일목록 출력
		// .listFiles()
		// 해당 File 객체 폴더의 파일목록을 배열(array)로 리턴
		File[] fileArray = proj.listFiles();
		for(int i = 0; i < fileArray.length; i++) {
			// 해당 File 객체의 풀 경로를 리턴 (경로 + 파일명)
			System.out.println(fileArray[i]);
		}
		
		// proj의 src 폴더 내 파일 목록 출력
		File src = new File(path + "/src");
		
		File[] srcArray = src.listFiles();
		for(int i = 0; i < srcArray.length; i++) {
			// 파일명만 출력
			System.out.println(srcArray[i].getName());
		}
		
		System.out.println("\n====================\n");
		
		// File 객체가 폴더인지 파일인지 확인
		// .isDirectory()
		System.out.println(src.isDirectory());
		
		System.out.println(srcArray[0]);
		
		// 프로젝트 내부에 Ramen.java 파일을 file 객체로 만들기
		
		File Ramen = new File(path + "/src/ch10_extens_interface/remen/Ramen.java");
		System.out.println(Ramen);
		
		// File 객체가 실제로 존재하는 파일을 바라보고 있는지 체크
		// .exists()
		System.out.println(Ramen.exists());
		
		// .lastModified()
		// 마지막 수정날짜
		System.out.println(Ramen.lastModified());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		System.out.println(sdf.format(Ramen.lastModified()));
		
		// 파일크기 ( Byte )
		// .length()
		// 1KB = 1024Byte
		// 1MB = 1024KB = 1024 * 1024 BYTE
		// 1GB = 1024MB
		// 
		System.out.println(Ramen.length());
		
		System.out.println("\n=========================\n");
		
		// 폴더 만들기
		
		File today = new File("/home/pc13/today");
		
		System.out.println(today.exists());
		
		// 이미 폴더가 존재하면 생성되지 않음
		today.mkdir();
		
		
		System.out.println("\n=========================\n");
		
		// 파일 만들기
		// /home/pc13/today 안에 test.txt 파일 만들기
		File test = new File("/home/pc13/today/test.txt");
		
		System.out.println(test.exists());
		
		try {
			test.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("\n=========================\n");
		
		String[] stuArray = {"유정", "준호", "동욱", "현진", "민경", "진영", "대일", "창연", "자영",
								"성복", "민기", "동윤", "지혜", "태윤", "준하"};
		
		for(int i = 0; i < stuArray.length; i++) {
			File stu = new File("/home/pc13/today/" + stuArray[i]);
			stu.mkdir();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
