package dongyun.submit12;

public class CartoonBoard extends Board{

	private String ima;
	
	
	private CartoonBoard() {}


	public CartoonBoard(int num, String title, String date, String content, String ima) {
		super(num, title, date, content);
		this.ima = ima;
	}


	@Override
	public String toString() {
		return "CartoonBoard [ima=" + ima + "]";
	}


	public String getIma() {
		return ima;
	}


	public void setIma(String ima) {
		this.ima = ima;
	}
	
	
	
	
	
	
}
