package poly.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.dto.MessageDTO;
import poly.service.IMessageService;

@Controller
public class IndexController {
	@Resource(name = "MessageService")
	private IMessageService messageService;
	
	@RequestMapping(value = "/editprofile")
	public String editprofile() throws Exception {
		
		return "/pages/editprofile";
	}
	
	@RequestMapping(value = "/index")
	public String index() throws Exception {
		
		return "/pages/index";
	}
	
	@RequestMapping(value = "/login")
	public String login() throws Exception {
		
		return "/pages/login";
	}
	
	@RequestMapping(value = "profile")
	public String profile(Model model) throws Exception {
		
		//String user_no = CmmUtil.nvl((String) request.getParameter("user_no"));
		String user_no = "1";
		List<MessageDTO> mList = null;
		try {
			mList = messageService.getMessage(user_no);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		model.addAttribute("messageList", mList);
		
		return "/pages/profile";
	}
	
	@RequestMapping(value = "register")
	public String register() throws Exception {
		
		return "/pages/register";
	}
	
	@RequestMapping(value = "tos")
	public String tos() throws Exception {
		
		return "/pages/tos";
	}
	
	@RequestMapping(value = "linkpage")
	public String linkpage(Model model) throws Exception {
		//String user_no = CmmUtil.nvl((String) request.getParameter("user_no"));
		String user_no = "1";
		List<MessageDTO> mList = null;
		try {
			mList = messageService.getMessage(user_no);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		model.addAttribute("messageList", mList);
		
		return "/pages/linkpage";
	}
}
