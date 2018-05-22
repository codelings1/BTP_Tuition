<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
input[type="checkbox"] {
	width: 20px; /*Desired width*/
	height: 20px; /*Desired height*/
}

table {
	color: yellow;
	background-color: blue;
}

a {
	color: yellow;
}

tr {
	background-color: green;
}

table,th,td {
	border: 1px solid black;
}

td {
	text-align: center;
}
</style>
</head>
<body>
	<form action="/Spring_Btp/attendanceEnter/${batchName}" method="POST"
		name="form1" onsubmit=checkcheckboxes()>
		<c:set value="" var="listId" />
		<table>

			<tr>
				<th>Student's Name</th>
				<th>Attendance for <span id="curr-date"></span></th>
			</tr>

			<c:forEach items="${batchStudents }" var="student">
				<c:set value="${listId}${student.id} " var="listId" />
				<tr>
					<!-- <td><input type = "hidden" name = "idlist" value = "hide"/></td> -->
					<!-- <td>
						<ul id="checkbox_submit">
							<li><input type="checkbox" value="Iron" name="check1" /></li>
							<li><input type="checkbox" value="Man" name="check1" /></li>
						</ul>
					</td> -->
					<td>${student.stud_name}</td>
					<td><input type="checkbox" name="attendancePresent"
						value="${student.id}" /></td>
				</tr>
			</c:forEach>
		</table>

		<input type="submit" name="sub_but" value="Submit" />
		<%-- value = "${ listId}"> --%>
	</form>
	<script>
	    	n =  new Date();
	    	y = n.getFullYear();
	    	m = n.getMonth() + 1;
	    	d = n.getDate();
	    	document.getElementById("curr-date").innerHTML = d + "/" + m + "/" + y;
    		/* document.getElementById("curr-date").innerHTML = new Date(); */
    		
            function checkcheckboxes() {
            	var inputs = document.getElementsByTagName('input');
	    		var selectedCheckboxes = "";
				for(var i=0; i<inputs.length; i++){
					console.log("1");
					if(inputs[i].getAttribute('type')=='checkbox')					{
						console.log("2");
						if((inputs[i].checked))					    {
							console.log("3");
					        selectedCheckboxes += inputs[i].getAttribute('value') + "-";
					    }
						console.log("4");
					}
					console.log("5");
				}
				document.getElementsByName("idlist").innerHTML = selectedCheckboxes;
				//alert(selectedCheckboxes);
				//alert(document.getElementById("checkbox_submit").getAttribute("value"));
				console.log(selectedCheckboxes);
            }
			
            //if(document.getElementByTagName("input").checked)
    	</script>
</body>
</html>