package com.sms.registration.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT_INFO")
public class Student {

	@Id
	private String student_id;
	private String student_name;
	private Date date_of_birth;
	private String guardian_type;
	private String guardian_name;
	private String address;
	private String country_id;
	private String contact_no;
	private String mail_id;
	private char gender;
	private String standard;
	private char standard_category;
	private char transport;
	private int net_fees;
	private Date date_of_joining;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(String student_id, String student_name, Date date_of_birth, String guardian_type,
			String guardian_name, String address, String country_id, String contact_no, String mail_id, char gender,
			String standard, char standard_category, char transport, int net_fees, Date date_of_joining) {
		super();
		this.student_id = student_id;
		this.student_name = student_name;
		this.date_of_birth = date_of_birth;
		this.guardian_type = guardian_type;
		this.guardian_name = guardian_name;
		this.address = address;
		this.country_id = country_id;
		this.contact_no = contact_no;
		this.mail_id = mail_id;
		this.gender = gender;
		this.standard = standard;
		this.standard_category = standard_category;
		this.transport = transport;
		this.net_fees = net_fees;
		this.date_of_joining = date_of_joining;
	}

	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getGuardian_type() {
		return guardian_type;
	}
	public void setGuardian_type(String guardian_type) {
		this.guardian_type = guardian_type;
	}
	public String getGuardian_name() {
		return guardian_name;
	}
	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry_id() {
		return country_id;
	}
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public char getStandard_category() {
		return standard_category;
	}
	public void setStandard_category(char standard_category) {
		this.standard_category = standard_category;
	}
	public char getTransport() {
		return transport;
	}
	public void setTransport(char transport) {
		this.transport = transport;
	}
	public int getNet_fees() {
		return net_fees;
	}
	public void setNet_fees(int net_fees) {
		this.net_fees = net_fees;
	}

	public Date getDate_of_joining() {
		return date_of_joining;
	}

	public void setDate_of_joining(Date date_of_joining) {
		this.date_of_joining = date_of_joining;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", date_of_birth="
				+ date_of_birth + ", guardian_type=" + guardian_type + ", guardian_name=" + guardian_name + ", address="
				+ address + ", country_id=" + country_id + ", contact_no=" + contact_no + ", mail_id=" + mail_id
				+ ", gender=" + gender + ", standard=" + standard + ", standard_category=" + standard_category
				+ ", transport=" + transport + ", net_fees=" + net_fees + ", date_of_joining=" + date_of_joining + "]";
	}
	
}
