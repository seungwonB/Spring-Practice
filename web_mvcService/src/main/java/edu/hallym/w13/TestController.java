package edu.hallym.w13;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TestController {
	@RequestMapping(value = "/t1.do", method = RequestMethod.GET)
	public String myTitle(Model model) {
		model.addAttribute("cmd", new TestModel("t1"));
		return "t1";
	}
	
	@RequestMapping(value = "/testmodelandview", method = RequestMethod.GET)
	public ModelAndView myTitle() {
		ModelAndView ret = new ModelAndView();
		ret.setViewName("testmodelandview");
		ret.addObject("cmd", new TestModel("testmodelandview"));
		
		return ret;
	}
	
	@RequestMapping(value = "/myvoid", method = RequestMethod.GET)
	public void mine(Model model) {
		model.addAttribute("cmd", new TestModel("myvoid"));
	}
	
	@RequestMapping(value = "/mymodel", method = RequestMethod.GET)
	public TestModel mymodel() {
		return new TestModel("mymodel");
	}
	
	@RequestMapping(value = "/mybody2", method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> myBody2() {
		HttpHeaders h = new HttpHeaders();
		h.add("Content-Type", "text/html; charset=UTF-8");
		
		String html = "<h1>TestTest.. Testing now</h1>";
		return new ResponseEntity<String>(html, h, HttpStatus.OK);
	}
}
