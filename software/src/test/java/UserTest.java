import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.mju.software.UserController;


public class UserTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRegisterclass() {
		UserController uc = new UserController();
		ModelAndView mav = uc.registerclassdone(null, null, "3");
		assertEquals(mav.getModel().get("res").toString(), "yes");
	}
	
	@Test
	public void testUnRegisterclass() {
		UserController uc = new UserController();
		ModelAndView mav = uc.deleteclass(null, null, "2");
		assertEquals(mav.getModel().get("res").toString(), "yes");
	}
}
