<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��ķ�� �޽��� �߼� �׽�Ʈ</title>
</head>
<body>
	<form action="/sendMessage.do">
	
		<h5>��ķ�� ���̵�</h5>
		���̵� : <input type="text" name="id" value="hkgo6040@naver.com" readonly><br/>
		��й�ȣ : <input type="text" name="pw" value="seasky1!" readonly>
		<hr/>
		
		<h5>�Դ��� ����(Soldier)</h5>
		����(default) : <input type="text" name="missSoldierClassCdNm" value="������/�Ʒú�" readonly><br/>
		����(default) :<input type="text" name="grpCdNm" value="����" readonly><br/>
		�̸� : <input type="text" name="name"><br/>
		������� : <input type="text" name="birth"><br/>
		�Կ��δ� : 
		<select name="trainUnitCdNm" id="trainUnitCdNm">
		</select><br/>
		�Կ���(8�ڸ�) : <input type="text" name="enterDate"><br/>
		���� : 
		<select name="trainUnitCdNm">
		    <option value="PARENT">�θ�</option>
		    <option value="SPOUSE">�����</option>
		    <option value="SIBLING">����/�ڸ�</option>
		    <option value="FRIEND">ģ��</option>
		    <option value="LOVER">����</option>
		    <option value="RELATIVE">ģô</option>
		    <option value="FAN">��</option>
		</select>
		<hr/>
		
		<h5>�Դ��� ����(Soldier)</h5>
		���� : <input type="text" name="title"><br/>
		���� : <textarea name="content"></textarea><br/><br/>
		
		<input type="submit" value="�߼�">
		
	</form>
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			var division = "1���,2���,3���,5���,6���,7���,9���,11���,12���,15���,17���,20���,21���,22���,23���,25���,27���,28���,30���,31���,32���,35���,36���,37���,39���,50���,51���,53���,�����Ʒü�,�����Ʒü�(23����),�����Ʒü�(25����),�����Ʒü�(26����),�����Ʒü�(27����),�����Ʒü�(28����),�����Ʒü�(29����),�����Ʒü�(30����)";
			
			var items = division.split(',');
			items.forEach(function(item) {
				 var option = $("<option value=\"" + item + "\">" + item + "</option>");
	             $('#trainUnitCdNm').append(option);
			});
		});
		
	</script>
	<p>
		�ڼ��� �˰���� ������ �߻��ϴ� �޽����� �Ʒ� ����� �׽�Ʈ ������ �������ּ���!<br>
		SpringPRJ/src/poly/util/TheCampLibrary.java
	</p>
</body>
</html>