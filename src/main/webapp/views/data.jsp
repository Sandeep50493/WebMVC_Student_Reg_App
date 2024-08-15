<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>View Students</h1>
   <a href="/">Add New Students</a>
   <br><br>
   <table border=1>
     <thead>
        <tr>
           <td>S.No</td>
           <td>Name</td>
           <td>Email</td>
           <td>Gender</td>
           <td>Course</td>
           <td>Timings</td>
        </tr>
     </thead>
     <tbody>
     <c:forEach  items="${students}" var="student"  varStatus="index">
        <tr>
          <td>${index.count}</td>
          <td>${student.name}</td>
          <td>${student.email}</td>
          <td>${student.gender}</td>
          <td>${student.course}</td>
          <td>${student.timings}</td>
        </tr>
     </c:forEach>
     </tbody>
   </table>  
</body>
</html>