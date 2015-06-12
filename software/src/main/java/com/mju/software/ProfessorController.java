package com.mju.software;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mju.frame.CController;
import com.mju.model.ClassModel;

@Controller
public class ProfessorController extends CController {
	public ProfessorController() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/professor/createclass", method = RequestMethod.GET)
	public ModelAndView createclass(Locale locale, Model model, HttpSession session) throws InstantiationException, IllegalAccessException {
		
		ModelAndView mav = new ModelAndView();
	
		ClassModel cls = new ClassModel();
		cls.setProfID(Integer.parseInt(session.getAttribute("userid").toString()));
		ArrayList<ClassModel> cma = dao.selectAll(cls, ClassModel.class);
		
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
		
		ClassModel cls = new ClassModel();
		cls.setTitle(title);
		cls.setProfID(Integer.parseInt(session.getAttribute("userid").toString()));
		
		if(!dao.insert(cls))
			mav.addObject("error", "yes");
		
		mav.setViewName("createclassdone");
		return mav;
	}
	
	@RequestMapping(value = "/professor/removeclass", method = RequestMethod.GET)
	public ModelAndView deleteclass(Locale locale, Model model, @ModelAttribute("id") String id) {
		ModelAndView mav = new ModelAndView();
		
		ClassModel cls = new ClassModel();
		cls.setID(Integer.parseInt(id));
		
		if(!dao.delete(cls)) mav.addObject("error", "yes");
		
		mav.setViewName("professorremoveclass");
		return mav;
	}
}
