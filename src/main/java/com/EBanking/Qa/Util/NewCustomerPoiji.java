package com.EBanking.Qa.Util;

import com.poiji.annotation.ExcelCellName;

public class NewCustomerPoiji {
	@ExcelCellName("Customer Name")
	private String Cname;

	@ExcelCellName("Address")
	private String Addres;

	@ExcelCellName("City")
	private String city;

	@ExcelCellName("State")
	private String state;

	@ExcelCellName("PIN")
	private long pin;

	@ExcelCellName("Mobile number")
	private long Mobileno;

	@ExcelCellName("E-Mail")
	private String email;

	@ExcelCellName("Password")
	private String Pword;

	public String getCname() {
		return Cname;
	}

	public String getAddres() {
		return Addres;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public long getPin() {
		return pin;
	}

	public long getMobileno() {
		return Mobileno;
	}

	public String getEmail() {
		return email;
	}

	public String getPword() {
		return Pword;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public void setAddres(String addres) {
		Addres = addres;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPin(long pin) {
		this.pin = pin;
	}

	public void setMobileno(long mobileno) {
		Mobileno = mobileno;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPword(String pword) {
		Pword = pword;
	}

	public NewCustomerPoiji nc() {
		return this;
	}
}
