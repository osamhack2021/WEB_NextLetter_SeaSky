package poly.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.MessageDTO;
import poly.service.IMessageService;
import poly.util.CmmUtil;

@Controller
//@RequestMapping("/admin")
public class TestController {

	@Resource(name = "MessageService")
	private IMessageService messageService;
	
//	@RequestMapping(value = "/loginProc", method = RequestMethod.GET)
//	public String loginProc(HttpServletRequest request, Model model, HttpSession session) throws Exception {
	
	@RequestMapping(value = "/test")
	public String test() throws Exception {
		
		return "/test";
	}
	
	

	@RequestMapping(value = "/test/MessageTest")
	public String MessageTest() throws Exception {
		
		return "/test/MessageTest";
	}
	
	@RequestMapping(value = "/test/MessageList")
	public String MessageList(ServletRequest request, Model model) throws Exception {
		//String user_no = CmmUtil.nvl((String) request.getParameter("user_no"));
		String user_no = "1";
		List<MessageDTO> mList = null;
		try {
			mList = messageService.getMessage(user_no);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println(mList);
		System.out.println(mList.get(0).getContent());
		model.addAttribute("messageList", mList);
		return "/test/MessageList";
	}
}
