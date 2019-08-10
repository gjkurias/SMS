package com.sms.registration.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import com.sms.registration.model.Student;
import com.sms.registration.validation.BusinessException;

public class StudentDAO {
	
	Connection con;

	public StudentDAO() {
		super();
		// TODO Auto-generated constructor stub
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			con=DriverManager.getConnection("jdbc:h2:mem:studDb","sa","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	public int retrieveTotalRegistrations() {
		String query="select count(*) from student_info";
		ResultSet rs;
		try {
			PreparedStatement ps=con.prepareStatement(query);
			 rs=ps.executeQuery();
			 return rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	
	}
	
	public float retrieveFees(Student st) {
		String query;
		ResultSet rs;
		String std=st.getStandard();
		PreparedStatement ps;
		float netFees=0f;
		if(st.getTransport()=='Y') {
			query="select transportfee,stdfees from fees_info where standard=?";
			try {
				ps=con.prepareStatement(query);
				ps.setString(1, std);
				rs=ps.executeQuery();
				netFees=rs.getInt(2)+rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			query="select stdfees from fees_info where standard=?";
			try {
				ps=con.prepareStatement(query);
				ps.setString(1, std);
				rs=ps.executeQuery();
				netFees=rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return netFees;
		
	}
	
	public Student insertStudent(Student st) {
		
		String std=st.getStandard();
		Student vstd=st;
		LocalDate now = LocalDate.now(); //gets localDate
		LocalDate dob=st.getDate_of_birth().toLocalDate();
		Period diff = Period.between(dob, now); //difference between the dates is calculated  
		
		int age=diff.getYears();

		
		String query;
		ResultSet rs;
		PreparedStatement ps;
		int reqAge=0;
		
			query="select age from fees_info where standard=?";
			try {
				ps=con.prepareStatement(query);
				ps.setString(1, std);
				rs=ps.executeQuery();
				reqAge=rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
//		try {
//			if( st.getStudent_name().matches("^[a-zA-Z]*$")) {
//				throw new BusinessException(501);
//			}
//			else if(!(st.getMail_id().contains("@")&&st.getMail_id().contains("."))) {
//				throw new BusinessException(502);
//			}
//			else if(age<reqAge) {
//				throw new BusinessException(503);
//			}
//			else if(now.compareTo(dob)>0) {
//				throw new BusinessException(504);
//			}
//			else if(now.compareTo(st.getDate_of_joining().toLocalDate())<=0) {
//				throw new BusinessException(505);
//			}
//			else if(!st.getContact_no().matches("^[0-9]{10}$")) {
//				throw new BusinessException(506);
//			}
//		} catch (BusinessException e) {
//			e.getCode();
//		}
		
		st.setNet_fees((int)retrieveFees(st));
		
		String id=Integer.toString(retrieveTotalRegistrations()+1);
		st.setStudent_id(id);
		if(std.equals("I")||std.equals("II")||std.equals("III")||std.equals("IV")||std.equals("V")) {
			vstd.setStandard_category('P');
		}
		else if(std.equals("VI")||std.equals("VII")||std.equals("VIII")||std.equals("IX")||std.equals("X")) {
			vstd.setStandard_category('S');
		}
		else {
			vstd.setStandard_category('H');
		}
		
		return vstd;
	}
	
	
}
