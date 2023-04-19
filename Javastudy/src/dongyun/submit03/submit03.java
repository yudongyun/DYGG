package dongyun.submit03;

public class submit03 {

	public static void main(String[] args) {

		// #1
		// 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1 == 10!
		
		int sum = 1;
		for(int i = 10; i >= 1; i--) {
			sum *= i;
		}
		System.out.println(sum);
		
		
		System.out.println("\n--------------------\n");
		
		// #1 @
		long suma = 1l;
		for(long i = 15l; i >= 1l; i--) {
			suma *=  i;
		}
		System.out.println(suma);
		
		
		System.out.println("\n--------------------\n");
		
		// #2
		String findWally =  "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일리월리월리윌리울리윌리울리일리울리울리윌리일리";  
		
		int count = 0;
		for(int i = 0; i < findWally.length()-2; i++) {
			String str = findWally.substring(i, i+2);
			
			if(str.equals("월리")) {
				count++;
			}
		}
		System.out.println("월리 : " + count);
		
		
		
		
		
		
		System.out.println("\n----------#3----------\n");
		
		// #3
		String stars = "*****";
		for(int i = 0; i <= 4; i++) {
			String str = stars.substring(i);
			System.out.println(str);
		}
		
		
	}

}
