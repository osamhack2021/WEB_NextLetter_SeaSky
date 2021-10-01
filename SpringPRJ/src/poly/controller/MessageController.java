package poly.controller;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.MessageDTO;
import poly.dto.SoldierDTO;
import poly.dto.UserDTO;
import poly.mail.AirForceLibrary;
import poly.mail.TheCampLibrary;
import poly.util.CmmUtil;

@Controller
@RequestMapping("/message")
public class MessageController {

//	@Resource(name = "MessageService")
//	private ITestService messageService;

	@RequestMapping(value = "/sendThecamp")
	public String sendThecamp(ServletRequest request ,Model model) throws Exception {
		//더캠프 로그인 정보
    	UserDTO uDTO = new UserDTO();
        String thecamp_id = CmmUtil.nvl((String) request.getParameter("id"));
        uDTO.setThecamp_id(thecamp_id);
        String thecamp_pw = CmmUtil.nvl((String) request.getParameter("pw"));
        uDTO.setThecamp_pw(thecamp_pw);

      //입대자 정보
        SoldierDTO sDTO = new SoldierDTO();
        String name = CmmUtil.nvl((String) request.getParameter("name"));
        sDTO.setName(name);
        String birth = CmmUtil.nvl((String) request.getParameter("birth"));
        sDTO.setBirth(birth);
        String missSoldierClassCdNm = CmmUtil.nvl((String) request.getParameter("missSoldierClassCdNm"));
        sDTO.setMissSoldierClassCdNm(missSoldierClassCdNm);
        String grpCdNm = CmmUtil.nvl((String) request.getParameter("grpCdNm"));
        sDTO.setGrpCdNm(grpCdNm);
        String trainUnitCdNm = CmmUtil.nvl((String) request.getParameter("trainUnitCdNm"));
        sDTO.setTrainUnitCdNm(trainUnitCdNm);
        String enterDate = CmmUtil.nvl((String) request.getParameter("enterDate"));
        sDTO.setEnterDate(enterDate);
        String missSoldierRelationship = CmmUtil.nvl((String) request.getParameter("missSoldierRelationship"));
        sDTO.setMissSoldierRelationship(missSoldierRelationship);

        
        //발송할 메시지
        String title = CmmUtil.nvl((String) request.getParameter("title"));
        String content = CmmUtil.nvl((String) request.getParameter("content"));
        MessageDTO mDTO = new MessageDTO();
        mDTO.setTitle(title);
        mDTO.setContent(content);
        
        try {
			String soldier_code = TheCampLibrary.getSoliderCode(uDTO, sDTO);
			String msg = TheCampLibrary.sendMsg(uDTO, sDTO, soldier_code, mDTO);
			if(msg.equals("success")) {
				model.addAttribute("msg", "발송에 성공했습니다.");
			}else {
				model.addAttribute("msg", msg);
			}
			
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", "발송에 실패했습니다.");
		}

		model.addAttribute("url", "/test/MessageTest.do");
		return "/alert";
	}
	
	@RequestMapping(value = "/sendAirforce")
	public String sendAirforce(ServletRequest request ,Model model) throws Exception {
		//입대자 정보
		SoldierDTO sDTO = new SoldierDTO();
		
        String name = CmmUtil.nvl((String) request.getParameter("name"));
        sDTO.setName(name);
        String birth = CmmUtil.nvl((String) request.getParameter("birth"));
        sDTO.setBirth(birth);
        String enterDate = CmmUtil.nvl((String) request.getParameter("enterDate"));
        sDTO.setEnterDate(enterDate);
		
        MessageDTO mDTO = new MessageDTO();
		
		String title = CmmUtil.nvl((String) request.getParameter("title"));
        String content = CmmUtil.nvl((String) request.getParameter("content"));
        String pw = CmmUtil.nvl((String) request.getParameter("pw"));
        String relation = CmmUtil.nvl((String) request.getParameter("relation"));
        
        mDTO.setTitle(title);
        mDTO.setContent(content);
        mDTO.setPw(pw);
        mDTO.setRelation(relation);
        
		String msg = "";
		
		try {
			msg = AirForceLibrary.sendMsg(sDTO, mDTO);
			
			if(msg.equals("success")) {
				model.addAttribute("msg", "발송에 성공했습니다.");
			}else {
				model.addAttribute("msg", msg);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", "발송에 실패했습니다.");
		}
		
		model.addAttribute("url", "/test/MessageTest.do");
		return "/alert";
	}

}