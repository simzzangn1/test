package VO;

import java.io.Serializable;

public class SUPPLIES implements Serializable, Comparable {
	private String supplies_seq;
	private String supply_class;
	private String supplies_name;
	private String supplies_quantity;
	private String units_seq;

	public SUPPLIES() {
		super();
	}

	public SUPPLIES(String supplies_seq, String supply_class, String supplies_name, String supplies_quantity,
			String units_seq) {
		super();
		this.supplies_seq = supplies_seq;
		this.supply_class = supply_class;
		this.supplies_name = supplies_name;
		this.supplies_quantity = supplies_quantity;
		this.units_seq = units_seq;
	}

	public String getSupplies_seq() {
		return supplies_seq;
	}

	public void setSupplies_seq(String supplies_seq) {
		this.supplies_seq = supplies_seq;
	}

	public String getSupply_class() {
		return supply_class;
	}

	public void setSupply_class(String supply_class) {
		this.supply_class = supply_class;
	}

	public String getSupplies_name() {
		return supplies_name;
	}

	public void setSupplies_name(String supplies_name) {
		this.supplies_name = supplies_name;
	}

	public String getSupplies_quantity() {
		return supplies_quantity;
	}

	public void setSupplies_quantity(String supplies_quantity) {
		this.supplies_quantity = supplies_quantity;
	}

	public String getUnits_seq() {
		return units_seq;
	}

	public void setUnits_seq(String units_seq) {
		this.units_seq = units_seq;
	}

	@Override
	public String toString() {
		return "SUPPLIES [보급품 번호=" + supplies_seq + ", 보급품 종류=" + supply_class + ", 보급품 이름=" + supplies_name
				+ ", 보급품 수량=" + supplies_quantity + ", 부대번호=" + units_seq + "]";
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return Integer.parseInt(this.units_seq) - Integer.parseInt(((SUPPLIES) arg0).getUnits_seq());
	}

}
