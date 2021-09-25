package poly.test;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import poly.dto.CookieDTO;
import poly.dto.MessageDTO;
import poly.dto.SoldierDTO;

public class TheCampIndex {
    /**
     * @param args
     * @throws UnirestException
     * @throws ParseException 
     */
    public static void main(String[] args) throws UnirestException, ParseException {
        //tempData
        String USER_ID="hkgo6040@naver.com";
        String USER_PWD="seasky1!";

        String TRAINEE_NAME="김땡땡";
        String TRAINEE_BIRTH="20011129";

        String CLASS_NAME="예비군인/훈련병";
        String GROUP_NAME="육군";
        String UNIT_NAME="28사단";
        String ENTER_DATE="20200829";
        String RELATIONSHIP = "FRIEND";

        SoldierDTO sDTO = new SoldierDTO();
        //-----------------------------------------------------------
        //발송할 메시지
        String title = "제목";
        String content = "내용";
        MessageDTO mDTO = new MessageDTO();
        mDTO.setTitle(title);
        mDTO.setContent(content);

        //-----------------------------------------------------------
        //로그인 쿠키 수신
        HttpResponse<String> response = Unirest.post("https://www.thecamp.or.kr/login/loginA.do")
        .header("content-type", "application/x-www-form-urlencoded")
        .body("state='email-login'&autoLoginYn='N'&userId=" + USER_ID + "&userPwd=" + USER_PWD)
        .asString();
        
        CookieDTO cDTO = new CookieDTO();
        if(response.getBody() == null || response.getBody().length() < 1) {
        	//Msg. 응답 값이 없습니다.
        }else if(response.getStatus() == 200) {
        	//Msg. 응답은 성공
        	 JSONParser jsonParser = new JSONParser();

             JSONObject jsonObj = (JSONObject) jsonParser.parse(response.getBody());
        	if(!jsonObj.get("resultCd").equals("0000")) {
        		//Msg. 알수 없는 에러
        	}
        }else if(response.getHeaders().get("Set-Cookie") == null || response.getHeaders().get("Set-Cookie").toString().length() < 1){
        	//Msg. 쿠키를 찾을 수 없습니다.
        }else {
        	String cookie_header = response.getHeaders().get("Set-Cookie").toString();
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
        
        //-----------------------------------------------------------
        //주어진 훈련병의 고유 id(code) 조회 => 등록되어있지 않은 훈련병이면 등록 후 조회
        
        
        
        
        /*msg = thecampy.Message([제목], [내용(1500자 이하)])

        image = thecampy.ThecampyImage('sample.png')

        tc = thecampy.Client(email, pw)

        tc.get_soldier(my_soldier) #returns soldier code

        tc.send_message(my_soldier, msg, image)*/
    } 
}
