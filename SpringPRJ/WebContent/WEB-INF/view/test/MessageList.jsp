<%@page import="poly.dto.MessageDTO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	List<MessageDTO> mList = (List<MessageDTO>) request.getAttribute("messageList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	    <thead>
	        <tr>
	            <th>message_no</th>
	            <th>제목</th>
	            <th>내용</th>
	            <th>발송자</th>
	            <th>수취인(user_no)</th>
	        </tr>
	    </thead>
	    <tbody>
		    <c:forEach var="mDTO" items="${mList}" varStatus="status">
				<tr>
		            <td>${mDTO.message_no}</td>
		            <td>${mDTO.title}</td>
		            <td>${mDTO.content}</td>
		            <td>${mDTO.relation} ${mDTO.sender}</td>
		            <td>${mDTO.user_no}</td>
		        </tr>	
			</c:forEach>
	        
	    </tbody>
	</table>
</body>
</html>