package VO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class UNITS implements Serializable {
	private String units_seq;
	private String units_name;
	private String unit_username;
	private String unit_password;
	public UNITS() {
		super();
	}
	public UNITS(String units_seq, String units_name, String unit_username, String unit_password) {
		super();
		this.units_seq = units_seq;
		this.units_name = units_name;
		this.unit_username = unit_username;
		this.unit_password = unit_password;
	}
	public String getUnits_seq() {
		return units_seq;
	}
	public void setUnits_seq(String units_seq) {
		this.units_seq = units_seq;
	}
	public String getUnits_name() {
		return units_name;
	}
	public void setUnits_name(String units_name) {
		this.units_name = units_name;
	}
	public String getUnit_username() {
		return unit_username;
	}
	public void setUnit_username(String unit_username) {
		this.unit_username = unit_username;
	}
	public String getUnit_password() {
		return unit_password;
	}
	public void setUnit_password(String unit_password) {
		this.unit_password = unit_password;
	}
	@Override
	public String toString() {
		return "UNITS [부대번호=" + units_seq + ", 부대이름=" + units_name + ", 아이디=" + unit_username
				+ ", 패스워드=" + unit_password + "]";
	}

	
}
