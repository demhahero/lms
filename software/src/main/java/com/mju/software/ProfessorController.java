package com.mju.software;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mju.model.ClassModel;
@SessionAttributes("userid")
@Controller
public class ProfessorController extends ControllerClass {
	@RequestMapping(value = "/professor/createclass", method = RequestMethod.GET)
	public ModelAndView createclass(Locale locale, Model model, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
	
		ClassModel[] cma;
		cma = dbhelper.getAllProfessorClasses(Integer.parseInt(session.getAttribute("userid").toString()));
		
		String classList="";
		for(ClassModel cm : cma)
		{
			if(cm != null)
			classList = classList + "<p>"+cm.getTitle()+" | <a href='removeclass?id="+cm.getID()+"'>Delete</a></p>";
		}
		mav.addObject("classlist", classList);
		
		mav.setViewName("createclass");
		return mav;
	}
	
	@RequestMapping(value = "/professor/createclassdone", method = RequestMethod.POST)
	public ModelAndView createclassdone(Locale locale, Model model, HttpSession session , @ModelAttribute("title") String title) {
		ModelAndView mav = new ModelAndView();
		
		if(dbhelper.createClass(title, Integer.parseInt(session.getAttribute("userid").toString())))
			mav.addObject("res" , "yes");
		else
			mav.addObject("res", "no");
		
		mav.setViewName("createclassdone");
		return mav;
	}
	
	@RequestMapping(value = "/professor/removeclass", method = RequestMethod.GET)
	public ModelAndView deleteclass(Locale locale, Model model, @ModelAttribute("id") String id) {
		ModelAndView mav = new ModelAndView();
		
		if(dbhelper.removeClass(id))
			mav.addObject("res" , "yes");
		else
			mav.addObject("res", "no");
		
		mav.setViewName("professorremoveclass");
		return mav;
	}
	
}
