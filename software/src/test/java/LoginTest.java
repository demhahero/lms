import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.mju.software.LoginController;

public class LoginTest {

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testLoginStudent() {
		
		LoginController uc = new LoginController();
		ModelAndView mav = uc.doLogin(null, null, "Ahmed", "pass");
		assertEquals(mav.getModel().get("rank"), 0);
		
	}
	

	@Test
	public void testLoginProfessor() {
		
		LoginController uc = new LoginController();
		ModelAndView mav = uc.doLogin(null, null, "ali", "pass");
		assertEquals(mav.getModel().get("rank"), 1);
		
	}
}
