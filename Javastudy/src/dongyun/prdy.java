package dongyun;

public class prdy {

	public static void main(String[] args) {

		// 트리
		// *
		// **
		// ***
		// ****
		// *****
		// ******
		// *******

		// i가 0 1 2 3 4 5 6
		// 공백 6 5 4 3 2 1 0
		// 별표는 1 2 3 4 5 6 7

		for (int i = 0; i < 7; i++) {
			String em = "";

			for (int u = 0; u < 6 - i; u++) {
				em += " ";
			}

			String star = "";
			for (int u = 0; u < i + 1; u++) {
				star += "*";
			}
			System.out.println(em + star);

		}

		// 트리
//		*
//		**
//		***
//		****
//		*****
//		******

//		i  0 1 2 3 4 
//		*  1 2 3 4 5

		for (int i = 0; i < 5; i++) {
			String str = "";

			for (int k = 0; k < i + 1; k++) {
				str += "*";
			}
			System.out.println(str);
		}

		System.out.println("\n----\n");
		// 트리
//		     *
//		    ***
//		   *****

//		i  0 1 2 
//		빈 5 4 3
//		*  1 3 5

		for (int i = 0; i < 3; i++) {
			String str = "";

			for (int k = 0; k < 5 - i; k++) {
				str += " ";
			}

			for (int h = 0; h < (i * 2) + 1; h++) {
				str += "*";
			}

			System.out.println(str);

		}

		System.out.println("\n----\n");

		// 트리
		// *****
		// ***
		// *

		for (int i = 0; i < 5; i++) {
			String str = "";

			for (int k = 0; k < i; k++) {
				str += " ";
			}

			for (int h = 0; h < 9 - (i * 2); h++) {
				str += "*";
			}

			System.out.println(str);
		}

		// 트리
		// *****
		// ****
		// ***
		// **
		// *

		for (int i = 0; i < 5; i++) {
			String str = "";

			for (int k = 0; k < 5 - i; k++) {
				str += "*";

			}
			System.out.println(str);
		}

		// 트리
		// *
		// **
		// ***
		// ****
		// *****
		// ******
		// *******

		for (int i = 0; i < 7; i++) {
			String str = "";

			for (int k = 0; k < 6 - i; k++) {
				str += " ";

			}
			for (int h = 0; h < i + 1; h++) {
				str += "*";
			}

			System.out.println(str);
		}

		int koko  = 35;
		while(koko > 40) {
			System.out.println(koko);
			break;
		}
		
		
		
		
		
		
	}

}
