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
import com.mju.model.UserModel;

@Controller
public class LoginController extends CController {

	
	public LoginController() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public ModelAndView doLogin(Locale locale, Model model , @ModelAttribute("username") String username , @ModelAttribute("password") String password, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
		
		ModelAndView mav = new ModelAndView();
		
		UserModel am = new UserModel();
		am.setUsername(username);
		am.setPassword(password);
		
		UserModel verifiedUser = verifyUser(am);
		if (!username.trim().equals("") && !password.trim().equals("") ) {
			if(verifiedUser != null){
				mav.addObject("userid", verifiedUser.getID());
				mav.addObject("username", verifiedUser.getUsername());
				mav.addObject("rank", verifiedUser.getRank() );
				
				request.getSession().setAttribute("userid", verifiedUser.getID());
				request.getSession().setAttribute("username", verifiedUser.getUsername());
			} else {
				mav.addObject("error", "wrong_login" );
			}
		} else {
			mav.addObject("error", "wrong_login" );
		}	
		
		mav.setViewName("dologin");
		return mav;
	}

	private UserModel verifyUser(UserModel user) throws InstantiationException, IllegalAccessException {
		ArrayList<UserModel> au = dao.selectAll(user, UserModel.class);
		if(au.size() > 0){
			return au.get(0);
		}
		return null;
	}
}
