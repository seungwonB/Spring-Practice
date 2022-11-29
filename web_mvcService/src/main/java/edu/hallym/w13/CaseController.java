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

@Controller
public class CaseController {
	@Autowired
	private CaseDB casedb;

	// 조회요청
	@RequestMapping(value = "/case_list.do", method = RequestMethod.GET)
	public String getCase(Model model, @RequestParam(value = "seq", required = false, defaultValue = "0") int seq) {
		if (seq == 0) {
			// 전체 조회
			List<Case> std = casedb.select();
			model.addAttribute("case_cmd", std);
			return "/list";
		} else {
			// 개별 조회
			Case std = casedb.select(seq);
			model.addAttribute("msg", std);
			return "/result";
		}
	}
	
	@RequestMapping(value = "/case_list_2021.do", method = RequestMethod.GET)
	public String getCase1(Model model, @RequestParam(value = "seq", required = false, defaultValue = "0") int seq) {
		if (seq == 0) {
			List<Case> std = casedb.select1();
			model.addAttribute("case_cmd", std);
			return "/list";
		} else {
			// 개별 조회
			Case std = casedb.select(seq);
			model.addAttribute("msg", std);
			return "/result";
		}
	}
	
	@RequestMapping(value = "/case_list_2020.do", method = RequestMethod.GET)
	public String getCase2(Model model, @RequestParam(value = "seq", required = false, defaultValue = "0") int seq) {
		if (seq == 0) {
			List<Case> std = casedb.select2();
			model.addAttribute("case_cmd", std);
			return "/list";
		} else {
			// 개별 조회
			Case std = casedb.select(seq);
			model.addAttribute("msg", std);
			return "/result";
		}
	}
	
	@RequestMapping(value = "/case_list_2019.do", method = RequestMethod.GET)
	public String getCase3(Model model, @RequestParam(value = "seq", required = false, defaultValue = "0") int seq) {
		if (seq == 0) {
			List<Case> std = casedb.select3();
			model.addAttribute("case_cmd", std);
			return "/list";
		} else {
			// 개별 조회
			Case std = casedb.select(seq);
			model.addAttribute("msg", std);
			return "/result";
		}
	}
	
	// 삭제 요청
	@RequestMapping(value = "/case_delete.do", method = RequestMethod.GET)
	public String delete(@RequestParam(value = "seq", required = true) int seq) {
		casedb.delete(seq);
		return "redirect:/case_list.do";
	}

}
