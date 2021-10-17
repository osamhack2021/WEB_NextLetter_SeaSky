function setInput(keyList){
	var list = keyList.split(',');
	
	for(var i in list){
		var key = list[i];
		var value = getSession(key);
		if(typeof value != 'undefined' && value != null && value != ''){
			addInput(key, value);
		}
	}
	
}

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

function addInput(name, value){
	var message_form = document.forms['message_form'];
	var input   = document.createElement('input');

	input.type   = 'hidden';
	input.name  = name;
	input.value  = value;

	message_form.appendChild(input);
}

function getLetterContents(message_no){
	var pw = document.getElementsByName('pw_' + message_no)[0].value;
	$.ajax({
        type : "POST",            	
        url : "/message/getContents.do",
        data : {
        	message_no : message_no,
        	pw : pw
        },
        success : function(result){
            if(result.msg == 'success'){
            	document.getElementById('contents_' + message_no).innerText = result.contents;
            }else{
            	alert(result.msg);
            }
        },
        error : function(error){
            alert("통신 실패.")
        }
    });
}