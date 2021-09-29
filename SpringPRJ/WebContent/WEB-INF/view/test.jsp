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
			<input type="hidden" id="siteId" name="siteId" value="last2">
			<input type="hidden" id="parent" name="parent" value="%2Fuser%2FindexSub.action%3FcodyMenuSeq%3D156893223%26siteId%3Dlast2%26menuUIType%3Dsub%26dum%3Ddum%26command2%3DwriteEmail%26searchCate%3D%26searchVal%3D%26page%3D1">
			<input type="hidden" id="page" name="page" value="1">
			<input type="hidden" id="command2" name="command2" value="writeEmail">
			
			<!-- 주소 -->
			<input type="text" id="senderZipcode" name="senderZipcode" value="31232" class="UItext" size="8" maxlength="8" readonly="readonly">	<br>
			<input type="text" id="senderAddr1" name="senderAddr1" value="충청남도 천안시 동남구 목천읍 독립기념관로 1" class="UItext W50p" readonly="readonly" onclick="javascript:alert('우편번호 검색을 통해서 입력하세요!');"><br>
			<input type="text" id="senderAddr2" name="senderAddr2" value="123" class="UItext W50p"><br>
			
			<input type="text" id="senderName" name="senderName" value="더캠프" class="UItext" size="15" maxlength="15"><br>
			<input type="text" id="relationship" name="relationship" value="더캠프" class="UItext" size="15" maxlength="15"><br>
			<input type="text" id="title" name="title" value="더캠프 테스트" class="UItext W95p" maxlength="150"><br>
			
			<textarea id="contents" name="contents" maxlength="1200" class="UItextarea" onkeyup="calContentsCnt(this.value);">더캠프 테스트 중입니다.</textarea><br>
			<input type="password" id="password" name="password" class="UItext" value="1234"><br>
			<input type="submit">
		</form>
</body>
</html>