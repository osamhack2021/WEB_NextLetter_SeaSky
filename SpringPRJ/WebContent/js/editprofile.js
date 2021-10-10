function saveInfo(nameList){
	var list = nameList.split(',');
	for(var i in list){
		var name = list[i];
		var value = document.getElementsByName(name)[0].value;
		
		if(typeof value != "undefined" && value != null && value != ""){
			setSession(name, value);
		}
		
	}
}



function setInfo(keyList){
	var list = keyList.split(',');
	
	for(var i in list){
		var key = list[i];
		var value = getSession(key);
		if(typeof value != "undefined" && value != null && value != ""){
			
			document.getElementsByName(key)[0].value = value;
		}
	}
	
}

function setSession(key, value){
	sessionStorage.setItem(key + '', value + '');
}

function getSession(key){
	return sessionStorage.getItem(key);
}