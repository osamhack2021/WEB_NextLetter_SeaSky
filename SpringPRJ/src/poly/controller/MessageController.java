package poly.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.MessageDTO;
import poly.dto.SoldierDTO;
import poly.dto.UserDTO;
import poly.mail.AirForceLibrary;
import poly.mail.TheCampLibrary;
import poly.service.IMessageService;
import poly.util.CmmUtil;

@Controller
@RequestMapping("/message")
public class MessageController {

	@Resource(name = "MessageService")
	private IMessageService messageService;

	@RequestMapping(value = "/sendThecamp", method=RequestMethod.POST)
	public String sendThecamp(ServletRequest request ,Model model) throws Exception {
		//더캠프 로그인 정보
    	UserDTO uDTO = new UserDTO();
        String thecamp_id = CmmUtil.nvl((String) request.getParameter("thecampId"));
        uDTO.setThecamp_id(thecamp_id);
        String thecamp_pw = CmmUtil.nvl((String) request.getParameter("thecampPw"));
        uDTO.setThecamp_pw(thecamp_pw);

      //입대자 정보
        SoldierDTO sDTO = new SoldierDTO();
        String name = CmmUtil.nvl((String) request.getParameter("name"));
        sDTO.setName(name);
        String birth = CmmUtil.nvl((String) request.getParameter("birth")).replaceAll("-", "");
        sDTO.setBirth(birth);
        String missSoldierClassCdNm = "예비군인/훈련병";
        sDTO.setMissSoldierClassCdNm(missSoldierClassCdNm);
        String grpCdNm = CmmUtil.nvl((String) request.getParameter("grpCdNm"));
        sDTO.setGrpCdNm(grpCdNm);
        String trainUnitCdNm = CmmUtil.nvl((String) request.getParameter("trainUnitCdNm"));
        sDTO.setTrainUnitCdNm(trainUnitCdNm);
        String enterDate = CmmUtil.nvl((String) request.getParameter("enterDate")).replaceAll("-", "");
        sDTO.setEnterDate(enterDate);
        String missSoldierRelationship = "FRIEND";
        sDTO.setMissSoldierRelationship(missSoldierRelationship);


        System.out.println(birth);
        System.out.println(enterDate);
        
        //발송할 메시지
        String title = CmmUtil.nvl((String) request.getParameter("title"));
        String relation = CmmUtil.nvl((String) request.getParameter("relation"));
        String sender = CmmUtil.nvl((String) request.getParameter("sender"));
        String content = CmmUtil.nvl((String) request.getParameter("content"));
        String pw = CmmUtil.nvl((String) request.getParameter("pw"));
        MessageDTO mDTO = new MessageDTO();
        mDTO.setTitle(title);
        mDTO.setContent("From. 『" + relation + ", " + sender + "』  " + content);
        mDTO.setPw(pw);
        
        try {
			String soldier_code = TheCampLibrary.getSoliderCode(uDTO, sDTO);
			String msg = TheCampLibrary.sendMsg(uDTO, sDTO, soldier_code, mDTO);
			if(msg.equals("success")) {
				model.addAttribute("msg", "발송에 성공했습니다.");
				
				mDTO.setRelation(relation);
				mDTO.setSender(sender);
				//로그인 가정.
				mDTO.setUser_no("1");
				try {
					messageService.insertMessage(mDTO);
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					model.addAttribute("msg", "DB저장에 실패했습니다.");
				}
				
			}else {
				model.addAttribute("msg", msg);
			}
			
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", "발송에 실패했습니다.");
		}

		model.addAttribute("url", "/linkpage.do");
		return "/alert";
	}
	
	@RequestMapping(value = "/sendAirforce", method=RequestMethod.POST)
	public String sendAirforce(ServletRequest request ,Model model) throws Exception {
		//입대자 정보
		SoldierDTO sDTO = new SoldierDTO();
		
        String name = CmmUtil.nvl((String) request.getParameter("name"));
        sDTO.setName(name);
        String birth = CmmUtil.nvl((String) request.getParameter("birth")).replaceAll("-", "");
        sDTO.setBirth(birth);
        String enterDate = CmmUtil.nvl((String) request.getParameter("enterDate")).replaceAll("-", "");
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
				try {
					messageService.insertMessage(mDTO);
				}catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("msg", "DB저장에 실패했습니다.");
				}
			}else {
				model.addAttribute("msg", msg);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", "발송에 실패했습니다.");
		}
		
		model.addAttribute("url", "/linkpage.do");
		return "/alert";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getContents", method=RequestMethod.POST)
	public Map<String, Object> getContents(ServletRequest request) throws Exception {
		Map<String, Object> hMap = new HashMap<String, Object>();
		String message_no = CmmUtil.nvl((String) request.getParameter("message_no"));
		String pw = CmmUtil.nvl((String) request.getParameter("pw"));
		
		MessageDTO mDTO = new MessageDTO();
		mDTO.setMessage_no(message_no);
		mDTO.setPw(pw);
		
		String contents = messageService.getSendedMessage(mDTO);

		if(contents != null && contents.length() > 1) {
			hMap.put("msg", "success");
			hMap.put("contents", contents);
		}else {
			hMap.put("msg", "비밀번호가 틀렸습니다.");
		}
		
		return hMap;
	}

}