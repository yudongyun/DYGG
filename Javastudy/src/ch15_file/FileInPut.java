package ch15_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInPut {

	public static void main(String[] args) {
		
		// 파일 읽어오기
		
		String filePath = "/home/pc13/today/test.txt";
		
		File test = new File(filePath);
		
		try(FileInputStream fis = new FileInputStream(test)) {
			
			
			// 데이터를 옮길때 사용되는 그릇
			byte[] box = new byte[fis.available()]; // [1] 바이트 씩 추출한다
			
			// avilable - > 가져올 데이터 수
			
			while(true) {
				// size는 박스에 담긴 데이터의 수
				int size = fis.read(box); // 이 타이밍에 box에 데이터가 담긴다
				System.out.println(size);
				
				// 더 이상 가져올 데이터가 없다면 -1 이 담긴다.
				if(size == -1) {
					break;
				}
				
				// byte[] 을 String 으로 변환
				String result = new String(box);
				System.out.println(result);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
