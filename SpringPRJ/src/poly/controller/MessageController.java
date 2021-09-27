package poly.controller;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.ITestService;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Resource(name = "MessageService")
	private IMessageService messageService;

	@RequestMapping(value = "/send")
	public String send(ServletRequest request ,Model model) throws Exception {
		//더캠프 로그인 정보
    	UserDTO uDTO = new UserDTO();
        String thecamp_id = request.getParameter("id");
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
			model.addAttribute("msg", "발송에 실패했습니다.");
		}

		model.addAttribute("url", "/test/MessageTest.do");
		return "/alert";
	}

