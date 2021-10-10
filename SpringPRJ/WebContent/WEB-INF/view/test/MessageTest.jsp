<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>더캠프 메시지 발송 테스트</title>
</head>
<body>
	<h4>[육군]더캠프 라이브러리</h4>
	<form action="/message/sendThecamp.do">
		<h5>더캠프 아이디</h5>
		아이디 : <input type="text" name="id" value="hkgo6040@naver.com" readonly><br/>
		비밀번호 : <input type="text" name="pw" value="seasky1!" readonly><br/>
		
		<h5>입대자 정보(Soldier)</h5>
		성분(default) : <input type="text" name="missSoldierClassCdNm" value="예비군인/훈련병" readonly><br/>
		군종(default) :<input type="text" name="grpCdNm" value="육군" readonly><br/>
		이름 : <input type="text" name="name"><br/>
		생년월일(8자리) : <input type="text" name="birth"><br/>
		입영부대 : 
		<select name="trainUnitCdNm" id="trainUnitCdNm">
		</select><br/>
		입영일(8자리) : <input type="text" name="enterDate"><br/>
		관계 : 
		<select name="trainUnitCdNm">
		    <option value="PARENT">부모</option>
		    <option value="SPOUSE">배우자</option>
		    <option value="SIBLING">형제/자매</option>
		    <option value="FRIEND">친구</option>
		    <option value="LOVER">애인</option>
		    <option value="RELATIVE">친척</option>
		    <option value="FAN">팬</option>
		</select><br/>
		발송자 명 : <input type="text" name="sender"><br/>
		
		<h5>편지 내용(Message)</h5>
		제목 : <input type="text" name="title" value="더캠프 라이브러리 테스트"><br/>
		내용 : <textarea name="content">더캠프 라이브러리 발송을 위한 테스트 중입니다. 이 내용을 폐기 하십시오.\n This is TheCamp Test.</textarea><br/><br/>
		
		<input type="submit" value="발송">
		
	</form>
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			var division = "1사단,2사단,3사단,5사단,6사단,7사단,9사단,11사단,12사단,15사단,17사단,20사단,21사단,22사단,23사단,25사단,27사단,28사단,30사단,31사단,32사단,35사단,36사단,37사단,39사단,50사단,51사단,53사단,육군훈련소,육군훈련소(23연대),육군훈련소(25연대),육군훈련소(26연대),육군훈련소(27연대),육군훈련소(28연대),육군훈련소(29연대),육군훈련소(30연대)";
			
			var items = division.split(',');
			items.forEach(function(item) {
				 var option = $("<option value=\"" + item + "\">" + item + "</option>");
	             $('#trainUnitCdNm').append(option);
			});
		});
		
	</script>
	<p>
		자세한 알고리즘과 에러시 발생하는 메시지는 아래 경로의 테스트 파일을 참고해주세요!<br>
		SpringPRJ/src/poly/util/TheCampLibrary.java
	</p>
	<hr/>
	<h4>[공군]</h4>
	<form action="/message/sendAirforce.do">
		<h5>입대자 정보(Soldier)</h5>
		이름 : <input type="text" name="name"><br/>
		생년월일(8자리) : <input type="text" name="birth"><br/>
		입영일(8자리) : <input type="text" name="enterDate">
		
		<h5>편지 내용(Message)</h5>
		제목 : <input type="text" name="title" value="더캠프 라이브러리 테스트"><br/>
		내용 : <textarea name="content">더캠프 라이브러리 발송을 위한 테스트 중입니다. 이 내용을 폐기 하십시오.\n <br/> This is TheCamp Test.</textarea><br/>
		비밀번호 : <input type="password" name="pw"><br/>
		관계 : <input type="text" name="relation" value="더캠프"><br/>
		발송자 명 : <input type="text" name="sender"><br/>
		
		<input type="submit" value="발송">
		
	</form>
</body>
</html>