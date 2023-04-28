package ch15_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutPut {

	public static void main(String[] args) {
		
		// 자바에서 파일에 내용 쓰기
		
		String filePath = "/home/pc13/today/test.txt";
		
		File test = new File(filePath);
		
		// try 문 옆 괄호에 변수를 선언하면 어디서든지 close로 종료 가능
		
		// FileOutPutStream (test) - > 기존 파일 내용을 덮어씀
		// FileOutPutStream (test, true) - > 기존 파일 내용을 이어서 작성
		try(FileOutputStream fos = new FileOutputStream(test, true)) {
			
			
			String temp = "\n 월요일도 쉰다용 ~ ㅋ.ㅋ";
			
			// String에 .getBytes() 하면 byte[] 를 리턴
			byte[] tempByte = temp.getBytes();
			
			fos.write(tempByte);
			System.out.println("작성 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		
		
		
		
		
		
		
	}

}
