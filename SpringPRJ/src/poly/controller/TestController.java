package poly.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.ITestService;

@Controller
//@RequestMapping("/admin")
public class TestController {

	@Resource(name = "TestService")
	private ITestService testService;
	
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

}
