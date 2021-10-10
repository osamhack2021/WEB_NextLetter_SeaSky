package poly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	/*@Resource(name = "MessageService")
	private IMessageService messageService;*/

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
	public String profile() throws Exception {
		
		return "/pages/profile";
	}
	
	@RequestMapping(value = "register")
	public String register() throws Exception {
		
		return "/pages/register";
	}
	
	@RequestMapping(value = "template")
	public String template() throws Exception {
		
		return "/pages/template";
	}
	
	@RequestMapping(value = "tos")
	public String tos() throws Exception {
		
		return "/pages/tos";
	}
}
