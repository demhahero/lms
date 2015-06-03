package com.mju.software;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;






import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



import com.mju.model.UserModel;

@Controller
@SessionAttributes("userid")
public class LoginController extends ControllerClass {

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("res", "home");
		mav.setViewName("Login");
		return mav;
	}
	
	@RequestMapping(value = "/dologin", method = RequestMethod.POST)
	public ModelAndView doLogin(Locale locale, Model model , @ModelAttribute("username") String username , @ModelAttribute("password") String password) {

	
		UserModel am = new UserModel();
		am.setUsername(username);
		am.setPassword(password);
		
		ModelAndView mav = new ModelAndView();
		am = dbhelper.login(am);
		if(am != null){
			mav.addObject("userid", am.getID());
			mav.addObject("rank", am.getRank() );
		} else
			mav.addObject("username", "notright" );
	
		mav.setViewName("doLogin");
		return mav;
	}

	
}
