package VO;

public class EggVO {

	private String egg_seq;
	private String chicken_seq;
	private String egg_price;
	private String egg_grade;

	public EggVO() {
		super();
	}

	public EggVO(String egg_seq, String chicken_seq, String egg_price, String egg_grade) {
		super();
		this.egg_seq = egg_seq;
		this.chicken_seq = chicken_seq;
		this.egg_price = egg_price;
		this.egg_grade = egg_grade;
	}

	public String getEgg_seq() {
		return egg_seq;
	}

	public void setEgg_seq(String egg_seq) {
		this.egg_seq = egg_seq;
	}

	public String getChicken_seq() {
		return chicken_seq;
	}

	public void setChicken_seq(String chicken_seq) {
		this.chicken_seq = chicken_seq;
	}

	public String getEgg_price() {
		return egg_price;
	}

	public void setEgg_price(String egg_price) {
		this.egg_price = egg_price;
	}

	public String getEgg_grade() {
		return egg_grade;
	}

	public void setEgg_grade(String egg_grade) {
		this.egg_grade = egg_grade;
	}

	@Override
	public String toString() {
		return "EggVO [egg_seq=" + egg_seq + ", chicken_seq=" + chicken_seq + ", egg_price=" + egg_price
				+ ", egg_grade=" + egg_grade + "]";
	}

}
