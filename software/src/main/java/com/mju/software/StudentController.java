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
import com.mju.model.RegisteredClassModel;

@Controller
public class StudentController extends CController {
	public StudentController() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/registerclass", method = RequestMethod.GET)
	public ModelAndView registerclass(Locale locale, Model model, HttpSession session) throws InstantiationException, IllegalAccessException {
		
		ModelAndView mav = new ModelAndView();
	
		ClassModel cls = new ClassModel();
		ArrayList<ClassModel> cma = dao.selectAll(cls, ClassModel.class);
		
		RegisteredClassModel rm = new RegisteredClassModel();
		rm.setStudent_id(Integer.parseInt(session.getAttribute("userid").toString()));
		ArrayList<RegisteredClassModel> rcma = dao.selectAll(rm, RegisteredClassModel.class);
		
		// Remove registered class
		for(RegisteredClassModel rcm : rcma)
		{
			for(ClassModel cm : cma)
			{
				if(rcm.getClass_id()==cm.getID()){
					cma.remove(cm);
					break;
				}
			}
		}
		
		String classList="";
		for(ClassModel cm : cma)
		{
			if(cm != null)
			classList = classList + "<option value='"+cm.getID()+"'>"+cm.getTitle()+"</option>";
		}
		mav.addObject("classlist", classList);
		
		
		
		
		classList="";
		for(RegisteredClassModel rcm : rcma)
		{
			ClassModel tcls = new ClassModel();
			tcls.setID(rcm.getClass_id());
			ArrayList<ClassModel> tcma = dao.selectAll(tcls, ClassModel.class);
			ClassModel tcm = tcma.get(0);
			
			if(tcm != null)
			classList = classList + "<p>"+tcm.getTitle()+" | <a href='deleteclass?id="+tcm.getID()+"'>Delete</a></p>";
		}
		mav.addObject("userclasslist", classList);		
		
		mav.setViewName("registerclass");
		return mav;
	}
	
	@RequestMapping(value = "/registerclassdone", method = RequestMethod.POST)
	public ModelAndView registerclassdone(Locale locale, Model model, @ModelAttribute("class") String id, HttpSession session ) {
		ModelAndView mav = new ModelAndView();
		
		RegisteredClassModel rm = new RegisteredClassModel();
		rm.setStudent_id(Integer.parseInt(session.getAttribute("userid").toString()));
		rm.setClass_id(Integer.parseInt(id));
		
		if(!dao.insert(rm))
			mav.addObject("error", "yes");
		
		mav.setViewName("registerclassdone");
		return mav;
	}
	
	@RequestMapping(value = "/deleteclass", method = RequestMethod.GET)
	public ModelAndView deleteclass(Locale locale, Model model , @ModelAttribute("id") String id, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		RegisteredClassModel rm = new RegisteredClassModel();
		rm.setStudent_id(Integer.parseInt(session.getAttribute("userid").toString()));
		rm.setClass_id(Integer.parseInt(id));
		
		if(!dao.delete(rm))
			mav.addObject("error", "yes");
		
		mav.setViewName("deleteclass");
		return mav;
	}
}
