package ch15_file;

import java.io.File;

public class TreasureHunter {

	public static void main(String[] args) {
		
		String Path = "/home/pc13/today/treasure";
		
		// treasure 폴더 내 파일을 먼저 찾기
		
		File tea = new File(Path); 
		
		System.out.println(tea);
		
		findFile(tea);
		
		
		
	} // main 끝
	public static void findFile(File folder) {
		
		File[] inner = folder.listFiles();
		for(int i = 0; i < inner.length; i++) {
			if(inner[i].isDirectory()) {
				findFile(inner[i]);
			}else {
				System.out.println(inner[i]);
				
			}
			
		}
		
		
		
		
		
	}

}
