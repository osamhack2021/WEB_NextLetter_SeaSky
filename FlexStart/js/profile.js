function setInfo(keyList){
	var list = keyList.split(',');
	
	for(var i in list){
		var key = list[i];
		var value = getSession(key);
		if(typeof value != 'undefined' && value != null && value != ''){
			document.getElementById('user_' + key).innerText = value;
		}
	}
	
	//비밀번호 disable
	var grpCdNm = getSession('grpCdNm');
	if(typeof grpCdNm != 'undefined' && grpCdNm != null && grpCdNm != ''){
		if(grpCdNm == 'army'){
			document.getElementById('pw').disabled = true;
		}
	}
}

function getSession(key){
	return sessionStorage.getItem(key);
}