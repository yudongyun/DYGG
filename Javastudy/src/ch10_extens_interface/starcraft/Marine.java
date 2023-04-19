package ch10_extens_interface.starcraft;

public class Marine extends StarUnit {

	public Marine() {
		this("마린", 6, 50, 0);

	}

	public Marine(String name, int damage, int hp, int armor) {
		super(name, damage, hp, armor);
//		super.setName(name); 이렇게 쭉쭉 나열해도 상관없음

	}

	public void stimpack() {
		System.out.println("우아아아앙 !");
		super.setHp(super.getHp() - 10);
		super.setDamage(super.getDamage() * 2);

	}
	
	public void attack(StarUnit unit) { // main에서 자식 클래스를 넣어도 똑같이 적용된다
		unit.setHp(unit.getHp() - super.getDamage());
		
	}
	
//	public void attack(HighTemplar high) {
//		high.setHp(high.getHp() - super.getDamage());
//		
//	}
	
	
	
	
	@Override
	public String toString() {
		return "Marine [name=" + super.getName() + ", damage=" + super.getDamage() + ", hp=" + super.getHp()
				+ ", armor=" + super.getArmor() + "]";
	}

}
