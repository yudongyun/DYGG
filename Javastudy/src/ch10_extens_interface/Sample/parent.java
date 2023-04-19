package ch10_extens_interface.Sample;

// 자바에서는 기본적으로 모든 클래스가 object 라는 클래스를 상속받고 있다.
// 이게 보이지 않는 상태일 뿐..
public class parent {
	
	private String name;
	private int age;
	
	public parent() {
//		this("아빠", 50);
		
	}

	public parent(String name, int age) {
		// 부모 클래스의 기본 생성자를 의미
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public void sayHello() {
		System.out.println("어른이입니다.");
	}
	

	// 부모 클래스의 메소드를 자식 클래스에서 재 정의 ( override )해서 사용
	@Override
	public String toString() {
		return "parent [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	
	
	
}
