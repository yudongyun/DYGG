package ch10_extens_interface.remen;

public class Jjappagheti extends Ramen{
	
	public Jjappagheti(String name, int price) {
		super(name, price);
	}

	@Override
	public void printRecipe() {
		System.out.println("끓는 물에 면을 삶은 후 물은 버리고 스프를 넣어 드세요");
	}
	
	
	
	
}
