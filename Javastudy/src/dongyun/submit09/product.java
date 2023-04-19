package dongyun.submit09;

public class product {

	// 1. 필드 변수의 선언

	// #1-1번 문제
	private String name;
	private int price;

	// 2. 생성자
	public product(String name, int price) {
		this.name = name;
		this.price = price;

	}
	// toString() 추가
	@Override
	public String toString() {
		return "product [name=" + name + ", price=" + price + "]";
	}
	
	// getter setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
