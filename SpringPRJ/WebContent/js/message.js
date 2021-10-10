function sendMessage(){
	var commonList = ['grpCdNm', 'name', 'birth', 'enterDate', 'title', 'sender', 'relation', 'pw', 'content'];
	for(var name in commonList){
		if(!chekNull(name)){
			return false;
		}
	}
	
	
	var grpCdNm = document.getElementsByName("grpCdNm")[0].value;
	
	if(grpCdNm == '육군'){
		var commonList = ['thecampId', 'thecampPw', 'trainUnitCdNm', 'trainUnitCdNm'];
		for(var name in commonList){
			if(!chekNull(name)){
				return false;
			}
		}
		
		$("#letterForm").attr("action", "/message/sendThecamp.do");
		
	}else if(grpCdNm == '공군'){
		$("#letterForm").attr("action", "/message/sendAirforce.do");
	}
	
	document.getElementById('letterForm').submit();
}

function chekNull(name){
	 var value = sessionStorage.getItem(name);

	if(value == null || value.length < 1){
		alert('설정되지 않은 정보가 있습니다!');
		return false;
	}else{
		document.getElementsByName(name)[0].value = value;
	}
}

