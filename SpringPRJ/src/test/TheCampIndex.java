package test;

import poly.dto.CookieDTO;
import poly.dto.SoldierDTO;

public class TheCampIndex {
    public static void main(String[] args) {
        //tempData
        String USER_ID="hkgo6040@naver.com";
        String USER_PWD="seasky1!";

        String TRAINEE_NAME="±è¶¯¶¯";
        String TRAINEE_BIRTH="20011129";

        String CLASS_NAME="¿¹ºñ±ºÀÎ/ÈÆ·Ãº´";
        String GROUP_NAME="À°±º";
        String UNIT_NAME="28»ç´Ü";
        String ENTER_DATE="20200829";
        String RELATIONSHIP = "FRIEND";

        SoldierDTO sDTO = new SoldierDTO();
        //TODO sDTO.setter

        MessageDTO mDTO = new MessageDTO();
        //TODO mDTO.setter

        HttpResponse<String> response = Unirest.post("https://www.thecamp.or.kr/login/loginA.do")
        .header("content-type", "application/x-www-form-urlencoded")
        .body("state='email-login'&autoLoginYn='N'&userId=" + USER_ID + "&userPwd=" + USER_PWD)
        .asString();

        /*
        cookie_header = r.headers['set-cookie']
            num_iuid = cookie_header.find('iuid=')
            num_token = cookie_header.find('Token=')
            self.iuid = cookie_header[num_iuid:num_iuid + 12]
            self.token = cookie_header[num_token:num_token + 36]
        */
        
        /*msg = thecampy.Message([Á¦¸ñ], [³»¿ë(1500ÀÚ ÀÌÇÏ)])

        image = thecampy.ThecampyImage('sample.png')

        tc = thecampy.Client(email, pw)

        tc.get_soldier(my_soldier) #returns soldier code

        tc.send_message(my_soldier, msg, image)*/
    } 
}
