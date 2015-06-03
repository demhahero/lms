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
public class StudentController extends ControllerClass {
	@RequestMapping(value = "/registerclass", method = RequestMethod.GET)
	public ModelAndView registerclass(Locale locale, Model model, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
	
		ClassModel[] cma;
		cma = dbhelper.getAllClasses();
		
		String classList="";
		for(ClassModel cm : cma)
		{
			if(cm != null)
			classList = classList + "<option value='"+cm.getID()+"'>"+cm.getTitle()+"</option>";
		}
		mav.addObject("classlist", classList);
		
		
		cma = dbhelper.getAllUserClasses(Integer.parseInt(session.getAttribute("userid").toString()));
		
		classList="";
		for(ClassModel cm : cma)
		{
			if(cm != null)
			classList = classList + "<p>"+cm.getTitle()+" | <a href='deleteclass?id="+cm.getID()+"'>Delete</a></p>";
		}
		mav.addObject("userclasslist", classList);		
		
		mav.setViewName("registerclass");
		return mav;
	}
	
	@RequestMapping(value = "/registerclassdone", method = RequestMethod.POST)
	public ModelAndView registerclassdone(Locale locale, Model model, @ModelAttribute("class") String id, HttpSession session ) {
		ModelAndView mav = new ModelAndView();
		
		if(dbhelper.registerclass(id, Integer.parseInt(session.getAttribute("userid").toString())))
			mav.addObject("res" , "yes");
		else
			mav.addObject("res", "no");
		
		mav.setViewName("registerclassdone");
		return mav;
	}
	
	@RequestMapping(value = "/deleteclass", method = RequestMethod.GET)
	public ModelAndView deleteclass(Locale locale, Model model , @ModelAttribute("id") String id, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		if(dbhelper.unregisterclass(id, Integer.parseInt(session.getAttribute("userid").toString())))
			mav.addObject("res" , "yes");
		else
			mav.addObject("res", "no");
		
		mav.setViewName("deleteclass");
		return mav;
	}
}
