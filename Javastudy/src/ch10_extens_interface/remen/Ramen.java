package ch10_extens_interface.remen;

public abstract class Ramen { //추상클래스이므로 abstract 를 붙혀줘야함
	String name;
	int price;
	
	
	
	
	public Ramen(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	public abstract void printRecipe();  // 추상메소드 생성
		
		
	
	
	
	
	
	
	
	
	
	

}
