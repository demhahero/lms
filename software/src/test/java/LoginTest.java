import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mju.software.LoginController;

public class LoginTest {

	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testLoginStudent() throws Exception {
		
		MockHttpServletRequest mock = new MockHttpServletRequest ();
		
		LoginController uc = new LoginController();
		ModelAndView mav = uc.doLogin(null, null, "Ahmed", "pass", mock);
		
		assertNull(mav.getModel().get("error"));
		assertEquals(mav.getModel().get("rank"), 0);
	}
	

	@Test
	public void testLoginProfessor() throws Exception {
		
		MockHttpServletRequest mock = new MockHttpServletRequest ();
		
		LoginController uc = new LoginController();
		ModelAndView mav = uc.doLogin(null, null, "ali", "pass", mock);
		
		assertNull(mav.getModel().get("error"));
		assertEquals(mav.getModel().get("rank"), 1);
		
	}
}
