package ch10_extens_interface.Sample;

// Child 는 parent가 가진 필드변수, 메소드를 가지고 있는 상태임 ( extend )
// private 로 되어있는건 자식 객체에서 접근 할 수 없다.
public class Child extends parent{
	
	// 굳이 useing 필드를 안써도 슈퍼클래스에서 호출할 수 있다.
	
	public Child() {
		super(); // 부모 클래스의 기본생성자를 호출한다.
	}

	public Child(String name, int age) {
		super(name, age);
	}

	@Override
	public void sayHello() {
//		super.sayHello(); // 부모객체의 sayHello가 실행되는 형태임
		System.out.println("응애에요"); // 메소드르 바꿀 수 있음 자식단에서
	}

	@Override
	public String toString() {
		return "Child [getName()=" + super.getName() + ", getAge()=" + getAge() + "]";
	} // 부모가 가지고 있는 getname을 출력하게 된다
	
	
	
	
}
