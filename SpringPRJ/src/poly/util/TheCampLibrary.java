package poly.util;

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
		//��ķ�� �α��� ����
    	UserDTO uDTO = new UserDTO();
        String thecamp_id="hkgo6040@naver.com";
        uDTO.setThecamp_id(thecamp_id);
        String thecamp_pw="seasky1!";
        uDTO.setThecamp_pw(thecamp_pw);

        //�Դ��� ����
        SoldierDTO sDTO = new SoldierDTO();
        String name="�趯��";
        sDTO.setName(name);
        String birth="20010616";
        sDTO.setBirth(birth);
        String missSoldierClassCdNm="������/�Ʒú�";
        sDTO.setMissSoldierClassCdNm(missSoldierClassCdNm);
        String grpCdNm="����";
        sDTO.setGrpCdNm(grpCdNm);
        String trainUnitCdNm="�����Ʒü�";
        sDTO.setTrainUnitCdNm(trainUnitCdNm);
        String enterDate="20210913";
        sDTO.setEnterDate(enterDate);
        String missSoldierRelationship = "FRIEND";
        sDTO.setMissSoldierRelationship(missSoldierRelationship);

        
        //�߼��� �޽���
        String title = "��ķ�� ���̺귯�� �׽�Ʈ";
        String content = "��ķ�� ���̺귯�� �߼��� ���� �׽�Ʈ ���Դϴ�. �� ������ ��� �Ͻʽÿ�.\n This is TheCamp Test.";
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
        	//Msg. ���� ���� �����ϴ�.
        }else if(login_response.getStatus() == 200) {
        	//Msg. ������ ����
	    	JsonParser jsonParser = new JsonParser();
	    	JsonObject jsonObj = jsonParser.parse(login_response.getBody()).getAsJsonObject();
        	if(!jsonObj.get("resultCd").getAsString().equals("0000")) {
        		//Msg. �˼� ���� ����
        	}else if(login_response.getHeaders().get("Set-Cookie") == null || login_response.getHeaders().get("Set-Cookie").toString().length() < 1){
            	//Msg. ��Ű�� ã�� �� �����ϴ�.
            }else {
            	String cookie_header = login_response.getHeaders().get("Set-Cookie").toString();
            	int iuid_index = cookie_header.indexOf("iuid=");
                String iuid = cookie_header.substring(iuid_index + 5, iuid_index + 12);
                int token_index = cookie_header.indexOf("Token=");
                String token = cookie_header.substring(token_index + 6, token_index + 36);
            
                if(iuid.length() < 1 || token.length() < 1) {
                	//Msg. ���� ���� �����ϴ�.
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
        	//Msg. ���� ���� �����ϴ�.
        }else if(cafe_response.getStatus() == 200) {
        	//Msg. ������ ����
        	JsonParser jsonParser = new JsonParser();
	        JsonObject jsonObj = jsonParser.parse(cafe_response.getBody()).getAsJsonObject();
        	if(!jsonObj.get("resultCd").getAsString().equals("9999")) {
        		//Msg. �˼� ���� ����
        		String error_msg = jsonObj.get("resultMsg").getAsString();
        	}else {
        		JsonArray jsonArray = jsonParser.parse(jsonObj.get("listResult").toString()).getAsJsonArray();
        		
        		if(jsonArray.size() < 1) {
        			//Msg. �ش��ϴ� ������ ã�� �� �����ϴ�.
        			System.out.println("�ش��ϴ� ������ ã�� �� �����ϴ�.");
        		}else {
        			JsonObject soldierJsonObj = jsonArray.get(0).getAsJsonObject();
        			soldier_code = soldierJsonObj.get("traineeMgrSeq").getAsString();
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
	        	//Msg. ���� ���� �����ϴ�.
	        }else if(add_solider_response.getStatus() == 200) {
	        	//Msg. ������ ����
	        	JsonParser jsonParser = new JsonParser();
		        JsonObject jsonObj = jsonParser.parse(cafe_response.getBody()).getAsJsonObject();
		        
		        String resultCd = jsonObj.get("resultCd").getAsString();
	        	if(!resultCd.equals("0000") && !resultCd.equals("E001")) {
	        		//Msg. �� �� ���� ����
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
		if(!sDTO.getMissSoldierClassCdNm().equals("������/�Ʒú�")) {
        	//������/�Ʒú����Ը� ������ ���� �� �ֽ��ϴ�.
        }else if(soldier_code.length() < 1){
        	//�Ʒú� �ĺ��ڵ带 ���� ���Ͽ����ϴ�.
        }else {
        	HttpResponse<String> msg_response = Unirest.post("https://www.thecamp.or.kr/consolLetter/insertConsolLetterA.do?")
        	  .header("Content-Type", "application/x-www-form-urlencoded")
        	  .header("Cookie", "Token=" + cDTO.getToken() + "; iuid=" + cDTO.getIuid())
        	  .field("traineeMgrSeq", soldier_code)
        	  .field("sympathyLetterContent", mDTO.getContent())
        	  .field("sympathyLetterSubject", mDTO.getTitle())
        	  .field("boardDiv", "sympathyLetter")
        	  //Y�̸� �߼��� ���ϰ� �ӽ� ���常!
        	  .field("tempSaveYn", "Y")
        	  .asString();
        	
        	System.out.println(msg_response.getBody().toString());
        	
        	if(msg_response.getBody() == null || msg_response.getBody().length() < 1) {
            	//Msg. ���� ���� �����ϴ�.
            }else if(msg_response.getStatus() == 200) {
            	//Msg. ������ ����
            	JsonParser jsonParser = new JsonParser();
    	        JsonObject jsonObj = jsonParser.parse(msg_response.getBody()).getAsJsonObject();
            	if(!jsonObj.get("resultCd").getAsString().equals("0000")) {
            		//Msg. �˼� ���� ����
            		msg = jsonObj.get("resultMsg").getAsString();
            	}else {
            		msg = "success";
            	}
            }
        }
		return msg;
	}
}
