function saveInfo(nameList){
	var list = nameList.split(',');
	for(var name in list){
		var value = document.getElementsByName(name)[0].value;
		setSession(name, value);
	}
}

function setSession(key, value){
	sessionStorage.setItem(key, value);
}