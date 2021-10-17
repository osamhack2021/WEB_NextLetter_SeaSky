function setInfo(keyList){
	var list = keyList.split(',');
	
	for(var i in list){
		var key = list[i];
		var value = getSession(key);
		if(typeof value != 'undefined' && value != null && value != ''){
			document.getElementById('user_' + key).innerText = value;
		}
	}
	
}

function getSession(key){
	return localStorage.getItem(key);
}