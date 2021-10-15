function saveInfo(nameList){
	var list = nameList.split(',');
	for(var i in list){
		var name = list[i];
		var value = '';
		if(name == 'grpCdNm'){
			value = document.querySelector('input[name="' + name + '"]:checked').value;
			
		}else if(name == 'trainUnitCdNm'){
			value = $('select[name='+ name + ']').val();
		}else{
			var item = document.getElementsByName(name)[0];
			if(typeof item != 'undefined' && item != null && item != ''){
				value = item.value;
			}else{
				alert(name + ' 항목을 채워주세요!');
				return false;
			}
			
		}
		 
		
		if(typeof value != 'undefined' && value != null && value != ''){
			setSession(name, value);
		}
		
	}

	alert('저장되었습니다.');
}



function setInfo(keyList){
	var list = keyList.split(',');
	
	for(var i in list){
		var key = list[i];
		var value = getSession(key);
		if(typeof value != 'undefined' && value != null && value != ''){
			if(key == 'grpCdNm'){
				if(value == 'army'){
					$("#army_radio").trigger("click");
				}else if(value == 'airforce'){
					$("#airforce_radio").trigger("click");
				}
			}else if(name == 'trainUnitCdNm'){
				$("#trainUnitCdNm").text(value).attr("selected", "selected");
			}else{
				document.getElementsByName(key)[0].value = value;
			}
			
		}
	}
	
}

function setSession(key, value){
	sessionStorage.setItem(key + '', value + '');
}

function getSession(key){
	return sessionStorage.getItem(key);
}