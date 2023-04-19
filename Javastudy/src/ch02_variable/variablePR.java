package ch02_variable;

public class variablePR {

	public static void main(String[] args) {
		
		int dy;
		dy = 50000;
		System.out.println(dy);
		
		String kkk = "q w, q  e, q  r";
		int len = kkk.length();
		System.out.println(len);
		
		char alphaL = kkk.charAt(1);
		System.out.println(kkk.charAt(1));
	
		System.out.println(kkk.replace("qw", "qqw"));
		
		String YDY = " HI YDY KK!! ";
		System.out.println(YDY);
		System.out.println(YDY.replace(" ", " "));
		System.out.println(YDY.trim());
		
		System.out.println(YDY.concat(", hello"));
		
		YDY = YDY + ", hello";
		System.out.println(YDY);
		
		System.out.println("\n----\n");
		
		char wordC = 'C';
		char numC = 33;
		System.out.println(wordC);
		System.out.println(numC);
		
		String name = "동윤이";
		String age = name + 27;
		System.out.println(age);
		System.out.println(name);
		
		int intdy = (int)3.7;
		System.out.println(intdy);
		
		int muldy = (int)(10 * 3.7);
		System.out.println(muldy);
		
		double result = (double)11 / (double)4;
		System.out.println(result);
		
		String strdd = "1020";
		System.out.println(strdd + 5);
		
		int dyNum = Integer.parseInt(strdd);
		System.out.println(dyNum + 5);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
