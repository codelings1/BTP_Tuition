<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
    .hell{
  	    background-color: red;
  	}
  	table , a{color: yellow;
  		background-color: blue;
    }
    tr {
  		background-color: green;
    }
    table, th, td {
    	border: 1px solid black;
  	}
  	td{
		text-align: center;
  	}
  	
</style>

</head>
<body>
	<table>
		<tr>
		    <th>Id</th>
			<th>Name</th>
			<th>Class</th>
			<th>Batch Timings</th>
			<th>Joining Date</th>
			<th>Fee Submitted Upto Month</th>
		</tr>
		<c:forEach items="${batchStudents}" var="student">
			<c:set value = "" var = "cssClass"/>
			<c:if test="${student.stud_fee_submitted_upto_month == 'January'}">
				<c:set value = "hell" var = "cssClass"/>
				<!-- <style>
					tr.hell{
						background-color: red;
					}
				</style> -->
			</c:if>
			<tr class = "${cssClass}">
			<%-- <tr class = "${student.id >= 10 ? 'hell' : 'odd'}"> --%>
				<td>${student.id }</td>
				<td>${student.stud_name}</td>
				<td>${student.stud_class}</td>
				<td>${student.stud_batch_time}</td>
				<td>${student.stud_joining}</td>
				<td>${student.stud_fee_submitted_upto_month}</td>
				<td><a href = " < c:url value = 'edit/${student.id}' /> " > Edit </a> </td>
				<td><a href = " < c:url value = 'remove/${student.id }'/>" > Remove </a> </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>