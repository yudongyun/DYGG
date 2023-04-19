package ch10_extens_interface.Sample;

public class SimpleMain {

	public static void main(String[] args) {
		
		parent papa = new parent("아빠", 50);
		System.out.println(papa);
		
		// parent 와 똑같이 메소드가 적용되어 출력된다.
		Child baby = new Child();
		
		baby.setName("아기");
		baby.setAge(3);
		baby.sayHello();
		
		System.out.println(baby);
		
		// 다형성
		// (면접, 정처기 문제에 자주 출제)
		parent nami = new Child("나미", 17); // 오른쪽이 본체다.
		
		System.out.println(nami);
		System.out.println(nami.getClass()); // nami 라는 클래스의 타입이 뭐니
		nami.sayHello();
		
		
		
		
		
		
		
		
		
	}

}
