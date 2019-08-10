<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource var="ds" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:orcl" user="scott"
		password="tiger" />
	<sql:query dataSource="${ds}" var="country">
		select distinct(country_name) from country_info
		</sql:query>
		
		
		<sql:query dataSource="${ds}" var="standard">
		select standard from fees_info
		</sql:query>

	<form action="registerStudent">

		Student Name : <input type="text" name="student_name" required>
		<P>
			DOB :<input type="date" name="date_of_birth" required>
		<P>Guardian Type :
		<p>
			Parent :<input type="radio" value="P" name="guardian_type"
				required> Guardian :<input type="radio" value="G"
				name="guardian_type" required>
		<P>
			Guardian Name :<input type="text" name="guardian_name" required>
		<P>
		Country :
		<select>
			<c:forEach var="row" items="${country.rows}">
				<option value='${row.country_name}'>${row.country_name}</option>
			</c:forEach>
		</select><p>
			State :<input type="text" name="state" required>
		<P>
			Address :<br>
			<textarea rows="5" cols="35" name="address" required></textarea>
		<P>
			Contact No.<input type="text" name="contact_no" required>
		<P>
			Mail Id :<input type="text" name="mail_id" required>
		<P>
			Date of Joining :<input type="date" name="date_of_joining" required>
		<P>Gender :
		<p>
			Male <input type="radio" name="gender" value="M" required> Female <input
				type="radio" name="gender" value="F" required>
		<P>
			Standard :<select name="standard">
			<c:forEach var="row" items="${standard.rows}">
				<option value='${row.standard}'>${row.standard}</option>
			</c:forEach>
		</select>
		<P>Transport :
		<P>
			Yes <input type="radio" name="transport" value="Y" required> No <input
				type="radio" name="transport" value="N" required>
		<P>
			FeeViewer <a id="feeview" href=""> Link </a>
		<p>
			<input type="submit" value="Register">&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="Reset">
	</form>
</body>
</html>