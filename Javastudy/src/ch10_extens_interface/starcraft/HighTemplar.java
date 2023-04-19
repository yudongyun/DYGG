package ch10_extens_interface.starcraft;

public class HighTemplar extends StarUnit{

	private int shield;
	private int mp;
	
	public HighTemplar() {
		this("하이템플러", 0, 60, 0, 50, 150);
		
	}
	
	public void tthunderStorm() {
		mp -= 75;
		System.out.println("우르릉 쾅쾅 !");
		
	}
	
	
	
	public HighTemplar(String name, int damage, int hp, int armor, int shield, int mp) {
		super(name, damage, hp, armor);
		this.shield = shield;
		this.mp = mp;
	}

	@Override
	public String toString() {
		return "HighTemplar [name=" + super.getName() + ", damage=" + super.getDamage() + ", hp=" + super.getHp() + ", armor=" + super.getArmor() + ", shield="
				+ shield + ", mp=" + mp + "]";
	}

	

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}
	
	
	
	
}
