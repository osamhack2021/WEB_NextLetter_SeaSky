package poly.mail;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import poly.dto.CookieDTO;
import poly.dto.MessageDTO;
import poly.dto.SoldierDTO;
import poly.dto.UserDTO;

public class TheCampLibrary {
	public static void main(String[] args) {
		//더캠프 로그인 정보
    	UserDTO uDTO = new UserDTO();
        String thecamp_id="hkgo6040@naver.com";
        uDTO.setThecamp_id(thecamp_id);
        String thecamp_pw="seasky1!";
        uDTO.setThecamp_pw(thecamp_pw);

        //입대자 정보
        SoldierDTO sDTO = new SoldierDTO();
        String name="김땡땡";
        sDTO.setName(name);
        String birth="20010616";
        sDTO.setBirth(birth);
        String missSoldierClassCdNm="예비군인/훈련병";
        sDTO.setMissSoldierClassCdNm(missSoldierClassCdNm);
        String grpCdNm="육군";
        sDTO.setGrpCdNm(grpCdNm);
        String trainUnitCdNm="육군훈련소";
        sDTO.setTrainUnitCdNm(trainUnitCdNm);
        String enterDate="20210913";
        sDTO.setEnterDate(enterDate);
        String missSoldierRelationship = "FRIEND";
        sDTO.setMissSoldierRelationship(missSoldierRelationship);

        
      //발송할 메시지
        String title = "더캠프 라이브러리 테스트";
        String content = "더캠프 라이브러리 발송을 위한 테스트 중입니다. 이 내용을 폐기 하십시오.\n This is TheCamp Test.";
        MessageDTO mDTO = new MessageDTO();
        mDTO.setTitle(title);
        mDTO.setContent(content);
        
        try {
			String soldier_code = getSoliderCode(uDTO, sDTO);
			String msg = sendMsg(uDTO, sDTO, soldier_code, mDTO);
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static CookieDTO getCookie(UserDTO uDTO) throws UnirestException {
		HttpResponse<String> login_response = Unirest.post("https://www.thecamp.or.kr/login/loginA.do")
		        .header("content-type", "application/x-www-form-urlencoded")
		        .body("state='email-login'&autoLoginYn='N'&userId=" + uDTO.getThecamp_id() + "&userPwd=" + uDTO.getThecamp_pw())
		        .asString();
		
		System.out.println("login_response : " + login_response.getBody().toString());
		        
        CookieDTO cDTO = new CookieDTO();
        if(login_response.getBody() == null || login_response.getBody().length() < 1) {
        	//Msg. 응답 값이 없습니다.
        }else if(login_response.getStatus() == 200) {
        	//Msg. 응답은 성공
	    	JsonParser jsonParser = new JsonParser();
	    	JsonObject jsonObj = jsonParser.parse(login_response.getBody()).getAsJsonObject();
        	if(!jsonObj.get("resultCd").getAsString().equals("0000")) {
        		//Msg. 알수 없는 에러
        	}else if(login_response.getHeaders().get("Set-Cookie") == null || login_response.getHeaders().get("Set-Cookie").toString().length() < 1){
            	//Msg. 쿠키를 찾을 수 없습니다.
            }else {
            	String cookie_header = login_response.getHeaders().get("Set-Cookie").toString();
            	int iuid_index = cookie_header.indexOf("iuid=");
                String iuid = cookie_header.substring(iuid_index + 5, iuid_index + 12);
                int token_index = cookie_header.indexOf("Token=");
                String token = cookie_header.substring(token_index + 6, token_index + 36);
            
                if(iuid.length() < 1 || token.length() < 1) {
                	//Msg. 응답 값이 없습니다.
                } 
                cDTO.setIuid(iuid);
                cDTO.setToken(token);
            }
        }
        
        return cDTO;
	}
	
	public static String getSoliderCode(UserDTO uDTO, SoldierDTO sDTO) throws UnirestException {
		CookieDTO cDTO = getCookie(uDTO);
		String soldier_code = "";
        HttpResponse<String> cafe_response = Unirest.post("https://www.thecamp.or.kr/main/cafeCreateCheckA.do")
          .header("Content-Type", "application/x-www-form-urlencoded")
          .header("Cookie", "Token=" + cDTO.getToken() + "; iuid=" + cDTO.getIuid())
          .field("name", sDTO.getName())
          .field("birth", sDTO.getBirth())
          .field("enterDate", sDTO.getEnterDate())
          .field("trainUnitCd", sDTO.getTrainUnitCd())
          .field("grpCd", sDTO.getGrpCd())
          .asString();
        
        System.out.println("cafe_response : " + cafe_response.getBody().toString());
        
        if(cafe_response.getBody() == null || cafe_response.getBody().length() < 1) {
        	//Msg. 응답 값이 없습니다.
        	soldier_code = "응답 값이 없습니다. : soldier_code";
        }else if(cafe_response.getStatus() == 200) {
        	//Msg. 응답은 성공
        	JsonParser jsonParser = new JsonParser();
	        JsonObject jsonObj = jsonParser.parse(cafe_response.getBody()).getAsJsonObject();
        	if(!jsonObj.get("resultCd").getAsString().equals("9999")) {
        		//Msg. 알수 없는 에러
        		String error_msg = jsonObj.get("resultMsg").getAsString();
        		soldier_code = error_msg;
        	}else {
        		JsonArray jsonArray = jsonParser.parse(jsonObj.get("listResult").toString()).getAsJsonArray();
        		
        		if(jsonArray.size() < 1) {
        			//Msg. 해당하는 군인을 찾을 수 없습니다.
        			soldier_code = "해당하는 군인을 찾을 수 없습니다.";
        		}else {
        			JsonObject soldierJsonObj = jsonArray.get(0).getAsJsonObject();
        			soldier_code = "scuccess//" + soldierJsonObj.get("traineeMgrSeq").getAsString();
        		}
        	}
        }
        
        if(soldier_code.length() < 1) {
        	HttpResponse<String> add_solider_response = Unirest.post("https://www.thecamp.or.kr/missSoldier/insertDirectMissSoldierA.do")
        	          .header("Content-Type", "application/x-www-form-urlencoded")
        	          .header("Cookie", "Token=" + cDTO.getToken() + "; iuid=" + cDTO.getIuid())
        	          .field("missSoldierClassCdNm", sDTO.getMissSoldierClassCdNm())
        	          .field("missSoldierClassCd", sDTO.getMissSoldierClassCd())
        	          .field("grpCdNm", sDTO.getGrpCdNm())
        	          .field("grpCd", sDTO.getGrpCd())
        	          .field("name", sDTO.getName())
        	          .field("birth", sDTO.getBirth())
        	          .field("enterDate", sDTO.getEnterDate())
        	          .asString();
        	        
        	System.out.println("add_solider_response : " + add_solider_response.getBody().toString());
        	
	        if(add_solider_response.getBody() == null || add_solider_response.getBody().length() < 1) {
	        	//Msg. 응답 값이 없습니다.
	        	soldier_code = "응답 값이 없습니다.";
	        }else if(add_solider_response.getStatus() == 200) {
	        	//Msg. 응답은 성공
	        	JsonParser jsonParser = new JsonParser();
		        JsonObject jsonObj = jsonParser.parse(cafe_response.getBody()).getAsJsonObject();
		        
		        String resultCd = jsonObj.get("resultCd").getAsString();
	        	if(!resultCd.equals("0000") && !resultCd.equals("E001")) {
	        		//Msg. 알 수 없는 에러
	        		soldier_code = "알 수 없는 에러";
	        	}else {
	        		soldier_code = getSoliderCode(uDTO, sDTO);
	        	}
	        }
	        
        }
        return soldier_code;
	}
	
	public static String sendMsg(UserDTO uDTO, SoldierDTO sDTO, String soldier_code, MessageDTO mDTO) throws UnirestException {
		CookieDTO cDTO = getCookie(uDTO);
		
		String msg = "";
		if(!sDTO.getMissSoldierClassCdNm().equals("예비군인/훈련병")) {
        	//예비군인/훈련병에게만 편지를 보낼 수 있습니다.
			msg = "예비군인/훈련병에게만 편지를 보낼 수 있습니다.";
        }else if(!soldier_code.contains("scuccess//")){
        	//훈련병 식별코드를 받지 못하였습니다.
        	System.out.println();
        	msg = "훈련병 식별코드를 받지 못하였습니다. : " + soldier_code;
        }else {
        	soldier_code = soldier_code.replaceAll("scuccess//", "");
        	HttpResponse<String> msg_response = Unirest.post("https://www.thecamp.or.kr/consolLetter/insertConsolLetterA.do?")
        	  .header("Content-Type", "application/x-www-form-urlencoded")
        	  .header("Cookie", "Token=" + cDTO.getToken() + "; iuid=" + cDTO.getIuid())
        	  .field("traineeMgrSeq", soldier_code)
        	  .field("sympathyLetterContent", mDTO.getContent())
        	  .field("sympathyLetterSubject", mDTO.getTitle())
        	  .field("boardDiv", "sympathyLetter")
        	  //Y이면 발송은 안하고 임시 저장만!
        	  .field("tempSaveYn", "N")
        	  .asString();
        	
        	System.out.println("sendMsg : " + msg_response.getBody().toString());
        	
        	if(msg_response.getBody() == null || msg_response.getBody().length() < 1) {
            	//Msg. 응답 값이 없습니다.
        		msg = "응답 값이 없습니다.";
            }else if(msg_response.getStatus() == 200) {
            	//Msg. 응답은 성공
            	JsonParser jsonParser = new JsonParser();
    	        JsonObject jsonObj = jsonParser.parse(msg_response.getBody()).getAsJsonObject();
            	if(!jsonObj.get("resultCd").getAsString().equals("0000")) {
            		//Msg. 알수 없는 에러
            		msg = jsonObj.get("resultMsg").getAsString();
            	}else {
            		msg = "success";
            	}
            }
        }
		return msg;
	}
}
