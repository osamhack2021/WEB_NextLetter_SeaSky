<%@page import="poly.util.CmmUtil"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<body>
	<form action="https://www.airforce.mil.kr/user/emailPicSaveEmail.action" method="POST">
			<input type="text" id="siteId" name="siteId" value="last2">
			<input type="text" id="command2" name="command2" value="writeEmail">
			<!-- 2021-06-01 세션 끊김 대비 start-->
			<input type="text" id="memberSeqVal" name="memberSeqVal" value="278989392">
			<input type="text" id="sodaeVal" name="sodaeVal" value="3404"><!-- 3중대 4소대 04번 -->
			
			<input type="text" id="senderName" name="senderName" value="더캠프" class="UItext" size="15" maxlength="15"><br>
			<input type="text" id="relationship" name="relationship" value="더캠프" class="UItext" size="15" maxlength="15"><br>
			<input type="text" id="title" name="title" value="더캠프 테스트" class="UItext W95p" maxlength="150"><br>
			
			<textarea id="contents" name="contents" maxlength="1200" class="UItextarea" onkeyup="calContentsCnt(this.value);">더캠프 테스트 중입니다.</textarea><br>
			<input type="password" id="password" name="password" class="UItext" value="1234"><br>
			<input type="submit">
	</form>
</body>
</html>

<!--
	1.교육생 검색
	https://www.airforce.mil.kr/user/emailPicViewSameMembers.action?siteId=last2&searchName=오승완&searchBirth=20030124
	2.html 파싱 -> if 입대날짜. memberSeqVal, sodaeVal  <input type="button" class="choice" value="선택하기" onclick="resultSelect('278989392')">
	3.개인페이지
	https://www.airforce.mil.kr/user/indexSub.action?codyMenuSeq=156893223&siteId=last2&menuUIType=sub&dum=dum&command2=getEmailList&searchName=%EC%98%A4%EC%8A%B9%EC%99%84&searchBirth=20030124&memberSeq=278989392
 -->