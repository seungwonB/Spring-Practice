package edu.hallym.w13;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.hallym.w13.Student;

@Controller
public class StdController {
	@Autowired
	private StdDB stddb;
	
	@RequestMapping(value = "/stdinput.do", method = RequestMethod.POST)
	public String eprocess3(@ModelAttribute Student ret, Model model) {
		model.addAttribute("msg", ret);
		stddb.create(ret);
		return "/result";
	}

	@RequestMapping(value = "/std1.do", method = RequestMethod.GET)
	public String eprocess1(Model model) {
		model.addAttribute("msg", new Student());
		return "/stdinput";
	}

	@RequestMapping(value = "/std2.do", method = RequestMethod.GET)
	public ModelAndView eprocess2() {
		ModelAndView k = new ModelAndView("/stdinput", "msg", new Student());
		return k;
	}

	// 조회요청
	@RequestMapping(value = "/std_list.do", method = RequestMethod.GET)
	public String getStudent(Model model, @RequestParam(value = "seq", required = false, defaultValue = "0") int seq) {
		if (seq == 0) {
			// 전체 학생 조회
			List<Student> std = stddb.select();
			model.addAttribute("std_cmd", std);
			return "list";
		} else {
			// 개별 학생 조회
			Student std = stddb.select(seq);
			model.addAttribute("msg", std);
			return "result";
		}
	}
	
	@RequestMapping(value = "/std_delete.do", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "seq", required = true) int seq) {
		stddb.delete(seq);
		return "redirect:/std_list.do";
	}
}
