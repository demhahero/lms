package com.mju.software;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClassController extends ControllerClass {
	@RequestMapping(value = "/createclass", method = RequestMethod.GET)
	public ModelAndView createclass(Locale locale, Model model) {
		
		ModelAndView mav = new ModelAndView();
	
		mav.setViewName("createclass");
		return mav;
	}
	
	@RequestMapping(value = "/createclassdone", method = RequestMethod.POST)
	public ModelAndView createclassdone(Locale locale, Model model , @ModelAttribute("title") String title) {
		ModelAndView mav = new ModelAndView();
		
		if(dbhelper.createClass(title, 1))
			mav.addObject("res" , "yes");
		else
			mav.addObject("res", "no");
		
		mav.setViewName("createclassdone");
		return mav;
	}
}
