<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page trimDirectiveWhitespaces="true" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	input[type="text"]{
	  width: 200px; /*Desired width*/
	  /*height: 20px; Desired height*/
	}
	input[type="date"]{
	  width: 200px; /*Desired width*/
	  /*height: 20px; Desired height*/
	}
	input[type="number"]{
	  width: 200px; /*Desired width*/
	  /*height: 20px; Desired height*/
	}
  body {background-color: powderblue;
  	width: 100%;
  	height: 100%;
  }
  h4 {color: red;}
  table {color: yellow;
  		background-color: blue;
  		
  }
  tr {
  		background-color: green;
  }
  table, th, td {
    text-align: center;
    border: 1px solid black;
  }
  td{
	text-align: center;
  }
  .container{
  width: 100%;
  margin: 0;
  padding: 0;
  /* border: 1px solid gray; */
  background-color: red;
  }
  .leftIndex{
  	position: fixed;
  	width: 20%;
  	height: 799px;
  	margin: 0;
  	float: left;
  	background-color: pink;
   }
  .maintable{
  	float: left;
  	width: 40%;
  	margin-left: 30%;
  	
  }
  a{
  	margin-top: 100px;
  	text-decoration: underline;
  	color: white;
  	font-weight: 900;
  	font-family: sans-serif;
  	
  	
  }
</style>
</head>
<body>
<div class = "container-fluid">
	<div class = "leftIndex" >
		<h2>Select any of these:</h2>
		<div><a href="listStudents"> View List Of Students</a></div>
		<br/>
		<div><a href = "listBatches"> View List of Batches</a></div>
	</div>
	<div class = "maintable">
	<h4>Enter details for a new Student	</h4>
	<form:form modelAttribute = "student" action = "first" method = "POST">
		<table>
			<c:if test="${!empty student.id}">
				<tr>
					<td>
						<form:label path="id">
							<spring:message text="ID"/>
						</form:label>
					</td>
					<td>
						<form:input path="id" readonly="true" size="8"  disabled="true" />
						<form:hidden path="id" />
					</td> 
				</tr>
			</c:if>
			<tr>
				<td>Enter Student Name:</td>
				<td> <form:input path = "stud_name" type = "text" placeholder = "Enter student's name" required = "true"/>
			</tr>
			
			<tr>
				<td>Enter Student Class:</td>
				<td><form:input path = "stud_class" type = "number" min = "8" max = "12" placeholder = "11" required = "true"/>
			</tr>
			
			<tr>
				<td>Enter Student's Batch Timings:</td>
				<td><form:input path = "stud_batch_time" type = "text" placeholder = "5-6TTS" pattern = "(([0-9]-[0-9])(MWF|TTS))" required = "true"/>
			</tr>
			
			<tr>
				<td>Enter Student's Joining Date:</td>
				<td><form:input path = "stud_joining" type = "date" placeholder = "mm/dd/yyyy" required = "true"/>
			</tr>
			
			<tr>
				<td>Fee Submitted Upto Month:</td>
				<td><form:input path = "stud_fee_submitted_upto_month" type = "text" placeholder = "March" required = "true"/>
			</tr>
			
			<tr>
				<td colspan = 2><input type = "submit" name = "Submit" value = "Submit"></td>
			</tr>
			
			
		</table>
	</form:form>
	</div>
	<%-- <div class = "bottom">
		<form>
			<!-- <h4>Click on the links below to view a list of students</h4> -->
			<button formaction="listStudents">View List Of Students</button>
			<button formaction = "listBatches">View List of Batches</button>
			
			<!-- <a href="listStudents">View List Of Students</a>
			<br/>
			<a href = "listBatches">List of Batches</a> -->
		</form>
	</div> --%>
</div>	
</body>
</html>