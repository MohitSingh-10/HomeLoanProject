package dao;

public class PersonalDetails {
	int customerId;
	String name;
	String email;
	int age;
	String dob;
	String panNumber;
	long aadharNo;
	String phoneNumber;
	char gender;
	String nationality;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public int getAge() {
		return age;
	}
	public String getDob() {
		return dob;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public char getGender() {
		return gender;
	}
	public String getNationality() {
		return nationality;
	}
	
}