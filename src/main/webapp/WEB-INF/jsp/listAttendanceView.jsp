<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
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
        <c:forEach items = "${listAttendance}" var = "attendanceRow" >
	    	<tr>
	    		<td>${attendanceRow.stud_id }</td>
	    		<td>${attendanceRow.date }</td>
	    		<td>${attendanceRow.stud_batch_time}</td>
	    		<td>${attendanceRow.status}</td>
	    	</tr>
	    	
    	</c:forEach>
    </table>
</body>
</html>