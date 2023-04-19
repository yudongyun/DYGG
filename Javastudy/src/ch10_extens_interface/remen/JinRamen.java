package ch10_extens_interface.remen;

public class JinRamen extends Ramen{
	
	public JinRamen(String name, int price) {
		super(name, price);
	}

	@Override
	public void printRecipe() {
		System.out.println("끓는 물에 면과 스프를 넣고 3분 후에 드세요");
	}
	
	
	
	
	
}
