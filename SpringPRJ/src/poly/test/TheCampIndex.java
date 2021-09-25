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

        String TRAINEE_NAME="�趯��";
        String TRAINEE_BIRTH="20011129";

        String CLASS_NAME="������/�Ʒú�";
        String GROUP_NAME="����";
        String UNIT_NAME="28���";
        String ENTER_DATE="20200829";
        String RELATIONSHIP = "FRIEND";

        SoldierDTO sDTO = new SoldierDTO();
        //-----------------------------------------------------------
        //�߼��� �޽���
        String title = "����";
        String content = "����";
        MessageDTO mDTO = new MessageDTO();
        mDTO.setTitle(title);
        mDTO.setContent(content);

        //-----------------------------------------------------------
        //�α��� ��Ű ����
        HttpResponse<String> response = Unirest.post("https://www.thecamp.or.kr/login/loginA.do")
        .header("content-type", "application/x-www-form-urlencoded")
        .body("state='email-login'&autoLoginYn='N'&userId=" + USER_ID + "&userPwd=" + USER_PWD)
        .asString();
        
        CookieDTO cDTO = new CookieDTO();
        if(response.getBody() == null || response.getBody().length() < 1) {
        	//Msg. ���� ���� �����ϴ�.
        }else if(response.getStatus() == 200) {
        	//Msg. ������ ����
        	 JSONParser jsonParser = new JSONParser();

             JSONObject jsonObj = (JSONObject) jsonParser.parse(response.getBody());
        	if(!jsonObj.get("resultCd").equals("0000")) {
        		//Msg. �˼� ���� ����
        	}
        }else if(response.getHeaders().get("Set-Cookie") == null || response.getHeaders().get("Set-Cookie").toString().length() < 1){
        	//Msg. ��Ű�� ã�� �� �����ϴ�.
        }else {
        	String cookie_header = response.getHeaders().get("Set-Cookie").toString();
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
        
        //-----------------------------------------------------------
        //�־��� �Ʒú��� ���� id(code) ��ȸ => ��ϵǾ����� ���� �Ʒú��̸� ��� �� ��ȸ
        
        
        
        
        /*msg = thecampy.Message([����], [����(1500�� ����)])

        image = thecampy.ThecampyImage('sample.png')

        tc = thecampy.Client(email, pw)

        tc.get_soldier(my_soldier) #returns soldier code

        tc.send_message(my_soldier, msg, image)*/
    } 
}
