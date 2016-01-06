package java76.pms.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java76.pms.domain.Student;
import java76.pms.service.StudentService;

@Controller
@RequestMapping("/auth/*")
public class AuthController {

	@Autowired StudentService studentService; // 인터페이스를 구현한 객체 주소
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String loginform(){
		return "auth/LoginForm";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(
			String email,
			String password,
			String saveEmail,
			HttpServletResponse response,
			HttpSession session) {
		response.setContentType("text/plain;charset=UTF-8");
		
		Cookie emailCookie = null;

		if (saveEmail != null) { 
			emailCookie = new Cookie("email", email);
			emailCookie.setMaxAge(60 * 60 * 24 * 15);
			response.addCookie(emailCookie);
			
		} else {
			emailCookie = new Cookie("email", "");
			emailCookie.setMaxAge(0); 
			
		}
		response.addCookie(emailCookie);
		
		Student student = studentService.retrieve(email, password);
		
		if (student == null) {
			session.invalidate(); 
			return "/auth/LoginFail";
		}
		session.setAttribute("loginUser", student);
		return "redirect:../board/list.do";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.do";
	}
}
