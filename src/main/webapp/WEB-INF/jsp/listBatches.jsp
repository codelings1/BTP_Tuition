<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	table{color: yellow;
  		background-color: blue;
    }
    a{color: yellow;
    	
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
			<th>Batches</th>
			<th>Attendance</th>
		</tr>
		<c:forEach items = "${listBatches }" var = "batch">
			<tr>
				<td><a href = "specificBatch/${batch}">${batch}</a></td>
				<%-- <td><a href = " < c:url value = 'attendanceEnter/${batch}' /> " > GO TO ATTENDANCE SHEETs </a> </td> --%>
				<td><a href = " < c:url value = 'initiateAttendanceModel/${batch}' /> " > FILL ATTENDANCE SHEET </a> </td>
				<td><a href = " < c:url value = 'batchDatesList/${batch}' /> " > VIEW ATTENDANCE SHEET </a> </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

